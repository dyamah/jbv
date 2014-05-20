package com.github.dyamah.jbv.impl;

import java.util.Arrays;

class BitVectorImpl {

  /** 基本単位 */
  private static final int     UNIT             = 64;

  /** ビットマスク */
  static private final long[]  BIT_MASK64       = { 0x8000000000000000L, 0x4000000000000000L, 0x2000000000000000L, 0x1000000000000000L, 0x0800000000000000L,
      0x0400000000000000L, 0x0200000000000000L, 0x0100000000000000L, 0x0080000000000000L, 0x0040000000000000L, 0x0020000000000000L, 0x0010000000000000L,
      0x0008000000000000L, 0x0004000000000000L, 0x0002000000000000L, 0x0001000000000000L, 0x0000800000000000L, 0x0000400000000000L, 0x0000200000000000L,
      0x0000100000000000L, 0x0000080000000000L, 0x0000040000000000L, 0x0000020000000000L, 0x0000010000000000L, 0x0000008000000000L, 0x0000004000000000L,
      0x0000002000000000L, 0x0000001000000000L, 0x0000000800000000L, 0x0000000400000000L, 0x0000000200000000L, 0x0000000100000000L, 0x0000000080000000L,
      0x0000000040000000L, 0x0000000020000000L, 0x0000000010000000L, 0x0000000008000000L, 0x0000000004000000L, 0x0000000002000000L, 0x0000000001000000L,
      0x0000000000800000L, 0x0000000000400000L, 0x0000000000200000L, 0x0000000000100000L, 0x0000000000080000L, 0x0000000000040000L, 0x0000000000020000L,
      0x0000000000010000L, 0x0000000000008000L, 0x0000000000004000L, 0x0000000000002000L, 0x0000000000001000L, 0x0000000000000800L, 0x0000000000000400L,
      0x0000000000000200L, 0x0000000000000100L, 0x0000000000000080L, 0x0000000000000040L, 0x0000000000000020L, 0x0000000000000010L, 0x0000000000000008L,
      0x0000000000000004L, 0x0000000000000002L, 0x0000000000000001L };

  private static int[]         BIT_MASK16       = { 0x8000, 0x4000, 0x2000, 0x1000, 0x0800, 0x0400, 0x0200, 0x0100, 0x0080, 0x0040, 0x0020, 0x0010, 0x0008,
      0x0004, 0x0002, 0x0001                   };

  /**
   * int 8bit用のビットマスク
   */
  private static int[]         BIT_MASK8        = { 0x80, 0x40, 0x20, 0x10, 0x08, 0x04, 0x02, 0x01 };

  /** 64bitポップカウント用のビットマスク */
  static private final long[]  POP_COUNT_MASK64 = { 0x0000000000000000L, 0x8000000000000000L, 0xC000000000000000L, 0xE000000000000000L, 0xF000000000000000L,
      0xF800000000000000L, 0xFC00000000000000L, 0xFE00000000000000L, 0xFF00000000000000L, 0xFF80000000000000L, 0xFFC0000000000000L, 0xFFE0000000000000L,
      0xFFF0000000000000L, 0xFFF8000000000000L, 0xFFFC000000000000L, 0xFFFE000000000000L, 0xFFFF000000000000L, 0xFFFF800000000000L, 0xFFFFC00000000000L,
      0xFFFFE00000000000L, 0xFFFFF00000000000L, 0xFFFFF80000000000L, 0xFFFFFC0000000000L, 0xFFFFFE0000000000L, 0xFFFFFF0000000000L, 0xFFFFFF8000000000L,
      0xFFFFFFC000000000L, 0xFFFFFFE000000000L, 0xFFFFFFF000000000L, 0xFFFFFFF800000000L, 0xFFFFFFFC00000000L, 0xFFFFFFFE00000000L, 0xFFFFFFFF00000000L,
      0xFFFFFFFF80000000L, 0xFFFFFFFFC0000000L, 0xFFFFFFFFE0000000L, 0xFFFFFFFFF0000000L, 0xFFFFFFFFF8000000L, 0xFFFFFFFFFC000000L, 0xFFFFFFFFFE000000L,
      0xFFFFFFFFFF000000L, 0xFFFFFFFFFF800000L, 0xFFFFFFFFFFC00000L, 0xFFFFFFFFFFE00000L, 0xFFFFFFFFFFF00000L, 0xFFFFFFFFFFF80000L, 0xFFFFFFFFFFFC0000L,
      0xFFFFFFFFFFFE0000L, 0xFFFFFFFFFFFF0000L, 0xFFFFFFFFFFFF8000L, 0xFFFFFFFFFFFFC000L, 0xFFFFFFFFFFFFE000L, 0xFFFFFFFFFFFFF000L, 0xFFFFFFFFFFFFF800L,
      0xFFFFFFFFFFFFFC00L, 0xFFFFFFFFFFFFFE00L, 0xFFFFFFFFFFFFFF00L, 0xFFFFFFFFFFFFFF80L, 0xFFFFFFFFFFFFFFC0L, 0xFFFFFFFFFFFFFFE0L, 0xFFFFFFFFFFFFFFF0L,
      0xFFFFFFFFFFFFFFF8L, 0xFFFFFFFFFFFFFFFCL, 0xFFFFFFFFFFFFFFFEL };

  /** 16bit用ポップカウントテーブル */
  static private final int[]   POP_COUNT_TABLE16;
  static {
    POP_COUNT_TABLE16 = new int[65536];
    for (int n = 0; n < POP_COUNT_TABLE16.length; n++) {
      int popcount = 0;
      for (int i = 0; i < 16; i++) {
        if ((n & BIT_MASK16[i]) == 0)
          continue;
        popcount++;
      }
      POP_COUNT_TABLE16[n] = popcount;
    }
  }

  /** 8it用ポップカウントテーブル */
  static private final int[]   POP_COUNT_TABLE8;
  static {
    POP_COUNT_TABLE8 = new int[256];
    for (int n = 0; n < POP_COUNT_TABLE8.length; n++) {
      int popcount = 0;
      for (int i = 0; i < 8; i++) {
        if ((n & BIT_MASK8[i]) == 0)
          continue;
        popcount++;
      }
      POP_COUNT_TABLE8[n] = popcount;
    }
  }

  /**
   * select1用の8bitテーブル
   */
  private static final int[][] SELECT1_TABLE;
  static {
    SELECT1_TABLE = new int[256][8];
    for (int i = 0; i < 256; i++) {
      SELECT1_TABLE[i] = new int[8];
      for (int k = 0; k < 8; k++)
        SELECT1_TABLE[i][k] = -1;

      int m = 0;
      for (int j = 0; j < BIT_MASK8.length; j++) {
        if ((BIT_MASK8[j] & i) != 0) {
          SELECT1_TABLE[i][m] = j;
          m++;
        }
      }
    }
  }

  /**
   * xのポップカウントを求める
   *
   * @param x
   *          入力値
   * @return ポップカウント（ビットが立っている個数）
   */
  static final int popCount(long x) {
    int popcount = POP_COUNT_TABLE16[(int) (x & 0xffff)];
    x = x >>> 16;
    popcount += POP_COUNT_TABLE16[(int) (x & 0xffff)];
    x = x >>> 16;
    popcount += POP_COUNT_TABLE16[(int) (x & 0xffff)];
    x = x >>> 16;
    popcount += POP_COUNT_TABLE16[(int) (x & 0xffff)];
    return popcount;
  }

  // ---------------------------------------------------

  /** デフォルトのキャパシティ */
  static final int         DEFAULT_CAPACITY = 1024;

  /** インデックス用ビットブロック */
  private long[]           bits_;

  /**
   * rank用索引
   */
  private long[]           rank_;

  /**
   * select用索引
   */
  private long[]           select_;

  /** １スモールブロックのビットサイズ */
  private static final int SB_SIZE          = 64;

  /** 1ラージブロックのビットサイズ */
  private static final int LB_SIZE          = 256;

  private static long      OFFSET_MASK      = 0xFFFFFFFF00000000L;
  private static long[]    SB_MASK          = { 0x00000000FF000000L, 0x0000000000FF0000L, 0x000000000000FF00L, 0x000000000000FF00L };

  /** 1の総数 */
  private int              one_;

  /**
   * デフォルトのキャパシティで初期化する。
   */
  public BitVectorImpl() {
    bits_ = new long[DEFAULT_CAPACITY / UNIT + 1];
    rank_ = new long[DEFAULT_CAPACITY / LB_SIZE + 1];
    select_ = new long[DEFAULT_CAPACITY / LB_SIZE + 1];
    initSelect(1);
    one_ = 0;
  }

  /**
   * 指定したキャパシティで初期化する。デフォルトのキャパシティより小さい場合はデフォルトキャパシティで初期化する
   *
   * @param capacity
   *          キャパシティ
   */
  public BitVectorImpl(int capacity) {
    bits_ = new long[capacity / UNIT + 1];
    rank_ = new long[capacity / LB_SIZE + 1];
    select_ = new long[capacity / LB_SIZE + 1];
    initSelect(1);
    one_ = 0;
  }

  /**
   * i番目のビットを返す
   *
   * @param i
   *          インデックス
   * @return　i番目のビット。iが負の場合は0を返す
   */
  public final int get(int i) {
    if (i < 0)
      return 0;
    int x = i / UNIT;
    int y = i % UNIT;
    if (x >= bits_.length)
      return 0;
    return ((bits_[x] & BIT_MASK64[y]) != 0) ? 1 : 0;
  }

  /**
   * i番目のビットを1にして、rank(i)を返す。
   *
   * @param i
   *          インデックス。負の場合はIllegalArgumentExceptionをスロー
   * @return i番目のビットを１にした後のrank(i)を返す
   */
  public final int set(int i) {
    if (i < 0)
      throw new IllegalArgumentException("The index is negative.");
    resize(i);

    int x = i / UNIT;
    int y = i % UNIT;

    long m = bits_[x];
    if ((m & BIT_MASK64[y]) == 0) {

      // updates lbs_
      bits_[x] |= BIT_MASK64[y];
      updatesRank(i);
      one_++;

      // updates select_
      int r1 = rank1(i);
      if ((r1 + 1) % LB_SIZE == 0)
        select_[(r1 + 1) / LB_SIZE] = ((select_[(r1 + 1) / LB_SIZE] & 0xFFFFFFFF00000000L) | (long) i);

      int r0 = i - r1;
      if ((r0 + 1) % LB_SIZE == 0) {
        select_[(r0 + 1) / LB_SIZE] = (select_[(r0 + 1) / LB_SIZE] & 0x00000000FFFFFFFFL) | ((long) i << 32);
      }
      return r1;
    }
    return rank1(i);
  }

  /**
   * i番目まで(iは含まない)に出現する1の個数
   *
   * @param i
   *          0未満の場合、IllegalArgumentExceptionをスロー
   * @return i番目までに出現する1の個数
   */
  int rank1(int i) {
    if (i < 0)
      throw new IllegalArgumentException("The index is negative.");
    if (i == 0)
      return 0;
    int k = i / LB_SIZE;
    if (k >= rank_.length)
      return one_;

    int rank = offset(k);

    int y = (i % LB_SIZE) / SB_SIZE;

    long sb = rank_[k];
    if (y == 1)
      rank += (int) ((sb & SB_MASK[0]) >>> 24);

    if (y == 2)
      rank += (int) ((sb & SB_MASK[1]) >>> 16);

    if (y == 3)
      rank += (int) ((sb & SB_MASK[2]) >>> 8);

    if ((i / UNIT) >= bits_.length)
      return rank;

    return rank + popCount(bits_[i / UNIT] & POP_COUNT_MASK64[i % UNIT]);
  }

  int rank0(int i) {
    if (i < 0)
      throw new IllegalArgumentException("The index is negative.");
    if (i == 0)
      return 0;
    return i - rank1(i);
  }

  /**
   * j番目の1が出現するインデックスを返す
   *
   * @param j
   *          jが1未満はIllegalArgumentExceptionをスロー
   * @return j番目の1が出現するインデックス。存在しない場合は-1
   */
  int select1(int j) {
    if (j < 1)
      throw new IllegalArgumentException("The argument is less than 1.");
    if (one_ < j)
      return -1;
    int k = (j - 1) / LB_SIZE;
    if (k >= rank_.length)
      return -1;

    int p = j / LB_SIZE;
    if (j % LB_SIZE == 0)
      return select1Index(p);

    int b = select1Index(p) / LB_SIZE;
    int e = select1Index(p+1) / LB_SIZE;
    int m = 0;

    // LB(256bit)毎の二分探索
    while (e - b > 1) {
      m = (b + e) / 2;
      int r = offset(m);
      if (r < j) {
        b = m;
      } else {
        e = m;
      }
    }
    m = b;
    if (offset(e) < j)
      m = e;

    // LB内のSBを二分探索
    long lb = rank_[m];

    int s = offset(m);
    int sb0 = (int) ((lb & SB_MASK[0]) >>> 24);
    int sb1 = (int) ((lb & SB_MASK[1]) >>> 16);
    int sb2 = (int) ((lb & SB_MASK[2]) >>> 8);

    if (j <= s + sb1) {
      if (j <= s + sb0) {
        int i = m * LB_SIZE;
        return i + select1Long64(bits_[i / UNIT], j - s);
      } else {
        int i = m * LB_SIZE + SB_SIZE;
        return i + select1Long64(bits_[i / UNIT], j - s - sb0);
      }
    } else {
      if (j <= s + sb2) {
        int i = m * LB_SIZE + SB_SIZE * 2;
        return i + select1Long64(bits_[i / UNIT], j - s - sb1);
      } else {
        int i = m * LB_SIZE + SB_SIZE * 3;
        return i + select1Long64(bits_[i / UNIT], j - s - sb2);
      }
    }
  }

  private int select1Long64(long bit, int k) {
    // 64bit内でのselect1を求める
    assert (k > 0);
    assert (k <= 64);
    int n0 = (int) ((bit & 0xFFFF000000000000L) >>> 48);
    int n1 = (int) ((bit & 0x0000FFFF00000000L) >>> 32);
    int pc0 = POP_COUNT_TABLE16[n0];
    int pc1 = POP_COUNT_TABLE16[n1];

    if (k <= pc0 + pc1) {
      if (k <= pc0) {
        return select1Int16(n0, k);
      } else {
        return 16 + select1Int16(n1, k - pc0);
      }
    } else {
      int n2 = (int) ((bit & 0x00000000FFFF0000L) >>> 16);
      int n3 = (int) ((bit & 0x000000000000FFFFL));
      int pc2 = POP_COUNT_TABLE16[n2];
      if (k <= pc0 + pc1 + pc2) {
        return 32 + select1Int16(n2, k - pc0 - pc1);
      } else {
        return 48 + select1Int16(n3, k - pc0 - pc1 - pc2);
      }
    }
  }

  private int select1Int16(int bit, int k) {
    // 16bit内でのselect1を求める
    assert (k <= 16);
    assert (k > 0);
    int h = (bit & 0xFF00) >>> 8;
    int hp = POP_COUNT_TABLE8[h];
    if (k <= hp)
      return SELECT1_TABLE[h][k - 1];
    int l = bit & 0x00FF;
    return 8 + SELECT1_TABLE[l][k - hp - 1];
  }

  private void initSelect(int begin) {
    int m = select_.length;
    long v = ((long) -1 << 32) | -1;
    for (int i = begin; i < m; i++)
      select_[i] = v;
  }

  private int offset(int k) {
    return (int) ((rank_[k] & OFFSET_MASK) >>> 32);
  }

  private void resize(int i) {
    int s = i / UNIT;
    if (s >= bits_.length)
      bits_ = Arrays.copyOf(bits_, s + 1);

    int m = i / LB_SIZE;
    if (m >= rank_.length) {
      s = rank_.length;
      long n = (long) one_ << 32;
      rank_ = Arrays.copyOf(rank_, m + 1);
      for (int k = s; k < rank_.length; k++)
        rank_[k] = n;
    }
    if (m >= select_.length - 1) {
      s = select_.length;
      select_ = Arrays.copyOf(select_, m + 2);
      initSelect(s);
    }
  }

  private void updatesRank(int i) {
    int k = i / LB_SIZE;
    for (int j = k + 1; j < rank_.length; j++) {
      rank_[j] = rank_[j] + 0x0000000100000000L;
    }

    int y = (i % LB_SIZE) / SB_SIZE;

    if (y == 0) {
      rank_[k] = rank_[k] + 0x0000000001010100L;
    } else if (y == 1) {
      rank_[k] = rank_[k] + 0x0000000000010100L;
    } else if (y == 2) {
      rank_[k] = rank_[k] + 0x0000000000000100L;
    }
  }

  private int select1Index(int k) {
    int i = (int) (select_[k] & 0x00000000FFFFFFFFL);
    if (i < 0)
      return bits_.length * UNIT - 1;
    return i;
  }
}
