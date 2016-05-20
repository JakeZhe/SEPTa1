package readUrlTest;

import java.io.*;
import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ReadURL {
	
	public static void main(String[] args) throws IOException{
		
		String[] web = new String[50];
		String state = "http://www.bom.gov.au/catalogue/data-feeds.shtml"; //State
		String NSW = "http://www.bom.gov.au/nsw/observations/coastal.shtml"; //New south wales(region)
		String melbourneOlympicPark = "http://www.bom.gov.au/products/IDV60901/IDV60901.95936.shtml"; 
		
//		readUrl(state);		
		readStation(melbourneOlympicPark);
	}
	
	public static void readUrl(String url)
	{
		Document doc;
		try {

			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("state.txt")));
			
			doc = Jsoup.connect(url).get();
			
			for(Element table : doc.select("tbody")){
				for (Element th : table.select("th")){
					//find table listing state only
					String state = th.text();
					if(state.contains("Australian State")){
						for (Element row : table.select("tr")){
							Elements tds = row.select("td");
							Elements tdsLink = row.select("a[href]");
							if(tds.size() != 0){
								Element coastal = tds.get(0);
								Element allLocation = tds.get(1);
								Element capital = tds.get(2);
								
								//extracting link
								//head
								String head = "http://www.bom.gov.au";
								
								Elements link1 = allLocation.select("a[href]");
								String allLocationLink;
								if(link1.attr("href").equals("")){
									allLocationLink = "Not Applicable";
								}
								else{
									allLocationLink = head + link1.attr("href");
								}
																								
								Elements link2 = capital.select("a[href]");
								String capitalLink = head + link2.attr("href");
								
								if(link2.attr("href").equals("")){
									capitalLink = "Not Applicable";
								}
								else{
									capitalLink = head + link2.attr("href");
								}
								
								//write to .txt
								pw.println(coastal.text() + ":" + allLocationLink + ":" + capitalLink);
							}
						}
					}
				}
				pw.close();
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void readStation(String url){
		Document doc;
		try {			
			//writing selected station to console
			doc = Jsoup.connect("http://www.bom.gov.au/products/IDV60901/IDV60901.95936.shtml").get();
			
			System.out.printf("%s\t\t|%s\t|%s\t|%s\t|%s\t|%s\t|%s\t|%s\t\t|%s\t\n", "Time", "Temperature(C)", "Wind dir"
					, "Wind Speed", "Gust knots", "hPa", "Rain(mm)", "Cloud", "Vis km");
			for(Element table : doc.select("table#t1")){
				for(Element tbody : table.select("tbody")){
//					System.out.println("A");
					for (Element row : tbody.select("tr")){
//						System.out.println("B");
						Elements tds = row.select("td");
//						System.out.println("C");
//						System.out.println("tds.size() = " + tds.size());
						if(tds.size() >= 0){
//							for(int i=0; i<tds.size(); i++)
//								System.out.println(tds.get(i).text());
							
							String time = tds.get(0).text();
							String temperature = tds.get(1).text();
							String dir = tds.get(2).text();
							String speed = tds.get(3).text();
							String gustKnots = tds.get(4).text();
							String hPa = tds.get(5).text();
							String rain = tds.get(7).text();
							String cloud = tds.get(9).text();
							String visKm = tds.get(10).text();
							
							System.out.printf("%s\t|%s\t\t|%s\t\t|%s\t\t|%s\t\t|%s\t|%s\t\t|%s\t|%s\t\n"
									, time, temperature, dir, speed, gustKnots, hPa, rain, cloud, visKm);													
						}
					}
				}
			}
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
