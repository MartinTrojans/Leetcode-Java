import java.util.List;

public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		List<String> res = s.letterCombinations("234");
		for (String str : res){
			System.out.println(str);
		}
	}

}
