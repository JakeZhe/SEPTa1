package septa1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ReadFile {

	
	
	public String[] GetData(String location) {
		
		int maxLines = 31;
		
		File file = new File(location+"Report.txt");
		String[] lines = new String[maxLines];
		
		try {
			FileReader fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);
				
			int x = 0;
			String s;
				
			while((s = bReader.readLine()) != null) {
				lines[x] = s;
				x++;
			}
				
		}	catch (IOException e) {
			System.out.print(e);
			System.exit(0);
		}
		
		return lines;
		
	}
		
}