/*

INPUT : str1 = "abc"
str2 = "yabd"

OUTPUT = 3 

EXPLAINATION = THERE WILL BE THREE OPERATION WE CAN PERFORM (insert, delete, concate) to make the 1st String to 2nd String

IN this example in 1st string 'y' missing c is replaced by d
*/

class LevensDistance 
{
	public static void main(String[] args) 
	{
		String str1 = "abc";
		String str2 = "yabd";

		System.out.println(levenshteinDistance(str1, str2));

	}

	public static int levenshteinDistance(String str1, String str2) {
    String small = str1.length() < str2.length() ? str1 : str2;
		String big = str1.length() >= str2.length() ? str1 : str2;
		int[] evenEdits = new int[small.length() + 1];
		int[] oddEdits = new int[small.length() + 1];
		for(int j = 0; j< small.length() + 1; j++) {
			evenEdits[j] = j;
		}
		int[] currentEdits;
		int[] previousEdits;
		for(int i = 1; i< big.length() +1; i++) {
			if(i % 2 == 1) {
				currentEdits = oddEdits;
				previousEdits = oddEdits;
			} else {
				currentEdits = evenEdits;
				previousEdits = oddEdits;
			}
			currentEdits[0] = i;
			for(int j = 1; j< small.length() + 1; j++) {
				if(big.charAt(i - 1) == small.charAt(j - 1)) {
					currentEdits[j] = previousEdits[j -1];
				} else {
					currentEdits[j] = 1+Math.min(previousEdits[j - 1], Math.min(previousEdits[j], currentEdits[j-1]));
				}
			}
		}
    return big.length() % 2 == 0 ? evenEdits[small.length()] : oddEdits[small.length()];
  }
}
