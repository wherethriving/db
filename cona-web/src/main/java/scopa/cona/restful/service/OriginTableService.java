package scopa.cona.restful.service;

import scopa.cona.database.model.OriginTable;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/origin_tables")
@Produces("application/json")
public interface OriginTableService {

    @GET
    @Path("/{origin_table_id}")
    Response getOriginTableById(@PathParam("origin_table_id") Integer originTableId);

    @POST
    @Path("/")
    void addOriginTable(OriginTable originTable);

    @PUT
    @Path("/{conf_dict_elem_id}")
    void updateOriginTable(OriginTable originTable);

    @DELETE
    @Path("/{origin_table_id}")
    void deleteOriginTable(@PathParam("origin_table_id") Integer originTableId);

}