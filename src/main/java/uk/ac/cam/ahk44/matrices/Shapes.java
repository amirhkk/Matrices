/*
 * Copyright 2021 Andrew Rice <acr31@cam.ac.uk>, Amir Kadkhodaei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.ahk44.matrices;

/** A static class for constructing matrices with 2d shapes. */
class Shapes {

  /**
   * Create a new 2x2 matrix which applies a rotation
   *
   * @param degrees to rotate by
   * @return a 2x2 matrix
   */
  static Matrix rotation2d(double degrees) {
    double[][] data = new double[2][2];
    data[0][0] = Math.cos(Math.toRadians(degrees));
    data[1][1] = Math.cos(Math.toRadians(degrees));
    data[0][1] = - Math.sin(Math.toRadians(degrees));
    data[1][0] = Math.sin(Math.toRadians(degrees));

    return new Matrix(data);
  }

  /** Create a new identity matrix with the specified size. */
  static Matrix identity(int size) {
    double[][] data = new double[size][size];
    for (int i = 0; i < size; i++) {
      data[i][i] = 1;
    }
    return new Matrix(data);
  }

  /**
   * Create a new matrix representing the points on the perimeter of a square centred on (0,0).
   *
   * @param size the length of half an edge i.e. the square will run from -size to size
   * @return a matrix of height 2 with each column representing a point on the square
   */
  static Matrix square(int size) {
    double[][] data = new double[2][8*size];
    int j = 0;
    for (int i = -size; i < size; i++, j++) {
      data[0][j] = i;
      data[1][j] = size;
    }
    for (int i = size; i > -size; i--, j++) {
      data[0][j] = size;
      data[1][j] = i;
    }
    for (int i = size; i > -size; i--, j++) {
      data[0][j] = i;
      data[1][j] = -size;
    }
    for (int i = -size; i < size; i++, j++) {
      data[0][j] = -size;
      data[1][j] = i;
    }
    return new Matrix(data);
  }

  // No instances
  private Shapes() {}
}
