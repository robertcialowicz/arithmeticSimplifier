package org;

import lombok.val;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PolynomialSumTest {

    @Nested
    class Plus {

        @Test
        void itShouldAddNotContainedPolynomial() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When "3c" is added
            val actual = sum.plus(new Polynomial(3, 'c'));

            // Then "2a + 2b + 3c" is returned
            val expected = new PolynomialSum(new Polynomial(2, 'a'),
                                             new Polynomial(2, 'b'),
                                             new Polynomial(3, 'c'));

            assertAll(
                    () -> assertThat(extractCoefficients(actual)).isEqualTo(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }

        @Test
        void itShouldAddContainedPolynomial() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When "3a" is added
            val actual = sum.plus(new Polynomial(3, 'a'));

            // Then "5a + 2b" is returned
            val expected = new PolynomialSum(new Polynomial(5, 'a'),
                                             new Polynomial(2, 'b'));

            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }

        @Test
        void itShouldAddNotContainedPolynomialSum() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When "2c - 2d" is added
            val actual = sum.plus(new PolynomialSum(new Polynomial(2, 'c'),
                                                    new Polynomial(-2, 'd')));

            // Then "2a + 2b + 2c - 2d" is returned
            val expected = new PolynomialSum(new Polynomial(2, 'a'),
                                             new Polynomial(2, 'b'),
                                             new Polynomial(2, 'c'),
                                             new Polynomial(-2, 'd'));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }

        @Test
        void itShouldAddContainedPolynomialSum() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When "3a + b" is added
            val actual = sum.plus(new PolynomialSum(new Polynomial(3, 'a'), new Polynomial(1, 'b')));

            // Then "5a + 3b" is returned
            val expected = new PolynomialSum(new Polynomial(5, 'a'),
                                             new Polynomial(3, 'b'));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }
    }

    @Nested
    class Minus {

        @Test
        void itShouldSubtractNotContainedPolynomial() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When "3c" is subtracted
            val actual = sum.minus(new Polynomial(3, 'c'));

            // Then "2a + 2b - 3c" is returned
            val expected = new PolynomialSum(new Polynomial(2, 'a'),
                                             new Polynomial(2, 'b'),
                                             new Polynomial(-3, 'c'));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }

        @Test
        void itShouldSubtractContainedPolynomial() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When "3a" is subtracted
            val actual = sum.minus(new Polynomial(3, 'a'));

            // Then "-a + 2b" is returned
            val expected = new PolynomialSum(new Polynomial(-1, 'a'),
                                             new Polynomial(2, 'b'));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }

        @Test
        void itShouldSubtractNotContainedPolynomialSum() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When "2c - 2d" is subtracted
            val actual = sum.minus(new PolynomialSum(new Polynomial(2, 'c'),
                                                     new Polynomial(-2, 'd')));

            // Then "2a + 2b - 2c + 2d" is returned
            val expected = new PolynomialSum(new Polynomial(2, 'a'),
                                             new Polynomial(2, 'b'),
                                             new Polynomial(-2, 'c'),
                                             new Polynomial(2, 'd'));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }

        @Test
        void itShouldSubtractContainedPolynomialSum() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When "3a + b" is subtracted
            val actual = sum.minus(new PolynomialSum(new Polynomial(3, 'a'), new Polynomial(1, 'b')));

            // Then "-a + b" is returned
            val expected = new PolynomialSum(new Polynomial(-1, 'a'),
                                             new Polynomial(1, 'b'));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }
    }

    @Nested
    class Multiply {

        @Test
        void itShouldMultiplyByPolynomial() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When it is multiplied by "3a"
            val actual = sum.multiply(new Polynomial(3, 'a'));

            // Then "6a^2 + 6ab" is returned
            val expected = new PolynomialSum(new Polynomial(6, new Intermediate('a', 2)),
                                             new Polynomial(6, Set.of(new Intermediate('a'), new Intermediate('b'))));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }

        @Test
        void itShouldMultiplyByNotContainedPolynomialSum() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When it is multiplied by "2c - 2d"
            val actual = sum.multiply(new PolynomialSum(new Polynomial(2, 'c'),
                                                        new Polynomial(-2, 'd')));

            // Then "4ac - 4ad + 4bc - 4bd" is returned
            val expected = new PolynomialSum(new Polynomial(4, Set.of(new Intermediate('a'), new Intermediate('c'))),
                                             new Polynomial(-4, Set.of(new Intermediate('a'), new Intermediate('d'))),
                                             new Polynomial(4, Set.of(new Intermediate('b'), new Intermediate('c'))),
                                             new Polynomial(-4, Set.of(new Intermediate('b'), new Intermediate('d'))));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }

        @Test
        void itShouldMultiplyByContainedPolynomialSum() {
            // Given a PolynomialSum of "2a + 2b"
            val sum = new PolynomialSum(new Polynomial(2, 'a'),
                                        new Polynomial(2, 'b'));

            // When it is multiplied by "a + 2b"
            val actual = sum.multiply(new PolynomialSum(new Polynomial(1, 'a'), new Polynomial(2, 'b')));

            // Then "2a^2 + 6ab + 4b^2" is returned
            val expected = new PolynomialSum(new Polynomial(2, new Intermediate('a', 2)),
                                             new Polynomial(6, Set.of(new Intermediate('a'), new Intermediate('b'))),
                                             new Polynomial(4, new Intermediate('b', 2)));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }
    }

    @Nested
    class Divide {

        @Test
        void itShouldDivideByPolynomial() {
            // Given a PolynomialSum of "2a^2 + 2a^3b"
            val sum = new PolynomialSum(new Polynomial(2, new Intermediate('a', 2)),
                                        new Polynomial(2, Set.of(new Intermediate('a', 3), new Intermediate('b'))));

            // When it is divided by "2a^2"
            val actual = sum.divide(new Polynomial(2, new Intermediate('a', 2)));

            // Then "1 + ab" is returned
            val expected = new PolynomialSum(new Polynomial(1),
                                             new Polynomial(1, Set.of(new Intermediate('a'), new Intermediate('b'))));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }

        @Test
        void itShouldDivideByNotContainedPolynomialSum() {
            // Given a PolynomialSum of "4a + 2b"
            val sum = new PolynomialSum(new Polynomial(4, 'a'),
                                        new Polynomial(2, 'b'));

            // When it is divided by "2c - 2d"
            val actual = sum.divide(new PolynomialSum(new Polynomial(2, 'c'),
                                                      new Polynomial(-2, 'd')));

            // Then "2a/c - 2a/d + b/c - b/d" is returned
            val expected = new PolynomialSum(new Polynomial(2,
                                                            Set.of(new Intermediate('a'), new Intermediate('c', -1))),
                                             new Polynomial(-2,
                                                            Set.of(new Intermediate('a'), new Intermediate('d', -1))),
                                             new Polynomial(1,
                                                            Set.of(new Intermediate('b'), new Intermediate('c', -1))),
                                             new Polynomial(-1,
                                                            Set.of(new Intermediate('b'), new Intermediate('d', -1))));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }

        @Test
        void itShouldDivideByContainedPolynomialSum() {
            // Given a PolynomialSum of "4a^2 + 2b"
            val sum = new PolynomialSum(new Polynomial(4, new Intermediate('a', 2)),
                                        new Polynomial(2, 'b'));

            // When it is divided by "2a + b"
            val actual = sum.divide(new PolynomialSum(new Polynomial(2, 'a'), new Polynomial(1, 'b')));

            // Then "2a + 4a^2/b + b/a + 2" is returned
            val expected = new PolynomialSum(new Polynomial(2, 'a'),
                                             new Polynomial(4,
                                                            Set.of(new Intermediate('a', 2),
                                                                   new Intermediate('b', -1))),
                                             new Polynomial(1,
                                                            Set.of(new Intermediate('b'), new Intermediate('a', -1))),
                                             new Polynomial(2));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }
    }

    @Nested
    class Power {

        @Test
        void itShouldRaiseToPower() {
            // Given a PolynomialSum of "2a^2 + 2a^3b"
            val sum = new PolynomialSum(new Polynomial(2, new Intermediate('a', 2)),
                                        new Polynomial(2, Set.of(new Intermediate('a', 3), new Intermediate('b'))));

            // When it is raised to power 2
            val actual = sum.power(2);

            // Then "4a^4 + 8a^5b + 4a^6b^2" is returned
            val expected = new PolynomialSum(new Polynomial(4, new Intermediate('a', 4)),
                                             new Polynomial(8, Set.of(new Intermediate('a', 5), new Intermediate('b'))),
                                             new Polynomial(4,
                                                            Set.of(new Intermediate('a', 6),
                                                                   new Intermediate('b', 2))));
            assertAll(
                    () -> assertThat(extractCoefficients(actual)).hasSameElementsAs(extractCoefficients(expected)),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }
    }

    private static List<Double> extractCoefficients(Set<Polynomial> polynomials) {
        return polynomials.stream()
                .map(Polynomial::getCoefficient)
                .collect(Collectors.toList());
    }

    private static List<Double> extractCoefficients(PolynomialSum sum) {
        return extractCoefficients(sum.getPolynomials());
    }
}
