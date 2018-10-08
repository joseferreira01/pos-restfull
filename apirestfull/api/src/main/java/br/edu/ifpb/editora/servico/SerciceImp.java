/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.editora.servico;

import br.edu.ifpb.editora.repositorio.Repositorio;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jose
 */
@Stateless
public class SerciceImp<T, KEY> implements Servico<T, KEY> {

    @EJB
    private Repositorio<T, KEY> rl;

    @Override
    public T salvar(T t) {
        return this.rl.salvar(t);
    }

    @Override
    public List<T> todos(Class tipo) {
        List<T> list = this.rl.list(tipo);
        if (list == null || list == Collections.emptyList()) {
          return Collections.emptyList();
        
        }
        return list;
    }

    @Override
    public T localizarPorId(Class<T> tipo, KEY id) {
        return this.rl.find(tipo, id);
    }

    @Override
    public T remove(Class<T> tipo, KEY id) {

        T livro = localizarPorId(tipo, id);
        return this.rl.remove(livro);
    }

    @Override
    public T update(T t) {
        return this.rl.update(t);
    }
}
