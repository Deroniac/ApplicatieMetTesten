package be.vdab.services;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import be.vdab.repositories.OpbrengstRepository;
import be.vdab.repositories.KostRepository;
import be.vdab.repositories.OpbrengstRepositoryStub;
import be.vdab.repositories.KostRepositoryStub;
import java.math.BigDecimal;

public class WinstServiceTest {
	private WinstService winstService;
	private OpbrengstRepository opbrengstRepository;
	private KostRepository kostRepository;
	
	@Before public void before() {
		opbrengstRepository = new OpbrengstRepositoryStub();
		kostRepository = new KostRepositoryStub();
		winstService = new WinstService(opbrengstRepository, kostRepository);
	}
	@Test
	public void berekenWinstDoorOpbrengstenMinKosten() {
		assertEquals(0, BigDecimal.valueOf(9).compareTo(winstService.getWinst()));
	}
}
