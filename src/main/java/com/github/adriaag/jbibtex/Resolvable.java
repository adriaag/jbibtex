/*
 * Copyright (c) 2012 University of Tartu
 */
package com.github.adriaag.jbibtex;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Resolvable {

	@JsonIgnore
	boolean isResolved();
}