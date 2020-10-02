

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 * 
 * @author Ivanova Yevheniia KM-92
 *
 */
public class Main_test {
	
	public static void main(String[] args) {
		
		InputData inp = new InputData();
		Processing prc = new Processing();
		
		String path_r = inp.PathFile("reading");
		String path_w = inp.PathFile("writing");
		
		String separator1 = inp.Separator(1);
		String separator2 = inp.Separator(2);
		
		
		try {
			BufferedReader br = null;
			File file_r = new File(path_r);
			File file_w = new File(path_w);
			if(!file_r.exists() && !file_w.exists()) {
				System.out.println("Error file not definded");
				file_r.createNewFile();
				file_w.createNewFile();}
			
			br = new BufferedReader(new FileReader(path_r));
			String line = "";
			PrintWriter pw = new PrintWriter (file_w);
			while((line = br.readLine()) != null) {
				String new_line = prc.Processing(line, separator1, separator2);
				pw.println(new_line);
			}
			br.close();
			pw.close();
			} catch (IOException e) {e.printStackTrace();}
		System.out.println("Mission complete!");
		
		}		
}

