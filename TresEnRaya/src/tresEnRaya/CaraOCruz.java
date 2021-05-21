package tresEnRaya;

public class CaraOCruz {
	public static int valorMoneda;
	public static int min,max;
	
	public static void LanzarMonedaCaraOCruz() {
		min=0;max=1;
		valorMoneda = (int) (min-(Math.random()*(max-min+1)));
		if (valorMoneda==0) {
			System.out.println("Turno de Jugador 1: "+TresEnRaya.nombreJugadorSc1);
			TresEnRaya.empiezaJugador1=true;
			
		} else if (valorMoneda==1) {
			System.out.println("Turno de Jugador 2: "+TresEnRaya.nombreJugadorSc2);
			TresEnRaya.empiezaJugador2=true;
		}
	}
	
	public static void main(String[] args) {
		LanzarMonedaCaraOCruz();
	}

}
