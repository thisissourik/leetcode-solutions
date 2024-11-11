class MiddleOfTheList {
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;

        int len = len(head);
        int half = len / 2;

        while (half != 0) {
            head = head.next;
            half--;
        }
        return head;
    }

    public int len(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        // System.out.println(cnt);
        return cnt;
    }
}

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}