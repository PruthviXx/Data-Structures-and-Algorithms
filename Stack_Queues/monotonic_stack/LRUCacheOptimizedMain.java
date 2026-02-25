import java.util.*;

// Total Time: O(1), Total Space: O(2n) -> one for map and one for list 
class LRUCache{
    private int capacity;
    private Map<Integer,Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
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
        // int use;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            // this.use = 0;
        }

        void setValue(int value){
            this.value = value;
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
            removeLRUNode();
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

        // attach the node after head
        Node headNext = head.next;
        head.next= node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
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
    public void removeLRUNode(){
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

public class LRUCacheOptimizedMain {
    public static void main(String[] args) {
        int value = 0;
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1,4);
        lruCache.put(2,10);
        value = lruCache.get(1);
        System.out.println(value);
        lruCache.put(3,8);
        value = lruCache.get(2);
        System.out.println(value);
        lruCache.put(4,2);
        value = lruCache.get(1);
        System.out.println(value);
        value = lruCache.get(3);
        System.out.println(value);
        value = lruCache.get(4);
        System.out.println(value);
    }
}
