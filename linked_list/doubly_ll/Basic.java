package linked_list.doubly_ll;

import java.util.HashSet;
import java.util.Set;

public class Basic {
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

    public static boolean bruteForce(Node head) {
        Node temp = head;

        Set<Node> set = new HashSet<>();

        while (temp != null) {
            if (set.contains(temp)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 7, 5, 3 };
        Node head = createDll(arr);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next;
        System.out.println(bruteForce(head));
        // printList(head);
    }
}
