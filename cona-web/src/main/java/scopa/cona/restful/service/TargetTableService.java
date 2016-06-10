package scopa.cona.restful.service;

import scopa.cona.database.model.TargetTable;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/target_tables")
@Produces("application/json")
public interface TargetTableService {

    @GET
    @Path("/{target_table_id}")
    Response getTargetTableById(@PathParam("target_table_id") Integer targetTableId);

    @POST
    @Path("/")
    void addTargetTable(TargetTable targetTable);

    @PUT
    @Path("/{target_table_id}")
    void updateTargetTable(TargetTable targetTable);

    @DELETE
    @Path("/{target_table_id}")
    void deleteTargetTable(@PathParam("target_table_id") Integer targetTableId);

}