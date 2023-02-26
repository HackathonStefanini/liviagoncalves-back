package com.stefanini.resources;

import com.stefanini.entity.Stefamon;
import com.stefanini.service.StefamonService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/stefamon")
public class StefamonResource {

    @Inject
    StefamonService stefamonservice;

    @GET
    @Path("/todos")
    public Response listarTodos() {
        return Response.status(Response.Status.OK).entity(stefamonservice.listarTodos()).build();
    }

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(stefamonservice.pegarPorId(id)).build();
    }

}
