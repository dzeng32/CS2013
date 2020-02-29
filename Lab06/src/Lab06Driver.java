import java.util.ArrayList;

public class Lab06Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Remove duplicates from arraylist
		ArrayList<Integer> dupes = new ArrayList<>();
		dupes.add(1);
		dupes.add(2);
		dupes.add(3);
		dupes.add(2);
		dupes.add(5);
		dupes.add(1);
		
		Lab06 test = new Lab06();
		
		test.removeDuplicates(dupes);
		System.out.println("Remove dupes: " + dupes);
		
		//2. Find the largest number
		Integer[][] maxNum = {
						{1, 3, 5},
						{6, 3, 9, 8},
						{5, 8, 11, 10, 7}
						};
		
		System.out.println("Largest number is: " + test.max(maxNum));
		
		//3. Sort the array list
		ArrayList<Integer> sorts = new ArrayList<>();
		sorts.add(10);
		sorts.add(5);
		sorts.add(7);
		sorts.add(3);
		sorts.add(1);
		sorts.add(9);
		
		test.sort(sorts);
		System.out.println("Sorted: " + sorts);
		
		//4. Shuffle the array list
		ArrayList<Integer> shuffles = new ArrayList<>();
		shuffles.add(1);
		shuffles.add(2);
		shuffles.add(3);
		shuffles.add(4);
		shuffles.add(5);
		
		test.shuffle(shuffles);
		System.out.println("Shuffled array list: " + shuffles);
	}
}

/* Console results:
Remove dupes: [1, 2, 3, 5]
Largest number is: 11
Sorted: [1, 3, 5, 7, 9, 10]
Shuffled array list: [3, 2, 1, 4, 5]
*/