/*
 * Copyright (c) 2012 University of Tartu
 */
package github.io.adriaag.jbibtex;

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