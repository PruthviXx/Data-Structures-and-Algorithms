package linked_list.singly_ll;

import java.util.ArrayList;
import java.util.Collections;

public class Basic {
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

    static int getSize(Node head) {
        Node mover = head;
        int cnt = 0;

        while (mover != null) {
            cnt++;
            mover = mover.next;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 7, 1 };
        Node head = createList(arr);
        printList(head);
        // System.out.println(getSize(head));
    }
}
