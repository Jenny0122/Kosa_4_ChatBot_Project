package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.Board;
import com.kosa.ma2garden.entity.BoardDTO;
import com.kosa.ma2garden.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {
	@Autowired
	BoardRepository boardRepository;

	public List<BoardDTO> getAllBoard() {

		List<BoardDTO> list = new ArrayList<BoardDTO>();

		for (Board board : boardRepository.findAll()) {
			BoardDTO boardDTO = BoardDTO.builder()
					.no(board.getNo())
					.counts(board.getCounts())
					.title(board.getTitle())
					.created_at(board.getCreatedAt())
					.updated_at(board.getUpdatedAt())
					.contents(board.getContents())
					.user_no(board.getUser_no())
					.build();
			list.add(boardDTO);
		}

		Collections.reverse(list);

		return list;
	}

	public boolean createBoardData(BoardDTO boardDTO) {

		Board newBoard = Board.builder()
				.counts(boardDTO.getCounts())
				.title(boardDTO.getTitle())
				.contents(boardDTO.getContents())
				.user_no(boardDTO.getUser_no())
				.build();

		boardRepository.save(newBoard);
		return true;
	}

	public BoardDTO getBoardByNo(long no) {

		Board board = boardRepository.findById(no)
				.get();
		boardRepository.updateCounts(no);

		if (board != null) {
			BoardDTO boardDTO = BoardDTO.builder()
					.no(board.getNo())
					.counts(board.getCounts())
					.title(board.getTitle())
					.created_at(board.getCreatedAt())
					.updated_at(board.getUpdatedAt())
					.contents(board.getContents())
					.user_no(board.getUser_no())
					.comment(board.getComments())
					.build();

			return boardDTO;
		} else {
			return null;

		}
	}

	public void deleteBoardByNo(long no) {
		boardRepository.deleteById(no);
	}

	public BoardDTO updateTitleAndContents(BoardDTO boardDTO) {

		int result = boardRepository.updateTitleAndContents(boardDTO.getTitle(), boardDTO.getContents(),
				boardDTO.getNo());
		Board board = boardRepository.findById(boardDTO.getNo())
				.get();

		return BoardDTO.builder()
				.no(board.getNo())
				.counts(board.getCounts())
				.title(board.getTitle())
				.created_at(board.getCreatedAt())
				.updated_at(board.getUpdatedAt())
				.contents(board.getContents())
				.user_no(board.getUser_no())
				.build();
	}
}
