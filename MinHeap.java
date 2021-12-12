
/*
CONSTRUCT MIN HEAP AND ACCORDING METHODS FOR
1> buildHeap()
2> insert()
3> remove()
4> peak()
5> shiftUp()
6> shiftDown()

*/

import java.util.*;
class MinHeap 
{
	static List<Integer> heap = new ArrayList<Integer>();
	public static void main(String[] args) 
	{
		List<Integer> array = new ArrayList<>(Arrays.asList(48,12,24,7,8,-5,24,391,24,56,2,6,8,41));
		System.out.println(buildHeap(array));
	}

	public static List<Integer> buildHeap(List<Integer> array) {
      int firstParentIdx = (array.size() - 2) / 2;
			for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
				siftDown(currentIdx, array.size() - 1, array);
			}
      return array;
    }

	public static void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      int childOneIdx = currentIdx * 2 + 1;
			while (childOneIdx <= endIdx) {
				int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
				int idxToSwap;
				if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
					idxToSwap = childTwoIdx;
				} else {
					idxToSwap = childOneIdx;
				}
				System.out.println("value->"+heap.get(idxToSwap)+" "+heap.get(currentIdx));
				System.out.println("Index->"+idxToSwap+" "+currentIdx);
				if(heap.get(idxToSwap) < heap.get(currentIdx)) {
					swap(currentIdx, idxToSwap, heap);
					currentIdx = idxToSwap;
					childOneIdx = currentIdx * 2 + 1;
				} else {
					return;
				}
			}
    }
	public static void swap(int i, int j, List<Integer> heap) {
			System.out.println(heap);
			Integer temp = heap.get(j);
			heap.set(j, heap.get(i));
			heap.set(i, temp);
		}

	public static void siftUp(int currentIdx, List<Integer> heap) {
      int parentIdx = (currentIdx - 1) /2;
			while(currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
				swap(currentIdx, parentIdx, heap);
				currentIdx = parentIdx;
				parentIdx = (currentIdx - 1) / 2;
			}
    }

    public static int peek() {
      return heap.get(0);
    }

    public static int remove() {
			swap(0, heap.size() - 1, heap);
			int valueToRemove = heap.get(heap.size() - 1);
			heap.remove(heap.size() - 1);
			siftDown(0, heap.size() - 1, heap);
      return valueToRemove;
    }

    public static void insert(int value) {
      heap.add(value);
			siftUp(heap.size() - 1, heap);
    }

}
