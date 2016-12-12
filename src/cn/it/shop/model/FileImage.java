package cn.it.shop.model;

import java.io.File;

public class FileImage {
	private File file;
	private String filename;
	private String contentType;
	public File getFile() {
		return file;
	}
	public void setUpload(File file) {
		this.file = file;
	}
	public void setUploadContentType(String contentType){
		this.contentType=contentType;
	}
	public String getContentType() {
		return contentType;
	}
	public String getFilename() {
		return filename;
	}
	public void setUploadFileName(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "FileImage [file=" + file + ", filename=" + filename + "]";
	}
	
	
	
}
