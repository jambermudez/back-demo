package com.example.demoback.operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoback.operation.dto.OperationDTO;
import com.example.demoback.operation.service.OperationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
public class OperationController {

	@Autowired
	private OperationService operationService;
	
	@Operation(summary = "Operation",
            description = "Do operation",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Operation OK"),
                    @ApiResponse(responseCode = "400", description = "Invalid Parameter"),
                    @ApiResponse(responseCode = "500", description = "Error Operation")})
	@PostMapping
	public Long operation (@RequestBody OperationDTO operationDTO) {
		return this.operationService.doOperation(operationDTO);
	}
	
}
