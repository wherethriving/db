package scopa.cona.restful.service;

import scopa.cona.database.model.RuleMapping;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/rule_mappings")
@Produces("application/json")
public interface RuleMappingService {

    @GET
    @Path("/{rule_mapping_id}")
    Response getRuleMappingById(@PathParam("rule_mapping_id") Integer ruleMappingId);

    @POST
    @Path("/")
    void addRuleMapping(RuleMapping ruleMapping);

    @PUT
    @Path("/{rule_mapping_id}")
    void updateRuleMapping(RuleMapping ruleMapping);

    @DELETE
    @Path("/{rule_mapping_id}")
    void deleteRuleMapping(@PathParam("rule_mapping_id") Integer ruleMappingId);

}