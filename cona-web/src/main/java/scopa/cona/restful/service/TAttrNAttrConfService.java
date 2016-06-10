package scopa.cona.restful.service;

import scopa.cona.database.model.TAttrNAttrConf;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/attr_conf_mappings")
@Produces("application/json")
public interface TAttrNAttrConfService {

    @GET
    @Path("/{attr_conf_mapping_id}")
    Response getTAttrNAttrConfById(@PathParam("attr_conf_mapping_id") Integer tAttrNAttrConfId);

    @POST
    @Path("/")
    void addTAttrNAttrConf(TAttrNAttrConf tAttrNAttrConf);

    @PUT
    @Path("/{attr_conf_mapping_id}")
    void updateTAttrNAttrConf(TAttrNAttrConf tAttrNAttrConf);

    @DELETE
    @Path("/{attr_conf_mapping_id}")
    void deleteTAttrNAttrConf(@PathParam("attr_conf_mapping_id") Integer tAttrNAttrConfId);

}