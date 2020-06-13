package modelo;

public class Funcionario {
	
	public int cod;
	public String nome;
	public double salb;
	public int bonus;
	public double saltotal;
	
	public Funcionario(){
		this(0,"",0.0,0,0.0);
	}
	
	Funcionario(int codigo, String nomeFuncionario, double salarioBruto, int bônus, double salarioTotal){
		cod = codigo;
		nome = nomeFuncionario;
		salb = salarioBruto;
		bonus = bônus;
		saltotal = salarioTotal;
		
	}

}
