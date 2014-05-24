package com.github.dyamah.jbv.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UINT64Test {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetSet00() {
    try {
      UINT64.get(0xFFFFFFFFFFFFFFFFL, -1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    for (int i = 0; i < 64; i++)
      assertEquals(1, UINT64.get(0xFFFFFFFFFFFFFFFFL, i));

    try {
      UINT64.get(0xFFFFFFFFFFFFFFFFL, 64);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    try {
      UINT64.set(0x0000000000000000L, -1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    for (int i = 0; i < 64; i++)
      assertEquals(1L << (63 - i), UINT64.set(0x0000000000000000L, i));

    try {
      UINT64.set(0x00000000000000000L, 64);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }
  }

  @Test
  public void testGetSet01() {
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 0));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 1));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 2));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 3));

    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 4));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 5));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 6));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 7));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 8));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 9));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 10));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 11));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 12));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 13));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 14));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 15));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 16));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 17));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 18));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 19));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 20));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 21));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 22));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 23));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 24));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 25));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 26));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 27));

    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 28));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 29));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 30));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 31));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 32));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 33));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 34));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 35));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 36));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 37));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 38));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 39));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 40));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 41));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 42));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 43));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 44));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 45));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 46));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 47));

    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 48));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 49));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 50));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 51));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 52));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 53));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 54));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 55));

    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 56));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 57));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 58));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 59));

    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 60));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 61));
    assertEquals(1, UINT64.get(0xBB00145F0102F00AL, 62));
    assertEquals(0, UINT64.get(0xBB00145F0102F00AL, 63));
  }

  @Test
  public void testGetSet02() {
    assertEquals(0x8102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 0));
    assertEquals(0x4102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 1));
    assertEquals(0x2102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 2));
    assertEquals(0x1102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 3));

    assertEquals(0x0902F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 4));
    assertEquals(0x0502F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 5));
    assertEquals(0x0302F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 6));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 7));

    assertEquals(0x0182F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 8));
    assertEquals(0x0142F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 9));
    assertEquals(0x0122F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 10));
    assertEquals(0x0112F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 11));

    assertEquals(0x010AF00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 12));
    assertEquals(0x0106F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 13));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 14));
    assertEquals(0x0103F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 15));

    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 16));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 17));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 18));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 19));

    assertEquals(0x0102F80A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 20));
    assertEquals(0x0102F40A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 21));
    assertEquals(0x0102F20A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 22));
    assertEquals(0x0102F10A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 23));

    assertEquals(0x0102F08A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 24));
    assertEquals(0x0102F04A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 25));
    assertEquals(0x0102F02A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 26));
    assertEquals(0x0102F01A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 27));

    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 28));
    assertEquals(0x0102F00E7039C01FL, UINT64.set(0x0102F00A7039C01FL, 29));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 30));
    assertEquals(0x0102F00B7039C01FL, UINT64.set(0x0102F00A7039C01FL, 31));

    assertEquals(0x0102F00AF039C01FL, UINT64.set(0x0102F00A7039C01FL, 32));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 33));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 34));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 35));

    assertEquals(0x0102F00A7839C01FL, UINT64.set(0x0102F00A7039C01FL, 36));
    assertEquals(0x0102F00A7439C01FL, UINT64.set(0x0102F00A7039C01FL, 37));
    assertEquals(0x0102F00A7239C01FL, UINT64.set(0x0102F00A7039C01FL, 38));
    assertEquals(0x0102F00A7139C01FL, UINT64.set(0x0102F00A7039C01FL, 39));

    assertEquals(0x0102F00A70B9C01FL, UINT64.set(0x0102F00A7039C01FL, 40));
    assertEquals(0x0102F00A7079C01FL, UINT64.set(0x0102F00A7039C01FL, 41));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 42));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 43));

    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 44));
    assertEquals(0x0102F00A703DC01FL, UINT64.set(0x0102F00A7039C01FL, 45));
    assertEquals(0x0102F00A703BC01FL, UINT64.set(0x0102F00A7039C01FL, 46));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 47));

    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 48));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 49));
    assertEquals(0x0102F00A7039E01FL, UINT64.set(0x0102F00A7039C01FL, 50));
    assertEquals(0x0102F00A7039D01FL, UINT64.set(0x0102F00A7039C01FL, 51));

    assertEquals(0x0102F00A7039C81FL, UINT64.set(0x0102F00A7039C01FL, 52));
    assertEquals(0x0102F00A7039C41FL, UINT64.set(0x0102F00A7039C01FL, 53));
    assertEquals(0x0102F00A7039C21FL, UINT64.set(0x0102F00A7039C01FL, 54));
    assertEquals(0x0102F00A7039C11FL, UINT64.set(0x0102F00A7039C01FL, 55));

    assertEquals(0x0102F00A7039C09FL, UINT64.set(0x0102F00A7039C01FL, 56));
    assertEquals(0x0102F00A7039C05FL, UINT64.set(0x0102F00A7039C01FL, 57));
    assertEquals(0x0102F00A7039C03FL, UINT64.set(0x0102F00A7039C01FL, 58));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 59));

    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 60));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 61));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 62));
    assertEquals(0x0102F00A7039C01FL, UINT64.set(0x0102F00A7039C01FL, 63));
  }

  @Test
  public void testPopCount() {
    assertEquals(0, UINT64.popCount(0L));
    assertEquals(64, UINT64.popCount(0xFFFFFFFFFFFFFFFFL));

    assertEquals(8, UINT64.popCount(0x1111111100000000L));
    assertEquals(16, UINT64.popCount(0x0000000033333333L));
  }

  @Test
  public void testRank1() {
    try {
      UINT64.rank1(0xFFFFFFFFFFFFFFFFL, -1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    for (int i = 0; i < 64; i++)
      assertEquals(i, UINT64.rank1(0xFFFFFFFFFFFFFFFFL, i));

    for (int i = 0; i < 64; i++)
      assertEquals(0, UINT64.rank1(0x0000000000000000L, i));

    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 0));
    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 1));
    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 2));
    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 3));

    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 4));
    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 5));
    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 6));
    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 7));

    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 8));
    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 9));
    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 10));
    assertEquals(0, UINT64.rank1(0x001000200F0FC001L, 11));

    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 12));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 13));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 14));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 15));

    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 16));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 17));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 18));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 19));

    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 20));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 21));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 22));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 23));

    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 24));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 25));
    assertEquals(1, UINT64.rank1(0x001000200F0FC001L, 26));
    assertEquals(2, UINT64.rank1(0x001000200F0FC001L, 27));

    assertEquals(2, UINT64.rank1(0x001000200F0FC001L, 28));
    assertEquals(2, UINT64.rank1(0x001000200F0FC001L, 29));
    assertEquals(2, UINT64.rank1(0x001000200F0FC001L, 30));
    assertEquals(2, UINT64.rank1(0x001000200F0FC001L, 31));

    assertEquals(2, UINT64.rank1(0x001000200F0FC001L, 32));
    assertEquals(2, UINT64.rank1(0x001000200F0FC001L, 33));
    assertEquals(2, UINT64.rank1(0x001000200F0FC001L, 34));
    assertEquals(2, UINT64.rank1(0x001000200F0FC001L, 35));

    assertEquals(2, UINT64.rank1(0x001000200F0FC001L, 36));
    assertEquals(3, UINT64.rank1(0x001000200F0FC001L, 37));
    assertEquals(4, UINT64.rank1(0x001000200F0FC001L, 38));
    assertEquals(5, UINT64.rank1(0x001000200F0FC001L, 39));

    assertEquals(6, UINT64.rank1(0x001000200F0FC001L, 40));
    assertEquals(6, UINT64.rank1(0x001000200F0FC001L, 41));
    assertEquals(6, UINT64.rank1(0x001000200F0FC001L, 42));
    assertEquals(6, UINT64.rank1(0x001000200F0FC001L, 43));

    assertEquals(6, UINT64.rank1(0x001000200F0FC001L, 44));
    assertEquals(7, UINT64.rank1(0x001000200F0FC001L, 45));
    assertEquals(8, UINT64.rank1(0x001000200F0FC001L, 46));
    assertEquals(9, UINT64.rank1(0x001000200F0FC001L, 47));

    assertEquals(10, UINT64.rank1(0x001000200F0FC001L, 48));
    assertEquals(11, UINT64.rank1(0x001000200F0FC001L, 49));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 50));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 51));

    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 52));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 53));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 54));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 55));

    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 56));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 57));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 58));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 59));

    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 60));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 61));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 62));
    assertEquals(12, UINT64.rank1(0x001000200F0FC001L, 63));

    try {
      UINT64.rank1(0xFFFFFFFFFFFFFFFFL, 64);
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
      UINT64.rank0(0xFFFFFFFFFFFFFFFFL, -1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    for (int i = 0; i < 64; i++)
      assertEquals(0, UINT64.rank0(0xFFFFFFFFFFFFFFFFL, i));

    for (int i = 0; i < 64; i++)
      assertEquals(i, UINT64.rank0(0x0000000000000000L, i));

    assertEquals(0, UINT64.rank0(0x001000200F0FC001L, 0)); // 0
    assertEquals(1, UINT64.rank0(0x001000200F0FC001L, 1));
    assertEquals(2, UINT64.rank0(0x001000200F0FC001L, 2));
    assertEquals(3, UINT64.rank0(0x001000200F0FC001L, 3));

    assertEquals(4, UINT64.rank0(0x001000200F0FC001L, 4)); // 0
    assertEquals(5, UINT64.rank0(0x001000200F0FC001L, 5));
    assertEquals(6, UINT64.rank0(0x001000200F0FC001L, 6));
    assertEquals(7, UINT64.rank0(0x001000200F0FC001L, 7));

    assertEquals(8, UINT64.rank0(0x001000200F0FC001L, 8)); // 1
    assertEquals(9, UINT64.rank0(0x001000200F0FC001L, 9));
    assertEquals(10, UINT64.rank0(0x001000200F0FC001L, 10));
    assertEquals(11, UINT64.rank0(0x001000200F0FC001L, 11));

    assertEquals(11, UINT64.rank0(0x001000200F0FC001L, 12)); // 0
    assertEquals(12, UINT64.rank0(0x001000200F0FC001L, 13));
    assertEquals(13, UINT64.rank0(0x001000200F0FC001L, 14));
    assertEquals(14, UINT64.rank0(0x001000200F0FC001L, 15));

    assertEquals(15, UINT64.rank0(0x001000200F0FC001L, 16)); // 0
    assertEquals(16, UINT64.rank0(0x001000200F0FC001L, 17));
    assertEquals(17, UINT64.rank0(0x001000200F0FC001L, 18));
    assertEquals(18, UINT64.rank0(0x001000200F0FC001L, 19));

    assertEquals(19, UINT64.rank0(0x001000200F0FC001L, 20)); // 0
    assertEquals(20, UINT64.rank0(0x001000200F0FC001L, 21));
    assertEquals(21, UINT64.rank0(0x001000200F0FC001L, 22));
    assertEquals(22, UINT64.rank0(0x001000200F0FC001L, 23));

    assertEquals(23, UINT64.rank0(0x001000200F0FC001L, 24)); // 2
    assertEquals(24, UINT64.rank0(0x001000200F0FC001L, 25));
    assertEquals(25, UINT64.rank0(0x001000200F0FC001L, 26));
    assertEquals(25, UINT64.rank0(0x001000200F0FC001L, 27));

    assertEquals(26, UINT64.rank0(0x001000200F0FC001L, 28)); // 0
    assertEquals(27, UINT64.rank0(0x001000200F0FC001L, 29));
    assertEquals(28, UINT64.rank0(0x001000200F0FC001L, 30));
    assertEquals(29, UINT64.rank0(0x001000200F0FC001L, 31));

    assertEquals(30, UINT64.rank0(0x001000200F0FC001L, 32)); // 0
    assertEquals(31, UINT64.rank0(0x001000200F0FC001L, 33));
    assertEquals(32, UINT64.rank0(0x001000200F0FC001L, 34));
    assertEquals(33, UINT64.rank0(0x001000200F0FC001L, 35));

    assertEquals(34, UINT64.rank0(0x001000200F0FC001L, 36)); // F
    assertEquals(34, UINT64.rank0(0x001000200F0FC001L, 37));
    assertEquals(34, UINT64.rank0(0x001000200F0FC001L, 38));
    assertEquals(34, UINT64.rank0(0x001000200F0FC001L, 39));

    assertEquals(34, UINT64.rank0(0x001000200F0FC001L, 40)); // 0
    assertEquals(35, UINT64.rank0(0x001000200F0FC001L, 41));
    assertEquals(36, UINT64.rank0(0x001000200F0FC001L, 42));
    assertEquals(37, UINT64.rank0(0x001000200F0FC001L, 43));

    assertEquals(38, UINT64.rank0(0x001000200F0FC001L, 44)); // F
    assertEquals(38, UINT64.rank0(0x001000200F0FC001L, 45));
    assertEquals(38, UINT64.rank0(0x001000200F0FC001L, 46));
    assertEquals(38, UINT64.rank0(0x001000200F0FC001L, 47));

    assertEquals(38, UINT64.rank0(0x001000200F0FC001L, 48)); // C
    assertEquals(38, UINT64.rank0(0x001000200F0FC001L, 49));
    assertEquals(38, UINT64.rank0(0x001000200F0FC001L, 50));
    assertEquals(39, UINT64.rank0(0x001000200F0FC001L, 51));

    assertEquals(40, UINT64.rank0(0x001000200F0FC001L, 52)); // 0
    assertEquals(41, UINT64.rank0(0x001000200F0FC001L, 53));
    assertEquals(42, UINT64.rank0(0x001000200F0FC001L, 54));
    assertEquals(43, UINT64.rank0(0x001000200F0FC001L, 55));

    assertEquals(44, UINT64.rank0(0x001000200F0FC001L, 56)); // 0
    assertEquals(45, UINT64.rank0(0x001000200F0FC001L, 57));
    assertEquals(46, UINT64.rank0(0x001000200F0FC001L, 58));
    assertEquals(47, UINT64.rank0(0x001000200F0FC001L, 59));

    assertEquals(48, UINT64.rank0(0x001000200F0FC001L, 60)); // 1
    assertEquals(49, UINT64.rank0(0x001000200F0FC001L, 61));
    assertEquals(50, UINT64.rank0(0x001000200F0FC001L, 62));
    assertEquals(51, UINT64.rank0(0x001000200F0FC001L, 63));

    try {
      UINT64.rank0(0xFFFFFFFFFFFFFFFFL, 64);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }
  }

  @Test
  public void testSelect1() {
    assertEquals(-1, UINT64.select1(0xFFFFFFFFFFFFFFFFL, -1));
    assertEquals(-1, UINT64.select1(0xFFFFFFFFFFFFFFFFL, 0));
    for (int i = 1; i <= 64; i++)
      assertEquals(i - 1, UINT64.select1(0xFFFFFFFFFFFFFFFFL, i));
    assertEquals(-1, UINT64.select1(0xFFFFFFFFFFFFFFFFL, 65));

    assertEquals(-1, UINT64.select1(0x0000000000000000L, -1));
    assertEquals(-1, UINT64.select1(0x0000000000000000L, 0));
    for (int i = 1; i <= 64; i++)
      assertEquals(-1, UINT64.select1(0x0000000000000000L, i));
    assertEquals(-1, UINT64.select1(0x0000000000000000L, 65));

    assertEquals(-1, UINT64.select1(0x0F0307010001200FL, -1));
    assertEquals(-1, UINT64.select1(0x0F0307010001200FL, 0));

    assertEquals(4, UINT64.select1(0x0F0307010001200FL, 1));
    assertEquals(5, UINT64.select1(0x0F0307010001200FL, 2));
    assertEquals(6, UINT64.select1(0x0F0307010001200FL, 3));
    assertEquals(7, UINT64.select1(0x0F0307010001200FL, 4));
    assertEquals(14, UINT64.select1(0x0F0307010001200FL, 5));
    assertEquals(15, UINT64.select1(0x0F0307010001200FL, 6));
    assertEquals(21, UINT64.select1(0x0F0307010001200FL, 7));
    assertEquals(22, UINT64.select1(0x0F0307010001200FL, 8));
    assertEquals(23, UINT64.select1(0x0F0307010001200FL, 9));
    assertEquals(31, UINT64.select1(0x0F0307010001200FL, 10));

    assertEquals(47, UINT64.select1(0x0F0307010001200FL, 11));
    assertEquals(50, UINT64.select1(0x0F0307010001200FL, 12));
    assertEquals(60, UINT64.select1(0x0F0307010001200FL, 13));
    assertEquals(61, UINT64.select1(0x0F0307010001200FL, 14));
    assertEquals(62, UINT64.select1(0x0F0307010001200FL, 15));
    assertEquals(63, UINT64.select1(0x0F0307010001200FL, 16));

    for (int i = 17; i <= 65; i++)
      assertEquals(-1, UINT64.select1(0x0F0307010001200FL, i));

  }

  @Test
  public void testSelect0() {
    assertEquals(-1, UINT64.select0(0xFFFFFFFFFFFFFFFFL, -1));
    assertEquals(-1, UINT64.select0(0xFFFFFFFFFFFFFFFFL, 0));
    for (int i = 1; i <= 64; i++)
      assertEquals(-1, UINT64.select0(0xFFFFFFFFFFFFFFFFL, i));
    assertEquals(-1, UINT64.select0(0xFFFFFFFFFFFFFFFFL, 65));

    assertEquals(-1, UINT64.select0(0x0000000000000000L, -1));
    assertEquals(-1, UINT64.select0(0x0000000000000000L, 0));
    for (int i = 1; i <= 64; i++)
      assertEquals(i - 1, UINT64.select0(0x0000000000000000L, i));
    assertEquals(-1, UINT64.select0(0x0000000000000000L, 65));

    // ---
    assertEquals(-1, UINT64.select0(0x0F0307010001200FL, -1));
    assertEquals(-1, UINT64.select0(0x0F0307010001200FL, 0));

    assertEquals(0, UINT64.select0(0x0F0307010001200FL, 1));
    assertEquals(1, UINT64.select0(0x0F0307010001200FL, 2));
    assertEquals(2, UINT64.select0(0x0F0307010001200FL, 3));
    assertEquals(3, UINT64.select0(0x0F0307010001200FL, 4));

    assertEquals(8, UINT64.select0(0x0F0307010001200FL, 5));
    assertEquals(9, UINT64.select0(0x0F0307010001200FL, 6));
    assertEquals(10, UINT64.select0(0x0F0307010001200FL, 7));
    assertEquals(11, UINT64.select0(0x0F0307010001200FL, 8));

    assertEquals(12, UINT64.select0(0x0F0307010001200FL, 9));
    assertEquals(13, UINT64.select0(0x0F0307010001200FL, 10));

    assertEquals(16, UINT64.select0(0x0F0307010001200FL, 11));
    assertEquals(17, UINT64.select0(0x0F0307010001200FL, 12));
    assertEquals(18, UINT64.select0(0x0F0307010001200FL, 13));
    assertEquals(19, UINT64.select0(0x0F0307010001200FL, 14));

    assertEquals(20, UINT64.select0(0x0F0307010001200FL, 15));

    assertEquals(24, UINT64.select0(0x0F0307010001200FL, 16));
    assertEquals(25, UINT64.select0(0x0F0307010001200FL, 17));
    assertEquals(26, UINT64.select0(0x0F0307010001200FL, 18));
    assertEquals(27, UINT64.select0(0x0F0307010001200FL, 19));

    assertEquals(28, UINT64.select0(0x0F0307010001200FL, 20));
    assertEquals(29, UINT64.select0(0x0F0307010001200FL, 21));
    assertEquals(30, UINT64.select0(0x0F0307010001200FL, 22));

    assertEquals(32, UINT64.select0(0x0F0307010001200FL, 23));
    assertEquals(33, UINT64.select0(0x0F0307010001200FL, 24));
    assertEquals(34, UINT64.select0(0x0F0307010001200FL, 25));
    assertEquals(35, UINT64.select0(0x0F0307010001200FL, 26));

    assertEquals(36, UINT64.select0(0x0F0307010001200FL, 27));
    assertEquals(37, UINT64.select0(0x0F0307010001200FL, 28));
    assertEquals(38, UINT64.select0(0x0F0307010001200FL, 29));
    assertEquals(39, UINT64.select0(0x0F0307010001200FL, 30));

    assertEquals(40, UINT64.select0(0x0F0307010001200FL, 31));
    assertEquals(41, UINT64.select0(0x0F0307010001200FL, 32));
    assertEquals(42, UINT64.select0(0x0F0307010001200FL, 33));
    assertEquals(43, UINT64.select0(0x0F0307010001200FL, 34));

    assertEquals(44, UINT64.select0(0x0F0307010001200FL, 35));
    assertEquals(45, UINT64.select0(0x0F0307010001200FL, 36));
    assertEquals(46, UINT64.select0(0x0F0307010001200FL, 37));

    assertEquals(48, UINT64.select0(0x0F0307010001200FL, 38));
    assertEquals(49, UINT64.select0(0x0F0307010001200FL, 39));
    assertEquals(51, UINT64.select0(0x0F0307010001200FL, 40));

    assertEquals(52, UINT64.select0(0x0F0307010001200FL, 41));
    assertEquals(53, UINT64.select0(0x0F0307010001200FL, 42));
    assertEquals(54, UINT64.select0(0x0F0307010001200FL, 43));
    assertEquals(55, UINT64.select0(0x0F0307010001200FL, 44));

    assertEquals(56, UINT64.select0(0x0F0307010001200FL, 45));
    assertEquals(57, UINT64.select0(0x0F0307010001200FL, 46));
    assertEquals(58, UINT64.select0(0x0F0307010001200FL, 47));
    assertEquals(59, UINT64.select0(0x0F0307010001200FL, 48));

    for (int i = 49; i < 100; i++)
      assertEquals(-1, UINT64.select0(0x0F0307010001200FL, i));

  }

}
