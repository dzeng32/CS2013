
import java.io.*;
import java.util.Scanner;

public class Lab00 {
	
	public static void main(String[] args) throws IOException{
		
			//Question 1 & 5------------------------------------------------------
			try( FileOutputStream output = new FileOutputStream
					("D:\\CSU\\CS2013 Programing with Data Structures\\Exercise17.dat", true)){
				
				for(int i = 1000; i <= 1200; i++) {
					output.write(i);
				}
				FileInputStream input = new FileInputStream("D:\\CSU\\CS2013 Programing with Data Structures\\Exercise17.dat");
				read(input);
				System.out.println();


			}
			// End of Question 1 ---------------------------------------------
			
			//Question 2 ---------------------------------------------------------
			try{
				
				DataInputStream input2 = new DataInputStream(
					new FileInputStream("D:\\CSU\\CS2013 Programing with Data Structures\\LincolnLab09-UTF.txt"));
				
				DataOutputStream output2 = 
						new DataOutputStream(new FileOutputStream("D:\\CSU\\CS2013 Programing with Data Structures\\Lab00.dat"));
				/*
				Scanner reader = new Scanner(input2);
				
				//String words = "";
				while( reader.hasNext() ) {
					
					 //words = input2.readUTF();
					
					//System.out.print(words + " ");
					output2.writeUTF(reader.nextLine());
				}*/
				
				StringBuilder sb = new StringBuilder();
	            while (input2.available() > 0) {
	                sb.append(input2.readUTF());
	            }
	            output2.writeUTF(sb.toString());
	            output2.flush();
				
				System.out.println();
				
				input2.close();
				output2.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			}//End of Question 2 -------------------------------------------------
			
			//Question 3 test
			String bits = "";
			int nums;
			
			System.out.println("\nEnter a number: ");
			Scanner testReader = new Scanner(System.in);
			
			nums = testReader.nextInt();
			bits += " " + getBits(nums);
			
			System.out.println(bits);
			
		
	}
	
	public static void read(FileInputStream input) throws IOException{
		int value;
		int sum = 0;
		int counter = 0;
		while((value = input.read()) != -1) {
			System.out.print(value + " ");
			sum += value;
			counter++;
		}
		System.out.println("\nAverage is: " + (double) sum/counter);
	}
	
	//Question 3 -------------------------------------
	public static String getBits(int value) {
		String bits = "";
		
		for(int i = 7; i >= 0; i--){
			bits += ((value >> i) & 1);
		}
		
		return bits;
	}
	
}
