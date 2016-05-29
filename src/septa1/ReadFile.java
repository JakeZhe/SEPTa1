package septa1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFile {

	
	
	public static String[] GetData(String location) {
		
		//max amount of days in a month
		int maxLines = 31;
		
		//uses location parameter to choose from txt files in working directory.
		File file = new File(location+".txt");
		String[] lines = new String[100];
		
		try {
			FileReader fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);
				
			int x = 0;
			String s;
				
			//assigns each line into the array, after checking if a line exists.
			while((s = bReader.readLine()) != null) {
				lines[x] = s;
				x++;
			}
			bReader.close();
			fReader.close();
				
		}	catch (IOException e) {
			System.out.print(e);
			System.exit(0);
		}
		
		//return the array
		return lines;
		
	}
		
}