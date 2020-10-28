package com.it.gb4.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.it.gb4.util.Pager;

public interface BoardService {
	
	// insert
	public int setInsert(BoardDTO boardDTO, MultipartFile files, HttpSession session) throws Exception;
	
	// update
	public int setUpdate(BoardDTO boardDTO) throws Exception;

	// delete
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	// list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	// one
	public BoardDTO getOne(BoardDTO boardDTO)throws Exception;
}
