package com.postgres.service;

import org.springframework.web.multipart.MultipartFile;

public interface SaveEmployeeDetails {

	public boolean saveDetails(MultipartFile file);
}
