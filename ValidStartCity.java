/*

INPUT = distance = {5,25,15,10,15}
		fuel = {1,2,1,0,3}
		mpg = 10

OUTPUT = 4

Explaination = FIND THE INDEX WHERE WE CAN START AND REACH TO THE END POINT WITH SUFFICIENT AMOUNT OF FUEL
Eg : IF WE START FROM INDEX 4, WE CAN REACH THE INDEX 4 WITh SUFFICiENT FUEL. 

*/

class ValidStartCity 
{
	public static void main(String[] args) 
	{
		int[] distance = {5,25,15,10,15};

		int[] fuel = {1,2,1,0,3};

		int mpg = 10;

		findIdx(distance, fuel, mpg);
	}

	public static void findIdx(int[] distance, int[] fuel, int mpg) {
		int total = 0;
		int minVal = 0;
		int idx = 0;
		for(int i = 1; i< distance.length; i++) {
			total = total + (mpg * fuel[i-1] - distance[i-1]);
			
			if(total < minVal) {
				minVal = total;
				idx = i;
			}
		}
		System.out.println(idx);
	}
}
