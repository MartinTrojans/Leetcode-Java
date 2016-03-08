import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	if (beginWord.equals(endWord))	return 1;
    	Set<String> startSet = new HashSet<String>();
    	Set<String> endSet =  new HashSet<String>();
    	int res = 1;
    	startSet.add(beginWord);
    	endSet.add(endWord);
    	while (!wordList.isEmpty() && !startSet.isEmpty() && !endSet.isEmpty()) {
    		res++;
    		Set<String> tempSet = new HashSet<String>();
    		for (String nWord: startSet) {
    			wordList.remove(nWord);
    			for (String ele: check(nWord, wordList)) {
    				if (endSet.contains(ele))	return res;
    				tempSet.add(ele);
    			}
    		}
    		startSet = tempSet;
    		tempSet = new HashSet<String>();
    		res++;
    		for (String nWord: endSet) {
    			wordList.remove(nWord);
    			for (String ele: check(nWord, wordList)) {
    				if (startSet.contains(ele))	return res;
    				tempSet.add(ele);
    			}
    		}
    		endSet = tempSet;
    	}
    	return 0;
    }
    private List<String> check(String word, Set<String> wordList) {
    	List<String> res = new ArrayList<String>();
    	int len = word.length();
    	if (len == 1)	{
    		res.addAll(wordList);
    		return res;
    	}
    	for (int i = 0; i < len; i++) {
    		char[] chs = word.toCharArray();
    		for (char j = 'a'; j <= 'z'; j++) {
    			chs[i] = j;
				String temp = String.valueOf(chs);
				if (wordList.contains(temp))	res.add(temp);  			
    		}
    	}
    	return res;
    }
}