import controller.Pessoa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("nome: ");
        String nome = sc.nextLine();

        System.out.print("RG: ");
        String rg = sc.nextLine();

        Pessoa pessoa = new Pessoa(rg, nome);
        System.out.print("Atualize seu nome de solteiro: ");
        pessoa.setNomePessoa(sc.nextLine());

    }
}
