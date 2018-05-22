package bambooSwords;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bambooSwords.SwapNodesInPair.ListNode;

public class SwapNodesInPairUnitTest {
    
    private SwapNodesInPair swapNodesInPair ;
    
    @Before
    public void setup(){
        swapNodesInPair = new SwapNodesInPair();
    }
    
    @Test
    public void testSwapPairs1(){
        ListNode output = swapNodesInPair.swapPairs(prepareLinkedList("1->2->3->4"));
        Assert.assertEquals("2->1->4->3", prepareListString(output));
    }

    private String prepareListString(ListNode output) {
        StringBuffer buffer = new StringBuffer();
        ListNode currNode = output;
        while(currNode != null){
            buffer.append(currNode.val);
            if(currNode.next != null){
                buffer.append("->");
            }
            currNode = currNode.next;
        }
        return buffer.toString();
    }

    private ListNode prepareLinkedList(String listString) {
        
        List<Integer> list = Arrays.asList(listString.split("->")).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        ListNode headNode = new ListNode(list.get(0));
        ListNode currNode = headNode;
        for(int i =1 ; i< list.size() ; i++){
            ListNode node = new ListNode(list.get(i));
            currNode.next=node;
            currNode = node;
        }
        return headNode;
    }

}
