package com.kosa.ma2garden.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

	@GetMapping("/admin")
	public String goAdminPage() {

		return "redirect:http://ma2garden.xyz:3000";
	}

}
