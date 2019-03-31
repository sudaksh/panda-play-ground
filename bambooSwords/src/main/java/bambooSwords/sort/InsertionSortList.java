package bambooSwords.sort;

import bambooSwords.generalClass.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode outer = head.next;
        int outerIndex = 1;
        ListNode outerPre = head;
        while (outer != null){
            int i = 0;
            ListNode innerPre = dummyHead;
            ListNode inner = dummyHead.next;
            ListNode insertion = outer;
            ListNode outerNext = outer.next;
            while (inner != null && inner.val < insertion.val && i != outerIndex){
                inner = inner.next;
                innerPre = innerPre.next;
                i++;
            }
            if (inner != null && i != outerIndex){
                innerPre.next = insertion;
                ListNode temp = insertion.next;
                insertion.next = inner;
                outerPre.next = temp;
                outer = outerNext;
            } else {
                outerPre = outer;
                outer = outer.next;
            }
            outerIndex++;
        }
        return dummyHead.next;
    }
}



