package com.github.dyamah.jbv;

/**
 * 簡潔データ構造ビットベクター
 *
 * @author Hiroyasu Yamada
 */
public interface BitVector {

  /**
   * i番目のビット値を返す.
   *
   * @param i インデックス。負の場合はIndexOutOfBoundsExceptionをスロー
   * @return i番目のビット値
   */
  int get(int i);

  /**
   * i番目のビットを1に設定する。
   *
   * @param j インデックス。負の場合はIndexOutOfBoundsExceptionをスロー
   */
  void set(int i);

  /**
   * このビットベクトル内で１の立っている個数を返す
   * @return １の立っている個数
   */
  int popCount();
}
