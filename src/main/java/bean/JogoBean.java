package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import bd.BancoDeDadosTemporário;
import entidades.Jogo;

@ManagedBean
public class JogoBean {
	private Jogo jogo = new Jogo();
	private List<Jogo> lista = new ArrayList<Jogo>();
	private List<Jogo> jogosSelecionados = new ArrayList<Jogo>();
		
	public String salvar() {
		jogo.incrementarId();
		jogo.gerarNumeroSecreto();
		jogo.verificarResultado();	
		BancoDeDadosTemporário.insert(jogo);
		if(jogo.getResultado() == "Acertou!"){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Número Secreto: "+jogo.getNumeroSecreto()+", parabéns, você acertou!"));
		}else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Número Secreto: "+jogo.getNumeroSecreto()+", tente novamente, você não acertou!", null));
		}
		jogo = new Jogo();
		return null;
	}
	
	public void quantidadeDeElementos() {
		Integer qtd = lista.size();
        if(qtd < 1) {
        	FacesMessage message = new FacesMessage("Não há elementos na tabela");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else {
        	FacesMessage message = new FacesMessage("Número de elementos: " + qtd);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
	
	public void excluirSelecionados() {
		if(jogosSelecionados.size() >= 1){
			lista.removeAll(jogosSelecionados);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Jogo excluído com Sucesso!"));
			jogosSelecionados.clear();
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não há nada para excluir!"));
		}
	}
	
	public void excluirTudo() {
		if(lista.size() == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não há nada para excluir!"));
		}else if(lista.size() >= 1){
			lista.clear();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Jogos Excluídos com Sucesso."));
		}
	}
	
	public List<Jogo> getJogosSelecionados() {
		return jogosSelecionados;
	}

	public void setJogosSelecionados(List<Jogo> jogosSelecionados) {
		this.jogosSelecionados = jogosSelecionados;
	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getLista() {
		lista = BancoDeDadosTemporário.select();
		return lista;
	}

	public void setLista(List<Jogo> lista) {
		this.lista = lista;
	}
}