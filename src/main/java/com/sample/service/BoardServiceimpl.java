package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.domain.BoardDTO;
import com.sample.domain.Criteria;
import com.sample.mapper.BoardMapper;

@Service
public class BoardServiceimpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDTO> readAll(Criteria criteria){
		return boardMapper.getList(criteria);
	}
	
	@Override
	public int totalCount(Criteria criteria) {
		return boardMapper.totalCount(criteria);
	}
}
