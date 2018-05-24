package be.vdab.oefeningen;

import org.junit.Test;
import static org.junit.Assert.*;
public class WoordTest {
	@Test
	public void lepelIsEenPalindroom() {
		Woord woord = new Woord("lepel");
		assertTrue(woord.isPalindroom());
	}
	@Test
	public void vorkIsGeenPalindroom() {
		Woord woord = new Woord("vork");
		assertFalse(woord.isPalindroom());
	}
	@Test
	public void eenLegeStringIsEenPalindroom() {
		Woord woord = new Woord("");
		assertTrue(woord.isPalindroom());
	}
}