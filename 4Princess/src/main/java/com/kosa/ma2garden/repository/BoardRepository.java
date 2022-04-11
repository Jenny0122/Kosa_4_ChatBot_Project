package com.kosa.ma2garden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kosa.ma2garden.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

	@Modifying
	@Query("update Board b set b.counts = b.counts + 1 where b.no = :no")
	int updateCounts(@Param("no") long no);
}
