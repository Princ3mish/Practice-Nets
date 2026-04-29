class Solution {
public:
    int firstUniqChar(string s) {
        int n=s.size();
        unordered_map<char,int>mpp;
        for(auto it:s){
            mpp[it]++;
        }

        for(int i=0; i<n; i++){
            if(mpp[s[i]]==1) return i;
        }

        return -1;
    }
};