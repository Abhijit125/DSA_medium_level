
/*
POWERSET PROBLEM

Input = [1,2,3]

OUTPUT = [[], [1], [2], [3], [1,2], [2,3],[1,3],[1,2,3]]

*/

import java.util.*;
class PowerSet {
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));

		List<List<Integer>> result = powerset(input);
		
		System.out.println(result);
	}
	public static List<List<Integer>> powerset(List<Integer> array) {
  	List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets.add(new ArrayList<>());
		for (Integer ele : array) {
			int length = subsets.size();
			for(int i = 0; i< length; i++) {
				List<Integer> currentSubset = new ArrayList<Integer>(subsets.get(i));
				currentSubset.add(ele);
				subsets.add(currentSubset);
			}
		}
    return subsets;
  }
}
