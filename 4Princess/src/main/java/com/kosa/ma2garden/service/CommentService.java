package com.kosa.ma2garden.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.Comment;
import com.kosa.ma2garden.entity.CommentDTO;
import com.kosa.ma2garden.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepository;

	public List<CommentDTO> getAllComment() {

		List<CommentDTO> list = new ArrayList<CommentDTO>();

		for (Comment comment : commentRepository.findAll()) {
			CommentDTO commentDTO = CommentDTO.builder()
					.co_no(comment.getCo_no())
					.comment(comment.getComment())
					.created_at(comment.getCreatedAt())
					.updated_at(comment.getUpdatedAt())
					.board_no(comment.getBoard_no())
					.user_no(comment.getUser_no())
					.build();
			list.add(commentDTO);
		}

		return list;
	}

	public boolean createBoardData(CommentDTO commentDTO) {

		Comment newComment = Comment.builder()
				.co_no(commentDTO.getCo_no())
				.comment(commentDTO.getComment())
				.board_no(commentDTO.getBoard_no())
				.user_no(commentDTO.getUser_no())
				.build();

		commentRepository.save(newComment);
		return true;
	}

	public void deleteCommentdByNo(long no) {
		commentRepository.deleteById(no);
	}

}
