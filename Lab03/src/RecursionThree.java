
public class RecursionThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] list = {9, 5, 1, 7, 4, 6, 3, 2, 10, 8};
		int key = 8;
		
		int[] sortedList = selectSort(list);
		
		for(int i = 0; i < sortedList.length; i++) {
			System.out.print(sortedList[i] + " ");
		}
		
		System.out.println();
		
		binarySearch(sortedList, key);
		binarySearch(sortedList, 10);
		binarySearch(sortedList, 4);
		
	}
	
	public static int[] selectSort(int[] list) {
		int minIndex, temp;
		
		for(int i = 0; i < list.length -1; i++) {
			minIndex = i; 
			
			for(int j = i+1; j < list.length; j++) {

				if(list[j] < list[minIndex]) {
					minIndex = j;
				}
				
			}
			temp = list[i];
			list[i] = list[minIndex];
			list[minIndex] = temp;
		}
		
		return list;
	}
	
	public static void binarySearch(int[] list, int key) {
		int mid;
		int low = 0;
		int high = list.length -1;
		
		while(low <= high) {
			
			mid = (low + high) / 2;
			if(key == list[mid]) {
				System.out.println("The key " + key + " is at index: " + mid);
				break;
			}
			else if(key > list[mid]) {
				low = mid + 1;
			}else if(key < list[mid]) {
				high = mid -1;
			}
		}
	}

}
