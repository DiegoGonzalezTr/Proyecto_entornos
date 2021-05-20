package tresEnRaya;

import java.util.Scanner;
/**
 * 
 * @author Diego Gonzalez Tripero.
 *
 */

public class TresEnRaya {
	public static char array_tablero[][] = new char[3][3];
	public static char tablero_vacio = '/';
	public static Scanner sc = new Scanner(System.in);
	public static  String nombreJugadorSc1, nombreJugadorSc2;
	// Para insertar datos en la matriz hacemos lo siguiente:
	public static void insetarDatos() {
		for (int i = 0; i < array_tablero.length; i++) {
			for (int j = 0; j < array_tablero.length; j++) {
				array_tablero[i][j] = tablero_vacio;
			}

		}
	}

	public static void quienGana(char[][] array_tablero, char jugador1, char jugador2, char tablero_vacio) {

		char  ficha = ganadorLinea(array_tablero,tablero_vacio);
		
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
			
			System.out.println("Gana  "+ nombreJugadorSc1 + " porque ha hecho una linea");
		} else {
			System.out.println("Gana  "+ nombreJugadorSc2 + " porque ha hecho una linea");
			}
		}
		
		

		ficha = ganadorColumna(array_tablero, tablero_vacio);
		
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
			
			System.out.println("Gana  "+ nombreJugadorSc1 + " porque ha hecho una columna");
		} else {
			System.out.println("Gana "+ nombreJugadorSc2 +" porque ha hecho una columna");
			}
		}
		
		
		ficha = ganadorDiagonalPrincipal(array_tablero, tablero_vacio);
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
			
			System.out.println("Gana  "+ nombreJugadorSc1  +" porque ha hecho una diagonal principal");
		} else {
			System.out.println( "Gana  "+ nombreJugadorSc2 + " porque ha hecho una diagonal principal");
			}
		}	
		
		
		
		ficha = ganadorDiagonalInversa(array_tablero, tablero_vacio);
		
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
			
			System.out.println("Gana  "+ nombreJugadorSc1 + " porque ha hecho una diagonal inversas");
		} else {
			System.out.println("Gana  " +nombreJugadorSc2 +" porque ha hecho una diagonal inversa");
			}
		}	
	}

	public static boolean gameOver(char[][] array_tablero, char tablero_vacio) {
		// Si tenemos linea, columna , diagonales o toda la matriz llena, la partida
		// acaba
		if (matrizCompleta(array_tablero, tablero_vacio)
				|| ganadorColumna(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorLinea(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorDiagonalPrincipal(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorDiagonalInversa(array_tablero, tablero_vacio) != tablero_vacio) {
			return true;
		}
		return false;
	}

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
		return true;
	}

	// metodo que usamos para saber si donde queremos poener un valor esta vacio o
	// no
	public static boolean estaLibre(char[][] array_tablero, int fil, int colum, int tablero_vacio) {
		if (array_tablero[fil][colum] != tablero_vacio) {
			return true;
		}
		return false;
	}

	// Con este metodo insetamos las fichas en el array
	public static void insertarDatos(char[][] array_tablero, int fil, int colum, char tablero_vacio) {
		array_tablero[fil][colum] = tablero_vacio;
	}

	public static void verTablero() {
		for (int i = 0; i < array_tablero.length; i++) {
			for (int j = 0; j < array_tablero[0].length; j++) {
				System.out.print(array_tablero[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	public static void turnos(boolean turno) {
		if (turno) {
			System.out.println(nombreJugadorSc1);
		} else {
			System.out.println(nombreJugadorSc2);
		}
	}

	// Comprobar fila
	/**
	 * 
	 * @param array_tablero
	 * @param fil
	 * @return
	 */
	public static boolean comprobarFil(char[][] array_tablero, int fil) {
		//Si el numero de fila que introduce el usuario esta entre 0 y 3 entonce es correcto (true)
		if (fil >= 0 && fil <= array_tablero.length) {
			return true;
		}
		return false;
	}

	// Comprobar columna
	public static boolean comprobarColum(char[][] array_tablero, int colum) {
		//Si el numero de columna que introduce el usuario esta entre 0 y 3 entonce es correcto (true)
		if (colum >= 0  && colum <= array_tablero.length) {
			return true;
		}
		return false;
	}

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
	 * 
	 * @param array_tablero
	 * @param tablero_vacio
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

	public static char ganadorDiagonalInversa(char[][] array_tablero, char tablero_vacio) {
		char ficha;
		boolean ganador = true;
		ficha = array_tablero[0][2];
		// si en la posicion 0,0 tenemos una ficha, entonces, empezemos a evaluar si
		// podemos tener una diagonal principal ganadora
		if (ficha != tablero_vacio) {
			for (int i = 1, j=1; i < array_tablero.length;i++,j--) {
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

		

	

	public static void main(String[] args) {
		// creamos las variables necesarias para el programa
		char jugador1 = 'X';
		char jugador2 = 'O';
		boolean turno = true;
		insetarDatos();
		int fil, colum;
		boolean filaCorrecta, ColumnaCorrecta, correcto;
		
		System.out.println("Introduce el nombre del jugador 1");
		nombreJugadorSc1= String.valueOf(sc.nextLine());
		
		System.out.println("Introduce el nombre del jugador 2");
		nombreJugadorSc2 = String.valueOf(sc.nextLine());
		
		//Mientras no se acabe el juego lo seguimos ejecutando
		while (!gameOver(array_tablero, tablero_vacio)) {
			
			
			do {
				turnos(turno);
				verTablero();
				correcto = false;
							
				
				System.out.println("Indique la fila");
				fil = Integer.valueOf(sc.nextInt());
				/*Le restamos uno a lo que introduce el usuario para que el usuario no tenga que empezar contando por
				 * la fila 0 y columna 0
				 */
				fil=fil-1;
				System.out.println("Indique la columna");
				colum = Integer.valueOf(sc.nextInt());
				colum=colum-1;
				
				/*
				 * hay que comprobar que los numeros que introduce el usuario son validos para
				 * nuestro array de 3x3 y tambien que donde el usuario quiera introducir un
				 * valor, la celda tiene que estar libre
				 */
				filaCorrecta = comprobarFil(array_tablero, fil);
				ColumnaCorrecta = comprobarColum(array_tablero, colum);

				if (filaCorrecta==true && ColumnaCorrecta==true) {
					// si esta el / entoces puedes escribir
					if (!estaLibre(array_tablero, fil, colum, tablero_vacio)) {
						// Le estoy diciendo que no es correcto para que recorra todo el do while
						correcto = true;
					} else {
						System.out.println(
								"¡Tramposo!, El lugar donde quiere introducir la ficha esta ocupado, introducelo en un lugar libre");
					}
				} else {
					System.out.println("Los números que has introducido están fuera del tablero, introducelos de nuevo");
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

}
