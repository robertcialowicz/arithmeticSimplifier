package org;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Intermediate {

    public static final Intermediate NUMBER = new Intermediate((char) 0, 1);

    char symbol;
    int exponent;

    public Intermediate(char symbol) {
        this(symbol, 1);
    }

    public Intermediate multiply(Intermediate i) {
        if (symbol != i.getSymbol()) {
            throw new IllegalArgumentException("Intermediates have to have the same symbol to be multiplied.");
        }

        return new Intermediate(symbol, exponent + i.exponent);
    }

    public Intermediate divide(Intermediate i) {
        if (symbol != i.getSymbol()) {
            throw new IllegalArgumentException("Intermediates have to have the same symbol to be divided.");
        }

        return new Intermediate(symbol, exponent - i.exponent);
    }

    public Intermediate power(int exponent) {
        return new Intermediate(symbol, this.exponent * exponent);
    }
}
