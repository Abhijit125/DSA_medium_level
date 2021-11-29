/*
Input = [120,5,7,20,19,200]

Output = 340

EXPLAINATION = MAXIMUM SUBSET VALUE IS (120, 20, 200) which is not in adjucent

*/


class  MaxSubSetSum
{
	public static void main(String[] args) 
	{
		int ar[] = {120,5,7,20,19,200};

		findMaxSubSet(ar);
	}

	public static void findMaxSubSet(int[] ar) {
		
		int second = ar[0];
		int first = Math.max(ar[0],ar[1]);
		
		for(int i = 2; i< ar.length; i++) {

			int current = Math.max(first, second+ar[i]);
			second = first;
			first = current;
		}
		System.out.println(first);
	}
}
