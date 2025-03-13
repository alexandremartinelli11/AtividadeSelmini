import java.util.ArrayList;

public class Ex4 {

    public static void main(String[] args) {

        ArrayList<Triangulo> lista = new ArrayList<>();
        Triangulo tri1 = new Triangulo(3, 4, 5);
        Triangulo tri2 = new Triangulo(3, 3, 3);
        Triangulo tri = new Triangulo(4, 4, 7);
        Triangulo tri4 = new Triangulo(1, 1, 3);
        lista.add(tri1);
        lista.add(tri2);
        lista.add(tri);
        lista.add(tri4);
        for(Triangulo triangulo: lista){
            if(triangulo.etriangulo()){
                System.out.println();
                System.out.println("Triangulo: a -> " + triangulo.a + " b -> " + triangulo.b + " c -> " + triangulo.c);
                System.out.println("Area: " + triangulo.area());
                System.out.println("Perimetro: " + triangulo.perimetro());
                System.out.println("x: " + triangulo.x());
                System.out.println("y " + triangulo.y());
            }
            else{
                System.out.println();
                System.out.println("Triangulo: a -> " + triangulo.a + " b -> " + triangulo.b + " c -> " + triangulo.c + " não é um triangulo");
            }
        }
    }

}
