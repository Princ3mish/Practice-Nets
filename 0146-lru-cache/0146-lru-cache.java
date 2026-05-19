class Node{
    int key;
    int value;
    Node prev ;
    Node next;
    Node(int key , int value){
        this.key = key ;
        this.value = value;
    }
}

class LRUCache {
private final Node head = new Node(-1,-1);
private final Node tail = new Node(-1,-1);
private final Map<Integer,Node> map;
private final int capacity;
    public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
    head.next = tail;
    tail.prev = head;  
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        inserttohead(node);
        return node.value;
       
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            inserttohead(node);
        }else{
            if(map.size() == capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node (key,value);
            map.put(key,newNode);
            inserttohead(newNode);
        }
      
    }
    private void remove(Node node){
        node.prev.next =  node.next;
        node.next.prev = node.prev;
    }
    private void  inserttohead(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }


}