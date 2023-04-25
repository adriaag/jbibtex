/*
 * Copyright (c) 2014 University of Tartu
 */
package com.github.adriaag.jbibtex;

import org.junit.Test;

import com.github.adriaag.jbibtex.Key;
import com.github.adriaag.jbibtex.KeyMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KeyMapTest {

	@Test
	public void putAndRemove(){
		KeyMap<Object> map = new KeyMap<>();

		assertTrue(map.putIfMissing(new Key("Test"), null));
		assertFalse(map.putIfMissing(new Key("test"), null));

		assertTrue(map.removeIfPresent(new Key("test")));
		assertFalse(map.removeIfPresent(new Key("Test")));
	}
}