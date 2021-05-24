package tresEnRaya;

import java.util.Scanner;

/**
 * @author Diego Gonzalez Tripero. [Más productivo].
 * @author Javier Hernandez Fernandez.
 * @author Jesús Blanco Antoraz.
 */
public class UnJugador {
	// Tablero de juego:
	public static char array_tablero[][] = new char[3][3];
	public static char tablero_vacio = '/';
	
	// Datos:
	public static String nombre_jugador;
	public static String nombre_BOT="BOT";
	public static Scanner sc = new Scanner(System.in);
	
	// Contadores de juego:
	public static int contador_victorias_jug1=0;
	public static int contador_victorias_jug2=0;
	public static int contador_derrotas_jug1=0;
	public static int contador_derrotas_jug2=0;
	public static int contador_empates_jug=0;
	
	public static void MostrarInfoContadores()
	{	System.out.println(" *** | INFO CONTADORES | ***\n"
		+nombre_jugador+" \tVict:"+contador_victorias_jug1+" Derr: "+contador_derrotas_jug1+" Empt: "+contador_empates_jug+"\n" 
		+nombre_BOT+" \tVict: "+contador_victorias_jug2+" Derr: "+contador_derrotas_jug2+" Empt: "+contador_empates_jug+"\n"
		);
	}
	
	public static void IntroduzcaSuNombre()
	{	System.out.println("Introduzca su nombre: ");
		nombre_jugador= String.valueOf(sc.nextLine());
	}
	
	public static void nombres_de_jugadores(boolean turno) {
		if (turno) {
			System.out.println(nombre_jugador);
		} else {
			System.out.println(nombre_BOT);
		}
	}
	
	public static void verTablero() {
		for (int i = 0; i < array_tablero.length; i++) {
			for (int j = 0; j < array_tablero[0].length; j++) {
				System.out.print(array_tablero[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	
	public static void insetarDatos() {
		for (int i = 0; i < array_tablero.length; i++) {
			for (int j = 0; j < array_tablero.length; j++) {
				array_tablero[i][j] = tablero_vacio;
			}
		}
	}
	
	public static void insertarDatos(char[][] array_tablero, int fil, int colum, char tablero_vacio) {
		array_tablero[fil][colum] = tablero_vacio;
	}
	
	
	
	public static void jugar() {
		// creamos las variables necesarias para el programa
		char jugador1 = 'X';
		char jugador2 = 'O';
		boolean turno = true;
		insetarDatos();
		int fil, colum;
		boolean filaCorrecta, ColumnaCorrecta, correcto;
		//Mientras no se acabe el juego lo seguimos ejecutando
		while (!gameOver(array_tablero, tablero_vacio)) {
			
			
			do {
				nombres_de_jugadores(turno);
				//CaraOCruz.LanzarMonedaCaraOCruz();
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
	
	// Comprobar que la Fila/Celda está libre.
	public static boolean estaLibre(char[][] array_tablero, int fil, int colum, int tablero_vacio) {
		if (array_tablero[fil][colum] != tablero_vacio) {
			return true;
		}
		return false;
	}
	
	public static boolean gameOver(char[][] array_tablero, char tablero_vacio) {
		// Si tenemos linea, columna , diagonales o toda la matriz llena, la partida
		// acaba
		if (matrizCompleta(array_tablero, tablero_vacio)
				|| ganadorColumna(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorLinea(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorDiagonalPrincipal(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorDiagonalInversa(array_tablero, tablero_vacio) != tablero_vacio){
			return true;
		}
		return false;
	}
	
	public static void quienGana(char[][] array_tablero, char jugador1, char jugador2, char tablero_vacio) {
		char  ficha;
		boolean empate=false;
		
		// Empate.
		if(empate==true) {
			System.out.println("Empate");
		}
		ficha = ganadorLinea(array_tablero,tablero_vacio);
		
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
			System.out.println("Gana  "+ nombre_jugador + " porque ha hecho una linea");
			contador_victorias_jug1++;
			contador_derrotas_jug2++;
			MostrarInfoContadores();
			
		} else if(ficha != jugador1) {
			System.out.println("Gana  "+ nombre_BOT + " porque ha hecho una linea");
			contador_victorias_jug2++;
			contador_derrotas_jug1++;
			MostrarInfoContadores();
			}
		}
		
		// Ganador: Columna.
		ficha = ganadorColumna(array_tablero, tablero_vacio);
		
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
			
			System.out.println("Gana  "+ nombre_jugador + " porque ha hecho una columna");
			contador_victorias_jug1++;
			contador_derrotas_jug2++;
			MostrarInfoContadores();
			
		} else {
			System.out.println("Gana "+ nombre_BOT +" porque ha hecho una columna");
			contador_victorias_jug2++;
			contador_derrotas_jug1++;
			MostrarInfoContadores();
			}
		}
		
		// Ganador: Diagonal.
		ficha = ganadorDiagonalPrincipal(array_tablero, tablero_vacio);
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
			System.out.println("Gana  "+ nombre_jugador  +" porque ha hecho una diagonal principal");
			contador_victorias_jug1++;
			contador_derrotas_jug2++;
			MostrarInfoContadores();
			
		} else {
			System.out.println( "Gana  "+ nombre_BOT + " porque ha hecho una diagonal principal");
			contador_victorias_jug2++;
			contador_derrotas_jug1++;
			MostrarInfoContadores();
			}
		}	
		
		// Ganador: Diagonal Inversa.
		ficha = ganadorDiagonalInversa(array_tablero, tablero_vacio);
		
		if (ficha != tablero_vacio) {
			if (ficha == jugador1) {
			System.out.println("Gana  "+ nombre_jugador + " porque ha hecho una diagonal inversas");
			contador_victorias_jug1++;
			contador_derrotas_jug2++;
			MostrarInfoContadores();
			
		} else {
			System.out.println("Gana  " +nombre_BOT +" porque ha hecho una diagonal inversa");
			contador_victorias_jug2++;
			contador_derrotas_jug1++;
			MostrarInfoContadores();
			}
		}	
		
	}
	
	public static void main(String[] args) {
	}

}
