

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
		while(!line.isEmpty()) {
			if(line.startsWith(separator1) && quote == false) {
				new_line += number_symb + separator2;
				number_symb = 0;
			}
			else if(line.startsWith("\"")) {quote = !quote;}
			else{number_symb++;}
		line = line.substring(1);
		}
		if(number_symb !=0) {new_line += number_symb;}
		return new_line;
	}
	
}
