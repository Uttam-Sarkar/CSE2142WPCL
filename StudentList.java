import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {
//		Check arguments
		if(args[0].equals(Constant.ShowAll)) {
			System.out.println(Constant.LoadingMessage);
			try {
				//String studentNamesLine = getString();
				String[] studentNames = getString().split(Constant.StrudentEntryDelimiter);
			for(String student : studentNames) {
				System.out.println(student);
			}
			} catch (Exception e){

			}
			System.out.println(Constant.DataLoadedMessage);
		}
		else if(args[0].equals(Constant.ShowRandom))
		{
			System.out.println(Constant.LoadingMessage);
			try {
				//String studentNamesLine = getString();
			String[] studentNames = getString().split(Constant.StrudentEntryDelimiter);
			//Random x = new Random();
			int y = Math.abs(new Random().nextInt()%(studentNames.length));
			System.out.println(studentNames[y]);
			} catch (Exception e){
			
			} 
			System.out.println(Constant.DataLoadedMessage);
		}
		else if(args[0].contains(Constant.AddEntry)){
			System.out.println(Constant.LoadingMessage);
			try {
			BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(Constant.StudentList, true));
			//String studentName = args[0].substring(1);
	       //	Date date = new Date();
	      		//String dateLayout = Constant.DateFormate;
	        	DateFormat dateFormat = new SimpleDateFormat(Constant.DateFormate);
	        	String dateUpdate = dateFormat.format(new Date());
			bufferedWriter.write(Constant.StrudentEntryDelimiter + args[0].substring(1) + Constant.LastUpdateMessage + dateUpdate);

			bufferedWriter.close();
			} catch (Exception e){
			
			}							
			System.out.println(Constant.DataLoadedMessage);
		}
		else if(args[0].contains(Constant.FindEntry))
		{
			System.out.println(Constant.LoadingMessage);
			try {
			//	String studentNamesLine = getString();
				String[] studentNames = getString().split(Constant.StrudentEntryDelimiter);
			String studentName = args[0].substring(1);

			for (String name : studentNames) {
				if (name.trim().equals(studentName)) {
					System.out.println(Constant.DataFoundMessage);
					break;
				}
			}
			} catch (Exception e){
			
			} 
			System.out.println(Constant.DataLoadedMessage);
		}
		else if(args[0].contains(Constant.ShowCount))
		{
			System.out.println(Constant.LoadingMessage);
			try {
				//String studentNamesLine = getString();
				char[] studentNamesToCharArray = getString().toCharArray();
			boolean in_word = false;
			int count=0;
			for(char studentNameChar:studentNamesToCharArray) {
				if(studentNameChar ==' ')
				{
					if (!in_word) {
						count++;
						in_word =true;
					}
					else {
						in_word=false;
					}
				}
			}
			System.out.println(count + Constant.WordsFoundMessage );
			} catch (Exception e){
			
			} 
			System.out.println(Constant.DataLoadedMessage);
		}
		else{
			System.out.println(Constant.WrongInputMessage);
		}
	}

	private static String getString() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(
				new FileInputStream(Constant.StudentList)));
		return bufferedReader.readLine();
	}
}
