package com.awsports.util;

public class RegexPattern {
	//用户名，1-15位字符串，包括中文，英文，数字和下划线
	public static String NAME = "^[\u4E00-\u9FA5A-Za-z0-9_]{1,15}$";
	//密码验证，6-18位字符串，必须以字母开头，包括英文字母， 数字和下划线
	public static String PASSWORD = "^[A-Za-z]\\w{5,17}$";
	//手机号， 11位数字
	public static String PHONE = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
	//邮箱
	public static String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	//身份证, 15位或18位
	public static String IDCARD = "^(\\d{14}|\\d{17})[0-9X]$";
	//地址
	public static String ADDRESS = "^[\u4E00-\u9FA5A-Za-z0-9]{2,20}$";
	//数字
	public static String NUMBERIC = "^(0|[1-9]\\d*)(\\.\\d*[1-9]\\d*)*$";
	//国际网球评级 1.0 - 7.0
	public static String TENNIS_LEVEL = "^[1-7](\\.\\d)*$";
	//正手
	public static String FOREHAND = "^[1-3]$";
	//布尔变量
	public static String BOOLEAN = "^[tT][rR][uU][eE]|[fF][aA][lL][sS][eE]$";
	//整型数字
	public static String INTEGER = "^\\d+$";
	//validate string, length=[least, most], include Chinese, English, number and underline
	public static String validateString(int least, int most) {
		return "^[\u4E00-\u9FA5A-Za-z0-9_]\\w{"+least+","+most+"}$";
	}
}
