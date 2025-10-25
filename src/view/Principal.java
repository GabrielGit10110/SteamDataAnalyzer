package view;

import java.io.IOException;

import controller.SteamController;

public class Principal {

	public static void main(String[] args) {
		String path = "/tmp/CSVs/steam/";
		String file = "SteamCharts";
		String extension = ".csv";
		SteamController steamReading = new SteamController(path, file, extension);
		
		String year = "2017";
		String month = "January";
		double mean = 7000.0;
		
		String yearCSV = "2018";
		String monthCSV = "March";
		String pathCSV = "/tmp/CSVs/steam/output/";
		String nameCSV = "nome";
		
		try {
			steamReading.readGames(year, month, mean);
			steamReading.createCSV(yearCSV, monthCSV, pathCSV, nameCSV, extension);
		} catch (IOException e) {
			System.out.println("Input or Output error: ");
			System.err.println(e.getMessage());
		}

	}

}
