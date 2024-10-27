package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Jogo {
	private static Integer incrementarId = 0;
	private Random rd = new Random();
	
	private Integer id;
	private String nomeJogador;
	private Integer numeroAposta;
	private Integer numeroSecreto; 
	private String resultado;
	private Date data = new Date();
	
	public Jogo() {
		
	}
	
	public Jogo(Integer id, String nomeJogador, Integer numeroAposta, Integer numeroSecreto, String resultado,Date data) {
		this.id = id;
		this.nomeJogador = nomeJogador;
		this.numeroAposta = numeroAposta;
		this.numeroSecreto = numeroSecreto;
		this.resultado = resultado;
		this.data = data;
	}
	
	//Gerar id's incrementais e sequenciais
	public Integer incrementarId() {
		id = ++incrementarId;
		return id;
	}
	
	//gerar numeros secretos
	public Integer gerarNumeroSecreto() {
		numeroSecreto = rd.nextInt(5) + 1;
		return numeroSecreto;
	}
	
	//Função para verificar o resultado
	public String verificarResultado() {
		if(getNumeroAposta() == getNumeroSecreto()){
		   resultado = "Acertou!";	
		}else {
		   resultado = "Não acertou!";
		}
		return resultado;
	}
	
	//formatar data
	public String getDataFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return sdf.format(data);
	}
	
	//Gets e Sets
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	public Integer getNumeroAposta() {
		return numeroAposta;
	}
	public void setNumeroAposta(Integer numeroAposta) {
		this.numeroAposta = numeroAposta;
	}
	public Integer getNumeroSecreto() {
		return numeroSecreto;
	}
	public void setNumeroSecreto(Integer numeroSecreto) {
		this.numeroSecreto = numeroSecreto;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
