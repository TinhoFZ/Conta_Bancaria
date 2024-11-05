package conta_bancaria;

import java.util.Scanner;

public class ContaBancaria {
	
public static double saldo, valorAdicionado, valorRetirado;
public static int acaoUsuario;
public static String titular;

public static Scanner teclado = new Scanner(System.in);

	static void adicionarSaldo() {
		System.out.println("Insira o valor que deseja adicionar:");
		valorAdicionado = teclado.nextDouble();
		
		if (valorAdicionado <= 0) {
			System.out.println("O valor adicionado é menor ou igual a zero logo, não é valido.");
			adicionarSaldo();
		} else {
			saldo = saldo + valorAdicionado;
			novoSaldo();
		}
	}
	
	static void retirarSaldo() {
		System.out.println("Insira o valor que deseja retirar:");
		valorRetirado = teclado.nextDouble();
		
		if ((valorRetirado > 0) && (saldo >= 0)){
			saldo = saldo - valorRetirado;
			novoSaldo();
		} else {
			System.out.println("O valor adicionado é menor ou igual a zero ou o seu saldo ficou negativo, logo o valor não é valido.");
			retirarSaldo();
		}
	}
	
	static void novoSaldo() {
		System.out.println("Agora o seu saldo é: " + saldo);
		System.out.println("---------------------------------------------------------------------------------------------------");
		modificarSaldo();
	}
	
	static void modificarSaldo(){
		System.out.println("Você deseja: adicionar saldo (digite '0'); retirar saldo (digite '1'); sair do sistema (digite '2')");
		acaoUsuario = teclado.nextInt();
		if (acaoUsuario == 0) {
			adicionarSaldo();
		} else if (acaoUsuario == 1) {
				retirarSaldo();
			} else if (acaoUsuario == 2) {
					System.out.println("Fim do sistema");
			} else {
				System.out.println("Esta opção não é valida, por favor insira outra.");
				modificarSaldo();
			}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Qual o nome do titular?");
		titular = teclado.nextLine();
		
		System.out.println("Qual o saldo da conta?");
		saldo = teclado.nextDouble();
		if (saldo <0) {
			System.out.println("O saldo deve ser igual ou maior a zero.");
		} else {
			modificarSaldo();
		}
	}

}
