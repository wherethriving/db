package scopa.cona.restful.service;

import scopa.cona.database.model.DataDictElement;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/data_dict_elems")
@Produces("application/json")
public interface DataDictElementService {

    @GET
    @Path("/{data_dict_element_id}")
    Response getDataDictElementById(@PathParam("data_dict_element_id") Integer dataDictElementId);

    @POST
    @Path("/")
    void addDataDictElement(DataDictElement dataDictElement);

    @PUT
    @Path("/{data_dict_element_id}")
    void updateDataDictElement(DataDictElement dataDictElement);

    @DELETE
    @Path("/{data_dict_element_id}")
    void deleteDataDictElement(@PathParam("data_dict_element_id") Integer dataDictElementId);

}