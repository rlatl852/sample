package com.sample.service;

import java.util.List;

import com.sample.domain.BoardDTO;
import com.sample.domain.Criteria;

public interface BoardService {

	List<BoardDTO> readAll(Criteria criteria);

	int totalCount(Criteria criteria);

}
