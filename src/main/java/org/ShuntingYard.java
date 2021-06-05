package org;

import java.util.*;

public class ShuntingYard {

    public static List<String> postfix(String[] tokens) {
        List<String> output = new ArrayList<>();
        Deque<String> stack = new LinkedList<>();

        for (String token : tokens) {
            // operator
            if (Operator.contains(token)) {
                while (!stack.isEmpty() && isHigerPrec(token, stack.peek())) {
                    output.add(stack.pop());
                }

                stack.push(token);

                // left parenthesis
            } else if (token.equals("(")) {
                stack.push(token);

                // right parenthesis
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    output.add(stack.pop());
                }

                stack.pop();

                // digit
            } else {
                output.add(token);
            }
        }

        while (!stack.isEmpty())
            output.add(stack.pop());

        return output;
    }

    // TODO move to Operator
    private static boolean isHigerPrec(String op, String sub) {
        return (Operator.contains(sub) && Operator.getBySymbol(sub).getPrecedence() >= Operator.getBySymbol(op).getPrecedence());
    }
}
