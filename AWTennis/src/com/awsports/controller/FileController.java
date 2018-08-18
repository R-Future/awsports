package com.awsports.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/file")
public class FileController {

	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年9月23日 上午8:52:16
	 * @param session
	 * @throws IOException
	 * @Return: ResponseEntity<byte[]>
	 * @Description: 批量导入单打模板文档下载
	 *
	 */
	@RequestMapping("/downloadSingleDoc")
	public ResponseEntity<byte[]> downloadSingleDoc(HttpSession session) throws IOException {
		String filePath = session.getServletContext().getRealPath("/")+"resources/download/single.xls";
		//System.out.print(filePath);
		File file = new File(filePath);
		HttpHeaders headers = new HttpHeaders();
		String filename = "singleMatchDoc.xls";
		headers.setContentDispositionFormData("attachment", filename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年9月23日 上午8:52:50
	 * @param session
	 * @throws IOException
	 * @Return: ResponseEntity<byte[]>
	 * @Description: 批量导入双打模板文档下载 
	 *
	 */
	@RequestMapping("/downloadDoubleDoc")
	public ResponseEntity<byte[]> downloadDoubleDoc(HttpSession session) throws IOException {
		String filePath = session.getServletContext().getRealPath("/")+"resources/download/double.xls";
		File file = new File(filePath);
		HttpHeaders headers = new HttpHeaders();
		String filename = "doubleMatchDoc.xls";
		headers.setContentDispositionFormData("attachment", filename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
