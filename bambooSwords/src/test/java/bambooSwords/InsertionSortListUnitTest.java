package bambooSwords;

import bambooSwords.generalClass.ListNode;
import org.junit.Test;

public class InsertionSortListUnitTest {
    @Test
    public void test(){
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        InsertionSortList insertionSortList = new InsertionSortList();
        insertionSortList.insertionSortList(n1);

    }
}
