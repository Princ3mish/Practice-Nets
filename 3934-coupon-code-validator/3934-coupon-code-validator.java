import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<String>[] buckets = new ArrayList[4];
        for (int i = 0; i < 4; i++) buckets[i] = new ArrayList<>();

        
        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        for (int i = 0; i < n; i++) {
            String c = code[i];
            String b = businessLine[i];
            boolean active = isActive[i];

            if (!active) continue;
            if (c == null || c.length() == 0) continue;
            Integer idx = order.get(b);
            if (idx == null) continue;

            boolean ok = true;
            for (int j = 0; j < c.length(); j++) {
                char ch = c.charAt(j);
                if (!(Character.isLetterOrDigit(ch) || ch == '_')) {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;

            buckets[idx].add(c);
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Collections.sort(buckets[i]);
            ans.addAll(buckets[i]);
        }
        return ans;
    }
}
