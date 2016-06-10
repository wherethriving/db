package scopa.cona.restful.service;

import scopa.cona.database.model.OriginAttr;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/origin_attrs")
@Produces("application/json")
public interface OriginAttrService {

    @GET
    @Path("/{origin_attr_id}")
    Response getOriginAttrById(@PathParam("origin_attr_id") Integer originAttrId);

    @POST
    @Path("/")
    void addOriginAttr(OriginAttr confDictElement);

    @PUT
    @Path("/{conf_dict_elem_id}")
    void updateOriginAttr(OriginAttr confDictElement);

    @DELETE
    @Path("/{origin_attr_id}")
    void deleteOriginAttr(@PathParam("origin_attr_id") Integer originAttrId);

}