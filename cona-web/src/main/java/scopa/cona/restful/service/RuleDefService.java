package scopa.cona.restful.service;

import scopa.cona.database.model.RuleDef;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/rule_defs")
@Produces("application/json")
public interface RuleDefService {

    @GET
    @Path("/{rule_def_id}")
    Response getRuleDefyId(@PathParam("rule_def_id") Integer ruleDefId);

    @POST
    @Path("/")
    void addRuleDef(RuleDef ruleDef);

    @PUT
    @Path("/{rule_def_id}")
    void updateRuleDef(RuleDef ruleDef);

    @DELETE
    @Path("/{rule_def_id}")
    void deleteRuleDef(@PathParam("rule_def_id") Integer ruleDefId);

}