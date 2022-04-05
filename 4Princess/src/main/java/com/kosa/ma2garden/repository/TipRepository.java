package com.kosa.ma2garden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosa.ma2garden.entity.Tip;

@Repository
public interface TipRepository extends JpaRepository<Tip, Long>{}