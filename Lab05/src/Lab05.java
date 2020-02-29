
import java.util.ArrayList;

public class Lab05 {

	public static void main(String[] args) {
		//GenericStack class is below ***
		
		GenericStack<Integer> intTest = new GenericStack<>();
		intTest.push(10);
		intTest.push(7);
		intTest.push(2);
		
		System.out.println("Size: " + intTest.getSize() + "\nIs empty: " + intTest.isEmpty()
			+ "\nPeek: " + intTest.peek());
		
		Integer[] list = {9, 5, 1, 7, 4, 6, 3, 2, 10, 8};
		int key = 8;
		
		selectionSort(list);
		
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		
		System.out.println("\nLinear search (8): " + linearSearch(list, 8));
		
		System.out.println("Binary search (8): " + binarySearch(list,8));
	}
	/*Results 
	 * Size: 3
		Is empty: false
		Peek: 2
		1 2 3 4 5 6 7 8 9 10 
		Linear search (8): 7
		Binary search (8): 7
	 */
	
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		
		for(int i = 0; i < list.length -1; i++) {
			if(list[i] == key) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		int mid;
		int low =0;
		int high = list.length;
				
		while(low <= high) {
			mid = (low + high) / 2;
			
			if(key.compareTo(list[mid]) == 0)
				return mid;
			else if(key.compareTo(list[mid]) > 0)
				low = mid + 1;
			else if(key.compareTo(list[mid]) < 0)
				high = mid - 1;
		}
		return -1;
	}
	
	public static <E extends Comparable<E>> void selectionSort(E[] list) {
		int minIndex;
		E temp;
		
		for(int i = 0; i < list.length-1; i++) {
			minIndex = i;
			for(int j = i + 1; j < list.length; j++) {
				if( list[j].compareTo(list[minIndex]) < 0)
					minIndex = j;
			}
			temp = list[i];
			list[i] = list[minIndex];
			list[minIndex] = temp;
			
		}
	}
	
}

