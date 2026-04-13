import java.util.*;

// Total Time: O(1), Total Space: O(2n) -> one for map and one for list 
class LFUCache{
    private int capacity;
    private Map<Integer,Node> map;
    private Node head;
    private Node tail;

    public LFUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }


    class Node{
        int key;
        int value;
        int use;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.use = 1;
        }

        void setValue(int value){
            this.value = value;
        }

        void incrementUse(){
            this.use++;
        }
    }

    // Time: O(1)
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        updatePoiting(node,node.value);

        return node.value;
    }

    public void put(int key, int value){
        // if key exist change poitings
        if(map.containsKey(key)){
            updatePoiting(map.get(key),value);
            return;
        }
        // map length >= capacity remove LRU and then add
        else if(map.size() >= capacity){
            removeLFUNode();
        }
        // map length < capacity add directly
        insertNewNode(key,value);
    }

    // Time: O(1) 
    public void updatePoiting(Node node, int newValue){
        node.setValue(newValue);

        // detach the node first
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // attach the node on the basis of use
        Node nodePrev = node;
        while(nodePrev.prev != null && nodePrev != head && nodePrev.prev.use <= nodePrev.use){
            nodePrev = nodePrev.prev;
        }
        Node nodeNext = nodePrev.next;
        nodePrev.next = node;
        node.prev = nodePrev;
        node.next = nodeNext;
        nodeNext.prev = node;
        node.incrementUse();
    }

    // Time: O(1)
    public void insertNewNode(int key, int value){
        Node newNode = new Node(key,value);
        Node headNext = head.next;
        head.next= newNode;
        newNode.next = headNext;
        newNode.prev = head;
        headNext.prev = newNode;
        map.put(key,newNode);
    }

    // Time: O(1)
    public void removeLFUNode(){
        Node lruNode = tail.prev;

        // when list is empty();
        if(lruNode == head){
            return;
        }

        Node lruNodePrev = lruNode.prev;
        lruNodePrev.next = tail;
        tail.prev = lruNodePrev;
        lruNode.next = null;
        lruNode.prev = null;

        map.remove(lruNode.key);
    }
}

public class LFUCacheOptimizedMain {
    public static void main(String[] args) {
        int value = 0;
        LFUCache lfuCache = new LFUCache(2);

        lfuCache.put(1,1);
        lfuCache.put(2,2);
        value = lfuCache.get(1);
        System.out.println(value);
        lfuCache.put(3,3);
        value = lfuCache.get(2);
        System.out.println(value);
        value = lfuCache.get(3);
        System.out.println(value);
        lfuCache.put(4,4);
        value = lfuCache.get(1);
        System.out.println(value);
        value = lfuCache.get(3);
        System.out.println(value);
        value = lfuCache.get(4);
        System.out.println(value);
    }
}
