package juegoDelPalo;

import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print(" Digite cantidad de palos a jugar : ");
		int palos = entrada.nextInt();
		boolean turnoPC = true;
		imprimirPalos(palos);
		do {
			turnoPC = !turnoPC;
			palos = turnoPC ? turnoPC(palos) : turnoJugador(palos);
			imprimirPalos(palos);
		}while(!validarVictoria(palos));
		String ganador = turnoPC ? "PC" : "JUGADOR";
		System.out.println("El Ganador es : "+ganador);
	}
	
	public static int turnoJugador(int n) {
		System.out.print(" Digite cantidad de palos a retirar 1-3 : ");
		int nTemp = entrada.nextInt();
		if(nTemp<=n&&nTemp>0) {
			return n-=nTemp;
		}else {
			System.out.println(" Digite un valor valido...\n");
			return turnoJugador(n);
		}
	}
	
	public static int turnoPC(int n) {
		Random rnd = new Random();
		System.out.println(" Turno PC...");
		if(n<=4) {
			return 1;
		}else {
			return n-=rnd.nextInt(1,4);
		}
	}
	
	public static void imprimirPalos(int n) {
		System.out.println("   ");
		for(int i=0;i<n;i++) {
			System.out.print("|");
		}
		System.out.println("\n");
	}
	
	public static boolean validarVictoria(int n) {
		return n==1 ? true : false;
	}
}
