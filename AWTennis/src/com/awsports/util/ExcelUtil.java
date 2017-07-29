package com.awsports.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.awsports.pojo.Singlematch;
import com.awsports.pojo.SinglematchQuery;
import com.awsports.pojo.Singlematchscore;
import com.awsports.pojo.User;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {
	List<SinglematchQuery> siglematchQuerys;
	public static void ExcelHandle(String filePath) throws BiffException, IOException{
		InputStream inputStream = new FileInputStream(filePath);
		Workbook workbook = Workbook.getWorkbook(inputStream);
		//获取sheet
		Sheet sheet = workbook.getSheet(0);
		//获取行数
		int rows = sheet.getRows();
		//获取列数
		int cols = sheet.getColumns();
		//遍历表格
		//System.out.println(rows+"行 * "+cols+"列");
		User user = null;
		SinglematchQuery singlematchQuery = null;
		Singlematch singlematch = null;
		for(int i= 1;i<rows;i++){
			singlematchQuery = new SinglematchQuery();
			List<Singlematchscore> singlematchscores = new ArrayList<Singlematchscore>();
			String matchscoreStr = "";
			singlematch = new Singlematch();
			for(int j=0;j<cols;j++){
				//按行读取表格
				Cell cell = sheet.getCell(j, i);
				switch(j){
				case 0:
					//主场选手
					user = new User();
					user.setName(cell.getContents().toString().trim());
					singlematchQuery.setUser1(user);
					break;
				case 1:
					//客场选手
					user = new User();
					user.setName(cell.getContents().toString().trim());
					singlematchQuery.setUser2(user);
					break;
				case 2:
					//比赛时间
					if(cell.getType() == CellType.DATE){
						DateCell dateCell = (DateCell) cell;
						singlematch.setMatchtime(dateCell.getDate());
					}
					break;
				case 3:
					//比赛地点
					if(cell.getType() == CellType.NUMBER){
						NumberCell placeId = (NumberCell)cell;
						singlematch.setMatchplace((int)placeId.getValue());
					}
					break;
				case 4:
					//tournament
					if(cell.getType() == CellType.NUMBER){
						NumberCell tournamentId = (NumberCell)cell;
						singlematch.setTournamentid((int)tournamentId.getValue());
					}
					break;
				case 5:
					//sets
					if(cell.getType() == CellType.NUMBER){
						NumberCell sets = (NumberCell)cell;
						singlematch.setSets((int)sets.getValue());
					}
					break;
				case 6:
					//HC challenger
					if("false".equals(cell.getContents().toString().trim().toLowerCase())){
						singlematch.setIshcchallenger(Boolean.FALSE);
					}else{
						singlematch.setIshcchallenger(Boolean.TRUE);
					}
					break;
				case 7:
					//AP challenger
					if("false".equals(cell.getContents().toString().trim().toLowerCase())){
						singlematch.setIsapchallenger(Boolean.FALSE);
					}else{
						singlematch.setIsapchallenger(Boolean.TRUE);
					}
					break;
				case 8:
					//HC retired
					if("false".equals(cell.getContents().toString().trim().toLowerCase())){
						singlematch.setHcretired(Boolean.FALSE);
					}else{
						singlematch.setHcretired(Boolean.TRUE);
					}
					break;
				case 9:
					//AP retired
					if("false".equals(cell.getContents().toString().trim().toLowerCase())){
						singlematch.setApretired(Boolean.FALSE);
					}else{
						singlematch.setApretired(Boolean.TRUE);
					}
					break;
				case 10:
					//match score
					matchscoreStr = cell.getContents();
					//使用正则表达式处理比分
					//。。。
					//。。。
				}
				System.out.print(cell.getContents() + " ");
			}
			System.out.println();
		}
	}
	
}
