/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.editora.servico;

import java.util.List;

/**
 *
 * @author jose
 * @param <T>
 * @param <KEY>
 */
public interface Servico<T, KEY> {

    T localizarPorId(Class<T> tipo, KEY id);

    T remove(Class<T> tipo, KEY id);

    T salvar(T t);

    List<T> todos(Class tipo);

    T update(T t);

}
