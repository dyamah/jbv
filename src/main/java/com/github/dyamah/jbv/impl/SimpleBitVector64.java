package com.github.dyamah.jbv.impl;

import com.github.dyamah.jbv.BitVector;

/**
 * 64bitを１ブロックとして実装した単純なビットベクトル(rankやselectは実装されていない)
 *
 * @author Hiroyasu Yamada
 *
 */
public class SimpleBitVector64 implements BitVector {

  /** デフォルトキャパシティ */
  private final int DEFAULT_CAPACITY = 1024;

  /** ビットブロック */
  private long[]    blocks_;

  /** popcount */
  private int       popCount_;

  /**
   * デフォルトのキャパシティでインスタンスを生成する
   */
  SimpleBitVector64() {
    blocks_ = new long[DEFAULT_CAPACITY / UINT64.SIZE];
    popCount_ = 0;
  }

  /**
   * 指定したキャパシティでインスタンスを生成する。
   *
   * @param capacity
   *          キャパシティ。負の値を指定した場合は IllegalArgumentException をスロー。
   */
  SimpleBitVector64(int capacity) {
    if (capacity < 0)
      throw new IllegalArgumentException("The capacity is negative.");
    blocks_ = new long[capacity / UINT64.SIZE];
    popCount_ = 0;
  }

  @Override
  public int get(int i) {
    if (i < 0)
      throw new IndexOutOfBoundsException(": " + i);
    int x = i / UINT64.SIZE;
    if (x >= blocks_.length)
      return 0;
    int y = i % UINT64.SIZE;
    return UINT64.get(blocks_[x], y);
  }

  @Override
  public void set(int i) {
    if (i < 0)
      throw new IndexOutOfBoundsException(": " + i);
    int x = i / UINT64.SIZE;
    resize(x);

    int y = i % UINT64.SIZE;
    if (UINT64.get(blocks_[x], y) == 0)
      popCount_++;
    blocks_[x] = UINT64.set(blocks_[x], y);
  }

  /**
   * k番目のブロックの値を取得する
   *
   * @param k
   *          インデックス。範囲外(負やブロック数を超える場合)はIndexOutOfBoundsExceptionをスロー
   * @return k番目のブロック値
   */
  long block(int k) {
    return blocks_[k];
  }

  private void resize(int x) {
    if (x < blocks_.length)
      return;
    long[] newBlocks = new long[x + 1];
    System.arraycopy(blocks_, 0, newBlocks, 0, blocks_.length);
    blocks_ = newBlocks;
  }

  @Override
  final public int popCount() {
    return popCount_;
  }

}
