package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class FilesController implements IFilesController {
	
	public FilesController() {
		super();
	}

	@Override
	public void readDir(String path) throws IOException {
		File dir = 	new File(path);	
		
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File f : files) {
				if (f.isFile()) {
					System.out.println("     \t"+f.getName());
				}
				else {
					System.out.println("<DIR>\t"+f.getName());
				}
			}
		} else {
			throw new IOException("This directory: "+path+" doesn't exist...");
		}
		
	}
	
	private String generateTxt() {
		StringBuffer buffer = new StringBuffer();
		String line = "";
		
		while (line.equalsIgnoreCase("fim")) {
			line = JOptionPane.showInputDialog(null, 
					"Input something: ",
					"Text Entry",
					JOptionPane.INFORMATION_MESSAGE);
			
			if (!line.equalsIgnoreCase("fim")) {
				buffer.append(line);
				buffer.append("\n");
			}
		}
		
		return buffer.toString();
	}

	@Override
	public void createFile(String path, String name, String extension) throws IOException {
		File dir = new File(path);
		File file = new File(path, name + extension);
		
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (file.exists()) {
				existe = true;
			}
			String conteudo = generateTxt();
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

	@Override
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

	@Override
	public void openFile(String path, String name, String extension) throws IOException{
		File file = new File(path, name + extension);
		
		if (file.exists() && file.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(file);

		} else {
			throw new IOException("Invalid file...");
		}
		
	}

}
