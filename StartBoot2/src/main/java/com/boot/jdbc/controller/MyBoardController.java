package com.boot.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.dto.MyDto;
import com.boot.jdbc.model.service.MyService;

@Controller
@RequestMapping("/myboard")
public class MyBoardController {

	@Autowired
	private MyService myService;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		List<MyDto> list = myService.selectList();
		model.addAttribute("list", list);
		return "myboardlist"; //view의 이름에 return..
	}
	
	@GetMapping("/detail")
	public String selectOne(Model model, int myno) {
		model.addAttribute("dto", myService.selectOne(myno));
		return "myboarddetail";
	}

	@GetMapping("/insertform")
	public String insert() {
		return "myboardinsert";
	}
	
	@GetMapping("/insert")
	public String insert(MyDto dto) {
		int res = myService.insert(dto);
		if(res>0) {
			return "redirect:list";
		}else {
			return "myboardinsert";
		}
	}
	
	@GetMapping("/updateform")
	public String updateForm(int myno, Model model) {
		model.addAttribute("dto",myService.selectOne(myno));
		return "myboardupdate";
	}
	
	@GetMapping("/update")
	public String update(MyDto dto) {
		int res = myService.update(dto);
		if(res>0) {
			return "redirect:detail?myno="+dto.getMyno();
		}else {
			return "redirect:updateform?myno="+dto.getMyno();
		}
		
	}
	/*
	 *  /detail:상세보기
	 *  /insertform:글작성페이지이동
	 *  /insert:작성글 저장
	 *  /updateform : 글 수정 페이지 이동
	 *  /update : 글 수정
	 *  /delete : 글 삭제
	 *  
	 */
}
