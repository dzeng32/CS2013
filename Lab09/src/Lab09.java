
import java.util.*;
import java.io.*;

public class Lab09 {
	
	public static void main(String[] args) {
		
		try {
			InputStream myInput = new FileInputStream("D:\\CSU\\CS2013 Programing with Data Structures\\LincolnLab09.txt");
			InputStream myInput2 = new FileInputStream("D:\\CSU\\CS2013 Programing with Data Structures\\LincolnLab09.txt");
			InputStream myInput3 = new FileInputStream("D:\\CSU\\CS2013 Programing with Data Structures\\LincolnLab09.txt");

			Scanner myInputFile = new Scanner(myInput);
			Scanner myInputFile2 = new Scanner(myInput2);
			Scanner myInputFile3 = new Scanner(myInput3);
			
			readAndDisplay(myInputFile);
			readVowels(myInputFile2);
			countOccurances(myInputFile3);
			/*
			while(myInputFile.hasNext()) {
				text = myInputFile.next();
				System.out.println(text + " ");
			}*/
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void readAndDisplay(Scanner input) {
		
		Set<String> set = new TreeSet<>();
		
		while(input.hasNext()) {
			set.add(input.next());
		}
		
		System.out.println(set);
	}
	
	public static void readVowels(Scanner input) {
		
		ArrayList<String> list = new ArrayList<>();
		int a = 0, e = 0, i = 0, o = 0, u = 0;
		
		while(input.hasNext()) {
			list.add(input.next());
		}
		
		for(int j = 0; j < list.size(); j++) {
			for(int k = 0; k < list.get(j).length(); k++) {
				
				if(list.get(j).charAt(k) == 'a')
					a++;
				else if(list.get(j).charAt(k) == 'e')
					e++;
				else if(list.get(j).charAt(k) == 'i')
					i++;
				else if(list.get(j).charAt(k) == 'o')
					o++;
				else if(list.get(j).charAt(k) == 'u')
					u++;
			}
		}
		System.out.println("\na: " + a + ", e: " + e + ", i: " + i + ", o: " + o + ", u: " + u);
	}
	
	public static void countOccurances(Scanner input) {
		
		ArrayList<String> text = new ArrayList<>();
		
		while(input.hasNextLine()) {
			text.add(input.nextLine());
		}
		
		Map<String, Integer> map = new TreeMap<>();
		
		for(int i = 0; i < text.size(); i++) {
			String[] words = text.get(i).split("[\\s+\\p{P}]");
			
			for(int j = 0; j < words.length; j++) {
				String key = words[j].toLowerCase();
				
				if(key.length() > 0) {
					if(!map.containsKey(key)) {
						map.put(key, 1);
					}else {
						int value = map.get(key);
						value++;
						map.put(key, value);
					}
				}
			}
		}
		System.out.println();
		map.forEach((k, v) -> System.out.println(k + "\t\t" + v));
	}
}
