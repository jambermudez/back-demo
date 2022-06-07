package com.example.demoback.operation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demoback.DemoBackApplication;
import com.example.demoback.operation.dto.OperationDTO;
import com.example.demoback.operation.factory.OperationType;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = DemoBackApplication.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
class OperationControllerTest{
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void operation_ok() throws Exception {
		
		OperationDTO operationDTO = new OperationDTO();
		operationDTO.setOperating1(1L);
		operationDTO.setOperating2(2L);
		operationDTO.setOperationType(OperationType.SUM);
		
		//Act
		ObjectMapper mapper = new ObjectMapper();
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(operationDTO));
		
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		MvcResult result = ra.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		//Assert
		Long expected = Long.valueOf(result.getResponse().getContentAsString());
		Long actual = 3L;
		
		assertEquals(expected, actual);
	}
	
	@Test
	void operation_400() throws Exception {
		
		OperationDTO operationDTO = new OperationDTO();
		operationDTO.setOperating1(1L);
		operationDTO.setOperating2(2L);
		operationDTO.setOperationType(OperationType.DIV);
		
		//Act
		ObjectMapper mapper = new ObjectMapper();
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(operationDTO));
		
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().is4xxClientError());
		
		String errorActual = ra.andReturn().getResponse().getContentAsString();
		
		String errorExpected = "Invalid Operatior";
		assertEquals(errorExpected, errorActual);
	}
	
	@Test
	void operation_Invalid_operator_500() throws Exception {
		
		OperationDTO operationDTO = new OperationDTO();
		operationDTO.setOperating1(1L);
		operationDTO.setOperating2(2L);
		operationDTO.setOperationType(OperationType.MULT);
		
		//Act
		ObjectMapper mapper = new ObjectMapper();
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(operationDTO));
		
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		ra.andExpect(MockMvcResultMatchers.status().is5xxServerError());
		
		String errorActual = ra.andReturn().getResponse().getContentAsString();
		
		String errorExpected = "Operation Not implemented yet";
		assertEquals(errorExpected, errorActual);
	}
}
