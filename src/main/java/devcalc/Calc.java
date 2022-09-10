package devcalc;

import java.util.Scanner;

public class Calc {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Escolha o calculo desejado");
        System.out.println("(1) Somar");
        System.out.println("(2) Subtrair");
        System.out.println("(3) Multiplicar");
        System.out.println("(4) Dividir");

        int opcao = entrada.nextInt();
        int num1 =0;
        int num2= 0;
        //somarDoisNumeros();

        switch (opcao){
            case 1 :
                System.out.println(somarDoisNumeros(num1, num2));
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }
    }
public static int somarDoisNumeros(int num1, int num2){
        return num1+ num2;

}



}
