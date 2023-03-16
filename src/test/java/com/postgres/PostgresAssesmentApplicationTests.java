package com.postgres;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.postgres.programs.TestPrograms;
import com.postgres.serviceImpl.SaveEmployeeDetailsImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class PostgresAssesmentApplicationTests {
private static final int EXPECTDVALUE = 4;
@Autowired
private SaveEmployeeDetailsImpl service;
	@Test
	void testPositiveMax() {
		assertEquals(EXPECTDVALUE, TestPrograms.maxValue(new int[] {1,2,3,4}));
	}

    @Test  
    public void testNegitiveMax(){  
        System.out.println("test case cube");  
        assertEquals(-1,TestPrograms.maxValue(new int[] {-1,-2,-3,-4}));  
    }  
	
 
}
