package com.github.marcelocure.sandbox.java.spring.injection;

public class TextEditor {
	private SpellChecker spellChecker;

	public TextEditor() {
		System.out.println("Inside TextEditor constructor.");
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
	
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker; 
	}
}