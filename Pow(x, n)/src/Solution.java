
public class Solution {
	static boolean negflag = false;
    public double myPow(double x, int n) {
    	if (n < 0){
    		negflag = true;
    		return 1 / dp(x, -n);
    	}
    	else
    		return dp(x, n);
    	
    }
    private double dp(double x, int n){
    	if (n == 0)
    		return 1;
    	if (n == 1)
    		return x;
    	if (n == 2)
    		return x * x;
    		
    	int m = n / 2;
    	int k = n % 2;
    	double v = dp(x, m);
    	if (negflag == true && v > 100000)
    		return 100000;
    	if (negflag == false && v < 0.00001)
    		return 0;
    	
    	if (k == 0)
    		return v * v;
    	else
    		return v * v * x;
    }
}