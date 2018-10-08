/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.editora.recurso;

import br.edu.ifpb.editora.entidade.Livro;
import br.edu.ifpb.editora.servico.Servico;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author jose
 */
@Path("livros") // .../vendas
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class RecursoLivro {

    private Servico<Livro, String> servico;

    @GET
    public Response todas() {
        List<Livro> livros = servico.todos(Livro.class);
        GenericEntity<List<Livro>> entity = new GenericEntity<List<Livro>>(livros) {
        };
        return Response.ok() //200
                .entity(entity)
                .build();

    }

    @GET
    @Path("{id}")
    public Response livroId(
            @PathParam("id") String id, @Context UriInfo uriInfo) {
        Livro venda = servico.localizarPorId(Livro.class, id);
        if (venda == null) {
            return Response.ok() //200
                    .entity(venda)
                    .build();

        }
        return Response.noContent().build();
    }

    @POST
    public Response novaVenda(JsonObject json) {
        Livro l = new Livro(json.getString("editora"), json.getString("descricao"), json.getString("titulo"));
        servico.salvar(l);
        if (l == null) {
            return Response.noContent().build();
        }
        return Response.ok() //200
                .entity(l)
                .build();
    }

}
