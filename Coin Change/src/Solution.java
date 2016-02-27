import java.util.Arrays;

public class Solution {
	/*
    public int coinChange(int[] coins, int amount) {
    	Arrays.sort(coins);
    	return helper(coins, amount, coins.length-1);
    }
    
    private int helper(int[] coins, int amount, int index){
    	if (amount == 0)
    		return 0;
    	if (amount < 0)
    		return -1;
    	for (int i = index; i >= 0; i--){
			int temp = helper(coins, amount-coins[i], i);
			if(temp != -1)
				return temp + 1;
    	}
    	return -1;
    }
    */
	/*
	public int coinChange(int[] coins, int amount) {
    	return helper(coins, amount, 0);
    }
	private int helper(int[] coins, int amount, int index){
		//end
		if (amount == 0)
			return 0;
		if (amount < 0 || index == coins.length)
			return -1;
		//recursive
		int temp1 = helper(coins, amount-coins[index], index);
		int temp2 = helper(coins, amount, index+1);
		//check valid
		if (temp1 == -1 && temp2 == -1)
			return -1;
		if (temp1 == -1)
			temp1 = Integer.MAX_VALUE-1;
		if (temp2 == -1)
			temp2 = Integer.MAX_VALUE; 
			
		return Math.min(temp1+1, temp2);
	}
	*/
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE-1;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i + coins[j] <= amount)
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE-1 ? -1 : dp[amount];
    }
}