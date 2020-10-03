import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class InputData {
	
	/**
	 * User enters separator
	 * @param f - file destination (writing/reading)
	 * @return separator for the the file for reading or writing
	 */
	public String Separator(int num_sep) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter separator " + num_sep + ": ");
		char separator = in.next().charAt(0); 
		return String.valueOf(separator);
	}
	
	/**
	 * User enters path to the file for reading or writing.
	 * The file system is checked for file existence. 
	 * If the file for reading does not exist, then the function is run recursively 
	 * until the user enters correct data. If the file for writing does not exist, then the function
	 * creates a new file at the specified path.
	 * @param f - file destination (writing/reading)
	 * @return path to the file for writing or reading
	 */
	public String PathFile(String f){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter path to file for " + f + ": ");
		String path = in.nextLine();
		try {
			File file = new File(path);
			if(!file.exists())
				if(f == "writing") {file.createNewFile();}
				else {PathFile("reading");}
		}catch(IOException e) {System.out.print("Error: " + e);}
		return path;
	}
}
