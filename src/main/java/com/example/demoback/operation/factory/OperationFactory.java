package com.example.demoback.operation.factory;

import com.example.demoback.operation.dto.OperationDTO;
import com.example.demoback.operation.utils.OperationUtils;

public class OperationFactory {
	
	public static Long buildOperation (OperationDTO operationDTO) {
		
		switch (operationDTO.getOperationType()) {
		case SUM:
			return OperationUtils.sum(operationDTO.getOperating1(), operationDTO.getOperating2());
			
		case REST:
			return OperationUtils.rest(operationDTO.getOperating1(), operationDTO.getOperating2());

		default:
			return null;
		}
	}

}
