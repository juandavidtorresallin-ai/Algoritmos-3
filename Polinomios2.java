import java.util.Scanner;

class Polinomio{
    private final int grado;
    private final int[] coeficientes;

    public Polinomio(int grado) {
        this.grado = grado;
        this.coeficientes = new int[grado + 1];
    }

    public void setCoeficiente(int indice, int valor) {
        if (indice >= 0 && indice <= grado) {
            coeficientes[indice] = valor;
        }
    }

    public int getCoeficiente(int indice) {
        if (indice >= 0 && indice <= grado) {
            return coeficientes[indice];
        }
        return 0;
    }

    public int evaluar(int x) {
        int resultado = 0;

        for (int coeficiente : coeficientes) {
            resultado = resultado * x + coeficiente;
        }

        return resultado;
    }

    public void imprimir() {
        for (int i = 0; i <= grado; i++) {
            if (i > 0 && coeficientes[i] >= 0) {
                System.out.print(" + ");
            }

            System.out.print(coeficientes[i]);

            int exponente = grado - i;
            if (exponente > 1) {
                System.out.print("x^" + exponente);
            } else if (exponente == 1) {
                System.out.print("x");
            }
        }
        System.out.println();
    }
}

public class Polinomios2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Polinomios");
        System.out.print("Ingrese el grado del polinomio: ");
        int grado = entrada.nextInt();

        Polinomio polinomio = new Polinomio(grado);

        for (int i = 0; i <= grado; i++) {
            int exponente = grado - i;
            System.out.print("Ingrese el coeficiente del término de grado "
                    + exponente + ": ");
            polinomio.setCoeficiente(i, entrada.nextInt());
        }

        System.out.print("El polinomio es: ");
        polinomio.imprimir();

        System.out.print("Ingrese el valor de x: ");
        int x = entrada.nextInt();

        int resultado = polinomio.evaluar(x);

        System.out.println("El resultado del polinomio evaluado en x = "
                + x + " es: " + resultado);

        entrada.close();
    }
}
