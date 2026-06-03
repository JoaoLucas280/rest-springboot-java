package com.JoaoLucas.spring_boot_application.Aula02;

import com.JoaoLucas.spring_boot_application.Aula02.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static boolean isNumeric(String strNumber) throws UnsupportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);

    }
}
