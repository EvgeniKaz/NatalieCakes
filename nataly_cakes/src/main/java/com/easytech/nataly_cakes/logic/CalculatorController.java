package com.easytech.nataly_cakes.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.easytech.nataly_cakes.beans.Calculator;
import com.easytech.nataly_cakes.enums.ProductType;

@Controller
public class CalculatorController {
	@Autowired
	private Calculator calculator;
	
	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public double calculateOrder() {
		double result = 0;
		if (calculator.getProductType().equals(ProductType.THEME_CAKES)) {
			switch (calculator.getCakeDecorationType()) {
			case SWEET_PRINT:
				result = 30;
				break;
			case SCULPTURED_CAKE:
				result = 40;
				break;
			case CLASSIC_CREME:
				result = 20;
			}
			switch (calculator.getWeight()) {
			case 1:
				result = result + 150;
				break;
			case 2:
				result = result + 160;
				break;
			case 3:
				result = result + 170;
				break;
			case 4:
				result = result + 180;
				break;
			case 5:
				result = result + 190;
				break;

			}

		}
		if (calculator.getProductType().equals(ProductType.PARTY_SETS)) {
			switch (calculator.getPartySetType()) {
			case CANDY:
				result = 5;
				break;
			case MUFFIN:
				result = 10;
				break;
			case COOKIES:
				result = 7;
				break;	
			}
			result = result*calculator.getProductQuantity();
		}
		if (calculator.getProductType().equals(ProductType.SALTED)) {
			switch (calculator.getSaltedType()) {
			case PIES:
				result = 12;
				break;
			case COOKIES:
				result = 7;
				break;	
			}
			result = result*calculator.getProductQuantity();
		}

		return result;
	}
}
