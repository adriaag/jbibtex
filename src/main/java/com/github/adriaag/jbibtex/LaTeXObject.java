/*
 * Copyright (c) 2012 University of Tartu
 */
package com.github.adriaag.jbibtex;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo (
	use = JsonTypeInfo.Id.CLASS
)
abstract
public class LaTeXObject implements Serializable {

	LaTeXObject(){
	}
}