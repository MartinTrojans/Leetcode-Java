import java.util.HashSet;

public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		HashSet<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		
		System.out.println(s.wordBreak("leetcode", wordDict));;
	}

}
