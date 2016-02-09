
public class Solution {
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        
        for (int i = 0; i < len; i++){
        	int curGas = 0;
        	for (int j = i; ; j++){
        		curGas += gas[j%len];
        		curGas -= cost[j%len];
        		if (curGas < 0)
        			break;
        		if (j - len == i - 1){
        			return i;
        		}
        	}
        }
        
        return -1;
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int curSum = 0;
        int total = 0;
        int index = 0;
        
        for (int i = 0; i < len; i++){
        	curSum += gas[i] - cost[i];
        	total += gas[i] - cost[i];
        	if (curSum < 0){
        		curSum = 0;
        		index = i + 1;
        	}
        }
        if (total < 0)
        	return -1;
        else
        	return index;
        
    }
}