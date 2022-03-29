package com.kosa.ma2garden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosa.ma2garden.entity.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long>{

}
