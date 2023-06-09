/*
 * Copyright (c) 2012 University of Tartu
 */
package com.github.adriaag.jbibtex;

public class BibTeXPreamble extends BibTeXObject {

	private Value value = null;


	BibTeXPreamble(){
	}

	public BibTeXPreamble(Value value){
		setValue(value);
	}

	public Value getValue(){
		return this.value;
	}

	private void setValue(Value value){
		this.value = value;
	}
}