package tresEnRaya;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Jes�s Blanco Antoraz
 * @version 0.4.3 21/05/2021 12:38
 */

public class Menu {
	public static Scanner escribir = new Scanner(System.in);
	public static int opcion=0;
    public static boolean check = false;
    
	/**
	 * Muestra el men� del programa, cuando termine de acabar una opci�n y recorra<br>
	 * el m�todo que conlleve el uso de una opci�n, volver� al men� de inicio.
	 */
	public static void Menu_inicio()
	{	System.out.println
			(" * * * MEN� TRES EN RAYA * * * \n"
			+"  [1] | Modo de juego: Un jugador\n"
			+"  [2] | Modo de dos jugadores: Un jugador\n"
			+"  [3] | Reglas\n"
			+"  [4] | Salir del juego.\n\n"
			+"  Cr�ditos: @Diego_Gonzalez | @Jes�s_Blanco | @Javier_Hern�ndez\n");
		try {	
			do {	
			
				System.out.print("\nEliga una opci�n del Men�: ");
				opcion = escribir.nextInt();
				
				if (opcion==1) {
					System.out.println(" \n*** Ha selecionado: Un jugador ***");
					//Llamar a M�todo.
					TresEnRaya.llamada(null);
					
				} else if (opcion==2) {
					System.out.println(" \n*** Ha selecionado: Dos jugadores ***");
					//Llamar a M�todo.
					
				} else if (opcion==3) {
					System.out.println(" \n*** Ha selecionado: Reglas del juego ***");
					Normas_lectura();
					
				} else if (opcion==4) {
					System.out.println(" \n*** Ha selecionado: Salir del juego ***");
					
				} else if (opcion>=5 || opcion<=0) {
					System.out.println(" \n*** �Debes selecionar una opci�n valida! ***");
					
				} else if (opcion == (int) opcion) {
					check = false;
				} 
				
			} while (!(opcion==4));
			
		} catch (InputMismatchException e) {
			System.out.println("Seleciona una opci�n, en formato digito.");
			System.out.print("\nEliga una opci�n del Men�: ");
			opcion = escribir.nextInt();
		    check = true;
		}
		
	}
	
	public static void Normas_lectura()
	{	//Muestra con un sysout en consola las normas del juego.
		System.out.println
				( "  | 1. | Selecci�n de modo de juego: un jugador (contra la m�quina) o dos jugadores.\r\n"
				+ "  | 2. | Sel�ccion de nombre de los jugadores.\r\n"
				+ "  | 3. | Cara o cruz para ver quien hace el primer movimiento, en las siguientes veces ser� el perdedor.\r\n"
				+ "  | 4. | Los jugadores pondr�n sus fichas hasta que alguno haga tres en raya o el tablero est� completo.\r\n"
				+ "  | 5. | El juego se finaliza cuando uno de los jugadores consiga 3 victorias.\r\n"
				+ "  | 6. | Cuando se acabe la partida se volver� al men�.");
	}
	
	public static void main(String[] args) {
		Menu_inicio();
	}

}
