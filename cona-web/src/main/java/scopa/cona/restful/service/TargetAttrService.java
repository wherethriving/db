package scopa.cona.restful.service;

import scopa.cona.database.model.TargetAttr;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/target_attrs")
@Produces("application/json")
public interface TargetAttrService {

    @GET
    @Path("/{target_attr_id}")
    Response getTargetAttrById(@PathParam("target_attr_id") Integer targetAttrId);

    @POST
    @Path("/")
    void addTargetAttr(TargetAttr targetAttr);

    @PUT
    @Path("/{target_attr_id}")
    void updateTargetAttr(TargetAttr targetAttr);

    @DELETE
    @Path("/{target_attr_id}")
    void deleteTargetAttr(@PathParam("target_attr_id") Integer targetAttrId);

}