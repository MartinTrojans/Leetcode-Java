/*
	class Solution {
	public int rangeBitwiseAnd(int m, int n) {
	        int d = Integer.MAX_VALUE;
	        while ((m & d) != (n & d)) {
	            d <<= 1;
	        }
	        return m & d;
	    }
	};
*/
	class Solution {
	public int rangeBitwiseAnd(int m, int n) {
	        int i = 0;
	        while (m != n) {
	            m >>= 1;
	            n >>= 1;
	            ++i;
	        }
	        return (m << i);
	    }
	};