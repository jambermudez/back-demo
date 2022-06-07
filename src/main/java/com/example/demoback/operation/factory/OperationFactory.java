package com.example.demoback.operation.factory;

import com.example.demoback.exception.Operation400Exception;
import com.example.demoback.exception.OperationException;
import com.example.demoback.operation.dto.OperationDTO;
import com.example.demoback.operation.utils.OperationUtils;

public class OperationFactory {
	
	public static Long buildOperation (OperationDTO operationDTO) throws OperationException, Operation400Exception {
		
		switch (operationDTO.getOperationType()) {
		case SUM:
			return OperationUtils.sum(operationDTO.getOperating1(), operationDTO.getOperating2());
			
		case REST:
			return OperationUtils.rest(operationDTO.getOperating1(), operationDTO.getOperating2());
			
		case MULT:
			throw new OperationException(OperationFactory.class, "Operation Not implemented yet");

		default:
			throw new Operation400Exception("Invalid Operatior");
		}
	}

}
