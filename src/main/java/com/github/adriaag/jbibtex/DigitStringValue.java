/*
 * Copyright (c) 2012 University of Tartu
 */
package com.github.adriaag.jbibtex;

public class DigitStringValue extends LiteralValue {

	DigitStringValue(){
	}

	public DigitStringValue(String string){
		super(string);
	}

	@Override
	protected String format(){
		return getString();
	}
}