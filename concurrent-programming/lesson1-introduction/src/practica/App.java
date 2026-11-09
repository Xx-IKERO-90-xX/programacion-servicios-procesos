package practica;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un numero entero: ");
        int num = Integer.parseInt(sc.nextLine());

        System.out.print("Introduce un texto: ");
        String text = sc.nextLine();
        
        System.out.println("El numero introducido es: " + num);
        System.out.print("El texto introducido es: " + text);

        sc.close();
    }
}
