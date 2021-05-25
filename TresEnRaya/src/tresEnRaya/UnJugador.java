package tresEnRaya;

import java.util.Scanner;

/**
 * @author Diego Gonzalez Tripero. [Más productivo].
 * @author Javier Hernandez Fernandez.
 * @author Jesús Blanco Antoraz.
 */
public class UnJugador {
	//Atributos de la clase: UnJugador.
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
	
	
	// A partir de abajo se incluyen los métodos.
	// Contadores de Vic/Derr/Empt de partidas.
	public static void MostrarInfoContadores()
	{	System.out.println(" *** | INFO CONTADORES | ***\n"
		+nombre_jugador+" \tVict:"+contador_victorias_jug1+" Derr: "+contador_derrotas_jug1+" Empt: "+contador_empates_jug+"\n" 
		+nombre_BOT+" \tVict: "+contador_victorias_jug2+" Derr: "+contador_derrotas_jug2+" Empt: "+contador_empates_jug+"\n"
		);
	}
	
	// Introducir nombres de jugadores.
	public static void IntroduzcaSuNombre()
	{	System.out.println("Introduzca su nombre: ");
		nombre_jugador= String.valueOf(sc.nextLine());
	}
	
	// Mostrar turnos con nombres de jugadores.
	public static void nombres_de_jugadores(boolean turno) {
		if (turno) {
			System.out.println(nombre_jugador);
		} else {
			System.out.println(nombre_BOT);
		}
	}
	
	// Mostrar el tablero de juego.
	public static void verTablero() {
		for (int i = 0; i < array_tablero.length; i++) {
			for (int j = 0; j < array_tablero[0].length; j++) {
				System.out.print(array_tablero[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	
	// Inserta datos en el tablero.
	public static void insetarDatos() {
		for (int i = 0; i < array_tablero.length; i++) {
			for (int j = 0; j < array_tablero.length; j++) {
				array_tablero[i][j] = tablero_vacio;
			}
		}
	}
	
	// Insertar ficha de juego en el tablero.
	public static void insertarDatos(char[][] array_tablero, int fil, int colum, char tablero_vacio) {
		array_tablero[fil][colum] = tablero_vacio;
	}
	
	// Juego Tres en Raya.
	public static void jugar() {
		// creamos las variables necesarias para el programa
		char jugador1 = 'X';
		char jugador2 = 'O';
		boolean turno = true;
		insetarDatos();
		
		// Incializamos la variable para poder usar los valores después del IF.
		int fil=0, colum = 0;
		boolean filaCorrecta, ColumnaCorrecta, correcto;
		//Mientras no se acabe el juego lo seguimos ejecutando
		while (!gameOver(array_tablero, tablero_vacio)) {
			
			
			do {
				nombres_de_jugadores(turno);
				//CaraOCruz.LanzarMonedaCaraOCruz();
				verTablero();
				correcto = false;
							
				if (turno==true) {
				System.out.println("Indique la fila");
				fil = Integer.valueOf(sc.nextInt());
				/*Le restamos uno a lo que introduce el usuario para que el usuario no tenga que empezar contando por
				 * la fila 0 y columna 0 de esta forma es mucho mas sencillo para usuarios no normales.
				 */
				fil=fil-1;
				System.out.println("Indique la columna");
				colum = Integer.valueOf(sc.nextInt());
				colum=colum-1;
				
				/* Aquí añado que si el turno es de el BOT, las posiciones
				 * dónde vaya a incluir la ficha serán aleatorios, si está ocupada generará
				 * otra posición aleatorio así hasta que ocupe la posición correcta que esté
				 * vacia. No hay criterio de filas ni columnas solo aleatoriamente.
				 */
				} else if (turno==false) {
					int Fmin=1, Fmax=3;
					int Cmin=1, Cmax=3;
					fil = (int) (Fmin+(Math.random()*(Fmax-Fmin+1)));
					fil=fil-1;
					
					colum = (int) (Cmin+(Math.random()*(Cmax-Cmin+1)));
					colum=colum-1;
				}
				
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
	
	// Comprobar Filas.
	public static boolean comprobarFil(char[][] array_tablero, int fil) {
		//Si el numero de fila que introduce el usuario esta entre 0 y 3 entonce es correcto (true)
		if (fil >= 0 && fil <= array_tablero.length) {
			return true;
		}
		return false;
	}

	// Comprobar columna.
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
		contador_empates_jug++;
		MostrarInfoContadores();
		System.out.println("Empate");
		return true;
	}

	// Caso de ganador en Columna.
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
	
	// Caso de ganador de Linea.
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
	
	// Caso de ganador en Diagonal 1.
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

	// Caso de ganador en Diagonal 2.
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

	// Casos de finalización del juego.
	public static boolean gameOver(char[][] array_tablero, char tablero_vacio) {
		// Si tenemos linea, columna , diagonales o toda la matriz llena, la partida finaliza.
		if (matrizCompleta(array_tablero, tablero_vacio)
				|| ganadorColumna(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorLinea(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorDiagonalPrincipal(array_tablero, tablero_vacio) != tablero_vacio
				|| ganadorDiagonalInversa(array_tablero, tablero_vacio) != tablero_vacio){
			return true;
		}
		return false;
	}
	
	// Casos de victoria en el juego.
	public static void quienGana(char[][] array_tablero, char jugador1, char jugador2, char tablero_vacio) {
		char  ficha;
		boolean empate=false;
		
		// Empate.
		if(empate==true) {
			System.out.println("Empate");
		} else {
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
	
	// Caso que indica quien ha sido el mejor en las tres partidas. Según Victorias/Derrotas.
	public static void mejor_de_tres() {
		if((contador_victorias_jug1-contador_derrotas_jug1)==3){
			System.out.println("El ganador es:" + nombre_jugador);
		}else if((contador_victorias_jug1-contador_derrotas_jug2)==(-3)) {
			System.out.println("El ganador es:" + nombre_BOT);
		}
	}
	
	// Main, ejecución del programa orden.
	public static void main(String[] args) {
		IntroduzcaSuNombre();
		jugar();
		jugar();
		jugar();
		mejor_de_tres();
		MenuFinal.Menu_final();
	}

}
