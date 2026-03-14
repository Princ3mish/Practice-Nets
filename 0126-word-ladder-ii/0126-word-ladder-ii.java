import java.util.*;

class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        List<List<String>> result = new ArrayList<>();

        if(!wordSet.contains(endWord))
            return result;

        Map<String, List<String>> parentMap = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean foundEnd = false;

        while(!queue.isEmpty() && !foundEnd) {

            int size = queue.size();

            Set<String> levelVisited = new HashSet<>();

            for(int i = 0; i < size; i++) {

                String word = queue.poll();

                char[] chars = word.toCharArray();

                for(int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for(char c = 'a'; c <= 'z'; c++) {

                        chars[j] = c;

                        String newWord = new String(chars);

                        if(!wordSet.contains(newWord))
                            continue;

                        if(!visited.contains(newWord)) {

                            if(!levelVisited.contains(newWord)) {
                                queue.offer(newWord);
                                levelVisited.add(newWord);
                            }

                            parentMap
                                .computeIfAbsent(newWord, k -> new ArrayList<>())
                                .add(word);

                            if(newWord.equals(endWord))
                                foundEnd = true;
                        }
                    }

                    chars[j] = original;
                }
            }

            visited.addAll(levelVisited);
        }

        // DFS to build paths
        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parentMap, path, result);

        return result;
    }


    private void dfs(String word,
                     String beginWord,
                     Map<String, List<String>> parentMap,
                     List<String> path,
                     List<List<String>> result) {

        if(word.equals(beginWord)) {

            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            result.add(validPath);

            return;
        }

        if(!parentMap.containsKey(word))
            return;

        for(String parent : parentMap.get(word)) {

            path.add(parent);

            dfs(parent, beginWord, parentMap, path, result);

            path.remove(path.size() - 1);
        }
    }
}