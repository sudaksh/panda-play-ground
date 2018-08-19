package bambooSwords;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode preStart = new ListNode(0);
        ListNode start = new ListNode(0);
        preStart.next = start;
        while (l1 != null || l2 != null || carry != 0){
            int l1Digit = l1 == null ? 0 : l1.val;
            int l2Digit = l2 == null ? 0 : l2.val;
            int sum = l1Digit + l2Digit + carry;
            int resultDigit = sum % 10;
            carry = sum / 10;
            start.val = resultDigit;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (!(l1 != null || l2 != null || carry != 0)){
                break;
            }
            start.next = new ListNode(0);
            start = start.next;
        }
        return preStart.next;
    }
}
