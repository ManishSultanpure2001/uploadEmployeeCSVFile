package com.postgres.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.postgres.entity.FinalResponse;

public interface SaveEmployeeDetails {

	public FinalResponse saveDetails(MultipartFile file) throws IOException;
}
