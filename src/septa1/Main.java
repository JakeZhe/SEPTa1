package septa1;

import java.io.IOException;

import readUrlTest.*;

public class Main {

	public static void main(String[] args) throws IOException {
		ReadURL.loadAll();
		System.out.println("loading complete!");
		Menu.menu(); 
	}

}
