package service;

import java.io.File;

public abstract class FileService {
	
	public abstract Boolean importData(File file, String plate);
	public abstract File exportData();
}
