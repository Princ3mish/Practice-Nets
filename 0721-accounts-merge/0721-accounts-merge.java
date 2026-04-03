import java.util.*;

class Solution {

    public int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    public void union(int a, int b, int[] parent) {
        int pa = find(a, parent);
        int pb = find(b, parent);

        if (pa != pb) {
            parent[pa] = pb;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Map<String, Integer> emailtoIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (!emailtoIndex.containsKey(email)) {
                    emailtoIndex.put(email, i);
                } else {
                    union(i, emailtoIndex.get(email), parent);
                }
            }
        }

        Map<Integer, Set<String>> groups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i, parent);
            groups.putIfAbsent(root, new HashSet<>());

            for (int j = 1; j < accounts.get(i).size(); j++) {
                groups.get(root).add(accounts.get(i).get(j));
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (int root : groups.keySet()) {
            List<String> emails = new ArrayList<>(groups.get(root));
            Collections.sort(emails);

            String name = accounts.get(root).get(0);

            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);

            result.add(merged);
        }

        return result;
    }
}