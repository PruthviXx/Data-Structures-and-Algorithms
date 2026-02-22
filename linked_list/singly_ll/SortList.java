package linked_list.singly_ll;

import java.util.ArrayList;
import java.util.Collections;

public class SortList {

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

    public Node bruteForce(Node head) {
        Node temp = head;
        ArrayList<Integer> list = new ArrayList<>();

        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(list);
        temp = head;
        int i = 0;
        while (temp != null) {
            temp.data = list.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node mergeList(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return dummyNode.next;
    }

    public static Node optimal(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = findMid(head);
        Node lefthead = head, righthead = mid.next;
        mid.next = null;
        lefthead = optimal(lefthead);
        righthead = optimal(righthead);
        return mergeList(lefthead, righthead);
    }

    static void printList(Node head) {
        Node mover = head;

        while (mover != null) {
            System.out.print(mover.data + " ");
            mover = mover.next;
        }

    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 2, 3 };
        Node head = createList(arr);
        printList(head);
        head = optimal(head);
        System.out.println();
        printList(head);

    }
}
