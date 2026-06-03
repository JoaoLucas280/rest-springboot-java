package com.JoaoLucas.spring_boot_application.Aula02.controller;

import com.JoaoLucas.spring_boot_application.Aula02.NumberConverter;
import com.JoaoLucas.spring_boot_application.Aula02.exception.UnsupportedMathOperationException;
import com.JoaoLucas.spring_boot_application.Aula02.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/math")
public class MathController {

    SimpleMath math = new SimpleMath();


    @RequestMapping("/sum/{numberOne}/{numberTwo}")

    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }


    @RequestMapping("subtract/{numberOne}/{numberTwo}")
    private Double subtract(@PathVariable("numberOne") String numberOne,
                            @PathVariable("numberTwo") String numberTwo)
    throws Exception{
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        if (NumberConverter.convertToDouble(numberOne) >  NumberConverter.convertToDouble(numberTwo))
            return NumberConverter.convertToDouble(numberOne) -  NumberConverter.convertToDouble(numberTwo);

        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }


    @RequestMapping("multiply/{numberOne}/{numberTwo}")
    private Double multiply(@PathVariable("numberOne") String numberOne,
                            @PathVariable("numberTwo") String numberTwo)
    throws Exception{
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }


    @RequestMapping("divide/{numberOne}/{numberTwo}")
    private Double divide(@PathVariable("numberOne") String numberOne,
                          @PathVariable("numberTwo") String numberTwo)
    throws Exception{
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        if (NumberConverter.convertToDouble(numberOne) == 0 || NumberConverter.convertToDouble(numberTwo) == 0)
            throw new UnsupportedMathOperationException("Division by zero is not allowed!");
        if (NumberConverter.convertToDouble(numberOne) >  NumberConverter.convertToDouble(numberTwo))
            return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);

        return math.divide(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("squareroot/{numberOne}")
    public Double squareRoot(@PathVariable("numberOne") String numberOne)
            throws Exception {
        if (!NumberConverter.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        }
        return math.squareRoot(NumberConverter.convertToDouble(numberOne));
    }

}
