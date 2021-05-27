package tresEnRaya;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Diego Gonzalez Tripero.
 * @author Javier Hernandez Fernandez.
 * @author Jesús Blanco Antoraz.
 * @version 0.4.5 27/05/2021 9:35
 */

/** Menú Principal del Juego | Tres en Raya */
public class Menu {
	/** Scanner | Introducir datos */
	public static Scanner escribir = new Scanner(System.in);
	/** Opción elegida por el usuario */
	public static int opcion = 0;
	/** Comprobar check que valor introducido sea el corecto. */
	public static boolean check = false;

	/**
	 * Muestra el menú del programa, cuando termine de acabar una opción y
	 * recorra<br>
	 * el método que conlleve el uso de una opción, volverá al menú de inicio.
	 */
	public static void Menu_inicio() {
		try {
			do {
				System.out.println(" * * * MENÚ TRES EN RAYA * * * \n" + "  [1] | Modo de juego: Un jugador\n"
						+ "  [2] | Modo de juego: Dos jugadores\n" + "  [3] | Reglas\n"
						+ "  [4] | Salir del juego.\n\n"
						+ "  Créditos: @Diego_Gonzalez | @Jesús_Blanco | @Javier_Hernández\n");

				System.out.print("\nEliga una opción del Menú: ");
				opcion = escribir.nextInt();

				/** Opción para jugar en Modo: Un Jugador contra el BOT. */
				if (opcion == 1) {
					System.out.println(" \n*** Ha selecionado: Un jugador ***");
					UnJugador.llamada(null);

					/** Opción parajugar entre dos jugadores: Jug1 y Jug2 */
				} else if (opcion == 2) {
					System.out.println(" \n*** Ha selecionado: Dos jugadores ***");
					DosJugadores.llamada(null);

					/** Opción para leer las normas de juego */
				} else if (opcion == 3) {
					System.out.println(" \n*** Ha selecionado: Reglas del juego ***");
					Normas_lectura();

					/** Opción para salir del juego y terminar la ejecución */
				} else if (opcion == 4) {
					System.out.println(" \n*** Ha selecionado: Salir del juego ***");

					/** Revisa que la opción de juego sea entre el rango de opciones de 1 a 4 */
				} else if (opcion >= 5 || opcion <= 0) {
					System.out.println(" \n*** ¡Debes selecionar una opción valida! ***");

				} else if (opcion == (int) opcion) {
					check = false;
				}

			} while (!(opcion == 4));

		} catch (InputMismatchException e) {
			System.out.println("Seleciona una opción, en formato digito.");
			System.out.print("\nEliga una opción del Menú: ");
			opcion = escribir.nextInt();
			check = true;
		}

	}

	/**
	 * Especifica las normas de juego y su funcionamiento una vez el usuario las
	 * haya visualizado<br>
	 * podrá volver a leerlas o selecionar otra opción del menú.
	 */
	public static void Normas_lectura() { // Muestra con un sysout en consola las normas del juego.
		System.out.println("  | 1. | Selección de modo de juego: un jugador (contra la máquina) o dos jugadores.\r\n"
				+ "  | 2. | Introducir de nombre de los jugadores.\r\n"
				+ "  | 3. | Los jugadores pondrán sus fichas hasta que alguno haga tres en raya o el tablero esté completo.\r\n"
				+ "  | 4. | El juego se finaliza cuando se juegan 3 partidas.\r\n"
				+ "  | 5. | Cuando se acabe la partida aparecerá un menú que le permite jugar de nuevo o salir del juego.\n\n");
	}

	
	/**
	 * Carga la clase Menú de Inicio, el usuario podrá selecionar su opción.<br>
	 * 
	 * @param args Main de Inicio de Juego | Clase Principal de Tres en Raya
	 */
	public static void main(String[] args) {
		Menu_inicio();
	}

}
