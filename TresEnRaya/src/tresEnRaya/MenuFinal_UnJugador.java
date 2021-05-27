package tresEnRaya;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Diego Gonzalez Tripero.
 * @author Javier Hernandez Fernandez.
 * @author Jes�s Blanco Antoraz.
 * @version 0.4.5 27/05/2021 9:35
 */

/**
 * Men� final | Tres en Raya | Fin de la partida en Modo un jugador.<br>
 * Muestra al usuario un men� con varias opciones una vez haya terminado de
 * jugar 3 partidas.
 */
public class MenuFinal_UnJugador {
	/** Scanner usado para introducir datos */
	public static Scanner escribir = new Scanner(System.in);
	/** opci�n la cual el usuario dejar� selecionada. */
	public static int opcion = 0;
	/** Revisa que el usuario hay escrito correctamente el valor correcto */
	public static boolean check = false;

	/** Men� Final, permite al usuario selecionar varias opciones de juego */
	public static void Menu_final() {
		try {
			do {
				System.out.println(" * * * MEN� FINAL * * * \n" + "  [1] | Volver a jugar\n"
						+ "  [2] | Regresar al men� inicial\n" + "  [3] | Salir del juego.\n\n"
						+ "  Cr�ditos: @Diego_Gonzalez | @Jes�s_Blanco | @Javier_Hern�ndez\n");

				System.out.print("\nEliga una opci�n del Men�: ");
				opcion = escribir.nextInt();

				if (opcion == 1) {
					System.out.println(" \n*** Ha selecionado: Volver a jugar ***");
					UnJugador.jugada();

				} else if (opcion == 2) {
					System.out.println(" \n*** Ha selecionado: Regresar al men� inicial ***");
					Menu.Menu_inicio();

				} else if (opcion == 3) {
					System.out.println(" \n*** Ha selecionado: Salir del juego ***");

				} else if (opcion >= 3 || opcion <= 0) {
					System.out.println(" \n*** �Debes selecionar una opci�n valida! ***");

				} else if (opcion == (int) opcion) {
					check = false;
				}

			} while (!(opcion == 3));

		} catch (InputMismatchException e) {
			System.out.println("Seleciona una opci�n, en formato digito.");
			System.out.print("\nEliga una opci�n del Men�: ");
			opcion = escribir.nextInt();
			check = true;
		}

	}

}
