package linked_list.doubly_ll;

public class Insertion {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    static Node createDll(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;

            prev = temp;
        }

        return head;
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static Node insertBeforeHead(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }
        Node temp = new Node(val, head, null);
        head.prev = temp;
        return temp;
    }

    static Node insertBeforeTail(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }

        if (head.prev == null) {
            return insertBeforeHead(head, val);
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        Node prev = temp.prev;
        Node newNode = new Node(val, temp, prev);
        prev.next = newNode;
        temp.prev = newNode;
        return head;
    }

    static Node insertBeforeKth(Node head, int k, int val) {
        if (k == 1) {
            return insertBeforeHead(head, val);
        }

        Node temp = head;
        int cnt = 0;

        while (temp != null) {
            cnt++;

            if (cnt == k) {
                break;
            }

            temp = temp.next;
        }

        if (temp != null) {
            Node prev = temp.prev;
            Node newNode = new Node(val, temp, prev);
            prev.next = newNode;
            temp.prev = newNode;
        }

        return head;
    }

    static void insertBeforeNode(Node node, int val) {
        Node prev = node.prev;
        Node newNode = new Node(val, node, prev);
        prev.next = node.prev = newNode;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 5, 7, 3 };
        Node head = createDll(arr);
        insertBeforeNode(head.next.next.next, 100);
        printList(head);
    }
}
