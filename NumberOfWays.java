/*
INPUT1 = 6
INPUT2 = [1,5]

OUTPUT = 2

EXPLAINATION = THERE ARE 2 WAYS TO MAKE THE COINS EQUAL. (1*6), (1*1 + 1*5)

*/


import java.util.*;
class NumberOfWays 
{
	public static void main(String[] args) 
	{
		int input1 = 6;
		int[] input2 = {1,5};

		noOfWays(input2, input1);
	}

	public static void noOfWays(int[] input2, int n) {
		int[] ways = new int[n + 1];
		ways[0] = 1;
		for(int data : input2) {
			for(int i = 1; i< n+1; i++) {
				if(data <= i) {
					ways[i] += ways[i - data];
				}
			}
		}
		System.out.println(Arrays.toString(ways));
	}
}
