/*input :
width = 3				
height = 4

OUTPUT = 10

Explaination = THE GRAPH HAVE 3 WIDTH LENGTH AND 4 HEIGHT LENGTH THE NUMBER OF WAYS TO TRAVEL FROM RIGHT END IS 10

FOR WIDTH 2, HEIGHT 3 NUMBER OF WAYS IS 3 TO TRAVERSE

*/


class NoWaysGraph 
{
	public static void main(String[] args) 
	{
		int width = 4;
		int height = 3;
		System.out.println(waysToFind(width, height));
	}

	public static int waysToFind(int width, int height) {
		
		int numerator = fact(width - 1 + height - 1);

		int denom = fact(width - 1) * fact(height - 1);

		return numerator / denom;
		
	}

	public static int fact(int n) {
		int result = 1;
		for(int i = 2; i< n + 1; i++) {
			result *= i;
		}
		return result;
	}
}
