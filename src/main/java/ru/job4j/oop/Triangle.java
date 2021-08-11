package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * semiPerimeter() - выполняет расчет полупериметра треугольника.
     * @param a - длина стороны а
     * @param b - длина стороны b
     * @param c - длина стороны с
     * @return - сумма длин сторон деленная на 2
     */
    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**
     * exist() - проверяет возможно ли из сторон с длинами a, b и c построить треугольник.
     * Для этого сумма длин двух сторон должна быть строго больше третьей стороны, для всех возможных сочетаний.
     * @param ab - длина сторроны
     * @param ac - длина сторроны
     * @param bc - длина сторроны
     * @return - возвращает true, если треугольник можно построить
     */
    public boolean exist(double ab, double ac, double bc) {
        return ab + ac > bc ? true : false;
    }

    /**
     * area() - рассчитывает площадь треугольника согласно формуле Герона.
     * @return
     */
    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            rsl = sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }
}
