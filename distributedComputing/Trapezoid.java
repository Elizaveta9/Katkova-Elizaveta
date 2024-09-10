package distributedComputing;

import java.io.Serializable;

// Класс трапеции
class Trapezoid implements Serializable { //Serializable нужен для работы ObjectOutputStream и ObjectInputStream
    private double a, b, h;

    Trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getH() {
        return h;
    }
}
