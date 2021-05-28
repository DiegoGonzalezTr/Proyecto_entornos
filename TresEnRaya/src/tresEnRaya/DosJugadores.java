package tresEnRaya;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Diego Gonzalez Tripero.
 * @author Javier Hernandez Fernandez.
 * @author Jesús Blanco Antoraz.
 * @version 0.4.5 27/05/2021 9:35
 */

/**
 * Tres en Raya | Clase de Tres En Raya<br>
 * Permite jugar a dos jugadores.
 */
public class DosJugadores {
	/** Array del tablero de juego y dimensiones */
	public static char array_tablero[][] = new char[3][3];

	/** Indica posición Tablero vacio */
	public static char tablero_vacio = '/';

	/** Scanner para poder escribir valores */
	public static Scanner sc = new Scanner(System.in);

	/** Nombres jugadores */
	public static String nombreJugadorSc1, nombreJugadorSc2;

	/** Contador de victorias Jugador 1. */
	public static int contador_victorias_jug1 = 0;
	/** Contador de victorias Jugador 2. */
	public static int contador_victorias_jug2 = 0;
	/** Contador de derrotas Jugador 1. */
	public static int contador_derrotas_jug1 = 0;
	/** Contador de derrotas Jugador 2. */
	public static int contador_derrotas_jug2 = 0;

	/**
	 * Muestra información de los contadores del juego, <br>
	 * una vez termina la partida, se muestran, se suma +1 a las victorias y +1 <br>
	 * a las derrotas de solamente el perdedor.<br>
	 */
	public static void MostrarInfoContadores() {
		System.out.println("\n *** | INFO CONTADORES | ***\n" + nombreJugadorSc1 + " \tVict: " + contador_victorias_jug1
				+ " Derr: " + contador_derrotas_jug1 + "\n" + nombreJugadorSc2 + " \tVict: " + contador_victorias_jug2
				+ " Derr: " + contador_derrotas_jug2 + "\n");
	}

	/**
	 * Insertar datos en la matriz, refiere al tablero de juego<br>
	 * Se calcula la distancia del array para saber su longitud<br>
	 * En este método se podría ampliar el tablero<br>
	 */
	public static void insetarDatos() {
		for (int i = 0; i < array_tablero.length; i++) {
			for (int j = 0; j < array_tablero.length; j++) {
				array_tablero[i][j] = tablero_vacio;
			}
		}
	}

	/**
	 * Se definen todos los casos de victorias que puedan realizar los jugadores<br>
	 * sobre el tablero, realizando distintas acciones y llamadas a métodos.<br>
	 * 
	 * @param array_tablero Tablero con fichas actuales
	 * @param jugador1      Jugador 1.
	 * @param jugador2      Jugador 2.
	 * @param tablero_vacio Tablero vacio.
	 */
	public static void quienGana(char[][] array_tablero, char jugador1, char jugador2, char tablero_vacio) {
		char ficha;
		boolean empate = false;
		if (empate == true) {
			System.out.println("Empate");
		}
		ficha = ganadorLinea(array_tablero, tablero_vacio);
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
				System.out.println("Gana  " + nombreJugadorSc1 + " porque ha hecho una linea");
				contador_victorias_jug1++;
				contador_derrotas_jug2++;
				MostrarInfoContadores();

			} else if (ficha != jugador1) {
				System.out.println("Gana  " + nombreJugadorSc2 + " porque ha hecho una linea");
				contador_victorias_jug2++;
				contador_derrotas_jug1++;
				MostrarInfoContadores();
			}
		}

		ficha = ganadorColumna(array_tablero, tablero_vacio);
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
				System.out.println("Gana  " + nombreJugadorSc1 + " porque ha hecho una columna");
				contador_victorias_jug1++;
				contador_derrotas_jug2++;
				MostrarInfoContadores();

			} else {
				System.out.println("Gana " + nombreJugadorSc2 + " porque ha hecho una columna");
				contador_victorias_jug2++;
				contador_derrotas_jug1++;
				MostrarInfoContadores();
			}
		}

		ficha = ganadorDiagonalPrincipal(array_tablero, tablero_vacio);
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
				System.out.println("Gana  " + nombreJugadorSc1 + " porque ha hecho una diagonal principal");
				contador_victorias_jug1++;
				contador_derrotas_jug2++;
				MostrarInfoContadores();

			} else {
				System.out.println("Gana  " + nombreJugadorSc2 + " porque ha hecho una diagonal principal");
				contador_victorias_jug2++;
				contador_derrotas_jug1++;
				MostrarInfoContadores();
			}
		}

		ficha = ganadorDiagonalInversa(array_tablero, tablero_vacio);
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
				System.out.println("Gana  " + nombreJugadorSc1 + " porque ha hecho una diagonal inversas");
				contador_victorias_jug1++;
				contador_derrotas_jug2++;
				MostrarInfoContadores();

			} else {
				System.out.println("Gana  " + nombreJugadorSc2 + " porque ha hecho una diagonal inversa");
				contador_victorias_jug2++;
				contador_derrotas_jug1++;
				MostrarInfoContadores();
			}
		}
	}

	/**
	 * Casos en los cuales la partida detecta que se ha terminado.<br>
	 * Con negación podemos dar los casos en los quehaya empates, y<br>
	 * distintas vicotrias según haya hecho columna, linea, diagonal.<br>
	 * 
	 * @param array_tablero Tablero
	 * @param tablero_vacio Tablero Vacio
	 * @return Devuelve true si, la partida tiene un caso de finalización.
	 */
	public static boolean gameOver(char[][] array_tablero, char tablero_vacio) {
		// Si tenemos linea, columna , diagonales o toda la matriz llena, la partida
		// acaba
		if (matrizCompleta(array_tablero, tablero_vacio) || empate(array_tablero, tablero_vacio, tablero_vacio)
				|| ganadorColumna(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorLinea(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorDiagonalPrincipal(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorDiagonalInversa(array_tablero, tablero_vacio) != tablero_vacio) {
			return true;
		}
		return false;
	}

	/**
	 * Muestra el tablero tras haber realizado la introducción de una ficha en
	 * el.<br>
	 * 
	 * @param array_tablero Tablero
	 * @param tablero_vacio Tablero vacio
	 * @return Sí en el tablero, se introduce una ficha dentro de la matriz, se
	 *         muestra.
	 */
	public static boolean matrizCompleta(char[][] array_tablero, char tablero_vacio) {
		for (int i = 0; i < array_tablero.length; i++) {
			for (int j = 0; j < array_tablero[0].length; j++) {
				// Con que en una celda me encuente un "/" entonces suponemos que se puede
				// seguir jugando
				if (array_tablero[i][j] == tablero_vacio) {
					return false;
				}
			}
		}
		MostrarInfoContadores();
		return true;
	}

	/**
	 * Método que usamos para saber si donde queremos poener un valor esta vacio o
	 * no.<br>
	 * 
	 * @param array_tablero Tablero
	 * @param fil           Filas del tablero.
	 * @param colum         Columnas del tablero.
	 * @param tablero_vacio Tablero vacio
	 * @return Sí la casilla del tablero está vacia, se pone la ficha del jugador.
	 */
	public static boolean estaLibre(char[][] array_tablero, int fil, int colum, int tablero_vacio) {
		if (array_tablero[fil][colum] != tablero_vacio) {
			return true;
		}
		return false;
	}

	/**
	 * Con este metodo insetamos las fichas en el array.
	 * 
	 * @param array_tablero Tablero.
	 * @param fil           Filas tablero.
	 * @param colum         Columnas tablero
	 * @param tablero_vacio Tablero vacio
	 */
	public static void insertarDatos(char[][] array_tablero, int fil, int colum, char tablero_vacio) {
		array_tablero[fil][colum] = tablero_vacio;
	}

	/**
	 * Muestra el tablero, para ello recorre el array y lo muestra en forma de
	 * sí.<br>
	 */
	public static void verTablero() {
		for (int i = 0; i < array_tablero.length; i++) {
			for (int j = 0; j < array_tablero[0].length; j++) {
				System.out.print(array_tablero[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println();
	}

	/**
	 * Método para casos de empate, en el caso de que ningún jugador<br>
	 * haya podido realizar una victoria de 3 en linea, diagonal.
	 * 
	 * @param array_tablero tablero.
	 * @param tablero_vacio tablero vacio.
	 * @param ficha         fichas del tablero.
	 * @return Delvuelve true en el caso de que haya habido un empate.
	 */
	public static boolean empate(char[][] array_tablero, char tablero_vacio, char ficha) {
		for (int i = 0; i < array_tablero.length; i++) {
			for (int j = 0; j < array_tablero[0].length; j++) {
				if (array_tablero[i][j] != tablero_vacio ||

						ganadorLinea(array_tablero, tablero_vacio) == ficha
						|| ganadorColumna(array_tablero, tablero_vacio) == ficha
						|| ganadorLinea(array_tablero, tablero_vacio) == ficha
						|| ganadorDiagonalPrincipal(array_tablero, tablero_vacio) == ficha) {
					return false;
				}
			}
		}
		MostrarInfoContadores();
		System.out.println("¡Ha habido un Empate, continuar jugando!");
		return true;
	}

	/**
	 * Los jugadores especifican los nombres, por defecto el jugador 1 y 2. Indican
	 * nombre<br>
	 * Sirve para reconocer quien tiene que jugar y quien comienza.
	 * 
	 * @param turno Turno del jugador si es true, jugador1 si es false jugador 2.
	 */
	public static void nombres_de_jugadores(boolean turno) {
		if (turno) {
			System.out.println("\nTurno de: "+nombreJugadorSc1);
		} else {
			System.out.println("\nTurno de: "+nombreJugadorSc2);
		}
	}

	/**
	 * Comprueba la fila del tablero.
	 * 
	 * @param array_tablero tablero.
	 * @param fil           filas del tablero.
	 * @return develve true si la fila es correcta.
	 */
	public static boolean comprobarFil(char[][] array_tablero, int fil) {
		// Si el numero de fila que introduce el usuario esta entre 0 y 3 entonce es
		// correcto (true)
		if (fil >= 0 && fil <= array_tablero.length) {
			return true;
		}
		return false;
	}

	/**
	 * Comprueba la columna del tablero.
	 * 
	 * @param array_tablero tablero.
	 * @param colum         Columnas del tablero.
	 * @return develve true si la columna es correcta.
	 */
	public static boolean comprobarColum(char[][] array_tablero, int colum) {
		// Si el numero de columna que introduce el usuario esta entre 0 y 3 entonce es
		// correcto (true)
		if (colum >= 0 && colum <= array_tablero.length) {
			return true;
		}
		return false;
	}

	/**
	 * Comprueba si el jugador ha hecho una Línea en el tablero.<br>
	 * yo voy a ser ganador hasta que algo de lo que hay mas abajo sear false,<br>
	 * entonces ya no sere ganador<br>
	 * Si en la siguiente posicion no hay un / me interesa seguir.<br>
	 * Si una ficha que esta en la misma fila no coincide con el resto, entonces
	 * no<br>
	 * hay 3 en raya<br>
	 * 
	 * @param array_tablero tablero.
	 * @param tablero_vacio tablero vacio
	 * @return develve true si la linea es correcta.
	 */
	public static char ganadorLinea(char[][] array_tablero, char tablero_vacio) {

		char ficha;
		boolean ganador;
		for (int i = 0; i < array_tablero.length; i++) {

			// yo voy a ser ganador hasta que algo de lo que hay mas abajo sear false,
			// entonces ya no sere ganador
			ganador = true;
			// cojemos el primero de cada fila
			ficha = array_tablero[i][0];
			// Si en la siguiente posicion no hay un / me interesa seguir,
			if (ficha != tablero_vacio) {
				for (int j = 1; j < array_tablero[0].length; j++) {
					if (ficha != array_tablero[i][j]) {
						// Si una ficha que esta en la misma fila no coincide con el resto, entonces no
						// hay 3 en raya
						ganador = false;
					}
				}
				if (ganador == true) {
					return ficha;
				}
			}
		}
		return tablero_vacio;
	}

	/**
	 * Si coinciden tres fichas en posición de columna<br>
	 * Jugador hace victoria. <br>
	 * 
	 * @param array_tablero tablero
	 * @param tablero_vacio tablero vacio
	 * @return develve true si la columna es correcta.
	 */
	public static char ganadorColumna(char[][] array_tablero, char tablero_vacio) {

		char ficha;
		boolean ganador;
		for (int i = 0; i < array_tablero.length; i++) {

			// yo voy a ser ganador hasta que algo de lo que hay mas abajo sear false,
			// entonces ya no sere ganador
			ganador = true;

			ficha = array_tablero[0][i];
			// Si en la siguiente posicion no hay un / me interesa seguir,
			if (ficha != tablero_vacio) {
				for (int j = 1; j < array_tablero[0].length; j++) {
					if (ficha != array_tablero[j][i]) {
						// Si una ficha que esta en la misma fila no coincide con el resto, entonces no
						// hay 3 en raya
						ganador = false;
					}

				}
				if (ganador == true) {
					return ficha;
				}

			}

		}
		return tablero_vacio;

	}

	/**
	 * @param array_tablero tablero
	 * @param tablero_vacio tablero vacio
	 * @return me devuelve la ficha que ha hecho una diagonal principal
	 */
	public static char ganadorDiagonalPrincipal(char[][] array_tablero, char tablero_vacio) {
		char ficha;
		boolean ganador = true;
		ficha = array_tablero[0][0];
		// si en la posicion 0,0 tenemos una ficha, entonces, empezemos a evaluar si
		// podemos tener una diagonal principal ganadora
		if (ficha != tablero_vacio) {
			for (int i = 1; i < array_tablero.length; i++) {
				//
				if (ficha != array_tablero[i][i]) {
					ganador = false;
				}
			}
			if (ganador) {
				return ficha;
			}
		}

		return tablero_vacio;

	}

	/**
	 * Si en la posicion 0,0 tenemos una ficha, entonces, empezemos a evaluar si<br>
	 * podemos tener una diagonal principal ganadora.<br>
	 * 
	 * @param array_tablero tablero
	 * @param tablero_vacio tablero vacio
	 * @return develve true si la diagonal es correcta.
	 */
	public static char ganadorDiagonalInversa(char[][] array_tablero, char tablero_vacio) {
		char ficha;
		boolean ganador = true;
		ficha = array_tablero[0][2];
		// si en la posicion 0,0 tenemos una ficha, entonces, empezemos a evaluar si
		// podemos tener una diagonal principal ganadora
		if (ficha != tablero_vacio) {
			for (int i = 1, j = 1; i < array_tablero.length; i++, j--) {
				// las filas disminuyen
				if (ficha != array_tablero[i][j]) {
					ganador = false;
				}
			}
			if (ganador == true) {
				return ficha;
			}
		}

		return tablero_vacio;

	}

	/** Método para comprobar quien es el mejor de las tres partidas y quien ha ganado durante las 3 rondas. */
	public static void mejor_de_tres() {
		if ((contador_victorias_jug1 - contador_derrotas_jug1) == 3) {
			System.out.println("El ganador es:" + nombreJugadorSc1);
		} else if ((contador_victorias_jug1 - contador_derrotas_jug2) == (-3)) {
			System.out.println("El ganador es:" + nombreJugadorSc2);
		}
		
		if (contador_victorias_jug1>contador_victorias_jug2) {
			System.out.println("** \\ El ganador es: "+nombreJugadorSc1+" // **");
		} else if (contador_victorias_jug2>contador_victorias_jug1) {
			System.out.println("** \\ El ganador es: "+nombreJugadorSc2+" // **");
		} else if ((contador_victorias_jug2==contador_victorias_jug1) || (contador_victorias_jug1==contador_victorias_jug2)) {
			System.out.println("** \\ Empate entre los dos jugadores | ¡Buena partida! // **\n");
		}
	}

	/**
	 * Introducir y almacenar los valores de los jugadores para próximas partidas.
	 */
	public static void info() {
		// Indicamos nombres de los jugadores al comenzar el programa.
		System.out.print("Introduce el nombre del jugador 1: ");
		nombreJugadorSc1 = String.valueOf(sc.nextLine());
		System.out.print("Introduce el nombre del jugador 2: ");
		nombreJugadorSc2 = String.valueOf(sc.nextLine());
	}

	/**
	 * Método base del juego: Se desarrolla la partida y el orden de ejecución<br>
	 */
	public static void jugar() {
		// creamos las variables necesarias para el programa
		char jugador1 = 'X';
		char jugador2 = 'O';
		boolean turno = true;

		insetarDatos();
		int fil, colum;
		boolean filaCorrecta, ColumnaCorrecta, correcto;
		// Mientras no se acabe el juego lo seguimos ejecutando
		while (!gameOver(array_tablero, tablero_vacio)) {
			correcto = false;

			do {
				nombres_de_jugadores(turno);
				verTablero();
				
				System.out.print("Indique la fila: ");
				comprobarEntero();
				fil = Integer.valueOf(sc.nextInt());
				/*
				 * Le restamos uno a lo que introduce el usuario para que el usuario no tenga
				 * que empezar contando por la fila 0 y columna 0
				 */
				fil = fil - 1;
				System.out.print("Indique la columna: ");
				comprobarEntero();
				colum = Integer.valueOf(sc.nextInt());
				colum = colum - 1;

				/*
				 * hay que comprobar que los numeros que introduce el usuario son validos para
				 * nuestro array de 3x3 y tambien que donde el usuario quiera introducir un
				 * valor, la celda tiene que estar libre
				 */
				filaCorrecta = comprobarFil(array_tablero, fil);
				ColumnaCorrecta = comprobarColum(array_tablero, colum);

				if (filaCorrecta == true && ColumnaCorrecta == true) {
					// si esta el / entoces puedes escribir
					if (!estaLibre(array_tablero, fil, colum, tablero_vacio)) {
						// Le estoy diciendo que no es correcto para que recorra todo el do while
						correcto = true;
					} else {
						System.out.println(
								"¡Tramposo!, El lugar donde quiere introducir la ficha esta ocupado, introducelo en un lugar libre");
					}
				} else {
					System.out
							.println("Los números que has introducido están fuera del tablero, introducelos de nuevo");
				}
			} while (!correcto); // hasta que no se cumpla que el usuario introduzca los datos correctos el
									// programa seguirá preguntando

			// Ahora introduccimos el valor
			if (turno) {
				insertarDatos(array_tablero, fil, colum, jugador1);
			} else {
				insertarDatos(array_tablero, fil, colum, jugador2);
			}

			// cambio de turno
			turno = !turno;

		}
		verTablero();
		quienGana(array_tablero, jugador1, jugador2, tablero_vacio);
	}

	/**
	 * Métdo utilizado para realizar 3 partidas y una vez finalizen<br>
	 * Utilizar el método mejor_de_tres() para comprobar quien ha ganado<br>
	 * Luego vuelve al menú final, da varias opciones, por ejemplo:<br>
	 * Volvera jugar<br>
	 * .
	 * @throws IOException Control de errores.
	 */
	public static void jugada() throws IOException {
		System.out.println("Ronda 1");
		jugar();
		System.out.println("Ronda 2");
		jugar();
		System.out.println("Ronda 3");
		jugar();
		mejor_de_tres();
		MenuFinal_DosJugadores.Menu_final();
		//Menu.CerrarEscritura();
	}

	/**
	 * Método utilizado para llamar a la Clase desde el menú<br>
	 * Una vez llamada, almacena valores de los jugadores en el caso de qu haya
	 * habido una<br>
	 * partida anterior ó si no, pide a los jugadores introducir sus nombres.
	 * 
	 * @param args llamda_volver_A_jugar
	 * @throws IOException Control de errores.
	 */
	public static void llamada(String[] args) throws IOException {
		info();
		jugada();
	}
	
	/**
	 * Comprobar caracteres no validos.
	 */
	private static void comprobarEntero()
	{	while (!sc.hasNextInt()) {
			System.out.println("¡Vaya! Has escrito una opción no valida... ¡Recuerda introduce solo el número!\n");
			System.out.print("Indique el valor: ");
			sc.next();
		}
	}

}
