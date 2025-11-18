class Solution {
    static class Node{
        long start, end;
        int considered; 
        long activeLength;
        Node left, right;
        public Node(long start, long end){
            this.start = start;
            this.end = end;
        }
    }
    static class SegmentTree{
        Node head;
        public SegmentTree(int n){
            head = new Node(0, n);
        }
        public void update(long left, long right, long leftRange, long rightRange, int append){
            update(left, right, leftRange, rightRange, head, append);
        }
        public long getLength(){
            return head.activeLength;
        }
        private void update(long left, long right, long leftRange, long rightRange, Node node, int append){
            if (rightRange <= left || right <= leftRange){
                return;
            }
            long mid = getMid(left, right, node);
            if (leftRange <= left && right <= rightRange){
                node.considered += append;
                updateNode(node, left, right);
                return;
            }
            update(left, mid, leftRange, rightRange, node.left, append);
            update(mid, right, leftRange, rightRange, node.right, append);
            updateNode(node, left, right);
        }
        private void updateNode(Node node, long start, long end){
            if (node.considered > 0){
                node.activeLength = end - start;
            }
            else{
                node.activeLength = node.left.activeLength + node.right.activeLength;
            }
        }
        private long getMid(long left, long right, Node node){
            long mid = left + (right-left)/2;
            if (node.left == null){
                node.left = new Node(left, mid);
            }
            if (node.right == null){
                node.right = new Node(mid, right);
            }
            return mid;
        }
    }
    static class Event implements Comparable<Event>{
        long x1, x2, y, length;
        boolean isEnd;
        public Event(long x1, long x2, long y, long length, boolean isEnd){
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
            this.length = length;
            this.isEnd = isEnd;
        }
        @Override
        public int compareTo(Event other){
            if (this.y != other.y){
                return Long.compare(this.y, other.y);
            }
            return this.isEnd ? -1 : 1; 
        }
    }
    private static final int MAX = 2_000_000_001;
    SegmentTree segmentTree;
    public Solution(){
        segmentTree = new SegmentTree(MAX);
    }
    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();

        for(int[] square:squares){
            events.add(new Event(square[0], (long)square[0]+square[2], square[1], square[2], false));
            events.add(new Event(square[0], (long)square[0]+square[2], (long)square[1]+square[2], square[2], true));
        }
        Collections.sort(events);
        double area = getArea(events);
        segmentTree = new SegmentTree(MAX);
        return seperateSquares(events, area);
    }
    private double getArea(List<Event> squares){
        int i = 0, n = squares.size();
        long prevY = 0, currY = 0, baseLength = 0;
        long combinedArea = 0;

        while(i < n){
            Event square = squares.get(i);
            currY = square.y; 
            combinedArea += (double)(baseLength * (currY - prevY));
            if (!square.isEnd){
                segmentTree.update(0, MAX, square.x1, square.x2, 1);
            }
            else{
                segmentTree.update(0, MAX, square.x1, square.x2, -1);
            }
            baseLength = segmentTree.getLength();
            prevY = currY;
            i++;
        }
        return combinedArea;
    }
    private double seperateSquares(List<Event> squares, double area){
        int i = 0, n = squares.size();
        double prevY = 0, currY = 0, combinedArea = 0, baseLength = 0;

        while(i < n){
            Event square = squares.get(i);
            currY = square.y; 
            combinedArea += baseLength * (currY - prevY);
            if (combinedArea >= area/2){
                if (combinedArea == area/2){
                    return currY;
                }
                return currY - (combinedArea - area / 2) / baseLength;
            }
            prevY = currY;
            if (!square.isEnd){
                segmentTree.update(0, MAX, square.x1, square.x2, 1);
            }
            else{
                segmentTree.update(0, MAX, square.x1, square.x2, -1);
            }
            baseLength = segmentTree.getLength();
            i++;
        }
        return -1;
    }
}