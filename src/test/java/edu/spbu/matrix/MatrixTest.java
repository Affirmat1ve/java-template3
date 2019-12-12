package edu.spbu.matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {
  /**
   * ожидается 4 таких теста
   */
  @Test
  public void mulDD() {
    Matrix m1 = new DenseMatrix("dm1.txt");
    Matrix m2 = new DenseMatrix("dm2.txt");
    Matrix expected = new DenseMatrix("dxd12.txt");
    Matrix actual = m1.mul(m2);
    System.out.println("expected:" + (expected).toString());
    System.out.println("actual:" + ((DenseMatrix) actual).toString());
    assertEquals(expected, actual);
  }


  @Test //small sparse
  public void mulSSEx1() {
    Matrix m1 = new SparseMatrix("sm1.txt");
    Matrix m2 = new SparseMatrix("sm2.txt");
    Matrix actual = m1.mul(m2);
    Matrix expected = new SparseMatrix("sxs12.txt");
    System.out.println("expected:" + (expected).toString());
    System.out.println("actual:" + ((SparseMatrix) actual).toString());
    assertEquals(expected, actual);
  }


  //Тест умножения плотной матрицы на разреженную
  @Test
  public void mulDSEx1() {
    Matrix m1 = new DenseMatrix("dm3.txt");
    Matrix m2 = new SparseMatrix("sm4.txt");
    Matrix actual = m1.mul(m2);
    Matrix expected = new DenseMatrix("dxs34.txt");
    System.out.println("expected:" + (expected).toString());
    System.out.println("actual:" + ((DenseMatrix) actual).toString());
    assertEquals(expected, m1.mul(m2));
  }

  @Test  //Тест умножения разреженной матрицы и плотной
  public void mulSDEx1() {
    Matrix m1 = new SparseMatrix("sm3.txt");
    Matrix m2 = new DenseMatrix("dm4.txt");
    Matrix actual = m1.mul(m2);
    Matrix expected = new DenseMatrix("sxd34.txt");
    System.out.println("expected:" + (expected).toString());
    System.out.println("actual:" + ((DenseMatrix) actual).toString());
    assertEquals(expected, actual);
  }


  @Test
  public void dmulDD() {
    Matrix m1 = new DenseMatrix("dm1.txt");
    Matrix m2 = new DenseMatrix("dm2.txt");
    Matrix expected = new DenseMatrix("dxd12.txt");
    Matrix actual = m1.dmul(m2);
    System.out.println("expected:" + ((DenseMatrix) expected).toString());
    System.out.println("actual:" + ((DenseMatrix) actual).toString());
    assertEquals(expected, actual);
  }

  @Test //small sparse
  public void dmulSSEx1() {
    Matrix m1 = new SparseMatrix("sm1.txt");
    Matrix m2 = new SparseMatrix("sm2.txt");
    Matrix actual = m1.dmul(m2);
    Matrix expected = new SparseMatrix("sxs12.txt");
    System.out.println("expected:" + (expected).toString());
    System.out.println("actual:" + ((SparseMatrix) actual).toString());
    assertEquals(expected, actual);
  }
/*
  @Test
  public void DDstack(){
    Matrix m1 = new DenseMatrix("m4.txt");
    Matrix m2 = new DenseMatrix("m5.txt");
    Matrix actual = MatrixStacker.vstack(m1, m2);
    System.out.println("actual:" + ((DenseMatrix) actual).toString());
  }
*/

  //Тест умножения плотной матрицы на разреженную
  @Test
  public void dmulDSEx1() {
    Matrix m1 = new DenseMatrix("dm3.txt");
    Matrix m2 = new SparseMatrix("sm4.txt");
    Matrix actual = m1.dmul(m2);
    Matrix expected = new DenseMatrix("dxs34.txt");
    System.out.println("expected:" + (expected).toString());
    System.out.println("actual:" + ((DenseMatrix) actual).toString());
    assertEquals(expected, m1.mul(m2));
  }
}
/*
  @Test //сколько по времени умножается 2000x2000
  public void dMultyMulSS() {
    Matrix m1 = new SparseMatrix("sparse1.txt");
    Matrix m2 = new SparseMatrix("sparse2.txt");

    long start = System.currentTimeMillis();
    m1.dmul(m2);
    long finish = System.currentTimeMillis();
    System.out.println(finish - start);
  }
}
*/