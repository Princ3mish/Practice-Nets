class Solution {
    class Pair{
        String word;
        int steps;
        Pair(String word , int steps){
            this.word = word ;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        if(!st.contains(endWord)){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord , 1));
        st.remove(beginWord);

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word =  curr.word ;
            int steps = curr.steps;
            if(word.equals(endWord)){
                return steps;
            }
            for(int i = 0 ; i < word.length() ; i++){
                char[] wordArray = word.toCharArray();
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.add(new Pair(newWord , steps + 1));
                    }
                }

            }
        }
        return 0;
        
    }
}
