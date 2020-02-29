
import java.util.List;
import java.util.ArrayList;
import java.math.*;
import java.util.Random;

public class Lab06 {

	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		//ArrayList<E> newList = new ArrayList<E>();
		//newList.add(list.get(0));
		
		for(int i = 0; i < list.size()-1; i++) {
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(i).equals(list.get(j))){
					list.remove(j);
				}
			}
		}
		return list;
	}
	
	public static <E extends Comparable<E>> E max(E[][] list) {
		E largest = list[0][0];
		
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j <list[i].length; j++) {
				if(largest.compareTo(list[i][j]) < 0)
					largest = list[i][j];
			}
		}
		return largest;
	}
	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		E currentMin;
		int currentMinIndex;
		
		for(int i = 0; i < list.size(); i++) {
			currentMin = list.get(i);
			currentMinIndex = i;
			
			for(int j = i + 1; j < list.size(); j++) {
				if(currentMin.compareTo(list.get(j)) > 0) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}
			if(currentMinIndex != i) {
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
		}
	}
	
	public static <E> void shuffle(ArrayList<E> list) {

		//E temp;
		//int tempIndex;
		
		Random rand = new Random();
		
		ArrayList<E> randList = new ArrayList<>();
		/* First attempt
		for(int i = 0; i < list.size(); i++) {
			
			int randInt = rand.nextInt(list.size());

			temp = list.get(randInt);
			tempIndex = randInt;
			
			list.set(i, temp);
			list.set(tempIndex, list.get(i));
		}*/
		
		while(!list.isEmpty()) {
			int randInt = rand.nextInt(list.size());
			randList.add(list.get(randInt));
			list.remove(randInt);
		}
		
		for(int i = 0; i < randList.size(); i++)
			list.add(randList.get(i));
	}
}
