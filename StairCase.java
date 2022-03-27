/*

INPUT : HEIGHT = 4, max Step = 2

OUTPUT = 5 i.e 1 > 1,1,1,1
			   2> 1,2,1
			   3> 2,1,1
			   4> 2,2

*/

class StairCase 
{
	public static void main(String[] args) 
	{
		int height = 4;
		int maxStep = 2;
		System.out.println(numberOfWaysToTop(height, maxStep));
	}

	public static int numberOfWaysToTop(int height, int maxSteps) {
		if(height <= 1) {
			return 1;
		}
		
	 int numberOfWays = 0;
		for(int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
			numberOfWays += numberOfWaysToTop(height - step, maxSteps);
		}
		
		return numberOfWays;
	}
}
