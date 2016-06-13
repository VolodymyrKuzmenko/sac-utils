package ua.kpi.compsys.resources;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.compsys.service.FunctionGeneratorService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/sac-util")
@Api("/sac-generator")
@Produces(MediaType.APPLICATION_JSON)
public class SacGeneratorResource {

    @Autowired
    private FunctionGeneratorService service;

    @GET
    @ApiOperation("Get generated SAC function")
    public Response sayHello() {

        return Response.ok(service.getNextSacFunction()).build();
    }

}
