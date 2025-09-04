import java.util.*;

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        
        Set<Integer> friendSet = new HashSet<>();
        for (int friendId : friends) {
            friendSet.add(friendId);
        }

        
        List<Integer> resultList = new ArrayList<>();

        
        for (int participant : order) {
            if (friendSet.contains(participant)) {
                resultList.add(participant);
            }
        }

        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
