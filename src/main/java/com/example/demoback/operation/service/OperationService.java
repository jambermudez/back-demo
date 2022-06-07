package com.example.demoback.operation.service;

import com.example.demoback.exception.Operation400Exception;
import com.example.demoback.exception.OperationException;
import com.example.demoback.operation.dto.OperationDTO;

public interface OperationService {

	Long doOperation(OperationDTO opertionDTO) throws OperationException, Operation400Exception;
}
