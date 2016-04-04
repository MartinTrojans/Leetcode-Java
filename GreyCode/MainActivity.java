
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode solution = new GrayCode();
		String[] res = solution.getGrayRecursively(3);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
