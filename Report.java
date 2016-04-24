package septa1;

import java.util.StringTokenizer;

public class Report extends ReadFile {

	public String date;
	public String DotW;
	public float minTemp;
	public float maxTemp;
	public float rain;
	public Wind maxWind;
	public String maxWindTime;
	public AmReport amReport;
	public PmReport pmReport;
	
	public Report[] BuildReport (String location) {
		
		String Data[];Data = GetData(location);
		int x = (Data.length);
		
		Report report[] = new Report[x];
		
		String COMMAS = ", ";
		
		int y = 0;
		int count;
		
		for(String st : Data) {
			StringTokenizer tk = new StringTokenizer(st, COMMAS, false);
			
			while (tk.hasMoreTokens()) {
				System.out.println("count:" + tk.countTokens());
				count = tk.countTokens();
				String stemp = tk.nextToken();
				
				if (!COMMAS.contains(stemp)) {
					
					if (count == 20)
						report[y].date = stemp;
					if (count == 19)
						report[y].DotW = stemp;
					if (count == 18)
						report[y].minTemp = Float.valueOf(stemp);
					if (count == 17)
						report[y].maxTemp = Float.valueOf(stemp);
					if (count == 16)
						report[y].rain = Float.valueOf(stemp);
					if (count == 15)
						report[y].maxWind.dir = stemp;
					if (count == 14)
						report[y].maxWind.spd = Integer.parseInt(stemp);
					if (count == 13)
						report[y].maxWindTime = stemp;
					if (count == 12)
						report[y].amReport.Temp = Float.valueOf(stemp);
					if (count == 11)
						report[y].amReport.RH = Integer.parseInt(stemp);
					if (count == 10)
						report[y].amReport.Cld = Integer.parseInt(stemp);
					if (count == 9)
						report[y].amReport.Wind.dir = stemp;
					if (count == 8)
						report[y].amReport.Wind.spd = Integer.parseInt(stemp);
					if (count == 7)
						report[y].amReport.MSLP = Float.valueOf(stemp);
					if (count == 6)
						report[y].pmReport.Temp = Float.valueOf(stemp);
					if (count == 5)
						report[y].pmReport.RH = Integer.parseInt(stemp);
					if (count == 4)
						report[y].pmReport.Cld = Integer.parseInt(stemp);
					if (count == 3)
						report[y].pmReport.Wind.dir = stemp;
					if (count == 2)
						report[y].pmReport.Wind.spd = Integer.parseInt(stemp);
					if (count == 1)
						report[y].pmReport.MSLP = Float.valueOf(stemp);
					
					
				}			
		    }
			
			y++;
		}
		return report;
		
	}
}
