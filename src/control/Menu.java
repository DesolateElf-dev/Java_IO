package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

import modelo.veiculo;

public class Menu {

	public static void main(String[] args) throws IOException {
		//valor que pode ser alterado, mudando a quantidade de cadastros de veículos que será feita
		int a = 50;
		
		veiculo[] carro = new veiculo[a];
		int opc=0;

		while(opc!=9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar "+a+" veículos  \n2- Gerar arquivo com cadastros  \n3 - Ler arquivo de veículos  \n4 - Mostra os veículos de maior valor  \n5 - Buscar por limite de valor  \n6 - Gera cadastros aleatórios  \n9 - Finalizar"));
			switch (opc){
	    		case 1: CadastraCarros(carro);
	    			break;
	    		case 2: GravaCarros(carro);
	    			break;
	    		case 3: {
	    			carro = LerCarros(carro);
	    			for(int i=0;i<a;i++) {
	    				System.out.println("Ano: "+carro[i].ano+"\nCor: "+carro[i].cor+"\nModelo: "+carro[i].modelo);
	    				System.out.printf("Valor: R$%.2f %n", carro[i].valor);
	    				System.out.println("");
	    			}
	    			System.out.println("-----------------");	
	    		}
	    			break;	
	    		case 4: buscaValorMaior(carro);
	    			break;
	    		case 5: buscaValorLimite(carro);
	    			break;
	    		case 6: GeraValores(carro);
	    			break;
	    		case 9: {
	    			System.out.println("Programa Finalizado");
	    			System.exit(0);
	    		}
	    		default: JOptionPane.showMessageDialog(null,"Inválido");
			}
		}
	}
	
	
	
	
	static void CadastraCarros(veiculo carros[]) {
		
		for(int i=0; i<carros.length; i++) {	
			carros[i] = new veiculo();
		}
		
		for(int i=0;i<carros.length;i++) {
			
			carros[i].ano = Integer.parseInt(JOptionPane.showInputDialog("Ano do veículo"));
			carros[i].cor = JOptionPane.showInputDialog("Digite a cor do veículo");
			carros[i].modelo = JOptionPane.showInputDialog("Digite o modelo do veículo");
			carros[i].valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do veículo"));
		}
		
	}
	
	
	static void GravaCarros(veiculo carros[]) throws IOException {
		String filename = "Carros.txt";
		int i;
		BufferedWriter escrever = new BufferedWriter(new FileWriter(filename));

		for(i=0;i<carros.length;i++) {
				
			escrever.write(Integer.toString(carros[i].ano));
			escrever.newLine();
			escrever.write(carros[i].cor);
			escrever.newLine();
			escrever.write(carros[i].modelo);
			escrever.newLine();
			escrever.write(Double.toString(carros[i].valor));
			escrever.newLine();
		}
		escrever.close();
		JOptionPane.showMessageDialog(null,"Arquivo Gerado com Sucesso");
	}
	

	public static veiculo[] LerCarros(veiculo carros[]) throws IOException {
		String filename = "Carros.txt";
		BufferedReader ler = new BufferedReader(new FileReader(filename));
		
		for(int i=0;i<carros.length;i++) {
			carros[i] = new veiculo();
		}
			
			for(int i=0;i<carros.length;i++) {
				
				carros[i].ano = Integer.parseInt(ler.readLine());
				carros[i].cor = ler.readLine();				
				carros[i].modelo = ler.readLine();
				carros[i].valor = Double.parseDouble(ler.readLine());
			}
		ler.close();
		return(carros);
	}
	
	
	static void buscaValorMaior(veiculo carros[]) {
		veiculo[] aux = new veiculo[carros.length];
		//ordenando vetor em order decrescente
		for(int i=0;i<(carros.length);i++){
			for(int j=0;j<carros.length;j++) {
				if(carros[j].valor<carros[i].valor) {
					aux[1] = carros[i];
					carros[i] = carros[j];
					carros[j] = aux[1];
				}
			}
		}
		
		int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite quantos veículos deseja"));
		//escreve os valores na console
		System.out.println("Consulta dos "+quantidade+" veículos mais caros cadastrados:");
		for(int i=0;i<quantidade;i++) {
			System.out.println("Ano: "+carros[i].ano+"\nCor: "+carros[i].cor+"\nModelo: "+carros[i].modelo);
			System.out.printf("Valor: R$%.2f %n", carros[i].valor);
			System.out.println("");
		}
		System.out.println("-----------------");
	}
	
	
	static void buscaValorLimite(veiculo carros[]) {
		veiculo[] aux = new veiculo[carros.length];
		int cont=0;
		double limite = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite de valor para efetuar a busca"));
		//ordena o vetor em ordem crescente
		for(int i=0;i<(carros.length);i++){
			for(int j=0;j<carros.length;j++) {
				if(carros[i].valor<carros[j].valor) {
					aux[1] = carros[i];
					carros[i] = carros[j];
					carros[j] = aux[1];
				}
			}
		}
		if(limite<carros[0].valor) {
			System.out.println("Veículo abaixo ou igual ao limite não encontrado");
		}
		else {
			for(int i=0;i<carros.length;i++) {
				if(carros[i].valor<=limite) {
					System.out.println("Ano: "+carros[i].ano+"\nCor: "+carros[i].cor+"\nModelo: "+carros[i].modelo);
					System.out.printf("Valor: R$%.2f %n", carros[i].valor);
					System.out.println("");
					cont++;
				}
			}
		}
		System.out.println(cont+" veículo(s) encontrado(s)");
		System.out.println("-----------------");
	}
	
	
	static void GeraValores(veiculo carros[]) throws IOException {
		
		Random gerador = new Random();
		String filename = "Carros.txt";
		String cor;
		String modelo;
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		
		for(int i=0;i<carros.length;i++) {
			carros[i] = new veiculo();
		}
		for(int i=0;i<carros.length;i++) {
			
			carros[i].ano = (gerador.nextInt(30))+1990;
			writer.write(Integer.toString(carros[i].ano));
			writer.newLine();
			//Gera cores para os veículos
			if(carros[i].ano%2==0) {
				cor = "Preto";
			}else {
				if(carros[i].ano%3==0) {
					cor = "Branco";
				}else {
					if(carros[i].ano%5==0) {
						cor = "Cinza";
					}else {
						cor = "Prata";
					}
				}
			}		
			carros[i].cor = cor;
			writer.write(carros[i].cor);
			writer.newLine();
			
			//Gera modelos para os veículos
			if(carros[i].ano%2==0) {
				modelo = "Uno";
			}else {
				if(carros[i].ano%3==0) {
					modelo = "Corsa";
				}else {
					if(carros[i].ano%5==0) {
						modelo = "Onix";
					}else {
						modelo = "HB20";
					}
				}
			}	
					
			carros[i].modelo = modelo;
			writer.write(carros[i].modelo);
			writer.newLine();
			carros[i].valor = (gerador.nextDouble())*100000;
			writer.write(Double.toString(carros[i].valor));
			writer.newLine();
		}
		writer.close();
		JOptionPane.showMessageDialog(null,"Arquivo Gerado com Sucesso");
		System.out.println(carros.length+" cadastros criados");
		System.out.println("-----------------");
	}
	
		
}
