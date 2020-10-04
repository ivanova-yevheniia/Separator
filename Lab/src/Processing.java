

public class Processing {
	/**
	 * The function gets a string from a file for reading. 
	 * Counts the number of symbols between separators.
	 * If the separator is in quotation marks, 
	 * it is counted as other symbols, and quotation marks are ignored.
	 * @param line 
	 * @param separator1 
	 * @param separator2
	 * @return new_line 
	 */
	public String Processing(String line, String separator1, String separator2){
		int number_symb = 0;
		String new_line = "";
		boolean quote = false;
		boolean com = false;
		while(!line.isEmpty()) {
			if(line.startsWith(separator1) && quote == false && com == false) {
				new_line += number_symb + separator2;
				number_symb = 0;
			}
			else if(line.indexOf('/')==0 && line.indexOf('*')==1) {com = true;}
			else if(line.indexOf('*')==0 && line.indexOf('/')==1) {com = false;line = line.substring(1);}
			else if(line.startsWith("\"") && number_symb == 0) {
				int q = line.indexOf("\"", 1);
				if(q != -1) {quote = true;}
				else {number_symb++;}
				}
			else if(line.startsWith("\"") && number_symb != 0) {
				if(quote == true) {quote = false;}
				else {number_symb++;}
			}
			else if (com == false){number_symb++;}
			else {}
		line = line.substring(1);
		}
		if(number_symb !=0) {new_line += number_symb;}
		return new_line;
	}
	
}
