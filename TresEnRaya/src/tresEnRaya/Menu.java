package tresEnRaya;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Diego Gonzalez Tripero.
 * @author Javier Hernandez Fernandez.
 * @author Jes�s Blanco Antoraz.
 * @version 0.4.5 27/05/2021 9:35
 */

/** Men� Principal del Juego | Tres en Raya */
public class Menu {
	/** Scanner | Introducir datos */
	public static Scanner escribir = new Scanner(System.in);
	/** Opci�n elegida por el usuario */
	public static int opcion = 0;
	/** Comprobar check que valor introducido sea el corecto. */
	public static boolean check = false;

	/**
	 * Muestra el men� del programa, cuando termine de acabar una opci�n y
	 * recorra<br>
	 * el m�todo que conlleve el uso de una opci�n, volver� al men� de inicio.
	 */
	public static void Menu_inicio() {
		try {
			do {
				System.out.println(" * * * MEN� TRES EN RAYA * * * \n" + "  [1] | Modo de juego: Un jugador\n"
						+ "  [2] | Modo de juego: Dos jugadores\n" + "  [3] | Reglas\n"
						+ "  [4] | Salir del juego.\n\n"
						+ "  Cr�ditos: @Diego_Gonzalez | @Jes�s_Blanco | @Javier_Hern�ndez\n");

				System.out.print("\nEliga una opci�n del Men�: ");
				opcion = escribir.nextInt();

				/** Opci�n para jugar en Modo: Un Jugador contra el BOT. */
				if (opcion == 1) {
					System.out.println(" \n*** Ha selecionado: Un jugador ***");
					UnJugador.llamada(null);

					/** Opci�n parajugar entre dos jugadores: Jug1 y Jug2 */
				} else if (opcion == 2) {
					System.out.println(" \n*** Ha selecionado: Dos jugadores ***");
					DosJugadores.llamada(null);

					/** Opci�n para leer las normas de juego */
				} else if (opcion == 3) {
					System.out.println(" \n*** Ha selecionado: Reglas del juego ***");
					Normas_lectura();

					/** Opci�n para salir del juego y terminar la ejecuci�n */
				} else if (opcion == 4) {
					System.out.println(" \n*** Ha selecionado: Salir del juego ***");

					/** Revisa que la opci�n de juego sea entre el rango de opciones de 1 a 4 */
				} else if (opcion >= 5 || opcion <= 0) {
					System.out.println(" \n*** �Debes selecionar una opci�n valida! ***");

				} else if (opcion == (int) opcion) {
					check = false;
				}

			} while (!(opcion == 4));

		} catch (InputMismatchException e) {
			System.out.println("Seleciona una opci�n, en formato digito.");
			System.out.print("\nEliga una opci�n del Men�: ");
			opcion = escribir.nextInt();
			check = true;
		}

	}

	/**
	 * Especifica las normas de juego y su funcionamiento una vez el usuario las
	 * haya visualizado<br>
	 * podr� volver a leerlas o selecionar otra opci�n del men�.
	 */
	public static void Normas_lectura() { // Muestra con un sysout en consola las normas del juego.
		System.out.println("  | 1. | Selecci�n de modo de juego: un jugador (contra la m�quina) o dos jugadores.\r\n"
				+ "  | 2. | Introducir de nombre de los jugadores.\r\n"
				+ "  | 3. | Los jugadores pondr�n sus fichas hasta que alguno haga tres en raya o el tablero est� completo.\r\n"
				+ "  | 4. | El juego se finaliza cuando se juegan 3 partidas.\r\n"
				+ "  | 5. | Cuando se acabe la partida aparecer� un men� que le permite jugar de nuevo o salir del juego.\n\n");
	}

	
	/**
	 * Carga la clase Men� de Inicio, el usuario podr� selecionar su opci�n.<br>
	 * 
	 * @param args Main de Inicio de Juego | Clase Principal de Tres en Raya
	 */
	public static void main(String[] args) {
		Menu_inicio();
	}

}
