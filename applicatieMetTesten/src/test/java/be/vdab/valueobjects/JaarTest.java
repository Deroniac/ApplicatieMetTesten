package be.vdab.valueobjects;
import org.junit.Assert;
import org.junit.Test;
public class JaarTest {
	@Test
	public void eenjaarDeelbaarDoor400IsEenSchrikkeljaar() {
		Assert.assertTrue(new Jaar(2000).isSchrikkeljaar());
	}
	@Test
	public void eenJaarDeelbaarDoor100IsGeenSchrikkeljaar() {
		Assert.assertFalse(new Jaar(1900).isSchrikkeljaar());
	}
	@Test
	public void eenJaarDeelbaarDoor4IsEenSchrikkeljaar() {
		Assert.assertTrue(new Jaar(2012).isSchrikkeljaar());
	}
	@Test
	public void eenJaarNietDeelbaarDoor4IsGeenSchrikkeljaar() {
		Assert.assertFalse(new Jaar(2015).isSchrikkeljaar());
	}
}