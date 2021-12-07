/*
Input = 	{	{1,3},
				{2,3,4},
				{0},
				{},
				{2,5},
				{}
			}

OUTPUT = true

Explaination = THE INPUT ARRAY HAVE 6 elements make each element as vertex, each and every array is a link between the vertex e.g(1,3) means node 0 have a link to 1 and 3 and so on. Check it is foring the cycle or not

*/



class CycleInGraph 
{
	public static void main(String[] args) 
	{
		int[][] ar = {
						{1,3},
						{2,3,4},
						{0},
						{},
						{2,5},
						{}
					};
	
		cycleInGraph(ar);
	}

	public boolean cycleInGraph(int[][] edges) {
    int numberOfNodes = edges.length;
		boolean[] visited = new boolean[numberOfNodes];
		boolean[] currentlyInStack = new boolean[numberOfNodes];
		
		for (int node = 0; node < numberOfNodes; node++) {
			if (visited[node]) {
				continue;
			}
			
			boolean containsCycle = isNodeInCycle(node, edges, visited, currentlyInStack);
			if(containsCycle) {
				return true;
			}
		}
		
    return false;
  }
	
	public boolean isNodeInCycle(
	int node, int[][] edges, boolean[] visited, boolean[] currentlyInStack) {
		visited[node] = true;
		currentlyInStack[node] = true;
		
		boolean containsCycle = false;
		int[] neighbors = edges[node];
		for (int neighbor : neighbors) {
			if (!visited[neighbor]) {
				containsCycle = isNodeInCycle(neighbor, edges, visited, currentlyInStack);
			}
			if (containsCycle) {
				return true;
			} else if (currentlyInStack[neighbor]) {
				return true;
			}
		}
		
		currentlyInStack[node] = false;
		return false;
	}
}