package com.postgres.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectReader;
import com.postgres.entity.EmployeeDetails;
import com.postgres.service.SaveEmployeeDetails;

@Service
public class SaveEmployeeDetailsImpl implements SaveEmployeeDetails{

	@Override
	public boolean saveDetails(MultipartFile file) {
		 try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

             // create csv bean reader
             CsvToBean<EmployeeDetails> csvToBean = new CsvToBeanBuilder(reader)
                     .withType(EmployeeDetails.class)
                     .withIgnoreLeadingWhiteSpace(true)
                     .build();

             // convert `CsvToBean` object to list of users
             List<EmployeeDetails> users = csvToBean.parse();
	return true;
	}

	
}
