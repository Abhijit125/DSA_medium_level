/*

FIND THE PERMUTATION OF ARRAY

INPUT = [1,2,3]

OUTPUT = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

*/
import java.util.*;
class Permutation 
{
	public static void main(String[] args) 
	{
		List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));
		List<List<Integer>> result = new ArrayList<>();
		getPermutations(0, input, result);
	}

	public static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
		if(i == array.size() - 1) {
		permutations.add(new ArrayList<Integer>(array));
	} else {
			for(int j = i; j < array.size(); j++) {
				swap(array, i, j);
				System.out.println("before Get "+i+" "+j);
				System.out.println(array);
				getPermutations(i + 1, array, permutations);
				System.out.println("After Get "+i+" "+j);
				System.out.println(array);
				swap(array, i, j);
			}
		}
	}
	public static void swap(List<Integer> array, int i, int j) {
		Integer tmp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, tmp);
	}
}
