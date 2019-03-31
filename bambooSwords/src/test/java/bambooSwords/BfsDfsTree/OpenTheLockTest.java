package bambooSwords.BfsDfsTree;

import org.junit.Test;

public class OpenTheLockTest {

    @Test
    public void test(){
        String[] s = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";

        OpenTheLock openTheLock = new OpenTheLock();
        openTheLock.openLock(s, target);
    }
}
