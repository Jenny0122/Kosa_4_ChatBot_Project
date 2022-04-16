package com.kosa.ma2garden.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.Board;
import com.kosa.ma2garden.entity.Comment;
import com.kosa.ma2garden.entity.CommentDTO;
import com.kosa.ma2garden.entity.User;
import com.kosa.ma2garden.repository.BoardRepository;
import com.kosa.ma2garden.repository.CommentRepository;
import com.kosa.ma2garden.repository.UserRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	UserRepository userRepository;

//	public List<CommentDTO> getAllComment() {
//
//		List<CommentDTO> list = new ArrayList<CommentDTO>();
//
//		for (Comment comment : commentRepository.findAll()) {
//			CommentDTO commentDTO = CommentDTO.builder()
//					.co_no(comment.getCo_no())
//					.comment(comment.getComment())
//					.created_at(comment.getCreatedAt())
//					.updated_at(comment.getUpdatedAt())
//					.board_no(comment.getBoard_no()
//							.getNo())
//					.user_no(comment.getUser_no())
//					.build();
//			list.add(commentDTO);
//		}

//		return list;
//	}

	public boolean createCommentData(CommentDTO commentDTO) {

		System.out.println(commentDTO);
		Board board = boardRepository.findById(commentDTO.getBoard_no()).get();
		User user = userRepository.findById(commentDTO.getUser_no().getId()).get();

		Comment newComment = Comment.builder()
				.co_no(commentDTO.getCo_no())
				.comment(commentDTO.getComment())
				.board_no(board)
				.user_no(user)
				.build();

		commentRepository.save(newComment);
		return true;
	}

	public void deleteCommentdByNo(long no) {
		commentRepository.deleteById(no);
	}

}
