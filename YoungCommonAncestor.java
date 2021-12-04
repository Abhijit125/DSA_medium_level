/*
Input =					A
	
				B				C

			D		E		F		G

		H		I

TOPVALUE = A
decentOne = E
decentTwo = I


OUTPUT = B

EXPLAINATION = HERE THE INPUT TREE HAVE TOP ANCESTOR IS 'A' AND THE DECENT VALUES ARE 'E' AND 'I' SO THERE YOUNGERANCESTOR IS 'B'('B' IS PARENT OF BOTH 'E' AND 'I'

*/


class YoungCommonAncestor 
{
	public static void main(String[] args) 
	{
		AncesTree at = new AncesTree('A');
		AncesTree top = at;
		at.left = new AncesTree('B');
		at.left.ances = at;
		at.right = new AncesTree('C');
		at.right.ances = at;
		at.left.left = new AncesTree('D');
		at.left.left.ances = at.left;
		at.left.right = new AncesTree('E');
		at.left.right.ances = at.left;
		AncesTree decentOne = at.left.right;
		at.right.left = new AncesTree('F');
		at.right.left.ances = at.right;
		at.right.right = new AncesTree('G');
		at.right.right.ances = at.right;
		at.left.left.left = new AncesTree('H');
		at.left.left.left.ances = at.left.left;
		at.left.left.right = new AncesTree('I');
		at.left.left.right.ances = at.left.left;
		AncesTree decentTwo = at.left.left.right;
		
		AncesTree result = findAncesTree(top, decentOne, decentTwo);
		
		System.out.println(result.name);
	}

	public static AncesTree findAncesTree(AncesTree top, AncesTree decentOne, AncesTree decentTwo) {

		int depth1 = getDepth(decentOne, top);

		int depth2 = getDepth(decentTwo, top);
		
		if(depth1 > depth2) {
			return backTrack(decentTwo, decentOne, depth1 - depth2);
		} else {
			return backTrack(decentOne, decentTwo, depth2 - depth1);
		}
	}

	public static int getDepth(AncesTree decent, AncesTree top) {
	
	int depth = 0;
	
	while(decent != top) {
		depth++;
		decent = decent.ances;
	}
	return depth;
	}

	public static AncesTree backTrack(AncesTree lower, AncesTree upper, int height) {

		while(height != 0) {
			upper = upper.ances;
			height--;
		}
		while(upper != lower) {
			lower = lower.ances;
			upper = upper.ances;
		}
		return upper;
	}

	public static class AncesTree
	{
		public char name;
		public AncesTree left;
		public AncesTree right;
		public AncesTree ances;

		public AncesTree(char name) {
			this.name = name;
		}
	}
}
