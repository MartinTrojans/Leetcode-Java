import java.util.HashSet;

public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String beginWord = "hot", endWord = "dog";
		HashSet<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dog");
		wordList.add("dot");
		int res = s.ladderLength(beginWord, endWord, wordList);
		System.out.println(res);
	}

}
