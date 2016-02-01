package poweroftwo;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 100000;
		boolean b;
		Solution s = new Solution();
		b = s.isPowerOfTwo(a);
		System.out.println(b);
	}
	
	public boolean isPowerOfTwo(int n){
		int d = n;
		if (n < 1)
			return false;
		else if (n == 1)
		    return true;
		while(d % 2 == 0){
			d = d / 2;
			if (d == 1)
				return true;
		}
		
		return false;
	}

}
