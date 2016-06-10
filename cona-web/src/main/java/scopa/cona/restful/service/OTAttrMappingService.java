package scopa.cona.restful.service;

import scopa.cona.database.model.OTAttrMapping;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/ot_attr_mappings")
@Produces("application/json")
public interface OTAttrMappingService {

    @GET
    @Path("/{ot_attr_mapping_id}")
    Response getOTAttrMappingById(@PathParam("ot_attr_mapping_id") Integer otAttrMappingId);

    @POST
    @Path("/")
    void addOTAttrMapping(OTAttrMapping otAttrMapping);

    @PUT
    @Path("/{ot_attr_mapping_id}")
    void updateOTAttrMapping(OTAttrMapping otAttrMapping);

    @DELETE
    @Path("/{ot_attr_mapping_id}")
    void deleteOTAttrMapping(@PathParam("ot_attr_mapping_id") Integer otAttrMappingId);

}