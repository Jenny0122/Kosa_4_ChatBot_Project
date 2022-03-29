package com.kosa.ma2garden;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kosa.ma2garden.entity.ColorFlower;
import com.kosa.ma2garden.repository.ColorFlowerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ColorFlowerTests {

	@Autowired
	ColorFlowerRepository colorFlowerRepository;

	@Test
	public void Test1() {
		for (ColorFlower colorflower : colorFlowerRepository.findAll()) {
			log.info(colorflower.toString());

		}

		assertThat(colorFlowerRepository.findAll()).isEmpty();

	}

}
