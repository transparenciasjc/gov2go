package org.transparencia.gov2go.services.impl;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.RandomStringUtils;
import org.transparencia.gov2go.model.impl.Acesso;
import org.transparencia.gov2go.repository.impl.Acessos;

public class AcessoService {

	@Inject
	Acessos dao;
	
	public Response criar() {
		
		String token = RandomStringUtils.random(30, true, true);
		
		Acesso acesso  = new Acesso();
		acesso.setToken(token);
		
		try {
			dao.salvar(acesso);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Response.status(Status.OK).entity(acesso).build();
	}
	
}
