package bambooSwords.generalClass;

public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) { val = x; }

     public void setVal(int val){
          this.val = val;
     }

     public void setNext(ListNode n){
          this.next = n;
     }

     public ListNode getNext(){
          return this.next;
     }
}
