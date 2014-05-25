package com.github.dyamah.jbv.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BitVectorImplTest.class, SimpleBitVector64Test.class, UINT32Test.class, UINT64Test.class })
public class AllTests {
  
}
