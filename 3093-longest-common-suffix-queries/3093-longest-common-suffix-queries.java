class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIdx = -1;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        int minLenIdx = 0;
        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[minLenIdx].length()) {
                minLenIdx = i;
            }
        }
        root.bestIdx = minLenIdx;
        for (int i = 0; i < wordsContainer.length; i++) {
            TrieNode curr = root;
            String word = wordsContainer[i];
            
            for (int j = word.length() - 1; j >= 0; j--) {
                int c = word.charAt(j) - 'a';
                if (curr.children[c] == null) curr.children[c] = new TrieNode();
                curr = curr.children[c];
                if (curr.bestIdx == -1 || word.length() < wordsContainer[curr.bestIdx].length()) {
                    curr.bestIdx = i;
                }
            }
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            TrieNode curr = root;
            String q = wordsQuery[i];
            
            for (int j = q.length() - 1; j >= 0 && curr.children[q.charAt(j) - 'a'] != null; j--) {
                curr = curr.children[q.charAt(j) - 'a'];
            }
            ans[i] = curr.bestIdx;
        }

        return ans;
    }
}