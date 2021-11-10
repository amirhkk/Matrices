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

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MatrixTest {

  @Test
  public void add_producesCorrectAnswer() {
    // ARRANGE
    Matrix a =
        new Matrix(
            new double[][] {
              {1, 2, 3}, //
              {4, 5, 6}
            });
    Matrix b =
        new Matrix(
            new double[][] {
              {7, 8, 9}, //
              {10, 11, 12},
            });
    Matrix d =
        new Matrix(
            new double[][] {
                {2, 3}, //
                {3, 4},
                {4, 5},
            });


    // ACT
    Matrix c = a.add(b);
    Matrix e = a.transpose();
    Matrix f = a.mult(d);
    //System.out.print(f.get(0, 0));

    // ASSERT
    assertThat(c.get(0, 0)).isWithin(1E-7).of(8);
    assertThat(c.get(0, 1)).isWithin(1E-7).of(10);
    assertThat(c.get(0, 2)).isWithin(1E-7).of(12);
    assertThat(c.get(1, 0)).isWithin(1E-7).of(14);
    assertThat(c.get(1, 1)).isWithin(1E-7).of(16);
    assertThat(c.get(1, 2)).isWithin(1E-7).of(18);

    assertThat(e.get(0, 0)).isWithin(1E-7).of(1);
    assertThat(e.get(0, 1)).isWithin(1E-7).of(4);
    assertThat(e.get(1, 0)).isWithin(1E-7).of(2);
    assertThat(e.get(1, 1)).isWithin(1E-7).of(5);
    assertThat(e.get(2, 0)).isWithin(1E-7).of(3);
    assertThat(e.get(2, 1)).isWithin(1E-7).of(6);

    assertThat(f.get(0, 0)).isWithin(1E-7).of(20);
    assertThat(f.get(0, 1)).isWithin(1E-7).of(26);
    assertThat(f.get(1, 0)).isWithin(1E-7).of(47);
    assertThat(f.get(1, 1)).isWithin(1E-7).of(62);
  }
}
