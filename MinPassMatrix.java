/*

INPUT =				{
						{0, -1 , -3, 2, 0},
						{1, -2 , -5,-1,-3},
						{3,  0 ,  0,-4,-1}
					}
OUTPUT = 3

EXPLAINATION = THERE ARE 3 VISIT TO CHANGE EVERY (-) element to (+) element. 1> 0 comes the adjucent element will not change to (+) value
2> If (+) value comes then only the aducent element will change its Value to(+) if (-) is there.
3> If (-) value comes then no any changes required skip it and go to next position
				
*/

import java.util.*;
class MinPassMatrix 
{
	public static void main(String[] args) 
	{
		int ar[][] = {
						{0, -1 , -3, 2, 0},
						{1, -2 , -5,-1,-3},
						{3,  0 ,  0,-4,-1}
					};

		System.out.println(minimumPassesOfMatrix(ar));
	}

	public static int minimumPassesOfMatrix(int[][] matrix) {
			int passes = convertNegatives(matrix);
			return (!containsNegative(matrix)) ? passes - 1 : -1;
		}
		
		public static int convertNegatives(int[][] matrix) {
			
			List<int[]> queue = getAllPositivePositions(matrix);
			for(int[] data : queue) {
				System.out.println(Arrays.toString(data));
			}
			
			int passes = 0;
			
			while (queue.size() > 0) {
				int currentSize = queue.size();
				
				while(currentSize > 0) {
					
					int[] vals = queue.remove(0);
					int currentRow = vals[0];
					int currentCol = vals[1];
					
					List<int[]> adjacentPositions = getAdjacentPositions(currentRow, currentCol, matrix);
					
					for(int[] position : adjacentPositions) {
						int row = position[0];
						int col = position[1];
					int value = matrix[row][col];
					
					if(value < 0) {
						matrix[row][col] *= -1;
						queue.add(new int[]{row, col});
					}
				}
				
				currentSize -= 1;
			}
			
			passes += 1;
		}
		return passes;
  }
	
	public static List<int[]> getAllPositivePositions(int[][] matrix) {
		List<int[]> positivePositions = new ArrayList<>();
		
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[row].length; col++) {
				int value = matrix[row][col];
				if(value > 0) {
					positivePositions.add(new int[] {row, col});
				}
			}
		}
		return positivePositions;
	}
	
	public static List<int[]> getAdjacentPositions(int row, int col, int[][] matrix) {
		
		List<int[]> adjacentPositions = new ArrayList<>();
		
		if(row > 0) {
			adjacentPositions.add(new int[] {row - 1, col});
		}
		if(row < matrix.length - 1) {
			adjacentPositions.add(new int[] {row + 1, col});
		}
		if(col > 0) {
			adjacentPositions.add(new int[] {row, col - 1});
		}
		if(col < (matrix[0].length - 1)) {
			adjacentPositions.add(new int[] {row, col + 1});
		}
		
		return adjacentPositions;
	}
	
	public static boolean containsNegative(int[][] matrix) {
	for (int[] row : matrix) {
		for (int value : row) {
			if (value < 0) {
				return true;
			}
		}
	}
		return false;
	}
}
