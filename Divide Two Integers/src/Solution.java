
public class Solution {
    public int divide2(int dividend, int divisor) {
        boolean neg = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
        	neg = true;
        long res = 0;
        long tempsum = 0;
        long temp = 0;
        long a = Math.abs(dividend);
        long b = Math.abs(divisor);
        if (b > a)
        	return 0;
        if (b == 1){
        	res = a;
        	if (neg)
            	res = -res;
            return (int)res;
        }
        	
        while (a > b){
        	tempsum = b;
        	temp = 1;
        	while (tempsum + tempsum< a){
        		tempsum += tempsum;
        		temp += temp;
        	}
        	a -= tempsum;
        	res += temp;
        }
        if (neg)
        	res = -res;
        return res>Integer.MAX_VALUE? Integer.MAX_VALUE: (int)res;
    }
    
    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    // It's easy to handle edge cases when
    // operate with long numbers rather than int
    public long divideLong(long dividend, long divisor) {

        // Remember the sign
        boolean negative = dividend < 0 != divisor < 0;

        // Make dividend and divisor unsign
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;

        // Return if nothing to divide
        if (dividend < divisor) return 0;

        // Sum divisor 2, 4, 8, 16, 32 .... times
        long sum = divisor;
        long divide = 1;
        while ((sum+sum) <= dividend) {
            sum += sum;
            divide += divide;
        }

        // Make a recursive call for (devided-sum) and add it to the result
        return negative ? -(divide + divideLong((dividend-sum), divisor)) :
            (divide + divideLong((dividend-sum), divisor));
    }
}