
public class Lab11 {

	public static void main(String[] args) {
		
		//Question 1 test
		Integer[] heaplist = { -44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		heapSort(heaplist);
		for(int i = 0; i < heaplist.length; i++)
			System.out.print(heaplist[i] + " ");
		
		
		//Question 2 test
		Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		quickSort(list);
		for(int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}
	
	//Question 1-------------------------------------------
	public static <E extends Comparable<E>> void heapSort(E[] list){

		//implement body
		Heap<E> heap = new Heap<>();
		
		//Add elements to the heap
		for(int i = 0; i < list.length; i++)
			heap.add(list[i]);
		
		//Remove elements from heap
		for(int i = list.length; i >= 0; i--)
			list[i] = heap.remove();
	}
	
	//Question 2-------------------------------------------
	public static <E extends Comparable<E>> void quickSort(E[] list){

		//implement body
		quickSort(list, 0, list.length - 1);
	}
	
	public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
		if(last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
		E pivot = list[first]; //First element is pivot
		int low = first + 1;   //Index for forward search
		int high = last;	   //Index for backward search
		
		while(high > low) {
			//Search forward from left
			while(low <= high && list[low].compareTo(pivot) <= 0) 
				low++;
			
			//Search backward from right
			while(low <= high && list[high].compareTo(pivot) > 0)
				high--;
			
			//Swap two elements in the list
			if(high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
			while(high > first && list[high].compareTo(pivot) >= 0) 
				high --;
			
			//Swap pivot with list[high]
			if(pivot.compareTo(list[high]) > 0) {
				list[first] = list[high];
				list[high] = pivot;
				return high;
			}
			else 
				return first;
	}
}
