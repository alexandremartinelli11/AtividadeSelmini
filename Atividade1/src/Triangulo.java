public class Triangulo {


    float a;
    float b;
    float c;

    public Triangulo(float a, float b, float c) {
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

        float p = perimetro() / 2;
        return  Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));

    }

    public float perimetro() {

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
