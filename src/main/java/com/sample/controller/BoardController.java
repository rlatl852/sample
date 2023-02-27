package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.domain.BoardDTO;
import com.sample.domain.Criteria;
import com.sample.domain.PageVO;
import com.sample.service.BoardService;

@Controller
@RequestMapping("/Board")
public class BoardController {

	@Autowired
	private BoardService service;

	// 게시물 목록
	@GetMapping("/list")
	public String boardList(Model model, Criteria criteria) {
		List<BoardDTO> readAll = service.readAll(criteria);
		PageVO pageVO = new PageVO(service.totalCount(criteria), criteria);
		model.addAttribute("list", readAll);
		model.addAttribute("pageMarker", pageVO);
		return "boardList";
	}
}
