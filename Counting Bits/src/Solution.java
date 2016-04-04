
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        
        int flag = 1;
        for (int i = 1; i <= num; i++) {
        	if (i / flag == 2)	flag *= 2;
        	res[i] = res[i % flag] + 1;
        }
        return res;
    }
}
