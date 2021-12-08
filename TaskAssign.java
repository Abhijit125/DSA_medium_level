/*

INPUT = [1,3,5,3,1,4]

OUTPUT = [ [0, 2],
		   [4, 5],
		   [1, 3]]
EXPLAINATION  = THE MINIMUM TIME BY ASSIGNING THE JOB TO EACH WORKER IS (idx0, idx2) -> Worker1, (idx4, idx5) -> Worker2, (idx1, idx3) -> Worker3 so the cost will be 6(input[0]+input[2] = (1+5) = 6 and so on)

*/

import java.util.*;
class TaskAssign 
{
	public static void main(String[] args) 
	{
		int k = 3;
		ArrayList<Integer> task = new ArrayList<>(Arrays.asList(1,3,5,3,1,4));
		System.out.println(taskAssignment(k, task));
	}
	public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<>();
		Map<Integer, List<Integer>> taskDurationsToIndices = getTaskDurationsToIndices(tasks);
		
		List<Integer> sortedTasks = tasks;
		Collections.sort(sortedTasks);//1,1,3,3,4,5
		
		for (int idx = 0; idx < k; idx++) {
			int task1Duration = sortedTasks.get(idx);
			List<Integer> indicesWithTask1Duration = taskDurationsToIndices.get(task1Duration);
			int task1Index = indicesWithTask1Duration.remove(indicesWithTask1Duration.size() - 1);
			
			int task2SortedIndex = tasks.size() - 1 - idx;
			int task2Duration = sortedTasks.get(task2SortedIndex);
			List<Integer> indicesWithTask2Duration = taskDurationsToIndices.get(task2Duration);
			int task2Index = indicesWithTask2Duration.remove(indicesWithTask2Duration.size() - 1);
			
			ArrayList<Integer> pairedTask = new ArrayList<>();
			pairedTask.add(task1Index);
			pairedTask.add(task2Index);
			pairedTasks.add(pairedTask);
		}
    return pairedTasks;
  }
	
	public static Map<Integer, List<Integer>> getTaskDurationsToIndices(List<Integer> tasks) {
		
		Map<Integer, List<Integer>> taskDurationsToIndices = new HashMap<>();
		
		for(int idx = 0; idx < tasks.size(); idx++) {
			int taskDuration = tasks.get(idx);
			if(taskDurationsToIndices.containsKey(taskDuration)) {
				taskDurationsToIndices.get(taskDuration).add(idx);
			} else {
				List<Integer> temp = new 	ArrayList<>();
				temp.add(idx);
				taskDurationsToIndices.put(taskDuration, temp);
			}
		}
		System.out.println(taskDurationsToIndices);
		return taskDurationsToIndices;
	}
}
