package com.JoaoLucas.spring_boot_application.Aula02.math;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo){
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo){
        return numberOne * numberTwo;
    }

    public Double divide(Double numberOne, Double numberTwo){
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo){
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(Double numberOne){
        return Math.sqrt(numberOne);
    }
}
