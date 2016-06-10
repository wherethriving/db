package scopa.cona.restful.service;

import org.codehaus.jettison.json.JSONException;
import scopa.cona.database.model.AttrConf;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/attr_confs")
//@Produces("application/json")
@Produces(MediaType.APPLICATION_JSON)
public interface AttrConfService {

    @GET
    @Path("/{attr_conf_id}")
    Response getAttrConfById(@PathParam("attr_conf_id") Integer attrConfId) throws JSONException;

    @POST
    @Path("/")
    void addAttrConf(AttrConf attrConf);

    @PUT
    @Path("/{attr_conf_id}")
    void updateAttrConf(AttrConf attrConf);

    @DELETE
    @Path("/{attr_conf_id}")
    void deleteAttrConf(@PathParam("attr_conf_id") Integer attrConfId);
}