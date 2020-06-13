package control;

import javax.swing.JOptionPane;

import modelo.Funcionario;

public class ExFuncionarios {

	public static void main(String[] args) {
		
		int a=3;
		Funcionario[] funcionarios = new Funcionario[a];
		int opc=0;
		while(opc!=9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastro de funcionários   \n2 - Exibe funcionários cadastrados   \n9 - Finaliza o programa"));
			switch(opc) {
			case 1: geraCadastro(funcionarios);
			break;
			case 2: exibeResultado(funcionarios);
			break;
			case 9: System.out.println("Programa Finalizado");
			System.exit(0);
			}
		}
	}
	
	static void geraCadastro(Funcionario funcionario[]) {
		
		for(int i=0;i<funcionario.length;i++) {
			funcionario[i] = new Funcionario();
		}
		
		
		for(int i=0;i<funcionario.length;i++) {
			funcionario[i].cod = i+1;//Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionário"));
			funcionario[i].nome = "Eduardo";//JOptionPane.showInputDialog("Digite o nome do funcionário");
			funcionario[i].salb = ((i+1)*10);//Double.parseDouble(JOptionPane.showInputDialog("Digite o salário Bruto"));
			funcionario[i].bonus = i+1;//Integer.parseInt(JOptionPane.showInputDialog("Digite o bonus do funcionário: \n1 - 10% do salario_bruto   \n2 - 15% do salario_bruto   \n3 - 20% do salario_bruto   \n4 - 25% do salario_bruto"));
			switch(funcionario[i].bonus) {
			case 1: funcionario[i].saltotal = ((funcionario[i].salb)*0.9)+(funcionario[i].salb*0.1);
			break;
			case 2: funcionario[i].saltotal = ((funcionario[i].salb)*0.9)+(funcionario[i].salb*0.15);
			break;
			case 3: funcionario[i].saltotal = ((funcionario[i].salb)*0.9)+(funcionario[i].salb*0.2);
			break;
			case 4: funcionario[i].saltotal = ((funcionario[i].salb)*0.9)+(funcionario[i].salb*0.25);
			break;
			}
		}
	}
	
	
	
	static void exibeResultado(Funcionario funcionario[]) {
		for(int i=0;i<funcionario.length;i++) {
			System.out.println("Código: "+funcionario[i].cod+"\nNome: "+funcionario[i].nome+"\nSalário Bruto: R$"+funcionario[i].salb+"\nBonus: "+funcionario[i].bonus+"\nSalário à Receber: R$"+funcionario[i].saltotal);
			System.out.println("\n");
		}
	}

}
