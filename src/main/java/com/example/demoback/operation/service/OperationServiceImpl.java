package com.example.demoback.operation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoback.exception.Operation400Exception;
import com.example.demoback.exception.OperationException;
import com.example.demoback.operation.dto.OperationDTO;
import com.example.demoback.operation.factory.OperationFactory;
import com.example.demoback.trace.UtilsTrace;

@Service
public class OperationServiceImpl implements OperationService{
	
	@Autowired
	private UtilsTrace utilsTrace;

	@Override
	public Long doOperation(OperationDTO opertionDTO) throws OperationException, Operation400Exception {
		Long result = OperationFactory.buildOperation(opertionDTO);
		this.utilsTrace.trace(result);
		return result;
	}

}
