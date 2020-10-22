package com.it.gb4.board;

import java.util.List;

import com.it.gb4.util.Pager;

public interface BoardDAO {
	
	// abstract 메서드의 선언부
	
	// insert
	// abstract 생략 가능, 인터페이스에서 자동으로 해준다.
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	// update
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	// delete
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	// list
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	// selectOne
	public BoardDTO getOne(BoardDTO boardDTO)throws Exception;
	
	// count
	public long getCount(Pager pager)throws Exception;

}
