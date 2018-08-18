package com.awsports.controller.exceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.awsports.util.CustomException;

/**
 * 
 * @author: Fu
 * @time: 2017年5月26日下午9:25:56
 * @description: 自定义异常处理器 
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {
		// TODO Auto-generated method stub
		CustomException customException=null;
		if(exception instanceof CustomException){
			customException=(CustomException)exception;
		}else{//未知错误
			customException=new CustomException("未知错误！");
		}
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("errorMessage",customException.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
