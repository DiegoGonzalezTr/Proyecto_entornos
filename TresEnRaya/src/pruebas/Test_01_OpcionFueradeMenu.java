package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tresEnRaya.Menu;

class Test_01_OpcionFueradeMenu {

	@Test
	/** Prueba el 1º Test de caja blanca.
	 * Opcion 4 es una opción valida del menú.
	 */
	void test() {
		Menu.opcion = 4;
		assertEquals(Menu.opcion, 4);
	}

}
