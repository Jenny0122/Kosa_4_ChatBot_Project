package com.kosa.ma2garden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosa.ma2garden.entity.Invention_backup;

@Repository
public interface InventionRepository_backup extends JpaRepository<Invention_backup, Long>{

}
