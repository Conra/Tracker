package controller;

import java.io.File;

import service.FileService;
import service.implementation.FilePltServiceImp;

public class FileController {
	
	private FileService fileService;
	
	public Boolean importData(File file, String plate) {
		//factory pattern fileService
		String extension = getFileExtension(file);
		if (extension.equals(new String(".plt")))
			setFileService(new FilePltServiceImp());
		//else if (extension == ".json")
		//	setFileService(new FileJsonService());
		else return Boolean.FALSE;
		
		getFileService().importData(file, plate);
		return Boolean.TRUE;
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	
	public String getFileExtension(File file) {
	    String name = file.getName();
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return "";
	    }
	    return name.substring(lastIndexOf);
	}
}
