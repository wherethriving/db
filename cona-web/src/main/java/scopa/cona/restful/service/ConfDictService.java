package scopa.cona.restful.service;

import scopa.cona.database.model.ConfDict;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/conf_dicts")
@Produces("application/json")
public interface ConfDictService {

    @GET
    @Path("/{conf_dict_id}")
    Response getConfDictById(@PathParam("conf_dict_id") Integer confDictId);

    @POST
    @Path("/")
    void addConfDict(ConfDict confDict);

    @PUT
    @Path("/{conf_dict_elem_id}")
    void updateConfDict(ConfDict confDict);

    @DELETE
    @Path("/{conf_dict_id}")
    void deleteConfDict(@PathParam("conf_dict_id") Integer confDictId);

}