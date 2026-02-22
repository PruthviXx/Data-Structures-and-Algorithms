package linked_list.doubly_ll;

public class DeleteAllOccurences {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    static Node optimal(Node head, int x) {
        // Write your code here
        Node dummyHead = new Node(1);
        dummyHead.next = head;
        head.prev = dummyHead;

        Node prev = dummyHead;
        Node next = head;

        while (next != null) {
            if (next.data == x) {
                next = next.next;
            } else {
                Node nextPrev = next.prev;
                Node prevNext = prev.next;
                nextPrev.next = null;
                prevNext.prev = null;
                next.prev = prev;
                prev.next = next;

                prev = next;
                next = next.next;
            }
        }

        if (prev.next != null) {
            Node prevNext = prev.next;
            prev.next = null;
            prevNext.prev = null;
        }

        Node temp = dummyHead;
        dummyHead = dummyHead.next;
        dummyHead.prev = null;
        temp.next = null;

        return dummyHead;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 10, 8, 4, 2, 5, 2 };
        Node head = createDll(arr);
        head = optimal(head, 2);
        printList(head);
    }

    static Node createDll(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            temp.prev = prev;
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
}
