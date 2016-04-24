package septa1;

import java.util.Calendar;
import java.util.StringTokenizer;

public class Report extends ReadFile {
	
	public int line;
	public String date;
	public String DotW;
	public float minTemp;
	public float maxTemp;
	public float evap;
	public float sun;
	public float rain;
	public Wind maxWind;
	public String maxWindTime;
	public AmReport amReport;
	public PmReport pmReport;
	
	public Report(int line) {
		this.line = line;
	}
	
	public static Report BuildReport (String location, int line) {
		
		String Data[];
		String TAB = "\t";
		int count;
		
		Report report = new Report(line);
		report.maxWind = new Wind();
		report.amReport = new AmReport();
		report.amReport.Wind = new Wind();
		report.pmReport = new PmReport();
		report.pmReport.Wind = new Wind();
		
		Data = GetData(location);
		
		StringTokenizer tk = new StringTokenizer(Data[line], TAB, false);
			
		while (tk.hasMoreTokens()) {
			count = tk.countTokens();
			String stemp = tk.nextToken();
				
			if (!TAB.contains(stemp)) {
					
				switch(count) {
				
				case 22:
					report.date = stemp;
					break;
					
				case 21:
					report.DotW = stemp;
					break;
					
				case 20:
					try {
						report.minTemp = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						report.minTemp = 0;
					}
					break;
					
				case 19:
					try {
						report.maxTemp = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						report.maxTemp = 0;
					}
					break;
					
				case 18:
					try {
						report.rain = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						report.rain = 0;
					}
					break;
					
				case 17:
					try {
						report.evap = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						report.evap = 0;
					}
					break;
					
				case 16:
					try {
						report.sun = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						report.sun = 0;
					}
					break;	
					
				case 15:
					report.maxWind.dir = stemp;
					break;
					
				case 14:
					try {
						report.maxWind.spd = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						report.maxWind.spd = 0;
					}
					break;
					
				case 13:
					report.maxWindTime = stemp;
					break;
					
				case 12:
					try {
						report.amReport.Temp = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						report.amReport.Temp = 0;
					}
					break;
					
				case 11:
					try {
						report.amReport.RH = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						report.amReport.RH = 0;
					}
					break;
					
				case 10:
					try {
						report.amReport.Cld = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						report.amReport.Cld = 0;
					}
					break;
					
				case 9:
					report.amReport.Wind.dir = stemp;
					break;
					
				case 8:
					try {
						report.amReport.Wind.spd = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						report.amReport.Wind.spd = 0;
					}
					break;
					
				case 7:
					try {
						report.amReport.MSLP = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						report.amReport.MSLP = -1;
					}
					break;
					
				case 6:
					try {
						report.pmReport.Temp = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						report.pmReport.Temp = 0;
					}
					break;
					
				case 5:
					try {
						report.pmReport.RH = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						report.pmReport.RH = 0;
					}
					break;
					
				case 4:
					try {
						report.pmReport.Cld = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						report.pmReport.Cld = 0;
					}
					break;
					
				case 3:
					report.pmReport.Wind.dir = stemp;
					break;
					
				case 2:
					try {
						report.pmReport.Wind.spd = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						report.pmReport.Wind.spd = 0;
					}
					break;
					
				case 1:
					try {
						report.pmReport.MSLP = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						report.pmReport.MSLP = 0;
					}
					break;
				}	
			}			
		}
		return report;
	}
	
	public static void printReport (String Location)
	{
		String string = new String();

		//Calendar cal = Calendar.getInstance();
		//int doM = cal.get(Calendar.DAY_OF_MONTH);
		int doM = 24;
		int x = 0;
		
		System.out.println("Date, DotW, Min, Max, Rain, Evap, Sun, mwDir, mwSpd, mwTime, pmTemp, pmRH, pmCld, pmwDir, pmwSpd, pmMSLP, pmTemp, pmRH, pmCld, pmwDir, pmwSpd, pmMSLP");
		
		while (x < doM) {
			Report report = new Report(x);
			report = Report.BuildReport(Location, report.line);
			
			string = report.date+", "+report.DotW+", "+report.minTemp+", "+report.maxTemp
					+", "+report.rain+", "+report.evap+", "+report.sun+", "+report.maxWind.dir
					+", "+report.maxWind.spd+", "+report.maxWindTime+", "+report.amReport.Temp
					+", "+report.amReport.RH+", "+report.amReport.Cld+", "+report.amReport.Wind.dir
					+", "+report.amReport.Wind.spd+", "+report.amReport.MSLP+", "+report.pmReport.Temp
					+", "+report.pmReport.RH+", "+report.pmReport.Cld+", "+report.pmReport.Wind.dir
					+", "+report.pmReport.Wind.spd+", "+report.pmReport.MSLP;

			System.out.println(string);
			
			x++;
		}
	}
}
