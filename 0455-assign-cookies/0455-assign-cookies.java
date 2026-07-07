class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int stud = 0;
        int cookie =0;
        while(stud < g.length && cookie < s.length){
            if( s[cookie] >= g[stud]){
                stud++;
            }
            cookie++;
        }
        return stud;
    }
}