package linked_list.doubly_ll;

public class ReverseDll {
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

    public static void main(String[] args) {
        int[] arr = { 12, 7, 5, 3 };
        Node head = createDll(arr);

        Node temp = head;

        while (temp != null) {
            Node prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            if (temp.prev == null) {
                break;
            }
            temp = temp.prev;
        }

        // return temp;
        head = temp;

        printList(head);

        
    }

    
}
