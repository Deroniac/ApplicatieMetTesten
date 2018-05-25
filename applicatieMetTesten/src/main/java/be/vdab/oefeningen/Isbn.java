package be.vdab.oefeningen;

import java.util.HashSet;
import java.util.Set;

public class Isbn {
	private static final Set<Short> MOGELIJKE_EERSTE_3_CIJFERS = new HashSet<>();
	private final long nummer;
	static {
		MOGELIJKE_EERSTE_3_CIJFERS.add((short) 978);
		MOGELIJKE_EERSTE_3_CIJFERS.add((short) 979);
	}
	
	public Isbn(long nummer) {
		if (nummer < 1000_000_000_000L || nummer > 9999_999_999_999L) {
			throw new IllegalArgumentException("Bestaat niet uit 13 cijfers");
		}
		short eerste3Cijfers = (short) (nummer / 10_000_000_000L);
		if (!MOGELIJKE_EERSTE_3_CIJFERS.contains(eerste3Cijfers)) {
			throw new IllegalArgumentException("begint niet met " + MOGELIJKE_EERSTE_3_CIJFERS);
		}
		long somEvenCijfers = 0;
		long somOnevenCijfers = 0;
		long teVerwerkenCijfers = nummer / 10;
		for (int teller = 0; teller != 6; teller++) {
			somEvenCijfers += teVerwerkenCijfers % 10;
			teVerwerkenCijfers /= 10;
			somOnevenCijfers += teVerwerkenCijfers % 10;
			teVerwerkenCijfers /= 10;
		}
		long controleGetal = somEvenCijfers * 3 + somOnevenCijfers;
		long naastGelegenTiental = controleGetal - controleGetal % 10 + 10;
		long verschil = naastGelegenTiental - controleGetal;
		long laatsteCijfer = nummer % 10;
		if (verschil == 10) {
			if (laatsteCijfer != 0) {
				throw new IllegalArgumentException("Verkeerd controlegetal");
			}
		} else {
			if(laatsteCijfer != verschil) {
				throw new IllegalArgumentException("Verkeerd controlegetal");
			}
		}
		this.nummer = nummer;
	}
	@Override
	public String toString() {
		return String.valueOf(nummer);
	}
}
