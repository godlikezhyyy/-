package cn.it.shop.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.it.shop.model.FileImage;

@Component("fileImageUtil")
public class FileImageUploadUtil implements FileImageUtil  {
	
	@Value("#{prop.filepath}")
	private String filepath;
	
	private String getFileExt(String filename){
		return filename.substring(filename.lastIndexOf("."));
	}
	
	private String newFileName(String filename){
		String ext=getFileExt(filename);
		return UUID.randomUUID().toString()+ext;
		
		
	}
	

	@Override
	public String fileUpload(FileImage fileImage){
		String newFilename=newFileName(fileImage.getFilename());
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filepath,newFilename));
			return newFilename;
		} catch (IOException e) {
			throw new RuntimeException();
		}finally{
			fileImage.getFile().delete();
		}
				
	}
	
	@Override
	public void deleteImage(String filename){
		File image=new File(filepath,filename);
		image.delete();
	}

	@Override
	public String getFilepath() {
		return filepath;
	}
	
	
	
}
