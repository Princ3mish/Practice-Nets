class Solution {
    public int numberOfSpecialChars(String word) {
        int[] last = new int[26];
        int[] first = new int[26];
        Arrays.fill(last , -1);
        Arrays.fill(first , -1);
        for(int i = 0 ; i < word.length();i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                last[ch - 'a'] = i;
            }else if (Character.isUpperCase(ch)){
                int idx = ch - 'A';
                if(first[idx] == -1){
                    first[idx] = i;
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(last[i] != -1 && first[i] != -1 &&last[i] < first[i]){
                count++;
            }
        }
        return count;
    }
}