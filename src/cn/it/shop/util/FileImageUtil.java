package cn.it.shop.util;

import cn.it.shop.model.FileImage;

public interface FileImageUtil {

	public abstract String fileUpload(FileImage fileImage);

	public abstract void deleteImage(String filename);

	public abstract String getFilepath();

}