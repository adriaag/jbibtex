/*
 * Copyright (c) 2012 University of Tartu
 */
package com.github.adriaag.jbibtex;

public class LaTeXCommand extends LaTeXObject {

	private String name = null;


	LaTeXCommand(){
	}

	public LaTeXCommand(String name){
		setName(name);
	}

	public String getName(){
		return this.name;
	}

	private void setName(String name){
		this.name = name;
	}
}