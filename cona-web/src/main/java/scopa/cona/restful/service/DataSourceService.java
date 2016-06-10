package scopa.cona.restful.service;

import scopa.cona.database.model.DataSource;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/data_sources")
@Produces("application/json")
public interface DataSourceService {

    @GET
    @Path("/{data_source_id}")
    Response getDataSourceById(@PathParam("data_source_id") Integer dataSourceId);

    @POST
    @Path("/")
    void addDataSource(DataSource dataSource);

    @PUT
    @Path("/{data_source_id}")
    void updateDataSource(DataSource dataSource);

    @DELETE
    @Path("/{data_source_id}")
    void deleteDataSource(@PathParam("data_source_id") Integer dataSourceId);

}