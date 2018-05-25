package be.vdab.services;

import be.vdab.repositories.OpbrengstRepository;

import java.math.BigDecimal;

import be.vdab.repositories.KostRepository;

public class WinstService {
	private final OpbrengstRepository opbrengstRepository;
	private final KostRepository kostRepository;
	
	public WinstService(OpbrengstRepository opbrengstRepository, KostRepository kostRepository) {
		this.opbrengstRepository = opbrengstRepository;
		this.kostRepository = kostRepository;
	}

	public BigDecimal getWinst() {
		return opbrengstRepository.findTotaleOpbrengst().subtract(kostRepository.findTotaleKost());
	}
	
}
