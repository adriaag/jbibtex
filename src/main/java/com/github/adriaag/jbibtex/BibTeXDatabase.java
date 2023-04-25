/*
 * Copyright (c) 2012 University of Tartu
 */
package com.github.adriaag.jbibtex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BibTeXDatabase implements Serializable {

	private List<BibTeXObject> objects = new ArrayList<>();

	private List<BibTeXInclude> includes = new ArrayList<>();

	private KeyMap<BibTeXString> strings = new KeyMap<>();

	private KeyMap<BibTeXEntry> entries = new KeyMap<>();


	public void addObject(BibTeXObject object){
		boolean success;

		if(object instanceof BibTeXInclude){
			BibTeXInclude include = (BibTeXInclude)object;

			success = this.includes.add(include);
		} else

		if(object instanceof BibTeXString){
			BibTeXString string = (BibTeXString)object;

			success = this.strings.putIfMissing(string.getKey(), string);
		} else

		if(object instanceof BibTeXEntry){
			BibTeXEntry entry = (BibTeXEntry)object;
			
            BibTeXEntry entryToPut = entryToPut(entry, entries);

            if(entryToPut != null) {
                this.entries.put(entryToPut.getKey(), entryToPut);
                success = true;
            } else {
                success = false;
            }
			
		} else

		{
			success = true;
		} // End if

		if(success){
			this.objects.add(object);
		}
	}

	public void removeObject(BibTeXObject object){
		boolean success;

		if(object instanceof BibTeXInclude){
			BibTeXInclude include = (BibTeXInclude)object;

			success = this.includes.remove(include);
		} else

		if(object instanceof BibTeXString){
			BibTeXString string = (BibTeXString)object;

			success = this.strings.removeIfPresent(string.getKey());
		} else

		if(object instanceof BibTeXEntry){
			BibTeXEntry entry = (BibTeXEntry)object;

			success = this.entries.removeIfPresent(entry.getKey());
		} else

		{
			success = true;
		} // End if

		if(success){
			this.objects.remove(object);
		}
	}

	public List<BibTeXObject> getObjects(){
		return Collections.unmodifiableList(this.objects);
	}

	public BibTeXString resolveString(Key key){
		BibTeXString string = this.strings.get(key);

		if(string == null){

			for(BibTeXInclude include : this.includes){
				BibTeXDatabase database = include.getDatabase();

				string = database.resolveString(key);
				if(string != null){
					return string;
				}
			}
		}

		return string;
	}

	public Map<Key, BibTeXString> getStrings(){
		return Collections.unmodifiableMap(this.strings);
	}

	public BibTeXEntry resolveEntry(Key key){
		BibTeXEntry entry = this.entries.get(key);

		if(entry == null){

			for(BibTeXInclude include : this.includes){
				BibTeXDatabase database = include.getDatabase();

				entry = database.resolveEntry(key);
				if(entry != null){
					return entry;
				}
			}
		}

		return entry;
	}

	public Map<Key, BibTeXEntry> getEntries(){
		return Collections.unmodifiableMap(this.entries);
	}
	
    private BibTeXEntry entryToPut(BibTeXEntry entryCandidate, KeyMap<BibTeXEntry> currentEntries) {

        if(!currentEntries.containsKey(entryCandidate.getKey())) {
            return entryCandidate;
        }

        int i = 0;
        Key k = null;
        do {
            k = new Key(String.format("%s-%d", entryCandidate.getKey().getValue(), ++i));
        } while(currentEntries.containsKey(k));

        BibTeXEntry entryToAdd = new BibTeXEntry(entryCandidate.getType(), k);
        entryToAdd.addAllFields(entryCandidate.getFields());
        return entryToAdd;
    }
}