package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.Board;
import com.kosa.ma2garden.entity.BoardDTO;
import com.kosa.ma2garden.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	BoardRepository boardRepository;

	public List<BoardDTO> getAllBoard() {

		List<BoardDTO> list = new ArrayList<BoardDTO>();

		for (Board board : boardRepository.findAll()) {
			BoardDTO boardDTO = BoardDTO.builder().no(board.getNo()).counts(board.getCounts()).title(board.getTitle())
					.contents(board.getContents()).day(board.getDay()).user_no(board.getUser_no()).build();
			list.add(boardDTO);
		}

		return list;
	}

	public boolean createBoardData(BoardDTO boardDTO) {
		
		Board newBoard = Board.builder()
				.counts(boardDTO.getCounts())
				.title(boardDTO.getTitle())
				.contents(boardDTO.getContents())
				.day(boardDTO.getDay())
				.user_no(boardDTO.getUser_no())
				.build();
		
		boardRepository.save(newBoard);
		return true;
	}
}
