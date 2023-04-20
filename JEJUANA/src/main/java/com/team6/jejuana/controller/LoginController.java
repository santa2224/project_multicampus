package com.team6.jejuana.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team6.jejuana.dto.LoginDTO;
import com.team6.jejuana.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	//
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/login");
		return mav;
	}
	
	//
	@GetMapping("/join")
	public ModelAndView join() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/join");
		return mav;
	}
	
	//로그인(DB)
	@PostMapping("/loginOk")
	public ModelAndView loginOk(String id, String password, HttpServletRequest request, HttpSession session) {
		LoginDTO dto = service.loginOk(id, password);
		ModelAndView mav = new ModelAndView();
		
		if(dto!=null) {//로그인 성공
			session.setAttribute("loginId", dto.getId());
			session.setAttribute("loginPassword", dto.getPassword());
			session.setAttribute("loginStatus", "Y");
			mav.setViewName("redirect:/");
		}else {//로그인 실패
			mav.setViewName("redirect:login");
		}
		return mav;		
	}
	
	// 로그아웃 - 세션제거
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	//아이디 중복검사
	@GetMapping("/idCheck")
	public String idCheck(String id, Model model) {
		int result = service.idCheckCount(id);
		
		model.addAttribute("id", id);
		model.addAttribute("result", result);
		
		return "login/idCheck";
	}
	
	//회원가입
	@RequestMapping(value="/joinOk", method=RequestMethod.POST)
	public ModelAndView joinOk(LoginDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		int result = service.loginInsert(dto);
		
		if(result>0) {//회원가입 성공시 로그인페이지이동
			mav.addObject("msg","회원가입에 성공했습니다. 로그인 페이지로 이동합니다.");
			mav.setViewName("redirect:login");
		}else {//회원가입 실패 시 로그인 폼으로 이동+메세지
			mav.setViewName("login/join");
		}
		return mav;
	}
}