package com.example.demoback.operation.dto;

import java.io.Serializable;

import com.example.demoback.operation.factory.OperationType;

public class OperationDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -905076631514254912L;

	private Long operating1;
	
	private Long operating2;
	
	private OperationType operationType;

	public Long getOperating1() {
		return operating1;
	}

	public void setOperating1(Long operating1) {
		this.operating1 = operating1;
	}

	public Long getOperating2() {
		return operating2;
	}

	public void setOperating2(Long operating2) {
		this.operating2 = operating2;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	
}
