package com.file.demo.emp.restController;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.file.demo.emp.model.Emp;
import com.file.demo.emp.service.EmpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/emp")
public class EmpRestController {
	
	private static final Logger logger = Logger.getLogger(EmpRestController.class.getName());
	
	@Autowired
	private EmpService empService;

	@PostMapping("/save")
	public ResponseEntity<String> saveEmp(@Valid @RequestBody Emp emp){
		logger.info("Request"+emp.toString());
		int saveEmp = empService.saveEmp(emp);
		
		if (saveEmp > 0 ) {
			logger.info("Resource Created");
			return ResponseEntity.status(HttpStatus.CREATED).body("Employee saved successfully.");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save employee.");
		
	}
}
