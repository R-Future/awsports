package com.awsports.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;


/**
 * 
 * @author peRFect
 *
 */
public class ValidationCode {
	
	private static String validationCode;
	private static BufferedImage bufferedImage;
	private static Random random = new Random();
	
	private static final int WIDTH = 100;
	private static final int HEIGHT = 34;
	private static final int NUMBER_OF_CODES=4;
	private static final int NUMBER_OF_INTERFERENCE_LINES=30;	

	public static String getValidationCode() {
		return validationCode;
	}



	public static void setValidationCode(String validationCode) {
		ValidationCode.validationCode = validationCode;
	}



	public static BufferedImage getBufferedImage() {
		return bufferedImage;
	}



	public static void setBufferedImage(BufferedImage bufferedImage) {
		ValidationCode.bufferedImage = bufferedImage;
	}



	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月9日 下午12:08:10
	 * @param image
	 * @Return: void
	 * @Description: 初始化生成验证码
	 *
	 */
	public static void initValidationCode(){
		
		bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		//初始化图片
		Graphics graphic = initImage();
		//字符集
		String codes="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		//生成的随机字符集
		StringBuffer randomCodes=new StringBuffer("");
		
		for(int i=0;i<NUMBER_OF_CODES;i++){
			//随机生成一个字符
			String code = ""+codes.charAt(random.nextInt(codes.length()));
			randomCodes.append(code);
			//设置验证码颜色
			graphic.setColor(new Color(20+random.nextInt(10),20+random.nextInt(110),20+random.nextInt(110)));
			//将code添加到图片中
			graphic.drawString(code, 13 * i + 20, 24);
		}
		//生成验证码
		setValidationCode(randomCodes.toString());
		//图片生效
		graphic.dispose();
		
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月9日 下午12:10:19
	 * @param image
	 * @param random
	 * @Return: Graphics
	 * @Description: 初始化图片
	 *
	 */
	public static Graphics initImage(){
		//获取图形
		Graphics graphic = bufferedImage.getGraphics();
		//设置背景颜色
		graphic.setColor(getRandomColor(200,250));
		graphic.fillRect(0,0,WIDTH,HEIGHT);
		graphic.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		graphic.setColor(getRandomColor(150,200));
		//随机生成数条随机线，避免恶意程序探测到验证码
		for(int i=0;i<NUMBER_OF_INTERFERENCE_LINES;i++){
			int xStart = random.nextInt(WIDTH);
			int yStart = random.nextInt(HEIGHT);
			int xEnd = random.nextInt(WIDTH);
			int yEnd = random.nextInt(HEIGHT);
			graphic.drawLine(xStart, yStart, xEnd, yEnd);
		}
		return graphic;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月9日 下午12:11:04
	 * @param fc
	 * @param bc
	 * @Return: Color
	 * @Description: 随机生成图片背景颜色
	 *
	 */
	private static Color getRandomColor(int fc, int bc){
		
		int r;
		int g;
		int b;
		if(fc>255){
			fc=255;
		}
		if(bc>255){
			bc=255;
		}
		r = fc + random.nextInt(bc - fc);
		g = fc + random.nextInt(bc - fc);
		b = fc + random.nextInt(bc - fc);
		
		return new Color(r,g,b);
	}
	
}
