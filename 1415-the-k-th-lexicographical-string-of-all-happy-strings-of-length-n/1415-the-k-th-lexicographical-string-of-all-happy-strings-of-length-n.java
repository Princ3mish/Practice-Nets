class Solution {
        int count = 0 ;
        String answer = "";
    public String getHappyString(int n, int k) {
        backtrack(n , k ,  new StringBuilder());
        return answer;
    }
    private void backtrack( int n , int k , StringBuilder current){
        if(answer.length() != 0)
        return;

        if( current.length() == n ){
            count++;
            if(count == k ){
                answer = current.toString();
            }
            return;
        }
        for( char c : new char[]{'a','b','c'}){
            if(current.length() > 0 &&
            current.charAt(current.length()-1) == c)
            continue;

            current.append(c);

            backtrack(n,k,current);

            current.deleteCharAt(current.length()-1);


        }
    }
}