package bambooSwords.BfsDfsTree;

import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        words.addAll(wordList);
        if (!words.contains(endWord)) return 0;
        Map<String, Set<String>> graph = generateGraph(beginWord, words);
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        int steps = 1;
        int size = 1;
        Set<String> visited = new HashSet<>();
        while (!que.isEmpty()){
            String cur = que.poll();
            size --;
            Set<String> next = graph.get(cur);
            if (CollectionUtils.isEmpty(next)) continue;
            for (String s : next){
                if (s.equals(endWord)) return steps + 1;
                if (visited.contains(s)) continue;
                que.add(s);
                visited.add(cur);
            }
            if (size == 0){
                steps++;
                size = que.size();
            }
        }
        return 0;
    }
    public Map<String, Set<String>> generateGraph(String beginWord, Set<String> words){
        Map<String, Set<String>> graph = new HashMap<>();
        words.add(beginWord);
        for (String s : words){
            Set<String> set = getNextWords(s, words);
            graph.put(s, set);
        }
        return graph;
    }
    public Set<String> getNextWords(String s, Set<String> words){
        Set<String> res = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            for (char c = 'a'; c <= 'z'; c++){
                String n = s.substring(0, i) + c + s.substring(i + 1);
                if (words.contains(n)) res.add(n);
            }
        }
        res.remove(s);
        return res;
    }
}
