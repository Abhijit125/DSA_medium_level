/*
INPUT =			{
						{1,1,1,1,0,0},
						{0,1,0,1,1,1},
						{0,0,1,0,1,0},
						{1,1,0,0,1,0},
						{1,0,1,1,0,0},
						{1,0,0,0,0,1}
					 }

OUTPUT =		[1, 1, 1, 1, 0, 0]
				[0, 1, 0, 1, 1, 1]
				[0, 0, 0, 0, 1, 0]
				[1, 1, 0, 0, 1, 0]
				[1, 0, 1, 1, 0, 0]
				[1, 0, 0, 0, 0, 1]

EXPLAINATION = the outer boarder '1' value is river if it is connected to its inner river(i.e '1') then dont make any changes if not make it Iseland(i.e '0') and so on

*/


import java.util.*;
class RemovalIseLand
{
	public static void main(String[] args) 
	{
		int ar[][] = {
						{1,1,1,1,0,0},
						{0,1,0,1,1,1},
						{0,0,1,0,1,0},
						{1,1,0,0,1,0},
						{1,0,1,1,0,0},
						{1,0,0,0,0,1}
					 };

		findRemovalIseLand(ar);

		findIseLand(ar);

		for(int[] data : ar) {
			System.out.println(Arrays.toString(data));
		}
	}

	public static void findRemovalIseLand(int[][] ar) {
		
		int endRow = ar.length - 1;
		int endCol = ar[0].length - 1;
		
		for(int j = 0; j< endCol; j++) {
			makeRemoval(ar, 0, j);
		}
		for(int i = 0; i < endRow; i++) {
			makeRemoval(ar, i, endCol);
		}
		for(int j = endCol; j >= 0; j--) {
			makeRemoval(ar, endRow, j);
		}
		for(int i = endRow; i>=0; i--) {
			makeRemoval(ar, i, 0);
		}
	}

	public static void makeRemoval(int ar[][], int i, int j) {
		
		right(ar, i, j + 1);
		left(ar, i, j - 1);
		up(ar, i - 1, j);
		down(ar, i + 1, j);
	}

	public static void right(int[][] ar, int i, int j) {
		if(j >= ar[0].length || ar[i][j] != 1) return;
		
		else {
			ar[i][j] = 3;
			makeRemoval(ar, i, j);
		}
	}
		public static void left(int[][] ar, int i, int j) {
		if(j < 0 || ar[i][j] != 1) return;
		
		else {
			ar[i][j] = 3;
			makeRemoval(ar, i, j);
		}
	}

		public static void up(int[][] ar, int i, int j) {
		if(i < 0 || ar[i][j] != 1) return;
		
		else {
			ar[i][j] = 3;
			makeRemoval(ar, i, j);
		}
	}

		public static void down(int[][] ar, int i, int j) {

		if(i >= ar.length || ar[i][j] != 1) return;
		
		else {
			ar[i][j] = 3;
			makeRemoval(ar, i, j);
		}
	}

	public static void findIseLand(int ar[][]) {

		for(int i = 0; i< ar.length; i++) {
			for(int j = 0; j< ar[0].length; j++) {
				if(ar[i][j] == 3) {
					ar[i][j] = 1;
				} else if(ar[i][j] == 1) {
					ar[i][j] = 0;
				}
			}
		}
	}
}
