package com.comcast.crm.generic.fileutility;


import java.io.FileInputStream;
import java.util.Properties;

import constant.IpathConstants;

public class FileUtility 
{
	public String getDataFromPropertiesFile(String Key) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(IpathConstants.filePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(Key);
		return data;
		
	}

}

