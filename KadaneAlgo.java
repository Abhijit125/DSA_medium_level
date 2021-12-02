/*
INPUT = [3,5,-9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]

OUTPUT = 19

EXPLAINATION  = THE SUBARRAY (1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1) have maximum sum which is 19

*/

import java.util.*;
class KadaneAlgo 
{
	public static void main(String[] args) 
	{
		int ar[] = {3,5,-9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};

		findMaxSum(ar);
	}

	public static void findMaxSum(int[] ar) {
	
		int maxNext = ar[0];
		int maxEle = ar[0];

		for(int i = 1; i< ar.length; i++) {

			int value = ar[i];

			maxNext = Math.max(maxNext+value, value);

			maxEle = Math.max(maxNext, maxEle);
		}
		System.out.println(maxEle);
	}
}
