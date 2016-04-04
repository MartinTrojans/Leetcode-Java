package compile;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) 
			System.out.println(in.next());
		
		in.close();
		*/
		String a = "Programming";
		String b = new String("Programming");
		String c = "Program" + "ming";
		
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(a.intern() == b.intern());
		
	}
	
	private int cal(int[] nums) {
		return dp(0, nums, 0, nums.length);
	}
	
	private int dp(int k, int[] nums, int i, int j) {
		if (k == nums.length / 2) 	return Math.max(nums[i], nums[j]);
		int a = nums[i] + nums[i+1] > nums[j]? dp(k+1, nums, i+2, j) : dp(k+1, nums, i+1, j-1);
		int b = nums[j] + nums[i] > nums[j-1]? dp(k+1, nums, i+1, j-1) : dp(k+1, nums, i, j-2);
		return Math.max(a, b);
	}

}
