package com.kjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kjy.domain.ReplyVO;
import com.kjy.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/replies/*")
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;
	
	@GetMapping("/list")
	public void list(Model model) {
	
		log.info("list");
		model.addAttribute("list",service.getList());
	}
	
	@PostMapping("/register")
	public String register(ReplyVO reply, RedirectAttributes rttr) {
		
		log.info("register : " + reply);
		
		service.register(reply);
		
		rttr.addFlashAttribute("result", reply.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/modify")
	public void get(@RequestParam("rno") Long rno, Model model) {
		
		log.info("modify");
		model.addAttribute("reply", service.get(rno));
	}
	
	@PostMapping("/modify")
	public String modify(ReplyVO reply, RedirectAttributes rttr) {
		log.info("modify:"+reply);
		
		if(service.modify(reply)) {
			rttr.addFlashAttribute("result","SUCCESS");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("rno") Long rno, RedirectAttributes rttr) {
		
		log.info("remove..."+rno);
		if(service.remove(rno)) {
			rttr.addFlashAttribute("result", "SUCCESS");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
	}


	
}
