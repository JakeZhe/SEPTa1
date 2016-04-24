package septa1;

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
		line = this.line;
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
			System.out.println("count:" + tk.countTokens());
			count = tk.countTokens();
			String stemp = tk.nextToken();
				
			if (!TAB.contains(stemp)) {
					
				switch(count) {
				
				case 22:
					System.out.println("stemp: "+stemp);
					report.date = stemp;
					System.out.println(report.date);
					break;
					
				case 21:
					System.out.println("stemp: "+stemp);
					report.DotW = stemp;
					System.out.println("DotW: "+report.DotW);
					break;
					
				case 20:
					try {
						System.out.println("stemp: "+stemp);
						report.minTemp = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.minTemp = -1;
					}
					break;
					
				case 19:
					try {
						System.out.println("stemp: "+stemp);
						report.maxTemp = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.maxTemp = -1;
					}
					break;
					
				case 18:
					try {
						System.out.println("stemp: "+stemp);
						report.rain = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.rain = -1;
					}
					break;
					
				case 17:
					try {
						System.out.println("stemp: "+stemp);
						report.evap = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.evap = -1;
					}
					break;
					
				case 16:
					try {
						System.out.println("stemp: "+stemp);
						report.sun = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.sun = -1;
					}
					break;	
					
				case 15:
					System.out.println("case 15: "+stemp);
					report.maxWind.dir = stemp;
					break;
					
				case 14:
					report.maxWind.spd = Integer.parseInt(stemp);
					break;
					
				case 13:
					report.maxWindTime = stemp;
					break;
					
				case 12:
					try {
						report.amReport.Temp = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.amReport.Temp = -1;
					}
					break;
					
				case 11:
					try {
						report.amReport.RH = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.amReport.RH = -1;
					}
					break;
					
				case 10:
					try {
						report.amReport.Cld = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.amReport.Cld = -1;
					}
					break;
					
				case 9:
					report.amReport.Wind.dir = stemp;
					break;
					
				case 8:
					try {
						report.amReport.Wind.spd = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.amReport.Wind.spd = -1;
					}
					break;
					
				case 7:
					try {
						report.amReport.MSLP = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.amReport.MSLP = -1;
					}
					break;
					
				case 6:
					try {
						report.pmReport.Temp = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.pmReport.Temp = -1;
					}
					break;
					
				case 5:
					try {
						report.pmReport.RH = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.pmReport.RH = -1;
					}
					break;
					
				case 4:
					try {
						report.pmReport.Cld = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.pmReport.Cld = -1;
					}
					break;
					
				case 3:
					report.pmReport.Wind.dir = stemp;
					break;
					
				case 2:
					try {
						report.pmReport.Wind.spd = Integer.parseInt(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.pmReport.Wind.spd = -1;
					}
					break;
					
				case 1:
					try {
						report.pmReport.MSLP = Float.parseFloat(stemp);
					} catch (NumberFormatException e) {
						System.out.println(e);
						report.pmReport.MSLP = -1;
					}
					break;
				}
					
			}			
		   }

		return report;
		
	}
	
	public static void main(String[] args)
	{
		String Location = "Melbourne";
		int line = 0;
		Report testReport = new Report(line);
		
		testReport = BuildReport(Location, testReport.line);
		

		System.out.println(testReport.date+", "+testReport.DotW+", "+testReport.minTemp+", "+testReport.maxTemp
				+", "+testReport.rain+", "+testReport.evap+", "+testReport.sun+", "+testReport.maxWind.dir
				+", "+testReport.maxWind.spd+", "+testReport.maxWindTime+", "+testReport.amReport.Temp
				+", "+testReport.amReport.RH+", "+testReport.amReport.Cld+", "+testReport.amReport.Wind.dir
				+", "+testReport.amReport.Wind.spd+", "+testReport.amReport.MSLP+", "+testReport.pmReport.Temp
				+", "+testReport.pmReport.RH+", "+testReport.pmReport.Cld+", "+testReport.pmReport.Wind.dir
				+", "+testReport.pmReport.Wind.spd+", "+testReport.pmReport.MSLP);

	}
}
