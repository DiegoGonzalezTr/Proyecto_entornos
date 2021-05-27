package tresEnRaya;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Diego Gonzalez Tripero.
 * @author Javier Hernandez Fernandez.
 * @author Jesús Blanco Antoraz.
 * @version 0.4.3 24/05/2021 19:35
 */

/**
 * Menú Final | 2 Jugadores | Permite selecionar varias opciones <br>
 * del menú de juego.
 */
public class MenuFinal_DosJugadores {
	/** Permite al usuario introducir valores */
	public static Scanner escribir = new Scanner(System.in);
	/** Seleciona la opción de menú valor predeterminado */
	public static int opcion = 0;
	/** Comprueba que el usuario haya escrito un valor valido */
	public static boolean check = false;

	/**
	 * Usuario puede selecionar una opción del menú final, una vez<br>
	 * haya finalizado de jugar 3 partidas, Gana el mejor de 3.
	 */
	public static void Menu_final() {
		try {
			do {
				System.out.println(" * * * MENÚ FINAL * * * \n" + "  [1] | Volver a jugar\n"
						+ "  [2] | Regresar al menú inicial\n" + "  [3] | Salir del juego.\n\n"
						+ "  Créditos: @Diego_Gonzalez | @Jesús_Blanco | @Javier_Hernández\n");

				System.out.print("\nEliga una opción del Menú: ");
				opcion = escribir.nextInt();

				if (opcion == 1) {
					System.out.println(" \n*** Ha selecionado: Volver a jugar ***");
					DosJugadores.jugada();

				} else if (opcion == 2) {
					System.out.println(" \n*** Ha selecionado: Regresar al menú inicial ***");
					Menu.Menu_inicio();

				} else if (opcion == 3) {
					System.out.println(" \n*** Ha selecionado: Salir del juego ***");

				} else if (opcion >= 3 || opcion <= 0) {
					System.out.println(" \n*** ¡Debes selecionar una opción valida! ***");

				} else if (opcion == (int) opcion) {
					check = false;
				}

			} while (!(opcion == 3));

		} catch (InputMismatchException e) {
			System.out.println("Seleciona una opción, en formato digito.");
			System.out.print("\nEliga una opción del Menú: ");
			opcion = escribir.nextInt();
			check = true;
		}

	}

}
