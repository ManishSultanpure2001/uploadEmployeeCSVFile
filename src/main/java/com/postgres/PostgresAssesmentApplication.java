package com.postgres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.postgres.programs.TestPrograms;

import lombok.experimental.var;
import com.postgres.programs.*;
@SpringBootApplication
public class PostgresAssesmentApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(PostgresAssesmentApplication.class, args);
		
	List<Integer> list=Arrays.asList(19,21,4,243,24,23);
	
	List<String> stringList =Arrays.asList("ramji","rafasj","raf1asj");
	
	String string = stringList.stream().reduce((a,b)->a.length()>b.length()?a:b).get();
	System.out.println(string);
//	TestPrograms.removeDuplicate();
//	TestPrograms.firstNonRepeatingCharecter();
//	TestPrograms.removeGivenCharecter();
//	TestPrograms.stringInterMethod();
//	TestPrograms.checkOperatorSize();
//	TestPrograms.varArgsExtract(12,32,12,312);
//	TestPrograms.stringSort();
//	TestPrograms.sortStringInDecedingOrder();
//	TestPrograms.sortStringOnTheBasisOFLastCahrecter();
//	TestPrograms.sortStringOnTheBasisOFLastCahrecterIfSameThanSecondLast();
//	TestPrograms.listCheck();
//	TestPrograms.arraySort();
	//TestPrograms.concurrentCheck();
	//System.out.println(TestPrograms.validation("abc uhasd auifsds  auidbas auid "));
	System.out.println(TestPrograms.removeDuplicate1());
	}

}
