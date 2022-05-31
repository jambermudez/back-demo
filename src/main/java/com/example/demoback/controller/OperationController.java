package com.example.demoback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoback.trace.UtilsTrace;


@RestController
public class OperationController {

	@Autowired
	private UtilsTrace utilsTrace;
	
	@GetMapping
	public void operation () {

		this.utilsTrace.trace(1L);
	}
	
}
