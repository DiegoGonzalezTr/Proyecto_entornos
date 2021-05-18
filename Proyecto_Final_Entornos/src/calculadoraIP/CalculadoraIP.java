package calculadoraIP;

import java.util.Scanner;

public class CalculadoraIP {
	//Ips y máscaras.
	static int ip_rista1;
	static int ip_rista2;
	static int ip_rista3;
	static int ip_rista4;
	
	static int mascara_rista1;
	static int mascara_rista2;
	static int mascara_rista3;
	static int mascara_rista4;
	
	//Direcciones Ips, y máscaras concatenadas.
	String ip_concatenada;
	String ip_red;
	String ip_primera_valida;
	String ip_ultima_valida;
	String ip_broadcast;
	String mascara_concatenada;
	
	//Scanner para introducir la IP.
	Scanner sc = new Scanner(System.in);

	public CalculadoraIP(int ip_rista1, int ip_rista2, int ip_rista3, int ip_rista4, int mascara_rista1,
			int mascara_rista2, int mascara_rista3, int mascara_rista4, String ip_concatenada, String ip_red,
			String ip_primera_valida, String ip_ultima_valida, String ip_broadcast, String mascara_concatenada) {
		super();
		CalculadoraIP.ip_rista1 = ip_rista1;
		CalculadoraIP.ip_rista2 = ip_rista2;
		CalculadoraIP.ip_rista3 = ip_rista3;
		CalculadoraIP.ip_rista4 = ip_rista4;
		CalculadoraIP.mascara_rista1 = mascara_rista1;
		CalculadoraIP.mascara_rista2 = mascara_rista2;
		CalculadoraIP.mascara_rista3 = mascara_rista3;
		CalculadoraIP.mascara_rista4 = mascara_rista4;
		this.ip_concatenada = ip_concatenada;
		this.ip_red = ip_red;
		this.ip_primera_valida = ip_primera_valida;
		this.ip_ultima_valida = ip_ultima_valida;
		this.ip_broadcast = ip_broadcast;
		this.mascara_concatenada = mascara_concatenada;
	}


	public int getIp_rista1() {
		return ip_rista1;
	}
	
	public void setIp_rista1(int ip_rista1) {
		CalculadoraIP.ip_rista1 = ip_rista1;
	}
	
	public int getIp_rista2() {
		return ip_rista2;
	}
	
	public void setIp_rista2(int ip_rista2) {
		CalculadoraIP.ip_rista2 = ip_rista2;
	}

	public int getIp_rista3() {
		return ip_rista3;
	}

	public void setIp_rista3(int ip_rista3) {
		CalculadoraIP.ip_rista3 = ip_rista3;
	}

	public int getIp_rista4() {
		return ip_rista4;
	}

	public void setIp_rista4(int ip_rista4) {
		CalculadoraIP.ip_rista4 = ip_rista4;
	}

	public int getMascara_rista1() {
		return mascara_rista1;
	}

	public void setMascara_rista1(int mascara_rista1) {
		CalculadoraIP.mascara_rista1 = mascara_rista1;
	}

	public int getMascara_rista2() {
		return mascara_rista2;
	}

	public void setMascara_rista2(int mascara_rista2) {
		CalculadoraIP.mascara_rista2 = mascara_rista2;
	}

	public int getMascara_rista3() {
		return mascara_rista3;
	}

	public void setMascara_rista3(int mascara_rista3) {
		CalculadoraIP.mascara_rista3 = mascara_rista3;
	}

	public int getMascara_rista4() {
		return mascara_rista4;
	}

	public void setMascara_rista4(int mascara_rista4) {
		CalculadoraIP.mascara_rista4 = mascara_rista4;
	}

	public String getIp_concatenada() {
		return ip_concatenada;
	}

	public void setIp_concatenada(String ip_concatenada) {
		this.ip_concatenada = ip_concatenada;
	}

	public String getIp_red() {
		return ip_red;
	}

	public void setIp_red(String ip_red) {
		this.ip_red = ip_red;
	}

	public String getIp_primera_valida() {
		return ip_primera_valida;
	}

	public void setIp_primera_valida(String ip_primera_valida) {
		this.ip_primera_valida = ip_primera_valida;
	}

	public String getIp_ultima_valida() {
		return ip_ultima_valida;
	}

	public void setIp_ultima_valida(String ip_ultima_valida) {
		this.ip_ultima_valida = ip_ultima_valida;
	}

	public String getIp_broadcast() {
		return ip_broadcast;
	}

	public void setIp_broadcast(String ip_broadcast) {
		this.ip_broadcast = ip_broadcast;
	}

	public String getMascara_concatenada() {
		return mascara_concatenada;
	}

	public void setMascara_concatenada(String mascara_concatenada) {
		this.mascara_concatenada = mascara_concatenada;
	}

	@Override
	public String toString() {
		return "CalculadoraIP [ip_rista1=" + ip_rista1 + ", ip_rista2=" + ip_rista2 + ", ip_rista3=" + ip_rista3
				+ ", ip_rista4=" + ip_rista4 + ", mascara_rista1=" + mascara_rista1 + ", mascara_rista2="
				+ mascara_rista2 + ", mascara_rista3=" + mascara_rista3 + ", mascara_rista4=" + mascara_rista4
				+ ", ip_concatenada=" + ip_concatenada + ", ip_red=" + ip_red + ", ip_primera_valida="
				+ ip_primera_valida + ", ip_ultima_valida=" + ip_ultima_valida + ", ip_broadcast=" + ip_broadcast
				+ ", mascara_concatenada=" + mascara_concatenada + "]";
	}
	
	public static void Insertar_IP()
	{	System.out.println("Inserte 1º Valor de la IP:");
		ip_rista1=0;
	}
	
	public static void main(String[] args) {
	}

}
