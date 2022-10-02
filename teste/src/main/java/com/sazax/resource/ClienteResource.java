package com.sazax.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sazax.dao.DaoException;
import com.sazax.dao.DaoFactory;
import com.sazax.dao.ClienteDAO;
import com.sazax.entidade.Cliente;


@Path("/cliente")
public class ClienteResource {
	
	private ClienteDAO dao;
	
	 public ClienteResource() throws DaoException{
		 dao = DaoFactory.getClienteDAO();
	 }
	
	
	@POST
	@Produces({"application/json", "text/csv"})
	@Consumes({"application/json", "text/csv"})
	public Response addNewCliente(Cliente cliente) throws DaoException {
		cliente = dao.addCliente(cliente);
		return Response.ok(cliente).build();
	}

}
