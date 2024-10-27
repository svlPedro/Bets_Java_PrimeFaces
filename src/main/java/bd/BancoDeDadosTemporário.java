package bd;

import java.util.ArrayList;
import java.util.List;

import entidades.Jogo;

public class BancoDeDadosTemporário {
	private static List<Jogo> dados = new ArrayList<Jogo>();
	
	public static void insert(Jogo j) {
		dados.add(j);
	}
	
	public static List<Jogo> select(){
		return dados;
	}
}