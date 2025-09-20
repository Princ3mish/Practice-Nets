class Router {
    static class Packet {
        int source, destination, timestamp;
        Packet(int s, int d, int t) { source = s; destination = d; timestamp = t; }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Packet p)) return false;
            return source == p.source && destination == p.destination && timestamp == p.timestamp;
        }
        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    private final Queue<Packet> queue = new LinkedList<>();
    private final Set<Packet> set = new HashSet<>();
    private final Map<Integer, List<Integer>> destToTimes = new HashMap<>();
    private final Map<Integer, Integer> procIndex = new HashMap<>();
    private final int memoryLimit;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if (set.contains(packet)) return false;
        if (queue.size() == memoryLimit) forwardPacket();
        queue.offer(packet);
        set.add(packet);
        destToTimes.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public List<Integer> forwardPacket() {
        if (queue.isEmpty()) return new ArrayList<>();
        Packet packet = queue.poll();
        set.remove(packet);
        procIndex.put(packet.destination, procIndex.getOrDefault(packet.destination, 0) + 1);
        return List.of(packet.source, packet.destination, packet.timestamp);
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> times = destToTimes.getOrDefault(destination, List.of());
        int start = procIndex.getOrDefault(destination, 0);
        // Binary search for fastest count
        int l = lowerBound(times, start, startTime);
        int r = upperBound(times, start, endTime);
        return r - l;
    }

    // Binary search helpers
    private int lowerBound(List<Integer> list, int start, int val) {
        int l = start, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) >= val) r = m;
            else l = m + 1;
        }
        return l;
    }
    private int upperBound(List<Integer> list, int start, int val) {
        int l = start, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) > val) r = m;
            else l = m + 1;
        }
        return l;
    }
}
