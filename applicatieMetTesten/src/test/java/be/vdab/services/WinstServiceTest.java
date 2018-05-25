package be.vdab.services;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import be.vdab.repositories.OpbrengstRepository;
import be.vdab.repositories.KostRepository;
import java.math.BigDecimal;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WinstServiceTest {
	private WinstService winstService;
	@Mock
	private OpbrengstRepository opbrengstRepository;
	@Mock
	private KostRepository kostRepository;
	
	@Before public void before() {
		when(opbrengstRepository.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(200));
		when(kostRepository.findTotaleKost()).thenReturn(BigDecimal.valueOf(169));
		winstService = new WinstService(opbrengstRepository, kostRepository);
	}
	@Test
	public void winstIsOpbrengstMinKost() {
		assertEquals(0, BigDecimal.valueOf(31).compareTo(winstService.getWinst()));
		verify(opbrengstRepository).findTotaleOpbrengst();
		verify(kostRepository).findTotaleKost();
	}
}
