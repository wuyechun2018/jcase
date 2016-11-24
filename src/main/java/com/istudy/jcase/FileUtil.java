package com.istudy.jcase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * 文件处理
 * 
 * @desc: itools
 * @author: wyc
 * @createTime: 2016年10月24日 下午5:01:52
 * @history:
 * @version: v1.0
 */
public class FileUtil {

	/**
	 * 
	 * 从控制台读入数据,写入txt
	 * @author: wyc
	 * @createTime: 2016年10月25日 上午8:36:48
	 * @history:
	 * @param args void
	 */
	public static void main(String[] args) {
		String filePath = "E:\\git-open\\jcase\\src\\main\\resources\\config\\test\\jcase.txt";
		//readFile(filePath);
		//writeText(filePath,"HelloKitty"+new Date(),true);
		//readFile(filePath);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a:");
		String inputStrA=sc.nextLine();
		writeText(filePath,"["+inputStrA+"]-"+new Date(),true);
		readFile(filePath);
		
	}

	/**
	 * 
	 * 读取文件
	 * @author: wyc
	 * @createTime: 2016年10月24日 下午6:01:25
	 * @history:
	 * @throws IOException void
	 */
	public static void readFile(String filePath){
		String encoding="UTF-8";
		//文件路径
		File file = new File(filePath);
		if (file.isFile() && file.exists()) {
			 InputStreamReader read;
			try {
				//BufferedReader->InputStreamReader->FileInputStream->File
				read = new InputStreamReader(new FileInputStream(file),encoding);
				 BufferedReader bufferedReader = new BufferedReader(read);
		         String lineTxt = null;
		         while((lineTxt = bufferedReader.readLine()) != null){
	                 System.out.println(lineTxt);
	             }
	             read.close();
			} catch (UnsupportedEncodingException | FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
		}

	}
	
	
	/**
	 * 
	 * 写入内容
	 * @author: wyc
	 * @createTime: 2016年10月24日 下午6:09:34
	 * @history: void
	 */
	public static void writeText(String filePath,String writeText,Boolean isNewLine){
		BufferedWriter fw = null;
		File file = new File(filePath);
		try {
			//指定编码格式，以免读取时中文字符异常
			//BufferedWriter->OutputStreamWriter->FileOutputStream->File
			fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); 
			if(isNewLine){
				fw.newLine();
			}
			fw.append(writeText);
			fw.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	
}
