package bambooSwords;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bambooSwords.MergeSortedLists.ListNode;

public class MergeSortedListsUnitTest {
	
	private MergeSortedLists mergeSortedLists;
	
	@Before
	public void setup() {
		mergeSortedLists = new MergeSortedLists();
	}
	
	
	@Test
	public void testMergeSortedLists() {
		MergeSortedLists.ListNode listNode1 = prepareList(new int[] {1,7,9,11});
		MergeSortedLists.ListNode listNode2 = prepareList(new int[] {5,8,20});
		MergeSortedLists.ListNode listNode3 = prepareList(new int[] {3,4,6,12,30,31});
		MergeSortedLists.ListNode listNode4 = prepareList(new int[] {5,8,20});
		
		MergeSortedLists.ListNode[] listNodes = new MergeSortedLists.ListNode[] {listNode1,listNode2,listNode3,listNode4}; 
		
		MergeSortedLists.ListNode resultList = mergeSortedLists.mergeKLists(listNodes);
		print(resultList);
		assertTrue(isSorted(resultList));

	}
	
//		[[1,4,5],[1,3,4],[2,6]]

	@Test
	public void testMergeSortedLists2() {
		MergeSortedLists.ListNode listNode1 = prepareList(new int[] {1,4,5});
		MergeSortedLists.ListNode listNode2 = prepareList(new int[] {1,3,4});
		MergeSortedLists.ListNode listNode3 = prepareList(new int[] {2,6});
		
		MergeSortedLists.ListNode[] listNodes = new MergeSortedLists.ListNode[] {listNode1,listNode2,listNode3}; 
		
		MergeSortedLists.ListNode resultList = mergeSortedLists.mergeKLists(listNodes);
		print(resultList);
		assertTrue(isSorted(resultList));

	}

	private boolean isSorted(ListNode resultList) {
		ListNode tempNode = resultList;
		while(tempNode != null && tempNode.next != null) {
			if(tempNode.next.val < tempNode.val) {
				return false;
			}
			tempNode = tempNode.next;
		}
		return true;
	}

	private void print(ListNode resultList) {
		ListNode tempNode = resultList;
		while(tempNode != null) {
			System.out.println(tempNode.val);
			tempNode = tempNode.next;
		}
	}

	private ListNode prepareList(int[] list) {
		ListNode firstNode = mergeSortedLists.new ListNode(list[0]);
		ListNode tempNode = firstNode;
		for(int i = 1 ; i < list.length ; i++) {
			tempNode.next = mergeSortedLists.new ListNode(list[i]);
			tempNode = tempNode.next;
			
		}
		return firstNode;
	}
	
}
