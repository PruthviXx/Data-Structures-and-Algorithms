package CP;
import java.util.HashMap;
import java.util.Map;

public class RevNodesKGroups {
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    static ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    static void printList(ListNode head) {
        ListNode mover = head;

        while (mover != null) {
            System.out.print(mover.data + " ");
            mover = mover.next;
        }
    }

    static int getSize(ListNode head) {
        ListNode mover = head;
        int cnt = 0;

        while (mover != null) {
            cnt++;
            mover = mover.next;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 1 };
        ListNode head = createList(arr);
        printList(head);
        head = optimal(head, 4);
        System.out.println();
        printList(head);
        // System.out.println(getSize(head));

        Map<ListNode, ListNode> map = new HashMap<>();
        map.get(head);
    }

    public static ListNode optimal(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        int cnt = 1;

        while (p2 != null) {
            if (cnt == k) {
                cnt = 1;
                break;
            }
            cnt++;
            p2 = p2.next;
        }

        if (cnt != 1) {
            return head;
        }

        ListNode start = p1;
        ListNode end = p2;
        ListNode tail = p1;
        p2 = p2.next;
        p1 = p2;
        head = reverse(start, end);
        System.out.println();
        printList(head);

        while (p2 != null) {
            if (cnt == k) {
                cnt = 0;
                start = p1;
                end = p2;
                p2 = p2.next;
                p1 = p2;
                ListNode newHead = reverse(start, end);
                tail.next = newHead;
                tail = start;
            } else {
                p2 = p2.next;
            }
            cnt++;
        }

        if (cnt != 0) {
            tail.next = p1;
        }

        return head;
    }

    public static ListNode reverse(ListNode start, ListNode end) {
        ListNode tail = null;
        while (start != end) {
            ListNode temp = start.next;
            start.next = tail;
            tail = start;
            start = temp;
        }

        start.next = tail;

        return start;
    }
}
