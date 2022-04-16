package com.kosa.ma2garden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.ma2garden.entity.UserDTO;
import com.kosa.ma2garden.entity.UserLoginResponseDTO;
import com.kosa.ma2garden.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "유저 정보 가져오기", notes = "노트 기록 예정")
	@ApiResponses({ @ApiResponse(code = 200, message = "API 정상 작동"), @ApiResponse(code = 500, message = "서버 에러") })
	@GetMapping("/idvaild/{id}")
	public ResponseEntity<Boolean> getCheck(@PathVariable long id) {

		return ResponseEntity.ok(userService.idVaild(id));
	}

	@ApiOperation(value = "유저 정보 가져오기", notes = "노트 기록 예정")
	@ApiResponses({ @ApiResponse(code = 200, message = "API 정상 작동"), @ApiResponse(code = 500, message = "서버 에러") })
	@PostMapping("/user")
	public ResponseEntity<String> getUsers(@RequestBody UserDTO userDTO) {

		userService.createUser(userDTO);
		return ResponseEntity.ok("성공");

	}

	@ApiOperation(value = "로그인 실행", notes = "노트 기록 예정")
	@ApiResponses({ @ApiResponse(code = 200, message = "API 정상 작동"), @ApiResponse(code = 500, message = "서버 에러") })
	@PostMapping("/login")
	public ResponseEntity<UserLoginResponseDTO> getLogin(@RequestBody UserDTO userDTO) {
		UserLoginResponseDTO loginDTO = userService.loginUser(userDTO);

		return ResponseEntity.ok(loginDTO);
	}
}
