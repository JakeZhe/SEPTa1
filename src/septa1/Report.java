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
	
	//for specific station data
	public String time, temp, appTmp, dewPt, relHum, deltaT, windDir, windSpd, windGust, spdKts, gustKts, pressQNH, pressMSL, rainSince9;
	
	//Constructor for Report only requires line to be initialised before its functions are called as the rest of the data is read from a txt file.
	public Report(int line) {
		this.line = line;
	}
	
	public static Report BuildReport (String location, int line) {
		
		String Data[];
		String TAB = ";"; //temporary change
		int count;
		
		//initialise data classes
		Report report = new Report(line);
		report.maxWind = new Wind();
		report.amReport = new AmReport();
		report.amReport.Wind = new Wind();
		report.pmReport = new PmReport();
		report.pmReport.Wind = new Wind();
		
		//fills Data array with lines of string from txt file.
		Data = GetData(location);
		
		StringTokenizer tk = new StringTokenizer(Data[line], TAB, false);
			
		while (tk.hasMoreTokens()) {
			count = tk.countTokens();
			String stemp = tk.nextToken();
				
			if (!TAB.contains(stemp)) {
					
				//tokenize the strings, assign each token to respective field
				//if a token is empty initialise each field blank where possible (for strings), or 0 (for numbers).
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

		//this can be used to check in real time what day of the month it is and read data from the txt files provided they are up to date as well
		//however since we have hard coded the data, it is not being fetched in real time and a variable is used instead as if it was the 24th of the month.
		//Calendar cal = Calendar.getInstance();
		//int doM = cal.get(Calendar.DAY_OF_MONTH);
		int doM = 24;
		int x = 0;
		
		System.out.println("Date	DotW	Min	Max	Rain	Evap	Sun	mwDir	mwSpd	mwTime	pmTemp	pmRH	pmCld	pmwDir	pmwSpd	pmMSLP	pmTemp	pmRH	pmCld	pmwDir	pmwSpd	pmMSLP");
		
		while (x < doM) {
			Report report = new Report(x);
			report = Report.BuildReport(Location, report.line);
			
			string = report.date+"\t"+report.DotW+"\t"+report.minTemp+"\t"+report.maxTemp
					+"\t"+report.rain+"\t"+report.evap+"\t"+report.sun+"\t"+report.maxWind.dir
					+"\t"+report.maxWind.spd+"\t"+report.maxWindTime+"\t"+report.amReport.Temp
					+"\t"+report.amReport.RH+"\t"+report.amReport.Cld+"\t"+report.amReport.Wind.dir
					+"\t"+report.amReport.Wind.spd+"\t"+report.amReport.MSLP+"\t"+report.pmReport.Temp
					+"\t"+report.pmReport.RH+"\t"+report.pmReport.Cld+"\t"+report.pmReport.Wind.dir
					+"\t"+report.pmReport.Wind.spd+"\t"+report.pmReport.MSLP;


			//prints the data, only formatted by commas.
			System.out.println(string);
			
			x++;
		}
	}
}
