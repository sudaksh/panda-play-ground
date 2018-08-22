package bambooSwords;

public class RemoveNodeFromList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        
        int pos = size - n;
        if(pos < 0)
            return head;
        
        
        curr = head;
        ListNode prev = null;
        for(int i = 0 ; i < pos ; i++){
            prev = curr;
            curr = curr.next;
        }
        
        if(prev != null){
            prev.next = curr.next;
            curr.next = null;
            return head;
        } else {
            return head;
        }
        

    }

}
