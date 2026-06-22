class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0 ,  a = 0 , l = 0, o = 0, n = 0;
        for(char ch : text.toCharArray()){
            if(ch == 'b') b++;
            else if (ch == 'a')a++;
            else if (ch == 'l')l++;
            else if (ch == 'o')o++;
            else if (ch == 'n')n++;
        }
        int maxballoons = b;
        maxballoons = Math.min(maxballoons,a);
        maxballoons = Math.min(maxballoons,l/2);
        maxballoons = Math.min(maxballoons,o/2);
        maxballoons = Math.min(maxballoons,n);
        return maxballoons;

    }
}