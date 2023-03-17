package com.postgres.controller;

import java.io.IOException;
import java.util.List;

import  org.slf4j.Logger;
import  org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.postgres.entity.EmployeeDetails;
import com.postgres.entity.FinalResponse;
import com.postgres.serviceImpl.SaveEmployeeDetailsImpl;

@RestController
public class EmployeeController {
	@Autowired 
	SaveEmployeeDetailsImpl saveEmployeeDetailsImpl;
	EmployeeDetails details;
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@PostMapping("/uploadFile")
	public ResponseEntity<Object> saveData(@RequestParam("file") MultipartFile file) throws IOException{
		FinalResponse saveDetails = saveEmployeeDetailsImpl.saveDetails(file);
		List<EmployeeDetails> errorData = saveEmployeeDetailsImpl.getErrorData();
		for(int i=0;i<errorData.size();i++) {
			logger.info("Id= "+errorData.get(i).getEmployeeId()+", Reasons= "+errorData.get(i).getMessage());
		}
		return ResponseEntity.ok(saveDetails);
	}
}
