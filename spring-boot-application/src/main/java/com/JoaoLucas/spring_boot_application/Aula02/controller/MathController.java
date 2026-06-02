package com.JoaoLucas.spring_boot_application.Aula02.controller;

import com.JoaoLucas.spring_boot_application.Aula02.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/math")
public class MathController {


    @RequestMapping("/sum/{numberOne}/{numberTwo}")

    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }


    @RequestMapping("subtract/{numberOne}/{numberTwo}")
    private Double subtract(@PathVariable("numberOne") String numberOne,
                            @PathVariable("numberTwo") String numberTwo)
    throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        if (convertToDouble(numberOne) >  convertToDouble(numberTwo))
            return convertToDouble(numberOne) -  convertToDouble(numberTwo);

        return convertToDouble(numberTwo) - convertToDouble(numberOne);
    }


    @RequestMapping("multiply/{numberOne}/{numberTwo}")
    private Double multiply(@PathVariable("numberOne") String numberOne,
                            @PathVariable("numberTwo") String numberTwo)
    throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }


    @RequestMapping("divide/{numberOne}/{numberTwo}")
    private Double divide(@PathVariable("numberOne") String numberOne,
                          @PathVariable("numberTwo") String numberTwo)
    throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        if (convertToDouble(numberOne) == 0 || convertToDouble(numberTwo) == 0)
            throw new UnsupportedMathOperationException("Division by zero is not allowed!");
        if (convertToDouble(numberOne) >  convertToDouble(numberTwo))
            return convertToDouble(numberOne) /  convertToDouble(numberTwo);

        return convertToDouble(numberTwo) / convertToDouble(numberOne);
    }

    @RequestMapping("mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping("squareroot/{numberOne}")
    public Double squareRoot(@PathVariable("numberOne") String numberOne)
            throws Exception {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        return Math.sqrt((convertToDouble(numberOne)));
    }





    private Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) throws UnsupportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
