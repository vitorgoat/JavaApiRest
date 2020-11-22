package edgex.livro;

import javax.persistence.Entity;

import edgex.BaseEntity;

@Entity
public class Livro extends BaseEntity{
	
	public String nome;
	public String ano;
	public String editora;
	public String autor;
	
	public Livro () {
	}

	public Livro(String nome, String ano, String editora, String autor) {
		super();
		this.nome = nome;
		this.ano = ano;
		this.editora = editora;
		this.autor = autor;
	}

	public String getNome() {
		return nome;
	}

	public String getAno() {
		return ano;
	}

	public String getEditora() {
		return editora;
	}

	public String getAutor() {
		return autor;
	}
	
	
}
