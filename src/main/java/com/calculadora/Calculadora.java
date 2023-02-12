package com.calculadora;

public class Calculadora {

    public double areaTriangulo(double a, double b, double c) throws LadosInvalidosException {
        if(!isTriangulo(a, b, c))
            throw new LadosInvalidosException();

        double s = semiPerimetro(a, b, c);
        double area = Math.sqrt(s * (s - a) * (s - b) * (s -c));
        return area;
    }

    public double semiPerimetro(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean isTriangulo(double a, double b, double c) {
        if(a >= b + c)
            return false;
        if(b >= a + c)
            return false;
        if(c >= a + b)
            return false;

        return true;
    }

}
