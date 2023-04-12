/*
 * Copyright (c) 2012 University of Tartu
 */
package github.io.adriaag.jbibtex;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Resolvable {

	@JsonIgnore
	boolean isResolved();
}