package bambooSwords;


public class MergeSortedLists {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		
		@Override
		public String toString() {
			ListNode tempNode = this;
			StringBuilder builder =  new StringBuilder();
			while(tempNode != null) {
				builder.append(tempNode.val).append(" ");
				tempNode = tempNode.next;
			}
			return builder.toString();
		}
	}


	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) {
			return null;
		}
		
		ListNode[] listsTemp = lists;
		while(listsTemp.length != 1) {
			listsTemp = mergeListsInPairs(listsTemp);
		}
		return listsTemp[0];
	}


	private ListNode[] mergeListsInPairs(ListNode[] lists) {
		
		ListNode[] results = new ListNode[(int)Math.ceil(lists.length/2.0)];
		for(int i = 0 ; i < lists.length ; i = i+2) {
			if(i+1 == lists.length) {
				results[i/2] = lists[i];
			} else {
				results[i/2] = mergeLists(lists[i], lists[i+1]);
			}
		}
		
		return results;
	}


	private ListNode mergeLists(ListNode list1 , ListNode list2) {
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		
		if(list1.val > list2.val) {
			ListNode temp = list1;
			list1 = list2;
			list2 = temp;
		}

		ListNode l1 = list1;
		ListNode l2 = list2;


		while(l1.next != null && l2 != null) {
			if(l1.next.val > l2.val) {
				ListNode temp = l2.next;
				l2.next = l1.next;
				l1.next = l2;
				l2 = temp;
				l1 = l1.next;
			} else {
				l1 = l1.next;
			}
		}
		
		if(l2 != null) {
			l1.next = l2;
		}
		
		
		return list1;

	}

}
