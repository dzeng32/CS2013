

public class Lab10 {

	public static void main(String[] args) {
		
		//Question 1 test
		Integer[] list = {1, 9, 4, 6, 5, -4};
		insertionSort(list);
		System.out.println("Insertion sort test: ");
		
		for(int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		
		System.out.println();
		
		//Question 2 test
		Integer[] list2 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		bubbleSort(list2);
		System.out.println("Bubble Sort test: ");
		
		for (int i = 0; i < list2.length; i++)
			System.out.print(list2[i] + " ");
		
		System.out.println();
		
		
		//Question 3 test
		Integer[] list3 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		mergeSort(list3);
		System.out.println("Merge sort test: ");
		
		for(int i = 0; i < list3.length; i++)
			System.out.print(list3[i] + " ");
	}
	
	//Question 1
	public static <E extends Comparable<E>> void insertionSort(E[] list){

		//implement body
		for(int i = 1; i < list.length; i++) {
			E currentElement = list[i];
			int j;
			
			for(j = i - 1; j >= 0 && list[j].compareTo(currentElement) > 0; j--) {
				list[j + 1] = list[j];
			}
			list[j + 1] = currentElement;
		}
	}
	
	//Question 2
	public static <E extends Comparable<E>> void bubbleSort(E[] list){
		
		//implement body
		E temp;
		
		for(int i = 1; i < list.length; i++) {
			
			for(int j = 0; j < list.length - i; j++) {
				
				if(list[j].compareTo(list[j + 1]) > 0) {
					temp = list[j];
					list[j] = list[j+1];
					list[j + 1] = temp;
				}				
			}
		}
	}
	
	//Question 3
	public static <E extends Comparable<E>> void mergeSort(E[] list){

		//implement body
		if(list.length > 1) {
			
			//Merge sort the first half
			int firstHalfLength = list.length / 2;
			@SuppressWarnings("unchecked")
			E[] firstHalf = (E[]) new Comparable[firstHalfLength];
			
			//E[] firstHalf = (E[]) Array.newInstance(list, list.length / 2);
			
			System.arraycopy(list, 0, firstHalf, 0, firstHalfLength);
			mergeSort(firstHalf);
			
			//Merge sort the second half
			int secondHalfLength = list.length - firstHalfLength;
			
			@SuppressWarnings("unchecked")
			E[] secondHalf = (E[]) new Comparable[secondHalfLength];
			
			//E[] secondHalf = (E[]) new Object[list.length / 2];
			
			System.arraycopy(list, firstHalfLength, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			//Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
	}
	
	public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
		int currentIndex1 = 0;
		int currentIndex2 = 0;
		int tempIndex = 0;
		
		while(currentIndex1 < list1.length && currentIndex2 < list2.length) {
			if(list1[currentIndex1].compareTo(list2[currentIndex2]) < 0)
				temp[tempIndex++] = list1[currentIndex1++];
			else
				temp[tempIndex++] = list2[currentIndex2++];
		}
		
		while(currentIndex1 < list1.length)
			temp[tempIndex++] = list1[currentIndex1++];
		
		while(currentIndex2 < list2.length)
			temp[tempIndex++] = list2[currentIndex2++];
		
	}
}
