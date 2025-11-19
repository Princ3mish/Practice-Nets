import java.util.*;

class Solution {
    private static class DSU {
        int[] p, r;
        DSU(int n) { p = new int[n+1]; r = new int[n+1]; for (int i = 1; i <= n; i++) p[i] = i; }
        int find(int x){ return p[x]==x?x:(p[x]=find(p[x])); }
        void union(int a,int b){
            a = find(a); b = find(b);
            if (a==b) return;
            if (r[a]<r[b]) p[a]=b;
            else if (r[b]<r[a]) p[b]=a;
            else { p[b]=a; r[a]++; }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);
        for (int[] e : connections) dsu.union(e[0], e[1]);

        
        Map<Integer, TreeSet<Integer>> compMap = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            compMap.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        int qCount = 0;
        for (int[] q : queries) if (q[0] == 1) qCount++;
        int[] ans = new int[qCount];
        int idx = 0;

        for (int[] q : queries) {
            int type = q[0], x = q[1];
            if (type == 2) {
                if (!online[x]) continue; 
                online[x] = false;
                int root = dsu.find(x);
                TreeSet<Integer> set = compMap.get(root);
                if (set != null) set.remove(x);
            } else { 
                if (online[x]) {
                    ans[idx++] = x;
                } else {
                    int root = dsu.find(x);
                    TreeSet<Integer> set = compMap.get(root);
                    if (set == null || set.isEmpty()) ans[idx++] = -1;
                    else ans[idx++] = set.first();
                }
            }
        }
        return ans;
    }
}
