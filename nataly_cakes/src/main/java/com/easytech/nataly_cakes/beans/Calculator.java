package com.easytech.nataly_cakes.beans;

import org.springframework.context.annotation.Configuration;

import com.easytech.nataly_cakes.enums.CakeDecorationType;
import com.easytech.nataly_cakes.enums.PartySetType;
import com.easytech.nataly_cakes.enums.ProductType;
import com.easytech.nataly_cakes.enums.SaltedType;

@Configuration
public class Calculator {
	private int weight;
	private int productQuantity;
	private ProductType productType;
	private CakeDecorationType cakeDecorationType;
	private SaltedType saltedType;
	private PartySetType partySetType;
	
	
	public Calculator(int weight, int productQuantity, ProductType productType, CakeDecorationType cakeDecorationType,
			SaltedType saltedType, PartySetType partySetType) {
		super();
		this.weight = weight;
		this.productQuantity = productQuantity;
		this.productType = productType;
		this.cakeDecorationType = cakeDecorationType;
		this.saltedType = saltedType;
		this.partySetType = partySetType;
	}
	public Calculator() {
		super();
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public CakeDecorationType getCakeDecorationType() {
		return cakeDecorationType;
	}
	public void setCakeDecorationType(CakeDecorationType cakeDecorationType) {
		this.cakeDecorationType = cakeDecorationType;
	}
	public SaltedType getSaltedType() {
		return saltedType;
	}
	public void setSaltedType(SaltedType saltedType) {
		this.saltedType = saltedType;
	}
	public PartySetType getPartySetType() {
		return partySetType;
	}
	public void setPartySetType(PartySetType partySetType) {
		this.partySetType = partySetType;
	}
	

}
