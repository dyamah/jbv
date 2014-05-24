package com.github.dyamah.jbv.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UINT32Test {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  private int naivePopCount(int x) {
    if (x == 0)
      return 0;

    int p = 0;
    for (int i = 0; i < 32; i++) {
      if (((0x80000000 >>> i) & x) != 0)
        p++;
    }
    return p;
  }

  @Test
  public void testPopCount() {
    int n = 1 << 21;
    for (int i = 0; i < n; i++)
      assertEquals(naivePopCount(i), UINT32.popCount(i));
    assertEquals(32, UINT32.popCount(0xFFFFFFFF));
  }

  @Test
  public void testRank1() {

    try {
      UINT32.rank1(0xFFFFFFFF, -1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    for (int i = 0; i < 32; i++)
      assertEquals(i, UINT32.rank1(0xFFFFFFFF, i));

    for (int i = 0; i < 32; i++)
      assertEquals(0, UINT32.rank1(0x00000000, i));

    for (int i = 0; i < 12; i++)
      assertEquals(0, UINT32.rank1(0x000F0000, i));
    for (int i = 12; i < 16; i++)
      assertEquals(i - 12, UINT32.rank1(0x000F0000, i));
    for (int i = 16; i < 32; i++)
      assertEquals(4, UINT32.rank1(0x000F0000, i));

    try {
      UINT32.rank1(0xFFFFFFFF, 32);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }
  }

  @Test
  public void testRank0() {
    try {
      UINT32.rank0(0xFFFFFFFF, -1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    for (int i = 0; i < 32; i++)
      assertEquals(0, UINT32.rank0(0xFFFFFFFF, i));

    for (int i = 0; i < 32; i++)
      assertEquals(i, UINT32.rank0(0x00000000, i));

    for (int i = 0; i < 12; i++)
      assertEquals(i, UINT32.rank0(0x000F0000, i));
    for (int i = 12; i < 16; i++)
      assertEquals(12, UINT32.rank0(0x000F0000, i));
    for (int i = 16; i < 32; i++)
      assertEquals(i - 4, UINT32.rank0(0x000F0000, i));

    try {
      UINT32.rank0(0xFFFFFFFF, 32);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }
  }

  @Test
  public void testSelect1() {
    assertEquals(-1, UINT32.select1(0xFFFFFFFF, -1));
    assertEquals(-1, UINT32.select1(0xFFFFFFFF, 0));
    for (int i = 1; i <= 32; i++)
      assertEquals(i - 1, UINT32.select1(0xFFFFFFFF, i));
    assertEquals(-1, UINT32.select1(0xFFFFFFFF, 33));

    assertEquals(-1, UINT32.select1(0x00000000, -1));
    assertEquals(-1, UINT32.select1(0x00000000, 0));
    for (int i = 1; i <= 32; i++)
      assertEquals(-1, UINT32.select1(0x00000000, i));
    assertEquals(-1, UINT32.select1(0x00000000, 33));

    assertEquals(-1, UINT32.select1(0x0F030701, -1));
    assertEquals(-1, UINT32.select1(0x0F030701, 0));

    assertEquals(4, UINT32.select1(0x0F030701, 1));
    assertEquals(5, UINT32.select1(0x0F030701, 2));
    assertEquals(6, UINT32.select1(0x0F030701, 3));
    assertEquals(7, UINT32.select1(0x0F030701, 4));
    assertEquals(14, UINT32.select1(0x0F030701, 5));
    assertEquals(15, UINT32.select1(0x0F030701, 6));
    assertEquals(21, UINT32.select1(0x0F030701, 7));
    assertEquals(22, UINT32.select1(0x0F030701, 8));
    assertEquals(23, UINT32.select1(0x0F030701, 9));
    assertEquals(31, UINT32.select1(0x0F030701, 10));

    for (int i = 11; i < 40; i++)
      assertEquals(-1, UINT32.select1(0x0F030701, i));
  }

  @Test
  public void testSelect0() {
    assertEquals(-1, UINT32.select0(0xFFFFFFFF, -1));
    assertEquals(-1, UINT32.select0(0xFFFFFFFF, 0));
    for (int i = 1; i <= 32; i++)
      assertEquals(-1, UINT32.select0(0xFFFFFFFF, i));
    assertEquals(-1, UINT32.select0(0xFFFFFFFF, 33));

    assertEquals(-1, UINT32.select0(0x00000000, -1));
    assertEquals(-1, UINT32.select0(0x00000000, 0));
    for (int i = 1; i <= 32; i++)
      assertEquals(i - 1, UINT32.select0(0x00000000, i));
    assertEquals(-1, UINT32.select0(0x00000000, 33));

    assertEquals(-1, UINT32.select0(0x0F030701, -1));
    assertEquals(-1, UINT32.select0(0x0F030701, 0));

    assertEquals(0, UINT32.select0(0x0F030701, 1));
    assertEquals(1, UINT32.select0(0x0F030701, 2));
    assertEquals(2, UINT32.select0(0x0F030701, 3));
    assertEquals(3, UINT32.select0(0x0F030701, 4));

    assertEquals(8, UINT32.select0(0x0F030701, 5));
    assertEquals(9, UINT32.select0(0x0F030701, 6));
    assertEquals(10, UINT32.select0(0x0F030701, 7));
    assertEquals(11, UINT32.select0(0x0F030701, 8));

    assertEquals(12, UINT32.select0(0x0F030701, 9));
    assertEquals(13, UINT32.select0(0x0F030701, 10));

    assertEquals(16, UINT32.select0(0x0F030701, 11));
    assertEquals(17, UINT32.select0(0x0F030701, 12));
    assertEquals(18, UINT32.select0(0x0F030701, 13));
    assertEquals(19, UINT32.select0(0x0F030701, 14));

    assertEquals(20, UINT32.select0(0x0F030701, 15));

    assertEquals(24, UINT32.select0(0x0F030701, 16));
    assertEquals(25, UINT32.select0(0x0F030701, 17));
    assertEquals(26, UINT32.select0(0x0F030701, 18));
    assertEquals(27, UINT32.select0(0x0F030701, 19));

    assertEquals(28, UINT32.select0(0x0F030701, 20));
    assertEquals(29, UINT32.select0(0x0F030701, 21));
    assertEquals(30, UINT32.select0(0x0F030701, 22));

    for (int i = 23; i < 40; i++)
      assertEquals(-1, UINT32.select0(0x0F030701, i));

  }

  @Test
  public void testGetSet00() {
    try {
      UINT32.get(0xFFFFFFFF, -1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    for (int i = 0; i < 32; i++)
      assertEquals(1, UINT32.get(0xFFFFFFFF, i));

    try {
      UINT32.get(0xFFFFFFFF, 32);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    try {
      UINT32.set(0x00000000, -1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    for (int i = 0; i < 32; i++)
      assertEquals(1 << (31 - i), UINT32.set(0x00000000, i));

    try {
      UINT32.set(0x00000000, 32);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

  }

  @Test
  public void testGetSet01() {

    assertEquals(0, UINT32.get(0x0102F00A, 0));
    assertEquals(0, UINT32.get(0x0102F00A, 1));
    assertEquals(0, UINT32.get(0x0102F00A, 2));
    assertEquals(0, UINT32.get(0x0102F00A, 3));
    assertEquals(0, UINT32.get(0x0102F00A, 4));
    assertEquals(0, UINT32.get(0x0102F00A, 5));
    assertEquals(0, UINT32.get(0x0102F00A, 6));
    assertEquals(1, UINT32.get(0x0102F00A, 7));
    assertEquals(0, UINT32.get(0x0102F00A, 8));
    assertEquals(0, UINT32.get(0x0102F00A, 9));

    assertEquals(0, UINT32.get(0x0102F00A, 10));
    assertEquals(0, UINT32.get(0x0102F00A, 11));
    assertEquals(0, UINT32.get(0x0102F00A, 12));
    assertEquals(0, UINT32.get(0x0102F00A, 13));
    assertEquals(1, UINT32.get(0x0102F00A, 14));
    assertEquals(0, UINT32.get(0x0102F00A, 15));
    assertEquals(1, UINT32.get(0x0102F00A, 16));
    assertEquals(1, UINT32.get(0x0102F00A, 17));
    assertEquals(1, UINT32.get(0x0102F00A, 18));
    assertEquals(1, UINT32.get(0x0102F00A, 19));

    assertEquals(0, UINT32.get(0x0102F00A, 20));
    assertEquals(0, UINT32.get(0x0102F00A, 21));
    assertEquals(0, UINT32.get(0x0102F00A, 22));
    assertEquals(0, UINT32.get(0x0102F00A, 23));
    assertEquals(0, UINT32.get(0x0102F00A, 24));
    assertEquals(0, UINT32.get(0x0102F00A, 25));
    assertEquals(0, UINT32.get(0x0102F00A, 26));
    assertEquals(0, UINT32.get(0x0102F00A, 27));
    assertEquals(1, UINT32.get(0x0102F00A, 28));
    assertEquals(0, UINT32.get(0x0102F00A, 29));

    assertEquals(1, UINT32.get(0x0102F00A, 30));
    assertEquals(0, UINT32.get(0x0102F00A, 31));
  }

  @Test
  public void testGetSet02() {

    assertEquals(0x8102F00A, UINT32.set(0x0102F00A, 0));
    assertEquals(0x4102F00A, UINT32.set(0x0102F00A, 1));
    assertEquals(0x2102F00A, UINT32.set(0x0102F00A, 2));
    assertEquals(0x1102F00A, UINT32.set(0x0102F00A, 3));

    assertEquals(0x0902F00A, UINT32.set(0x0102F00A, 4));
    assertEquals(0x0502F00A, UINT32.set(0x0102F00A, 5));
    assertEquals(0x0302F00A, UINT32.set(0x0102F00A, 6));
    assertEquals(0x0102F00A, UINT32.set(0x0102F00A, 7));

    assertEquals(0x0182F00A, UINT32.set(0x0102F00A, 8));
    assertEquals(0x0142F00A, UINT32.set(0x0102F00A, 9));
    assertEquals(0x0122F00A, UINT32.set(0x0102F00A, 10));
    assertEquals(0x0112F00A, UINT32.set(0x0102F00A, 11));

    assertEquals(0x010AF00A, UINT32.set(0x0102F00A, 12));
    assertEquals(0x0106F00A, UINT32.set(0x0102F00A, 13));
    assertEquals(0x0102F00A, UINT32.set(0x0102F00A, 14));
    assertEquals(0x0103F00A, UINT32.set(0x0102F00A, 15));

    assertEquals(0x0102F00A, UINT32.set(0x0102F00A, 16));
    assertEquals(0x0102F00A, UINT32.set(0x0102F00A, 17));
    assertEquals(0x0102F00A, UINT32.set(0x0102F00A, 18));
    assertEquals(0x0102F00A, UINT32.set(0x0102F00A, 19));

    assertEquals(0x0102F80A, UINT32.set(0x0102F00A, 20));
    assertEquals(0x0102F40A, UINT32.set(0x0102F00A, 21));
    assertEquals(0x0102F20A, UINT32.set(0x0102F00A, 22));
    assertEquals(0x0102F10A, UINT32.set(0x0102F00A, 23));

    assertEquals(0x0102F08A, UINT32.set(0x0102F00A, 24));
    assertEquals(0x0102F04A, UINT32.set(0x0102F00A, 25));
    assertEquals(0x0102F02A, UINT32.set(0x0102F00A, 26));
    assertEquals(0x0102F01A, UINT32.set(0x0102F00A, 27));

    assertEquals(0x0102F00A, UINT32.set(0x0102F00A, 28));
    assertEquals(0x0102F00E, UINT32.set(0x0102F00A, 29));
    assertEquals(0x0102F00A, UINT32.set(0x0102F00A, 30));
    assertEquals(0x0102F00B, UINT32.set(0x0102F00A, 31));
  }

}
