package com.file.demo.emp.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.demo.emp.model.Emp;
import com.file.demo.emp.model.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	private static final Logger logger = Logger.getLogger(EmpServiceImpl.class.getName());
	
	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public int saveEmp(Emp emp) {
		
		logger.info("saving emp data");
		Emp save = empRepository.save(emp);
		if (save != null) {
			return 1;
		}
		return 0;
	}

}
