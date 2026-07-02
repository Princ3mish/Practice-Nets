class TimeMap {
    private static class DataNode {
        String value;
        int timestamp;

        DataNode(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    private Map<String, List<DataNode>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new DataNode(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<DataNode> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    private String binarySearch(List<DataNode> list, int targetTime) {
        int low = 0;
        int high = list.size() - 1;
        String res = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid).timestamp == targetTime) {
                return list.get(mid).value;
            } else if (list.get(mid).timestamp < targetTime) {
                res = list.get(mid).value; 
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }

        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */