package bambooSwords;

import org.junit.Before;
import org.junit.Test;

import bambooSwords.RemoveNodeFromList.ListNode;

public class RemoveNodeFromListUnitTest {

    private RemoveNodeFromList removeNodeFromList;
    
    
    @Before
    public void setup() {
        removeNodeFromList = new RemoveNodeFromList();
    }
    
    @Test
    public void testRemoveNthFromEnd(){
        RemoveNodeFromList.ListNode head = prepareTestLinkedList();
        removeNodeFromList.removeNthFromEnd(head, 3);
        printList(head);
    }

    private void printList(ListNode head) {
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " --> ");
            curr = curr.next;
        }
    }

    private RemoveNodeFromList.ListNode prepareTestLinkedList() {
        RemoveNodeFromList.ListNode head = new RemoveNodeFromList.ListNode(1);
        RemoveNodeFromList.ListNode node2 = new RemoveNodeFromList.ListNode(2);
        RemoveNodeFromList.ListNode node3 = new RemoveNodeFromList.ListNode(3);
        RemoveNodeFromList.ListNode node4 = new RemoveNodeFromList.ListNode(4);
        RemoveNodeFromList.ListNode node5 = new RemoveNodeFromList.ListNode(5);
        RemoveNodeFromList.ListNode node6 = new RemoveNodeFromList.ListNode(6);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        return head;
    }
    
}
