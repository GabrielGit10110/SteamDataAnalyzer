package controller;

import java.io.IOException;

public interface IFilesController {
	public void readDir(String path) throws IOException;
	public void createFile(String path, String name, String extension) throws IOException;
	public void readFile(String path, String name, String extension) throws IOException;
	public void openFile(String path, String name, String extension) throws IOException;
	
}
