package refresh;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.ForecastIO;


public class ReadURL {
	
	public static void loadAll() throws IOException{
		
		String[] web = new String[10];
		web[0] = "http://www.bom.gov.au/climate/dwo/IDCJDW3033.latest.shtml"; //Melbourne Olympic park
		web[1] = "http://www.bom.gov.au/climate/dwo/IDCJDW3030.latest.shtml"; //Geelong Racecourse
		web[2] = "http://www.bom.gov.au/climate/dwo/IDCJDW4019.latest.shtml"; //Brisbane
		web[3] = "http://www.bom.gov.au/climate/dwo/IDCJDW4024.latest.shtml"; //Cairns
		web[4] = "http://www.bom.gov.au/climate/dwo/IDCJDW9203.latest.shtml"; //Casey, Antartica
		web[5] = "http://www.bom.gov.au/climate/dwo/IDCJDW9201.latest.shtml"; //Davis, Antartica
		web[6] = "http://www.bom.gov.au/climate/dwo/IDCJDW9204.latest.shtml"; //Macquarie Island, Offshore
		web[7] = "http://www.bom.gov.au/climate/dwo/IDCJDW6026.latest.shtml"; //Christmas Island, Offshore
		web[8] = "http://www.bom.gov.au/climate/dwo/IDCJDW4043.latest.shtml"; //Flinders Reed, Offshore
		
		for(int i=0; i<9; i++){
			loadStation(web[i], i);
			System.out.print("..." + (i+1)*10 + "%\n");
		}
	}
	
	public static void refresh(String location) throws IOException{
		int station = Integer.parseInt(location);
		
		String[] web = new String[10];
		web[0] = "http://www.bom.gov.au/climate/dwo/IDCJDW3033.latest.shtml"; //Melbourne Olympic park
		web[1] = "http://www.bom.gov.au/climate/dwo/IDCJDW3030.latest.shtml"; //Geelong Racecourse
		web[2] = "http://www.bom.gov.au/climate/dwo/IDCJDW4019.latest.shtml"; //Brisbane
		web[3] = "http://www.bom.gov.au/climate/dwo/IDCJDW4024.latest.shtml"; //Cairns
		web[4] = "http://www.bom.gov.au/climate/dwo/IDCJDW9203.latest.shtml"; //Casey, Antartica
		web[5] = "http://www.bom.gov.au/climate/dwo/IDCJDW9201.latest.shtml"; //Davis, Antartica
		web[6] = "http://www.bom.gov.au/climate/dwo/IDCJDW9204.latest.shtml"; //Macquarie Island, Offshore
		web[7] = "http://www.bom.gov.au/climate/dwo/IDCJDW6026.latest.shtml"; //Christmas Island, Offshore
		web[8] = "http://www.bom.gov.au/climate/dwo/IDCJDW4043.latest.shtml"; //Flinders Reed, Offshore
		
		loadStation(web[station], station);
	}
	
	public static void loadStation(String url, int name) throws IOException{
		
		
		//writing to .txt file
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(name + ".txt")));		
		
		Document doc;
		try {
			
			//read url
			doc = Jsoup.connect(url).get();
			
			for(Element table : doc.select("table.data")){
				for(Element tbody : table.select("tbody")){
					for (Element row : tbody.select("tr")){
						Elements ths = row.select("th.rb");
						Elements tds = row.select("td");
						if(!(ths.text()).equals("")){
							
							String date = ths.text();
							pw.printf(date+";");
							
							for(int i=0; i<tds.size(); i++){
								if(tds.get(i).text().equals("\u00a0"))
									pw.printf("(null)");
								else
									pw.printf(tds.get(i).text());
								
								pw.printf(";");
							}
							
							pw.println();
						}
					}
				}
			}			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		pw.close();
		System.out.print("loading");
	}

	public static void forecast(String latitude, String longitude){
		ForecastIO fio = new ForecastIO("602feb177573eea307339e7463b386a1"); //instantiate the class with the API key. 
		fio.setUnits(ForecastIO.UNITS_SI);             //sets the units as SI - optional
		fio.setExcludeURL("hourly,minutely");             //excluded the minutely and hourly reports from the reply
		fio.getForecast(latitude, longitude);   //sets the latitude and longitude - not optional
		                                               //it will fail to get forecast if it is not set
		                                               //this method should be called after the options were set
		FIODaily daily = new FIODaily(fio);
	    
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Forecast for 3 days");
		for(int i=0; i<3; i++){
			Calendar c = Calendar.getInstance(); 
			c.setTime(date); 
			c.add(Calendar.DATE, 1);
			date = c.getTime();
			
			String [] f  = daily.getDay(i).getFieldsArray();
			System.out.println();
			System.out.println(ft.format(date));
			System.out.println(f[0]+": "+daily.getDay(i).getByKey(f[0]));
		    System.out.println(f[4]+": "+daily.getDay(i).getByKey(f[4]));
		    System.out.println(f[7]+": "+daily.getDay(i).getByKey(f[7]));
		    System.out.println(f[18]+": "+daily.getDay(i).getByKey(f[18]));
		}	    
	}
}
