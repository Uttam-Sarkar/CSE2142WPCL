import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
					new FileInputStream("students.txt"))); 
			String studentNamesLine = bufferedReader.readLine();
			String studentNames[] = studentNamesLine.split(", ");			
			for(String student : studentNames) {
				System.out.println(student);
			}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
					new FileInputStream("students.txt"))); 
			String studentNamesLine = bufferedReader.readLine();
			//System.out.println(studentNamesLine);
			String studentNames[] = studentNamesLine.split(", ");	
			Random x = new Random();
			int y = (Math.abs(x.nextInt()) % 2 + 2) % 3;
			System.out.println(studentNames[y]);
			} catch (Exception e){
			
			} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter("students.txt", true));
			String studentName = args[0].substring(1);
	       	Date date = new Date();
	      		String dateLayout = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(dateLayout);
	        	String dateUpdate = dateFormat.format(date);
			bufferedWriter.write(" ,"+studentName+"\nList last updated on "+ dateUpdate);
			bufferedWriter.close();
			} catch (Exception e){
			
			}							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
					new FileInputStream("students.txt"))); 
			String studentNamesLine = bufferedReader.readLine();
			String studentNames[] = studentNamesLine.split(",");	
			boolean done = false;
			String studentName = args[0].substring(1);
			for(int idx = 0; idx<studentNames.length && !done; idx++) {
				if(studentNames[idx].equals(studentName)) {
					System.out.println("We found it!");
					done=true;
				}
			}
			} catch (Exception e){
			
			} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
					new FileInputStream("students.txt"))); 
			String studentNamesLine = bufferedReader.readLine();
			char studentNamesToCharArray[] = studentNamesLine.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char studentNameChar:studentNamesToCharArray) {
				if(studentNameChar ==' ')
				{
					if (!in_word) {
						count++; in_word =true;
					}
					else { 
					in_word=false;
					}			
				}
			}
			System.out.println(count +" word(s) found " );
			} catch (Exception e){
			
			} 
			System.out.println("Data Loaded.");				
		}
		else{
			System.out.println("Your input data is wrong.\nPlease enter the correct input (a, r, ? or +) : " );
		}
	}
}
