package MasterWorker;

import java.io.Serializable;

class Trapezoid implements Serializable {
    double a, b, h;

    Trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }
}
