package com.github.dyamah.jbv.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BitVectorImplTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testPopCount00() {
    assertEquals(0, BitVectorImpl.popCount(0L));
    assertEquals(64, BitVectorImpl.popCount(0xFFFFFFFFFFFFFFFFL));
    assertEquals(1, BitVectorImpl.popCount(0x8000000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x4000000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x2000000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x1000000000000000L));

    assertEquals(1, BitVectorImpl.popCount(0x0800000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0400000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0200000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0100000000000000L));

    assertEquals(1, BitVectorImpl.popCount(0x0080000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0040000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0020000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0010000000000000L));

    assertEquals(1, BitVectorImpl.popCount(0x0008000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0004000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0002000000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0001000000000000L));

    assertEquals(1, BitVectorImpl.popCount(0x0000800000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000400000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000200000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000100000000000L));

    assertEquals(1, BitVectorImpl.popCount(0x0000080000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000040000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000020000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000010000000000L));

    assertEquals(1, BitVectorImpl.popCount(0x0000008000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000004000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000002000000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000001000000000L));

    assertEquals(1, BitVectorImpl.popCount(0x0000000800000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000400000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000200000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000100000000L));

    assertEquals(1, BitVectorImpl.popCount(0x0000000080000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000040000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000020000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000010000000L));

    assertEquals(1, BitVectorImpl.popCount(0x0000000008000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000004000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000002000000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000001000000L));

    assertEquals(1, BitVectorImpl.popCount(0x0000000000800000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000400000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000200000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000100000L));

    assertEquals(1, BitVectorImpl.popCount(0x0000000000080000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000040000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000020000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000010000L));

    assertEquals(1, BitVectorImpl.popCount(0x0000000000008000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000004000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000002000L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000001000L));

    assertEquals(1, BitVectorImpl.popCount(0x0000000000000800L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000000400L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000000200L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000000100L));

    assertEquals(1, BitVectorImpl.popCount(0x0000000000000080L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000000040L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000000020L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000000010L));

    assertEquals(1, BitVectorImpl.popCount(0x0000000000000008L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000000004L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000000002L));
    assertEquals(1, BitVectorImpl.popCount(0x0000000000000001L));
  }

  @Test
  public void testPopCount01() {
    assertEquals(16, BitVectorImpl.popCount(0x3030303030303030L));
    assertEquals(16, BitVectorImpl.popCount(0x0303030303030303L));
    assertEquals(16, BitVectorImpl.popCount(0x1111111111111111L));
    assertEquals(16, BitVectorImpl.popCount(0xB00B00B00B00B001L));
    assertEquals(16, BitVectorImpl.popCount(0xF0011BC00C009001L));
    assertEquals(32, BitVectorImpl.popCount(0x0123456789ABCDEFL));
  }

  @Test
  public void testBitVectorImpl() {
    BitVectorImpl bv = new BitVectorImpl();
    for (int i = 0; i < 10000; i++)
      assertEquals(0, bv.get(i));

  }

  @Test
  public void testBitVectorImplInt() {
    BitVectorImpl bv = new BitVectorImpl(3096);
    for (int i = 0; i < 10000; i++)
      assertEquals(0, bv.get(i));
  }

  @Test
  public void testGetSet00() {
    BitVectorImpl bv = new BitVectorImpl();

    try {
      bv.set(-1);
      fail("");
    } catch (IllegalArgumentException e) {
      assertEquals("The index is negative.", e.getMessage());

    } catch (Exception e) {
      e.printStackTrace();
      fail("");
    }

    assertEquals(0, bv.get(-1));
    assertEquals(0, bv.get(0));
    assertEquals(0, bv.set(0));
    assertEquals(1, bv.get(0));
  }

  @Test
  public void testGetSet01() {
    BitVectorImpl bv = new BitVectorImpl();

    assertEquals(0, bv.set(1));
    assertEquals(0, bv.set(1));
    assertEquals(1, bv.set(3));
    assertEquals(2, bv.set(9));

    assertEquals(0, bv.get(0));
    assertEquals(1, bv.get(1));
    assertEquals(0, bv.get(2));
    assertEquals(1, bv.get(3));
    assertEquals(0, bv.get(4));
    assertEquals(0, bv.get(5));
    assertEquals(0, bv.get(6));
    assertEquals(0, bv.get(7));
    assertEquals(0, bv.get(8));
    assertEquals(1, bv.get(9));
    assertEquals(0, bv.get(10));
  }

  @Test
  public void testRank1_0() {
    BitVectorImpl bv = new BitVectorImpl();
    try {
      bv.rank1(-1);
      fail("");
    } catch (IllegalArgumentException e) {
      assertEquals("The index is negative.", e.getMessage());
    } catch (Exception e) {
      fail("");
    }

    assertEquals(0, bv.rank1(0));
    assertEquals(0, bv.rank1(1));
  }

  @Test
  public void testRank0_0() {
    BitVectorImpl bv = new BitVectorImpl();
    try {
      bv.rank0(-1);
      fail("");
    } catch (IllegalArgumentException e) {
      assertEquals("The index is negative.", e.getMessage());
    } catch (Exception e) {
      fail("");
    }

    assertEquals(0, bv.rank0(0));
    assertEquals(1, bv.rank0(1));
  }

  @Test
  public void testRank1_1() {
    BitVectorImpl bv = new BitVectorImpl();
    assertEquals(0, bv.rank1(1088));

    for (int i = 0; i < 4096; i++)
      assertEquals(0, bv.rank1(i));

    assertEquals(0, bv.set(1));
    assertEquals(1, bv.set(64));
    assertEquals(2, bv.set(127));
    assertEquals(3, bv.set(128));
    assertEquals(4, bv.set(255));
    assertEquals(5, bv.set(256));
    assertEquals(5, bv.set(256));
    assertEquals(6, bv.set(1024));

    for (int i = 0; i < 4096; i++) {
      if (i <= 1)
        assertEquals(0, bv.rank1(i));
      if (1 < i && i <= 64)
        assertEquals(1, bv.rank1(i));
      if (64 < i && i <= 127)
        assertEquals(2, bv.rank1(i));
      if (127 < i && i <= 128)
        assertEquals(3, bv.rank1(i));
      if (128 < i && i <= 255)
        assertEquals(4, bv.rank1(i));
      if (255 < i && i <= 256)
        assertEquals(5, bv.rank1(i));
      if (256 < i && i <= 1024)
        assertEquals(6, bv.rank1(i));
      if (1024 < i)
        assertEquals(7, bv.rank1(i));
    }
  }

  @Test
  public void testRank0_1() {
    BitVectorImpl bv = new BitVectorImpl();
    assertEquals(1088, bv.rank0(1088));

    assertEquals(0, bv.rank0(0));

    for (int i = 1; i < 4096; i++)
      assertEquals(i, bv.rank0(i));

    assertEquals(0, bv.set(1));
    assertEquals(1, bv.set(64));
    assertEquals(2, bv.set(127));
    assertEquals(3, bv.set(128));
    assertEquals(4, bv.set(255));
    assertEquals(5, bv.set(256));
    assertEquals(5, bv.set(256));
    assertEquals(6, bv.set(1024));

    for (int i = 0; i < 4096; i++) {
      if (0 < i && i <= 1)
        assertEquals(1, bv.rank0(i));
      if (1 < i && i <= 64)
        assertEquals(i-1, bv.rank0(i));
      if (64 < i && i <= 127)
        assertEquals(i-2, bv.rank0(i));
      if (127 < i && i <= 128)
        assertEquals(i-3, bv.rank0(i));
      if (128 < i && i <= 255)
        assertEquals(i-4, bv.rank0(i));
      if (255 < i && i <= 256)
        assertEquals(i-5, bv.rank0(i));
      if (256 < i && i <= 1024)
        assertEquals(i-6, bv.rank0(i));
      if (1024 < i)
        assertEquals(i-7, bv.rank0(i));
    }
  }

  @Test
  public void testRank1_2() {
    BitVectorImpl bv = new BitVectorImpl();

    for (int i = 0; i < 4200; i++)
      assertEquals(0, bv.rank1(i));

    for (int i = 0; i < 4200; i++) {
      assertEquals(i, bv.set(i));
    }

    for (int i = 0; i < 4200; i++) {
      assertEquals(i, bv.rank1(i));
    }
    for (int i = 4200; i < 8400; i++) {
      assertEquals(4200, bv.rank1(i));
    }
  }

  @Test
  public void testRank1_3() {
    BitVectorImpl bv = new BitVectorImpl();
    assertEquals(0, bv.set(65536));
    assertEquals(0, bv.set(65536));
    for (int i = 0; i <= 65536; i++)
      assertEquals(0, bv.rank1(i));
    assertEquals(1, bv.rank1(65537));
    for (int i = 65537; i < 65537 + 10000; i++)
      assertEquals(1, bv.rank1(i));
  }

  @Test
  public void testSelect1_0() {
    BitVectorImpl bv = new BitVectorImpl();
    try {
      bv.select1(-1);
      fail("");
    } catch (IllegalArgumentException e) {
      assertEquals("The argument is less than 1.", e.getMessage());
    } catch (Exception e) {
      fail("");
    }

    try {
      bv.select1(0);
      fail("");
    } catch (IllegalArgumentException e) {
      assertEquals("The argument is less than 1.", e.getMessage());
    } catch (Exception e) {
      fail("");
    }

    assertEquals(-1, bv.select1(1));
  }

  @Test
  public void testSelect1_1() {
    BitVectorImpl bv = new BitVectorImpl();

    for (int i = 1; i < 4096; i++)
      assertEquals(-1, bv.select1(i));

    assertEquals(0, bv.set(1));
    assertEquals(1, bv.set(64));
    assertEquals(2, bv.set(127));
    assertEquals(3, bv.set(128));
    assertEquals(4, bv.set(255));
    assertEquals(5, bv.set(256));
    assertEquals(5, bv.set(256));
    assertEquals(6, bv.set(1024));

    assertEquals(1, bv.select1(1));
    assertEquals(64, bv.select1(2));
    assertEquals(127, bv.select1(3));
    assertEquals(128, bv.select1(4));
    assertEquals(255, bv.select1(5));
    assertEquals(256, bv.select1(6));
    assertEquals(1024, bv.select1(7));

    for (int i = 8; i < 4096; i++)
      assertEquals(-1, bv.select1(i));
  }

  @Test
  public void testSelect1_2() {
    BitVectorImpl bv = new BitVectorImpl();

    for (int i = 1; i <= 8192; i++)
      assertEquals(-1, bv.select1(i));

    for (int i = 0; i < 8192; i++)
      assertEquals(i, bv.set(i));

    assertEquals(1279, bv.select1(1280));

    for (int i = 1; i <= 8192; i++)
      assertEquals(i - 1, bv.select1(i));
  }

  @Test
  public void testSelect1_3() {
    BitVectorImpl bv = new BitVectorImpl();

    for (int i = 1; i <= 8192; i++)
      assertEquals(-1, bv.select1(i));

    for (int i = 0; i < 8192; i++)
      if (i % 256 == 0)
        bv.set(i);

    assertEquals(1280, bv.select1(6));

    for (int i = 1; i <= 8192 / 256; i++)
      assertEquals(256 * (i - 1), bv.select1(i));

  }

}
