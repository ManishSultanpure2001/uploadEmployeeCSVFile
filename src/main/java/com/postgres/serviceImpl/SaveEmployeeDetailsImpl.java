package com.postgres.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.postgres.entity.EmployeeDetails;
import com.postgres.entity.FinalResponse;
import com.postgres.repository.EmployeeDetailsRepo;
import com.postgres.service.SaveEmployeeDetails;

@Service
public class SaveEmployeeDetailsImpl implements SaveEmployeeDetails {

	InputStream inputStreamImage;
	EmployeeDetails emp;
	List<EmployeeDetails> correctData;
	List<EmployeeDetails> errroData;
	int proccessedCount;
	int UnproccessedCount;

	FinalResponse finalResponse = new FinalResponse();
	@Autowired
	EmployeeDetailsRepo employeeDetailsRepo;

	@Override
	public FinalResponse saveDetails(MultipartFile file) throws IOException {

		inputStreamImage = file.getInputStream();
		Reader reader = new InputStreamReader(file.getInputStream());
		CSVReader csvReader = new CSVReaderBuilder(reader).build();
		correctData = new ArrayList<EmployeeDetails>();
		errroData = new ArrayList<EmployeeDetails>();
		// read line by line
		String[] record = null;
		List<String[]> readAll = csvReader.readAll();
		for (int i = 0; i < readAll.size(); i++) {
			record = readAll.get(i);
			try {
				emp = new EmployeeDetails();
				emp.setEmployeeId(Integer.parseInt(record[0].trim()));
				emp.setEmployeeName(record[1]);
				emp.setEmployeeAge(Integer.parseInt(record[2].trim()));
				emp.setEmployeeCountry(record[3]);
				if (record[0].equals("") || record[1].equals("") || record[2].equals("") || record[3].equals("")) {
					errroData.add(emp);
					emp.setMessage("Id , Name , Age , Country Must not be empty temp");
					UnproccessedCount++;
				} else {
					proccessedCount++;
					correctData.add(emp);
					employeeDetailsRepo.save(emp);
				}
				reader.close();
			} catch (Exception e) {
				UnproccessedCount++;
				errroData.add(emp);
				emp.setMessage("type Miss Match");
			}
		}

		finalResponse.setProcessedRow(proccessedCount);
		finalResponse.setSkippedRow(UnproccessedCount);
		System.out.println(finalResponse);
		return finalResponse;
	}

	public List<EmployeeDetails> getErrorData() {
		return errroData;
	}

}
