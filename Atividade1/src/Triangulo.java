public class Triangulo {


    int a;
    int b;
    int c;

    public Triangulo(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean etriangulo() {
        if (this.a < this.c + this.b & this.c < this.a + this.b & this.b < this.c + this.a)
            return true;
        return false;
    }

    public double area() {

        int p = (this.a + this.b + this.c) / 2;
        return  Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }

    public int perimetro() {

        return this.a + this.b + this.c;

    }

    public double lambida() {

        return (Math.pow(this.a, 2) + Math.pow(this.b, 2) - Math.pow(this.c, 2)) / (2 * this.a * this.b);

    }

    public double y() {

        return (this.a / 3) * Math.sqrt(1 - Math.pow(lambida(), 2));
    
    }

    public double x() {

        return (this.b + this.a * lambida()) / 3;
    
    }

}
