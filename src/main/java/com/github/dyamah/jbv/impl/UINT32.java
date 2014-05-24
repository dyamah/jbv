package com.github.dyamah.jbv.impl;

import com.github.dyamah.jbv.UINT;

public final class UINT32 implements UINT {
  static final int             SIZE     = 32;

  static private final int[]   BIT_MASK;
  static {
    BIT_MASK = new int[32];
    for (int i = 0; i < 32; i++)
      BIT_MASK[i] = 0x80000000 >>> i;
  }

  private static final int[]   POP_COUNT_MASK;
  static {
    POP_COUNT_MASK = new int[32];
    POP_COUNT_MASK[0] = 0;
    for (int i = 1; i < 32; i++)
      POP_COUNT_MASK[i] = 0x80000000 >> (i - 1);
  }

  /** the table for popcount */
  static private final int[]   POP_COUNT_TABLE;
  static {
    POP_COUNT_TABLE = new int[65536];
    for (int n = 0; n < POP_COUNT_TABLE.length; n++) {
      int popcount = 0;
      for (int i = 0; i < 16; i++) {
        if ((n & BIT_MASK[i + 16]) == 0)
          continue;
        popcount++;
      }
      POP_COUNT_TABLE[n] = popcount;
    }
  }

  private static final int[][] SELECT1_TABLE;
  static {
    SELECT1_TABLE = new int[256][9];
    for (int i = 0; i < 256; i++) {
      SELECT1_TABLE[i] = new int[9];
      for (int k = 0; k < 9; k++)
        SELECT1_TABLE[i][k] = -1;

      int m = 1;
      for (int j = 1; j <= 8; j++) {
        if ((BIT_MASK[23 + j] & i) != 0) {
          SELECT1_TABLE[i][m] = j - 1;
          m++;
        }
      }
    }
  }

  private static final int[][] SELECT0_TABLE;
  static {
    SELECT0_TABLE = new int[256][9];
    for (int i = 0; i < 256; i++) {
      SELECT0_TABLE[i] = new int[9];
      for (int k = 0; k < 9; k++)
        SELECT0_TABLE[i][k] = -1;

      int m = 1;
      for (int j = 1; j <= 8; j++) {
        if ((BIT_MASK[23 + j] & i) == 0) {
          SELECT0_TABLE[i][m] = j - 1;
          m++;
        }
      }
    }
  }

  private UINT32() {
  }

  /**
   * uのi番目のビット値を返す
   * @param u
   * @param i 負の値や32以上の場合はIndexOutOfBoundsExceptionをスロー
   * @return uのi番目のビット値
   */
  static int get(int u, int i){
    return ((u & BIT_MASK[i]) == 0) ? 0 : 1 ;
  }

  /**
   * uのi番目のビットを1にした値を返す
   * @param u
   * @param i 負の値や32以上の場合はIndexOutOfBoundsExceptionをスロー
   * @return uのi番目のビットを1にした値
   */
  static int set(int u, int i) {
    return u | BIT_MASK[i];
  }

  /**
   * popcountを計算する。　
   *
   * @param x
   *          計算対象の整数値
   * @return xのビットのうち１がとなっている個数
   */
  static int popCount(int x) {
    return POP_COUNT_TABLE[0x0000FFFF & x] + POP_COUNT_TABLE[x >>> 16];
  }

  /**
   * uのi番目までのビットで1となっている数（iを含まない）を取得する
   *
   * @param u
   *          　対象となる整数値
   * @param i
   *          インデックス。負や32以上の場合はIndexOutOfBoundsExceptionをスローする。
   * @return　i番目までのビットで1となっている数
   */
  static int rank1(int u, int i) {
    return popCount(POP_COUNT_MASK[i] & u);
  }

  /**
   * uのi番目までのビットで0となっている数（iを含まない）を取得する
   *
   * @param u
   *          　対象となる整数値
   * @param i
   *          インデックス。負や32以上の場合はIndexOutOfBoundsExceptionをスローする。
   * @return　i番目までのビットで0となっている数
   */
  static int rank0(int u, int i) {
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
  static int select1(int u, int j) {
    if (j < 1 || j > 32)
      return -1;

    int b0 = (0xFF000000 & u) >>> 24;
    int b1 = (0x00FF0000 & u) >>> 16;

    int pc0 = POP_COUNT_TABLE[b0];
    int pc1 = POP_COUNT_TABLE[b1];

    if (j <= pc0 + pc1) {
      if (j <= pc0) {
        return SELECT1_TABLE[b0][j];
      } else {
        int s = SELECT1_TABLE[b1][j - pc0];
        return (s < 0) ? s : 8 + s;
      }
    } else {
      int b2 = (0x0000FF00 & u) >>> 8;
      int b3 = (0x000000FF & u);
      int pc2 = POP_COUNT_TABLE[b2];
      if (j <= pc0 + pc1 + pc2) {
        int s = SELECT1_TABLE[b2][j - pc0 - pc1];
        return (s < 0) ? s : 16 + s;
      } else {
        if (j - pc0 - pc1 - pc2 > 8)
          return -1;
        int s = SELECT1_TABLE[b3][j - pc0 - pc1 - pc2];
        return (s < 0) ? s : 24 + s;
      }
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
  static int select0(int u, int j) {
    if (j < 1 || j > 32)
      return -1;

    int b0 = (0xFF000000 & u) >>> 24;
    int b1 = (0x00FF0000 & u) >>> 16;

    int pc0 = 8 - POP_COUNT_TABLE[b0];
    int pc1 = 8 - POP_COUNT_TABLE[b1];

    if (j <= pc0 + pc1) {
      if (j <= pc0) {
        return SELECT0_TABLE[b0][j];
      } else {
        int s = SELECT0_TABLE[b1][j - pc0];
        return (s < 0) ? s : 8 + s;
      }
    } else {
      int b2 = (0x0000FF00 & u) >>> 8;
      int b3 = (0x000000FF & u);
      int pc2 = 8 - POP_COUNT_TABLE[b2];
      if (j <= pc0 + pc1 + pc2) {
        int s = SELECT0_TABLE[b2][j - pc0 - pc1];
        return (s < 0) ? s : 16 + s;
      } else {
        if (j - pc0 - pc1 - pc2 > 8)
          return -1;
        int s = SELECT0_TABLE[b3][j - pc0 - pc1 - pc2];
        return (s < 0) ? s : 24 + s;
      }
    }
  }
}
