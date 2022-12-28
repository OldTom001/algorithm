import java.util.HashSet;
import java.util.Set;

public class Test {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
                cur.next = head;
            }
            head = head.next;
            //System.out.println(head.val);
        }
        return cur.next;
    }

    public static void main(String[] args) {
        ListNode h1 =new ListNode(1);
        ListNode h2 =new ListNode(1);
        ListNode h3 =new ListNode(2);
        ListNode h4 =new ListNode(3);
        ListNode h5 =new ListNode(2);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = null;
        removeDuplicateNodes(h1);
    }
}