package com.kosa.ma2garden.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kosa.ma2garden.entity.User;
import com.kosa.ma2garden.repository.UserRepository;

@Service
public class SchedulerService {

	@Autowired
	UserRepository userRepository;

	@Scheduled(fixedDelay = 1000000)
	public void test() {
		for (User users : userRepository.findAll()) {
			System.out.println(users);
		}
	}
}
