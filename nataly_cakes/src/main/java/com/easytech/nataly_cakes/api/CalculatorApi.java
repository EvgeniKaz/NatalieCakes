package com.easytech.nataly_cakes.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytech.nataly_cakes.beans.Calculator;
import com.easytech.nataly_cakes.exceptions.ApplicationException;
import com.easytech.nataly_cakes.logic.CalculatorController;

@RestController
@RequestMapping("/calculate")
public class CalculatorApi {

	@Autowired
	private CalculatorController calculatorController = null;
	@PostMapping
	public void enterOrder(@RequestBody Calculator calculator) throws ApplicationException{
		calculatorController.getCalculator().setCakeDecorationType(calculator.getCakeDecorationType());
		calculatorController.getCalculator().setProductType(calculator.getProductType());
		calculatorController.getCalculator().setPartySetType(calculator.getPartySetType());
		calculatorController.getCalculator().setProductQuantity(calculator.getProductQuantity());
		calculatorController.getCalculator().setSaltedType(calculator.getSaltedType());
		calculatorController.getCalculator().setWeight(calculator.getWeight());
	}
	@GetMapping 
	public double getOrderResult() {
		return calculatorController.calculateOrder();
	}
	
}
