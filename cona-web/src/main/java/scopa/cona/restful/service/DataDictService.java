package scopa.cona.restful.service;

import scopa.cona.database.model.DataDict;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/data_dicts")
@Produces("application/json")
public interface DataDictService {

    @GET
    @Path("/{data_dict_id}")
    Response getDataDictById(@PathParam("data_dict_id") Integer dataDictId);

    @POST
    @Path("/")
    void addDataDict(DataDict dataDict);

    @PUT
    @Path("/{data_dict_id}")
    void updateDataDict(DataDict dataDict);

    @DELETE
    @Path("/{data_dict_id}")
    void deleteDataDict(@PathParam("data_dict_id") Integer dataDictId);

}