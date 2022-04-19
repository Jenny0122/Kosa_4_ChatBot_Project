package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.config.MetricCounter;
import com.kosa.ma2garden.dto.BoardDTO;
import com.kosa.ma2garden.dto.CommentDTO;
import com.kosa.ma2garden.dto.UserDTO;
import com.kosa.ma2garden.entity.Board;
import com.kosa.ma2garden.entity.Comment;
import com.kosa.ma2garden.entity.User;
import com.kosa.ma2garden.repository.BoardRepository;
import com.kosa.ma2garden.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MetricCounter metricCounter;

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
					.user_id(board.getUser_no()
							.getId())
					.build();
			list.add(boardDTO);
		}

		Collections.reverse(list);

		return list;
	}

	@Transactional
	public long createBoardData(BoardDTO boardDTO) {
		User user = userRepository.findById(boardDTO.getUser_id())
				.get();

		Board newBoard = Board.builder()
				.counts(boardDTO.getCounts())
				.title(boardDTO.getTitle())
				.contents(boardDTO.getContents())
				.user_no(user)
				.build();

		long newBoardNo = boardRepository.save(newBoard)
				.getNo();

		return newBoardNo;
	}

	public BoardDTO getBoardByNo(long no) {

		Board board = boardRepository.findById(no)
				.get();
		boardRepository.updateCounts(no);

		if (board != null) {
			List<Comment> comments = board.getComments();
			List<CommentDTO> dtoList = new ArrayList<CommentDTO>();

			for (Comment comment : comments)
				dtoList.add(CommentDTO.builder()
						.co_no(comment.getCo_no())
						.user_no(UserDTO.builder()
								.id(comment.getUser_no()
										.getId())
								.email(comment.getUser_no()
										.getEmail())
								.build())
						.comment(comment.getComment())
						.build());

			BoardDTO boardDTO = BoardDTO.builder()
					.no(board.getNo())
					.counts(board.getCounts())
					.title(board.getTitle())
					.created_at(board.getCreatedAt())
					.updated_at(board.getUpdatedAt())
					.contents(board.getContents())
					.user_id(board.getUser_no()
							.getId())
					.comment(dtoList)
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
				.user_id(board.getUser_no()
						.getId())
				.build();
	}
}
