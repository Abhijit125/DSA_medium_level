/*
INPUT = [2,3,1,-4,-4,2]

OUTPUT = true

EXPLAINATION = THE GIVEN INPUT IS FORMING SINGLE CYCLE. ex -> 1st element is 2, it will go to index 2 (0+2) and so on finally it ends at index 4
each and every elements comes once which traversing

*/

class SingleCycleCheck 
{
	public static void main(String[] args) 
	{
		int ar[] = {2,3,1,-4,-4,2};

		System.out.println(singleCycleCheck(ar));
	}
	
	public static boolean singleCycleCheck(int[] array) {
    int numEl = 0;
		int crnt = 0;
		while(numEl < array.length) {
			if(numEl > 0 && crnt == 0) return false;
			numEl++;
			crnt = getNextIdx(crnt, array);
		}
		System.out.println(crnt);
    return crnt == 0;
  }
	
	public static int getNextIdx(int crnt, int[] array) {
		int jump = array[crnt];
		int nextIdx = (crnt + jump) % array.length;
		return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
	}
}
