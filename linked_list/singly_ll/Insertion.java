package linked_list.singly_ll;

public class Insertion {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static Node createList(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    static void printList(Node head) {
        Node mover = head;

        while (mover != null) {
            System.out.print(mover.data + " ");
            mover = mover.next;
        }

    }

    static Node insertHead(Node head, int data) {
        return new Node(data, head);
    }

    static Node insertTail(Node head, int data) {
        Node mover = head;

        while (mover.next != null) {
            mover = mover.next;
        }

        Node newNode = new Node(data);
        mover.next = newNode;

        return head;
    }

    static Node insertK(Node head, int data, int k) {
        if (k == 1 || head == null)
            return new Node(data, head);

        Node mover = head;
        int cnt = 2;

        while (mover != null) {

            if (cnt == k) {
                Node newNode = new Node(data, mover.next);
                mover.next = newNode;
            }
            cnt++;
            mover = mover.next;
        }

        return head;
    }

    static Node insertBeforeEl(Node head, int data, int el) {
        if (head.data == el)
            return new Node(data, head);

        Node mover = head;
        Node prevoius = null;

        while (mover != null) {
            if (mover.data == el) {
                Node newNode = new Node(data, prevoius.next);
                prevoius.next = newNode;
            }
            prevoius = mover;
            mover = mover.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 4, 7, 9, 3 };
        Node head = createList(arr);
        head = insertBeforeEl(head, 100, 9);
        printList(head);
    }
}
