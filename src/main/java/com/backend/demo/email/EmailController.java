package com.backend.demo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@CrossOrigin("*")
public class EmailController {
	
	@Autowired
	private EmailPort emailPort;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/enviar")
	@ResponseBody
	public boolean SendEmail(@RequestBody EmailBody emailBody) {
		return emailPort.sendEmail(emailBody);
	}
}
