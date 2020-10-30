package com.it.gb4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.it.gb4.board.BoardDTO;
import com.it.gb4.board.BoardService;
import com.it.gb4.board.file.BoardFileDTO;
import com.it.gb4.util.FileSaver;
import com.it.gb4.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileSaver fileSaver;
	
	public int setReply(BoardDTO boardDTO) throws Exception{
		int result = qnaDAO.setReplyUpdate(boardDTO);
		result = qnaDAO.setReply(boardDTO);
		return result;
	}
	
	@Override
	public int setInsert(BoardDTO boardDTO,MultipartFile [] files,HttpSession session) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/upload/qna");
		File file = new File(path);
		System.out.println(path);
		
		int result = qnaDAO.setInsert(boardDTO);
		System.out.println("NUM : " +boardDTO.getNum());
		
		for(MultipartFile multipartFile:files) {
			if(multipartFile.getSize()!=0) {
				String fileName = fileSaver.saveCopy(file, multipartFile);
				
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setFileName(fileName);
				boardFileDTO.setOriName(multipartFile.getOriginalFilename());
				boardFileDTO.setNum(boardDTO.getNum());
				
				qnaDAO.setInsertFile(boardFileDTO);
			}
		}
		
		return result; 
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(qnaDAO.getCount(pager));
		pager.makePage();
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getOne(boardDTO);
	}

}
