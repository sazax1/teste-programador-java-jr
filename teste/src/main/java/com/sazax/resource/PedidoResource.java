package com.sazax.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sazax.dao.DaoException;
import com.sazax.dao.DaoFactory;
import com.sazax.dao.PedidoDAO;
import com.sazax.entidade.Pedido;


@Path("/pedido")
public class PedidoResource {
	
	private PedidoDAO dao;
	
	 public PedidoResource() throws DaoException{
		 dao = DaoFactory.getPedidoDAO();
	 }
	@GET
	@Produces({"application/json"})
	public Response getAllPedido() throws DaoException{
		return Response.ok(dao.findAll()).build();
	}
	
	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response addNewPedido(Pedido pedido) throws DaoException {
		pedido = dao.addPedido(pedido);
		return Response.ok(pedido).build();
	}

}
