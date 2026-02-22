package linked_list.singly_ll;

import java.util.HashSet;
import java.util.Set;

public class Deletion {
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

    static Node deleteHead(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    static Node deleteTail(Node head) {
        Node mover = head;

        while (mover.next.next != null) {
            mover = mover.next;
        }

        mover.next = null;

        return head;
    }

    static Node deleteK(Node head, int k) {
        if (head == null) {
            return null;
        }

        if (k == 1)
            return head.next;

        Node mover = head;
        Node previous = null;
        int cnt = 1;

        while (mover != null) {

            if (cnt == k) {
                previous.next = mover.next;
            }
            cnt++;
            previous = mover;
            mover = mover.next;
        }

        return head;
    }

    static Node deleteEl(Node head, int el) {
        if (head.data == el) {
            return head.next;
        }

        Node mover = head;
        Node previous = null;
        
        while (mover != null) {

            if (mover.data == el) {
                previous.next = mover.next;
            }

            previous = mover;
            mover = mover.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 4, 7, 9, 3 };
        Node head = createList(arr);
        // head=deleteHead(head);
        // head=deleteTail(head);
        head = deleteEl(head, 99);
        printList(head);
    }
}
