
public class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int[] res = new int[l1+l2];
        
        for (int i = l1-1; i >= 0; i--) {
        	for (int j = l2-1; j >= 0; j--){
        	    int index = l1+l2-i-j-2;
        		res[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        		res[index+1] += res[index] / 10;
        		res[index] = res[index] % 10;
        	}
        }
        
        StringBuilder fres = new StringBuilder();
        for (int i = res.length-1; i >= 0; i--) {
        	if (!(fres.length() == 0 && res[i] == 0))
        		fres.append(res[i]);
        }
        
        return fres.length() == 0? "0":fres.toString();
    }
}