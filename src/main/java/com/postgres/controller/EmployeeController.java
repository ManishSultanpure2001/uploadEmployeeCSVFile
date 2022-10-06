package com.postgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.postgres.serviceImpl.SaveEmployeeDetailsImpl;

@RestController
public class EmployeeController {

	@Autowired 
	SaveEmployeeDetailsImpl saveEmployeeDetailsImpl;
	
	@PostMapping("/uploadFile")
	public ResponseEntity<String> saveData(@RequestParam("file") MultipartFile file){
		System.out.println(file);
		if(saveEmployeeDetailsImpl.saveDetails(file))
		return ResponseEntity.ok("Success"+file);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email Or password"+file);
	}
}
