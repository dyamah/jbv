package com.github.dyamah.jbv;

/**
 * 簡潔データ構造を用いたベクター
 *
 * @author Hiroyasu Yamada
 *
 * @param <E>
 *          要素の型
 */
public interface BitVector<E> {

  /**
   * i番目の要素を返す.
   *
   * @param i
   *          インデックス
   * @return i番目の要素。範囲外や要素が設定されていない場合はnullを返す
   */
  E get(int i);

  /**
   * i番目に要素を設定する。
   *
   * @param i
   *          インデックス。負の数は IllegalArgumentExceptionをスロー
   * @param element
   *          設定する要素 nullは IllegalArgumentExceptionをスロー
   */
  void set(int i, E element);

  /**
   * 設定した要素数を返す。
   *
   * @return 設定された要素数
   */
  int size();

}
