package com.sazax.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sazax.dao.DaoException;
import com.sazax.dao.DaoFactory;
import com.sazax.dao.ProdutoDAO;
import com.sazax.entidade.Produto;


@Path("/produto")
public class ProdutoResource {
	
	private ProdutoDAO dao;
	
	 public ProdutoResource() throws DaoException{
		 dao = DaoFactory.getProdutoDAO();
	 }
	@GET
	@Produces({"application/json"})
	public Response getAllProduto() throws DaoException{
		return Response.ok(dao.findAll()).build();
	}
	
	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response addNewProduto(Produto produto) throws DaoException {
		produto = dao.addProduto(produto);
		return Response.ok(produto).build();
	}

}
