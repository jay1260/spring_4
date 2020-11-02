package com.it.gb4.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.it.gb4.board.BoardDTO;
import com.it.gb4.board.BoardService;
import com.it.gb4.board.file.BoardFileDTO;
import com.it.gb4.util.FileSaver;
import com.it.gb4.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;
	
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception {
		// 파일을 HDD 저장
		String path = session.getServletContext().getRealPath("/resources/upload/notice");
		File file = new File(path);
		System.out.println(path);
		
		// ------ Sequence 받아오기
		//boardDTO.setNum(noticeDAO.getNum());
		
		// ------ Notice Insert
		int result = noticeDAO.setInsert(boardDTO);
		
		System.out.println("Num : "+boardDTO.getNum());
		
		// ------ NoticeFile Insert

		for(MultipartFile multipartFile:files) {
			if(multipartFile.getSize() != 0) {
				String fileName = fileSaver.saveCopy(file, multipartFile);
				
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setFileName(fileName);
				boardFileDTO.setOriName(multipartFile.getOriginalFilename());
				boardFileDTO.setNum(boardDTO.getNum());
				
				noticeDAO.setInsertFile(boardFileDTO);
			}
		}
		
		// -------------------
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(noticeDAO.getCount(pager));
		pager.makePage();
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getOne(boardDTO);
	}

}
