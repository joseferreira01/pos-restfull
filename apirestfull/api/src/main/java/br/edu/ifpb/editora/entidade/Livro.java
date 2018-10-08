/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.editora.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@XmlRootElement
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String editora;
    private String descricao;
    private String titulo;
     @ManyToMany
    private List<Autor> autores = new ArrayList<>();
            

    public Livro() {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public Livro(String editora, String descricao, String titulo) {
        this();
       
        this.editora = editora;
        this.descricao = descricao;
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return Collections.unmodifiableList(autores);
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    public void novo(Autor autor){
        this.autores.add(autor);
    }
    
    
}
