package com.dxc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/conversion")
public class ConversionService {
	
	
	@GET
	@Path("/inch2cm/{inch}")
	public String inch2cm(@PathParam("inch") double inch) {
		double cm;
		cm= inch * 2.54;
		return ""+cm;
	}
	
	

}
