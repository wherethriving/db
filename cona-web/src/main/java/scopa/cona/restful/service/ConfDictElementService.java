package scopa.cona.restful.service;

import scopa.cona.database.model.ConfDictElement;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/conf_dict_elems")
@Produces("application/json")
public interface ConfDictElementService {

    @GET
    @Path("/{conf_dict_elem_id}")
    Response getConfDictElementById(@PathParam("conf_dict_elem_id") Integer confDictElementId);

    @POST
    @Path("/")
    void addConfDictElement(ConfDictElement confDictElement);

    @PUT
    @Path("/{conf_dict_elem_id}")
    void updateConfDictElement(ConfDictElement confDictElement);

    @DELETE
    @Path("/{conf_dict_elem_id}")
    void deleteConfDictElement(@PathParam("conf_dict_elem_id") Integer confDictElementId);

}