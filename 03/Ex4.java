package ex;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("A: ");
        int a = teclado.nextInt();
        System.out.println("B: ");
        int b = teclado.nextInt();
        System.out.println("C: ");
        int c = teclado.nextInt();

        if (formaTriangulo(a, b, c)){
            System.out.println("Forma um triângulo");
        } else {
            System.out.println("Não forma um triângulo");
        }
    }
    public static boolean formaTriangulo(int a, int b, int c){
        if (a < b + c && b < a + c && c < a + b){
            return true;
        } else {
            return false;
        }
    }
}
