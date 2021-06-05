package org;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
@Getter
public enum Operator {

    ADD("+", 1),
    SUBTRACT("-", 2),
    MULTIPLY("*", 3),
    DIVIDE("/", 4),
    POWER("^", 5);

    String symbol;
    int precedence;

    public static boolean contains(String symbol) {
        return Arrays.stream(Operator.values())
                .anyMatch(o -> o.symbol.equals(symbol));
    }

    public static Operator getBySymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(symbol));
    }
}
