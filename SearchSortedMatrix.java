/*
Input :
MATRIX = 
{1,2,3,4,5}
{6,7,8,9,10}
{33,44,55,66,77}

target = 33

OUTPUT = [2,0]
*/

import java.util.*;
class SearchSortedMatrix 
{
	public static void main(String[] args) 
	{
		int[][] matrix = {{1,2,3,4,5},
							{6,7,8,9,10},
							{33,44,55,66,77}};
		int target = 33;

		int[] result = searchInSortedMatrix(matrix, target);
		System.out.println(Arrays.toString(result));
	}

	 public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    int row = 0;
		int col = matrix[0].length - 1;
		while(row < matrix.length && col >= 0) {
			if(matrix[row][col] > target) {
				col--;
			} else if(matrix[row][col] < target) {
				row++;
			} else {
				return new int[] {row, col};
			}
		}
    return new int[] {-1, -1};
  }
}
