package com.awsports.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelUtil {

	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月30日 上午10:42:00
	 * @param matchScoreStr
	 * @param apScore
	 * @param apTieScore
	 * @param hcScore
	 * @param hcTieScore
	 * @Return: int[]
	 * @Description: parsing the match score string
	 *
	 */
	public static int[] getMatchScore(String matchScoreStr, int apScore, int apTieScore, int hcScore, int hcTieScore) {
		int[] result = new int[4];
		// 使用正则表达式处理比分
		String patternPlayer1 = "(\\(\\d+\\))?\\d+(?=:)";
		String patternPlayer2 = ":\\d+(\\(\\d+\\))?";
		Pattern pattern1 = Pattern.compile(patternPlayer1);
		Pattern pattern2 = Pattern.compile(patternPlayer2);
		int flag1 = 0;
		int flag2 = 0;
		Matcher matcher1 = pattern1.matcher(matchScoreStr);
		Matcher matcher2 = pattern2.matcher(matchScoreStr);
		if (matcher1.find()) {
			Matcher mPlayer1 = Pattern.compile("\\d+").matcher(matcher1.group(0).toString());
			while (mPlayer1.find()) {
				if (flag1 == 0) {
					hcTieScore = Integer.parseInt(mPlayer1.group());
					flag1++;
				} else {
					hcScore = Integer.parseInt(mPlayer1.group());
					flag1++;
				}
			}
			if (flag1 == 1) {
				// the match did not play tie break
				hcScore = hcTieScore;
				hcTieScore = 0;
			}

		}
		if (matcher2.find()) {
			Matcher mPlayer2 = Pattern.compile("\\d+").matcher(matcher2.group(0).toString());
			while (mPlayer2.find()) {
				if (flag2 == 0) {
					apScore = Integer.parseInt(mPlayer2.group());
					flag2++;
				} else {
					apTieScore = Integer.parseInt(mPlayer2.group());
					flag2++;
				}
			}

		}
		// the match played tie break
		if (flag1 == 2) {
			if (hcTieScore < 6) {
				apTieScore = 7;
			} else {
				apTieScore = hcTieScore + 2;
			}
		}
		if (flag2 == 2) {
			if (apTieScore < 6) {
				hcTieScore = 7;
			} else {
				hcTieScore = apTieScore + 2;
			}
		}
		// return result
		result[0] = hcScore;
		result[1] = hcTieScore;
		result[2] = apScore;
		result[3] = apTieScore;
		return result;
	}

}
