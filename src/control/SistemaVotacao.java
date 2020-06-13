package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

import modelo.votacao;

public class SistemaVotacao {

	public static void main(String[] args) throws IOException {
		int a= 100;
		votacao[] votos = new votacao[a];
		int opc =0;
		
		while(opc!=9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 – Carregar Seção/Número Eleitor \n2 – Classificar por Seção  \n3 – Gravar Registros  \n4 – Mostrar Indicadores  \n5 - Exibe na console   \n9 – Finalizar"));
			switch (opc){
			case 1: votos = FCADASTRAVOTACAO(a);
			break;
			case 2: votos = FCLASSIFICASECAO(votos,a);
			break;
			case 3: gravaDados(votos);
			break;
			case 5: exibeDados(votos);
			break;
			case 9: {
				System.out.println("Programa Finalizado");
				System.exit(0);
			}
			}
		}
	}
	
	
	
	
	public static votacao[] FCADASTRAVOTACAO(int a){
		votacao[] voto = new votacao[a];
		Random gerador = new Random();
		
		for(int i=0;i<a;i++) {
			voto[i] = new votacao();
		}
		
		for(int i=0;i<a;i++) {
			voto[i].secao = gerador.nextInt(11);
			voto[i].candidato = gerador.nextInt(301);	
		}
		System.out.println("Votos Gerados");
		System.out.println("-----------------");
		return(voto);
	}
	
	public static votacao[] FCLASSIFICASECAO(votacao voto[],int a) {
		votacao[] aux = new votacao[voto.length];
		
		for(int i=0;i<voto.length;i++) {
			for(int j=0;j<voto.length;j++) {
				if(voto[i].secao<voto[j].secao) {
					aux[1] = voto[i];
					voto[i] = voto[j];
					voto[j] = aux[1];
				}
			}
		}
		System.out.println("Dados classificaos");
		System.out.println("-----------------");
		return(voto);
	}
	
	static void gravaDados(votacao voto[]) throws IOException {
		String filename = "Votacao2019.txt";
		BufferedWriter escrever = new BufferedWriter(new FileWriter(filename));
		
		for(int i=0;i<voto.length;i++) {
			
			escrever.write(Integer.toString(voto[i].secao));
			escrever.newLine();
			escrever.write(Integer.toString(voto[i].candidato));
			escrever.newLine();
		}
		escrever.close();
		JOptionPane.showMessageDialog(null,"Arquivo criado com sucesso");		
		
	}
	
	static void exibeDados(votacao voto[]) {
		
		for(int i=0;i<voto.length;i++) {
			System.out.println("Sessão: "+voto[i].secao+"\nCandidato: "+voto[i].candidato+"\n");
		}
		System.out.println("-----------------");
	}
}
