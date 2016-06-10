package scopa.cona.restful.service;

import scopa.cona.database.model.OTTableMapping;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/ot_table_mappings")
@Produces("application/json")
public interface OTTableMappingService {

    @GET
    @Path("/{ot_table_mapping_id}")
    Response getOTTableMappingById(@PathParam("ot_table_mapping_id") Integer otTableMappingId);

    @POST
    @Path("/")
    void addOTTableMapping(OTTableMapping otTableMapping);

    @PUT
    @Path("/{ot_table_mapping_id}")
    void updateOTTableMapping(OTTableMapping otTableMapping);

    @DELETE
    @Path("/{ot_table_mapping_id}")
    void deleteOTTableMapping(@PathParam("ot_table_mapping_id") Integer otTableMappingId);

}