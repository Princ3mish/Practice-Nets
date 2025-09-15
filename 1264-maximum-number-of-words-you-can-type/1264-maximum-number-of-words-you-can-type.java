class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0 ;
        for( String word : text.split(" ")){
            boolean broken = false ;
            for( char c : brokenLetters.toCharArray()){
                if( word.indexOf(c) != -1){
                    broken = true ;
                    break;
                }
            }
            if(!broken) count++;
        }
        return count;
    }
}