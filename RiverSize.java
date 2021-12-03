/*
INPUT =				{
						{1, 0, 0, 1, 0},
						{1, 0, 1, 0, 0},
						{0, 0, 1, 0, 1},
						{1, 0, 1, 0, 1},
						{1, 0, 1, 1, 0}
					}

OUTPUT = [2,1,5,2,2]

EXPLAINATION : LETS PUT 1 AS RIVER AND 0 AS LAND SO THE RIVER SIZE WITH ADJUCENT ARE (2, 1, 5,2, 2) e.g: position ar[0][0] is 1 and a[1][0] is 1 so RIVER SIZE IS 2 and SO ON
*/
import java.util.*;
class RiverSize 
{
	public static void main(String[] args) 
	{
		int[][] ar = {
						{1, 0, 0, 1, 0},
						{1, 0, 1, 0, 0},
						{0, 0, 1, 0, 1},
						{1, 0, 1, 0, 1},
						{1, 0, 1, 1, 0}
					};

			findRiverSize(ar);
	}

	public static void findRiverSize(int ar[][]) {
		List<Integer> lsResult = new ArrayList<>();
		for(int i = 0; i< ar.length; i++) {
			for(int j = 0; j< ar[0].length; j++) {
				if(ar[i][j] == 1) {
					findNextEle(i, j, lsResult, ar);
				}
			}
		}
		for(int[] data : ar) {
			System.out.println(Arrays.toString(data));
		}
		System.out.println(lsResult);
	}

	public static void findNextEle(int i, int j, List<Integer> lsResult, int[][] ar) {
		ar[i][j] = 0;
		lsResult.add(allMovements(i, j, ar, 1));
	}

	public static int allMovements(int i, int j, int[][] ar, int count) {
		count = right(i, j+1, ar, count);

		count = left(i, j - 1, ar, count);

		count = up(i - 1, j, ar, count);

		count = down(i + 1, j, ar, count);

		return count;
	}
	
	public static int right(int i, int j, int[][] ar, int c) {
		if(j >= ar.length || ar[i][j] == 0) return c;

		else if(j < ar[0].length) {
			ar[i][j] = 0;
			c = allMovements(i, j, ar, c) + 1;
		}
		return c;
	}

	public static int left(int i, int j, int[][] ar, int c) {
		if(j < 0 || ar[i][j] == 0) return c;

		else if(j >= 0) {
			ar[i][j] = 0;
			c = allMovements(i, j, ar, c) + 1;
		}
		return c;
	}

	public static int up(int i, int j, int[][] ar, int c) {
		if(i < 0 || ar[i][j] == 0) return c;

		else if(i >= 0) {
			ar[i][j] = 0;
			c = allMovements(i, j, ar, c) + 1;
		}
		return c;
	}

	public static int down(int i, int j, int[][] ar, int c) {
		if(i >=ar.length || ar[i][j] == 0) return c;
		
		else if(i < ar.length) {
			ar[i][j] = 0;
			c = allMovements(i, j, ar, c) + 1;
		}
		return c;
	}
}
