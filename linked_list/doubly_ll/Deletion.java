package linked_list.doubly_ll;

public class Deletion {
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

    static Node removeHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node prev = head;
        head = head.next;
        prev.next = null;
        head.prev = null;

        return head;
    }

    static Node removeTail(Node head) {
        if (head == null || (head.prev == null && head.next == null)) {
            return null;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        Node prev = temp.prev;
        prev.next = null;
        temp.prev = null;

        return head;
    }

    static Node removeKth(Node head, int k) {
        if (head == null) {
            return null;
        }

        Node temp = head;
        int cnt = 0;

        while (temp != null) {
            cnt++;

            if (cnt == k)
                break;

            temp = temp.next;
        }

        if (cnt == k) {
            Node back = temp.prev;
            Node front = temp.next;

            if (back == null && front == null) {
                return null;
            } else if (back == null) {
                return removeHead(head);
            } else if (front == null) {
                return removeTail(head);
            }

            back.next = front;
            front.prev = back;
            temp.next = null;
            temp.prev = null;
        } else {
            System.out.println("please enter the valid k!");
        }

        return head;
    }

    static void removeNode(Node node) {
        if (node == null) {
            return;
        }

        Node back = node.prev;
        Node front = node.next;

        if (front == null) {
            back.next = null;
            node.prev = null;
            return;
        }

        back.next = front;
        front.prev = back;

        node.next = node.prev = null;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 7, 5, 3 };
        Node head = createDll(arr);
        // head = removeHead(head);
        // head = removeTail(head);
        // head = removeKth(head, 1);
        removeNode(head.next.next.next.next);
        printList(head);
    }
}
