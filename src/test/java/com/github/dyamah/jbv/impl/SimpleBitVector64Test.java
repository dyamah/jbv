package com.github.dyamah.jbv.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleBitVector64Test {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSimpleBitVector64() {
    assertNotNull(new SimpleBitVector64());
  }

  @Test
  public void testSimpleBitVector64Int() {
    try {
      new SimpleBitVector64(-1);
      fail("");
    } catch (IllegalArgumentException e) {
      assertEquals("The capacity is negative.", e.getMessage());
    } catch (Exception e) {
      fail("");
    }
    assertNotNull(new SimpleBitVector64(0));
  }

  @Test
  public void testGetSet00() {
    SimpleBitVector64 bv = new SimpleBitVector64(2);
    try {
      bv.get(-1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }
    assertEquals(0, bv.get(1));
    assertEquals(0, bv.get(2));
    assertEquals(0, bv.get(3));
  }

  @Test
  public void testGetSet01() {
    SimpleBitVector64 bv = new SimpleBitVector64(5);

    assertEquals(0, bv.get(0));
    assertEquals(0, bv.get(1));
    assertEquals(0, bv.get(2));
    assertEquals(0, bv.get(3));
    assertEquals(0, bv.get(4));
    assertEquals(0, bv.get(5));

    bv.set(1);
    bv.set(3);
    bv.set(4);

    assertEquals(0, bv.get(0));
    assertEquals(1, bv.get(1));
    assertEquals(0, bv.get(2));
    assertEquals(1, bv.get(3));
    assertEquals(1, bv.get(4));
    assertEquals(0, bv.get(5));

    bv.set(2);
    bv.set(3);
    bv.set(4);
    bv.set(100);

    assertEquals(0, bv.get(0));
    assertEquals(1, bv.get(1));
    assertEquals(1, bv.get(2));
    assertEquals(1, bv.get(3));
    assertEquals(1, bv.get(4));
    for (int i = 5; i < 100; i++)
      assertEquals(0, bv.get(i));

    assertEquals(1, bv.get(100));

    for (int i = 101; i < 200; i++)
      assertEquals(0, bv.get(i));

  }

  @Test
  public void testBlock00() {
    SimpleBitVector64 bv = new SimpleBitVector64(128);
    try {
      bv.block(-1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    assertEquals(0L, bv.block(0));
    assertEquals(0L, bv.block(1));

    try {
      bv.block(2);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    bv.set(128);

    try {
      bv.block(-1);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }

    assertEquals(0L, bv.block(0));
    assertEquals(0L, bv.block(1));

    try {
      assertEquals(0x8000000000000000L, bv.block(2));
    } catch (Exception e) {
      fail("");
    }
  }

  @Test
  public void testBlock01() {
    SimpleBitVector64 bv = new SimpleBitVector64(256);

    bv.set(0);
    bv.set(128); bv.set(129); bv.set(191);
    for(int i = 193; i < 256; i++)
      bv.set(i);

    assertEquals(0x8000000000000000L, bv.block(0));
    assertEquals(0x0000000000000000L, bv.block(1));
    assertEquals(0xC000000000000001L, bv.block(2));
    assertEquals(0x7FFFFFFFFFFFFFFFL, bv.block(3));

    try {
      bv.block(4);
      fail("");
    } catch (IndexOutOfBoundsException e) {
      assertNotNull(e);
    } catch (Exception e) {
      fail("");
    }
  }

  @Test
  public void testPopCount() {
    SimpleBitVector64 bv = new SimpleBitVector64(5);

    assertEquals(0, bv.popCount());
    bv.set(0);
    assertEquals(1, bv.popCount());
    bv.set(1);
    assertEquals(2, bv.popCount());
    bv.set(1);
    assertEquals(2, bv.popCount());
    bv.set(7);
    assertEquals(3, bv.popCount());
    bv.set(2);
    assertEquals(4, bv.popCount());
    bv.set(100);
    assertEquals(5, bv.popCount());
    bv.set(101);
    assertEquals(6, bv.popCount());
  }

}
