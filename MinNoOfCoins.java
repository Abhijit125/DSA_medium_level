/*
INPUT1 = 7
INPUT2 = [1,2,5,10]

OUTPUT = 2 COINS

EXPLAINATION : THERE ARE 2 MIN COINS NEEDED TO MAKE 7 AMOUNT (2 + 5)

*/

import java.util.*;
class MinNoOfCoins 
{
	public static void main(String[] args) 
	{
		int n = 7;
		int input[] = {1,5,10};

		findMinTimesCoin(n, input);
	}

	public static void findMinTimesCoin(int n, int[] denoms) {
		int[] numOfCoins = new int[n+1];
		Arrays.fill(numOfCoins, Integer.MAX_VALUE);
		numOfCoins[0] = 0;
		int toCompare = 0;
		for(int denom : denoms) {
			for(int amount = 0; amount < numOfCoins.length; amount++) {
				if(denom <= amount) {
					if(numOfCoins[amount-denom] == Integer.MAX_VALUE) {
						toCompare = numOfCoins[amount - denom];
					} else {
						toCompare = numOfCoins[amount - denom] +1;
					}
					numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
				}
			}
		}
		System.out.println(Arrays.toString(numOfCoins));
	}
}
