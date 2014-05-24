package com.github.dyamah.jbv.impl;

import com.github.dyamah.jbv.UINT;

public class UINT64 implements UINT {
  static final int            SIZE     = 64;

  static private final long[] BIT_MASK;
  static {
    BIT_MASK = new long[64];
    for (int i = 0; i < 64; i++)
      BIT_MASK[i] = 0x8000000000000000L >>> i;
  }

  private static final long[] POP_COUNT_MASK;
  static {
    POP_COUNT_MASK = new long[64];
    POP_COUNT_MASK[0] = 0;
    for (int i = 1; i < 64; i++)
      POP_COUNT_MASK[i] = 0x8000000000000000L >> (i - 1);
  }

  private UINT64() {
  }

  /**
   * uのi番目のビット値を返す
   *
   * @param u
   * @param i
   *          負の値や64以上の場合はIndexOutOfBoundsExceptionをスロー
   * @return uのi番目のビット値
   */
  static int get(long u, int i) {
    return ((u & BIT_MASK[i]) == 0) ? 0 : 1;
  }

  /**
   * uのi番目のビットを1にした値を返す
   *
   * @param u
   * @param i
   *          負の値や64以上の場合はIndexOutOfBoundsExceptionをスロー
   * @return uのi番目のビットを1にした値
   */
  static long set(long u, int i) {
    return u | BIT_MASK[i];
  }

  /**
   * popcountを計算する。　
   *
   * @param x
   *          計算対象の整数値
   * @return xのビットのうち１がとなっている個数
   */
  static int popCount(long x) {
    return UINT32.popCount((int) x) + UINT32.popCount((int) (x >>> 32));
  }

  /**
   * uのi番目までのビットで1となっている数（iを含まない）を取得する
   *
   * @param u
   *          　対象となる整数値
   * @param i
   *          インデックス。負や64以上の場合はIndexOutOfBoundsExceptionをスローする。
   * @return　i番目までのビットで1となっている数
   */
  static int rank1(long u, int i) {
    return popCount(POP_COUNT_MASK[i] & u);
  }

  /**
   * uのi番目までのビットで0となっている数（iを含まない）を取得する
   *
   * @param u
   *          　対象となる整数値
   * @param i
   *          インデックス。負や64以上の場合はIndexOutOfBoundsExceptionをスローする。
   * @return　i番目までのビットで0となっている数
   */
  static int rank0(long u, int i) {
    return i - rank1(u, i);
  }

  /**
   * uの先頭からj個目の1がたっているビットの位置を返す。
   *
   * @param u
   *          　対象となる整数値
   * @param j
   * @return　uの先頭からj個目の1がたっているビットの位置。jが0以下やj個の1が存在しない場合は-1
   */
  static int select1(long u, int j) {
    if (j < 1 || j > 64)
      return -1;

    long b0 = (0xFFFFFFFF00000000L & u) >>> 32;

    int pc0 = popCount(b0);
    if (j <= pc0) {
      return UINT32.select1((int)b0, j);
    } else {
      long b1 = 0x00000000FFFFFFFFL & u;
      int pc1 = pc0 + popCount(b1);
      if (j > pc1)
        return -1 ;
      int s = UINT32.select1((int)b1, j - pc0);
      return (s < 0) ? s : 32 + s;
    }
  }

  /**
   * uの先頭からj個目の0がたっているビットの位置を返す。
   *
   * @param u
   *          　対象となる整数値
   * @param j
   * @return　uの先頭からj個目の0がたっているビットの位置。jが0以下やj個の0が存在しない場合は-1
   */
  static int select0(long u, int j) {
    if (j < 1 || j > 64)
      return -1;

    long b0 = (0xFFFFFFFF00000000L & u) >> 32;

    int pc0 = 32 - popCount(b0);
    if (j <= pc0) {
      return UINT32.select0((int)b0, j);
    } else {
      long b1 = 0x00000000FFFFFFFFL & u;
      int pc1 = pc0 + (32 - popCount(b1));
      if (j > pc1)
        return -1 ;
      int s = UINT32.select0((int)b1, j - pc0);
      return (s < 0) ? s : 32 + s;
    }
  }

}
