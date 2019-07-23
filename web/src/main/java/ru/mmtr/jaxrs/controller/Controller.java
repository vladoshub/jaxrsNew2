package ru.mmtr.jaxrs.controller;

import ru.mmtr.jaxrs.dto.HumanDto;
import ru.mmtr.jaxrs.service.ServiceApi;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class Controller{

    @Context
    private HttpServletRequest request;

    @EJB
    private ServiceApi serviceApi;


    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postHuman(HumanDto human) {
        try {

            serviceApi.addHuman(human);
           return Response.status(200).entity("Ok").build();
        }
        catch (Exception e){
            return Response.status(200).entity("error").build();
        }
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListHuman(){
        try {

            List<HumanDto> humans = serviceApi.getHumans();
            if (humans.isEmpty())
                return Response.status(200).entity("List is Empty").build();
            GenericEntity<List<HumanDto>> genericEntity = new GenericEntity<List<HumanDto>>(humans){};
            return Response.status(200).entity(genericEntity).build();

        }
        catch (Exception e){
            return Response.status(200).entity("error").build();
        }
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(){
        try {
            return Response.status(200).entity("is ok").build();
        }
        catch (Exception e){
            return Response.status(200).entity("error").build();
        }
    }
}
