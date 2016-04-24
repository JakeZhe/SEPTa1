package septa1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFile {

	
	
	public static String[] GetData(String location) {
		
		int maxLines = 31;
		
		File file = new File(location+"Report.txt");
		System.out.println(file.getAbsolutePath());
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
			bReader.close();
			fReader.close();
				
		}	catch (IOException e) {
			System.out.print(e);
			System.exit(0);
		}
		
		return lines;
		
	}
		
}