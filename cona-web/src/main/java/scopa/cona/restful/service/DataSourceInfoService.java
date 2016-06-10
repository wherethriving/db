package scopa.cona.restful.service;

import scopa.cona.database.model.DataSourceInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/data_source_info")
@Produces("application/json")
public interface DataSourceInfoService {

    @GET
    @Path("/{data_source_info_id}")
    Response getDataSourceInfoById(@PathParam("data_source_info_id") Integer dataSourceInfoId);

    @POST
    @Path("/")
    void addDataSourceInfo(DataSourceInfo dataSourceInfo);

    @PUT
    @Path("/{data_source_info_id}")
    void updateDataSourceInfo(DataSourceInfo dataSourceInfo);

    @DELETE
    @Path("/{data_source_info_id}")
    void deleteDataSourceInfo(@PathParam("data_source_info_id") Integer dataSourceInfoId);

}