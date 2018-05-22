package bambooSwords;

public class SwapNodesInPair {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode currNode = head;
        ListNode returnNode = head.next;
        ListNode prevNode = null;
        while(currNode != null){
            ListNode nextNode = currNode.next;
            if(nextNode != null){
                if(prevNode != null){
                    prevNode.next = currNode.next;
                }
                currNode.next = nextNode.next;
                nextNode.next = currNode;
                prevNode = currNode;
                currNode = currNode.next;
            } else {
                currNode = null;
            }
        }
        return returnNode;
    }





}
