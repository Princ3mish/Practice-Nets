class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] mapping = new int[26];
        for(int i = 0; i < order.length(); i++){
            mapping[order.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < words.length - 1 ; i++){
            String curr = words[i];
            String next = words[i+1];
            int min = Math.min(curr.length() , next.length());
            boolean found = false;
            for(int j = 0 ; j < min ; j++){
                char char1 = curr.charAt(j);
                char char2 = next.charAt(j);
                if(char1 != char2){
                    if(mapping[char1 - 'a'] > mapping[char2 - 'a']){
                        return false;
                    }else{
                        found = true;
                        break;
                    }
                }
            }
            if(!found && curr.length() > next.length()){
                return false;
            }
        }
        return true;
        
    }
}