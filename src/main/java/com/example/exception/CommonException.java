package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages={"com.example"})
public class CommonException {
	
	@ExceptionHandler(value={RuntimeException.class})
	private ModelAndView handleErrorCommon(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("errorMsg", "@ControllerAdvice 메시지입니다.");
		mav.addObject("exception", e);
		mav.setViewName("errorCommon");
		return mav;
	}

}
