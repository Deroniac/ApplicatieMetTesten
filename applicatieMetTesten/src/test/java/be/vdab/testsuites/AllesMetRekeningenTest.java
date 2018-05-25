package be.vdab.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import be.vdab.entities.RekeningTest;
import be.vdab.entities.RekeningnummerTest;

@RunWith(Suite.class)
@SuiteClasses({RekeningnummerTest.class, RekeningTest.class})
public class AllesMetRekeningenTest {

}
