package bambooSwords.BfsDfsTree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordLadderUnitTest {
    @Test
    public void test(){
        WordLadder w = new WordLadder();

        String beginWord = "leet";
        String endWord = "code";
        List<String> wordList = Arrays.asList("lest","leet","lose","code","lode","robe","lost");
        int a = w.ladderLength(beginWord, endWord, wordList);
        System.out.print("Answer " + a);
    }
}
