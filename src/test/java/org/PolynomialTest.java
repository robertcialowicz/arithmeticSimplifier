package org;

import lombok.val;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.*;

public class PolynomialTest {

    @Nested
    class Plus {

        @Test
        void itShouldAddAnotherPolynomial() {
            // Given two Polynomials "2ab" and "3ab"
            val a = new Polynomial(2, Set.of(new Intermediate('a'), new Intermediate('b')));
            val b = new Polynomial(3, Set.of(new Intermediate('a'), new Intermediate('b')));

            // When they are added
            val actual = a.plus(b);

            // Then a sum is returned
            val expected = new Polynomial(5, Set.of(new Intermediate('a'), new Intermediate('b')));

            assertAll(
                    () -> assertThat(actual.getCoefficient()).isEqualTo(expected.getCoefficient()),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }
    }

    @Nested
    class Minus {

        @Test
        void itShouldSubtractAnotherPolynomial() {
            // Given two Polynomials "5ab" and "2ab"
            val a = new Polynomial(5, Set.of(new Intermediate('a'), new Intermediate('b')));
            val b = new Polynomial(2, Set.of(new Intermediate('a'), new Intermediate('b')));

            // When they are subtracted
            val actual = a.minus(b);

            // Then a difference is returned
            val expected = new Polynomial(3, Set.of(new Intermediate('a'), new Intermediate('b')));

            assertAll(
                    () -> assertThat(actual.getCoefficient()).isEqualTo(expected.getCoefficient()),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }
    }

    @Nested
    class Multiply {

        @Test
        void itShouldMultiply() {
            // Given two Polynomials "5a" and "2ab"
            val a = new Polynomial(5, Set.of(new Intermediate('a')));
            val b = new Polynomial(2, Set.of(new Intermediate('a'), new Intermediate('b')));

            // When they are multiplied
            val actual = a.multiply(b);

            // Then a product is returned
            val expected = new Polynomial(10, Set.of(new Intermediate('a', 2), new Intermediate('b')));

            assertAll(
                    () -> assertThat(actual.getCoefficient()).isEqualTo(expected.getCoefficient()),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }
    }

    @Nested
    class Division {

        @Test
        void itShouldDivide() {
            // Given two Polynomials "5a^3b" and "2abc"
            val a = new Polynomial(5, Set.of(new Intermediate('a', 3), new Intermediate('b')));
            val b = new Polynomial(2, Set.of(new Intermediate('a'), new Intermediate('b'), new Intermediate('c')));

            // When they are divided
            val actual = a.divide(b);

            // Then a quotient is returned
            val expected = new Polynomial(2.5, Set.of(new Intermediate('a', 2), new Intermediate('c', -1)));

            assertAll(
                    () -> assertThat(actual.getCoefficient()).isEqualTo(expected.getCoefficient()),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }
    }

    @Nested
    class Power {

        @Test
        void itShouldRaiseToPower() {
            // Given a Polynomial "2ab^2"
            val a = new Polynomial(2, Set.of(new Intermediate('a', 1), new Intermediate('b', 2)));

            // When it is raised to power 3
            val actual = a.power(3);

            // Then a power is returned
            val expected = new Polynomial(8, Set.of(new Intermediate('a', 3), new Intermediate('b', 6)));

            assertAll(
                    () -> assertThat(actual.getCoefficient()).isEqualTo(expected.getCoefficient()),
                    () -> assertThat(actual).isEqualTo(expected)
            );
        }
    }
}
