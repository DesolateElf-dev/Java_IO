package grava;
import java.io.*;	
import javax.swing.*;
import modelo.veiculo;

public class GravaCarros {
	
	public static void main (String args[]) throws IOException {
		
		veiculo[] carro = new veiculo[3];
		String filename = "Carros.txt";
		int i;
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		
		for(i=0; i<3; i++) {	
			carro[i] = new veiculo();
		}
			
			for(i=0;i<3;i++) {
				
				carro[i].ano = Integer.parseInt(JOptionPane.showInputDialog("Ano do ve�culo"));
				writer.write(Integer.toString(carro[i].ano));
				writer.newLine();
				carro[i].cor = JOptionPane.showInputDialog("Digite a cor do ve�culo");
				writer.write(carro[i].cor);
				writer.newLine();
				carro[i].modelo = JOptionPane.showInputDialog("Digite o modelo do ve�culo");
				writer.write(carro[i].modelo);
				writer.newLine();
				carro[i].valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do ve�culo"));
				writer.write(Double.toString(carro[i].valor));
				writer.newLine();				
			}
		writer.close();	
		System.exit(0);
	}
}
