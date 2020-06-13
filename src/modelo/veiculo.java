package modelo;

public class veiculo {
	
	public int ano;
	public String cor;
	public String modelo;
	public double valor;
	
	public veiculo(){
		this(0,"","",0.0);
	}
	
	veiculo(int carroAno, String carroCor, String carroModelo, double carroValor){
		ano = carroAno;
		cor = carroCor;
		modelo = carroModelo;
		valor = carroValor;
	}
}
