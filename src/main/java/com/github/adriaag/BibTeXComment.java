/*
 * Copyright (c) 2012 University of Tartu
 */
package com.github.adriaag;

public class BibTeXComment extends BibTeXObject {

	private StringValue value = null;


	BibTeXComment(){
	}

	public BibTeXComment(StringValue value){
		setValue(value);
	}

	public StringValue getValue(){
		return this.value;
	}

	private void setValue(StringValue value){
		this.value = value;
	}
}