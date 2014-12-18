package com.asrracing.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.asrracing.busca.Marcas;
import com.asrracing.busca.Modelo;
import com.asrracing.busca.MongoMarca;

//http://localhost:8080/RESTfulExample/rest/message/hello%20world
@Path("/car")
public class AsrRest {

	@GET
	@Path("/marcas")
	public Response marcas() {
		Marcas marcas = new Marcas();
		String result = marcas.getMarcas();
		if(result!=null)
		return Response.status(200).entity(result).build();
		else
			return Response.status(500).entity(result).build();

	}
	@GET
	@Path("/busca/marcas/{nombreMarca}")
	@Produces("application/json")
	public Response buscaMarca(@PathParam("nombreMarca") String marca){
		MongoMarca mongoM = new MongoMarca();
		String result = mongoM.buscaMarca(marca);
		if(result!=null)
			return Response.status(200).entity(result).build();
			else
				return Response.status(500).entity(result).build();

	}
	@GET
	@Path("/busca/modelo/{marca}")
	@Produces("application/json")
	public Response buscaModelo(@PathParam("marca")String marca){
		
		Modelo modelo = new Modelo();
		String result = modelo.getModelos(marca);
		if(result!=null)
			return Response.status(200).entity(result).build();
			else
				return Response.status(500).entity(result).build();
			
		}
		
	}

