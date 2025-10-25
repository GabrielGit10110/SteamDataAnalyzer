package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController {
	private String path;
	private String name;
	private String extension;
	
	public SteamController() {
		super();
		this.path = null;
		this.name = null;
		this.extension = null;
	}

	public SteamController(String path, String name, String extension) {
		super();
		this.path = path;
		this.name = name;
		this.extension = extension;
	}
	
	public void readGames(String year, String month, double mean) throws IOException {
		File file = new File(path, name + extension);
		
		if (file.exists() && file.isFile()) {
			FileInputStream fileInput = new FileInputStream(file); // open file
			InputStreamReader reader = new InputStreamReader(fileInput); // read file
			BufferedReader buffer = new BufferedReader(reader); // put it inside a buffer
			
			System.out.println("=========================================================================");
			System.out.printf("%-45s %s%n", "NOME_JOGO", "MEDIA_JOGADORES_ATIVOS");
			System.out.println("=========================================================================");
			String line = buffer.readLine(); // put all the buffered lines inside a String
			while (line != null) {
				if (line != null && !line.contains("gamename")) {
					String[] game = line.split(",");
					printLogic(game, year, month, mean);
				}
				line = buffer.readLine();
			}
			
			buffer.close();
			reader.close();
			fileInput.close();

		} else {
			throw new IOException("Invalid file: "+this.name);
		}
		
	}
	
	private void printLogic(String[] game, String year, String month, double mean) {
		double avg = Double.parseDouble(game[3]);
		if (game[1].equals(year) && game[2].equals(month) && avg >= mean) {
			System.out.printf("%-50s %s%n", game[0], game[3]);
		}
		
	}
	
	public void createCSV(String year, String month, String path, String name, String extension) throws IOException {
		File dir = new File(path);
		File file = new File(path, name + extension);
		
		if (dir.exists() && dir.isDirectory()) {
			boolean exists = false;
			if (file.exists() && file.isFile()) {
				exists = true;
			} 			
			String content = readYearMonth(year, month);
			FileWriter fileWriter = new FileWriter(file, exists);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(content);

			print.flush();
			print.close();
			fileWriter.close();

		} else {
			throw new IOException("Invalid directory: "+path);
		}
		System.out.println("\n"+"The file was saved in: "+path);
	}
	
	private String readYearMonth(String year, String month) throws IOException {
		File file = new File(this.path, this.name + this.extension);
		StringBuffer games = new StringBuffer();
		
		if (file.exists() && file.isFile()) {
			FileInputStream fileInput = new FileInputStream(file); // open file
			InputStreamReader reader = new InputStreamReader(fileInput); // read file
			BufferedReader buffer = new BufferedReader(reader); // put it inside a buffer
			
			games.append("NOME DO JOGO");
			games.append(";");
			games.append("MEDIA DE JOGADORES ATIVOS").append("\n");
			String line = buffer.readLine(); // put all the buffered lines inside a String
			while (line != null) {
				if (line != null && !line.contains("gamename")) {
					String[] game = line.split(",");
					
					if (game[1].equals(year) && game[2].equals(month)) {
						games.append(game[0]).append(";").append(game[3]);
						games.append("\n");
					}

				}
				line = buffer.readLine();
			}
			
			buffer.close();
			reader.close();
			fileInput.close();
		} else {
			throw new IOException("Invalid file: "+this.name);
		}

		return games.toString();
	
	}

	public void createFile(String path, String name, String extension) throws IOException {
		File dir = new File(path);
		File file = new File(path, name + extension);
		
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (file.exists()) {
				existe = true;
			}
			String conteudo = "";
			FileWriter fileWriter = new FileWriter(file, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);

			print.flush();
			print.close();
			fileWriter.close();
			
		} else {
			throw new IOException("This directory: "+path+" doesn't exist...");
		}
		
		
	}

	public void readFile(String path, String name, String extension) throws IOException {
		File file = new File(path, name + extension);
		
		if (file.exists() && file.isFile()) {
			FileInputStream fileInput = new FileInputStream(file); // open file
			InputStreamReader reader = new InputStreamReader(fileInput); // read file
			BufferedReader buffer = new BufferedReader(reader); // put it inside a buffer
			
			String line = buffer.readLine(); // put all the buffered lines inside a String
			while (line != null) {
				System.out.println(line);
				line = buffer.readLine();
				
			}
			buffer.close(); // close the buffer
			reader.close(); // close the file reader
			fileInput.close(); // close the file
		} else {
			throw new IOException("Invalid file...");
		}
		
	
	}
	
	
}
