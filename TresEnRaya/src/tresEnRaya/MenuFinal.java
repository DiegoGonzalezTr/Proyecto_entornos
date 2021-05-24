package tresEnRaya;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Javier Hern�ndez
 */

public class MenuFinal {
	public static Scanner escribir = new Scanner(System.in);
	public static int opcion=0;
    public static boolean check = false;
    
	
	public static void Menu_final()
	{	
		try {	
			do {	
				System.out.println
				(" * * * MEN� FINAL * * * \n"
				+"  [1] | Volver a jugar\n"
				+"  [2] | Regresar al men� inicial\n"
				+"  [3] | Salir del juego.\n\n"
				+"  Cr�ditos: @Diego_Gonzalez | @Jes�s_Blanco | @Javier_Hern�ndez\n");
			
				System.out.print("\nEliga una opci�n del Men�: ");
				opcion = escribir.nextInt();
				
				if (opcion==1) {
					System.out.println(" \n*** Ha selecionado: Volver a jugar ***");
				//	LLamar a metodo
					TresEnRaya.jugar();
					
				} else if (opcion==2) {
					System.out.println(" \n*** Ha selecionado: Regresar al men� inicial ***");
					Menu.Menu_inicio();
					
				} else if (opcion==3) {
					System.out.println(" \n*** Ha selecionado: Salir del juego ***");
					
				
				} else if (opcion>=3 || opcion<=0) {
					System.out.println(" \n*** �Debes selecionar una opci�n valida! ***");
					
				} else if (opcion == (int) opcion) {
					check = false;
				} 
				
			} while (!(opcion==3));
			
		} catch (InputMismatchException e) {
			System.out.println("Seleciona una opci�n, en formato digito.");
			System.out.print("\nEliga una opci�n del Men�: ");
			opcion = escribir.nextInt();
		    check = true;
		}
		
	}
	



}
