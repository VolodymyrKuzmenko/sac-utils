package ua.kpi.compsys.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/sac-analytics")
public class SacAnalyticsResource {

    @GET
    
    public Response testFunction(int [] fucntion){
        return Response.ok().build();
    }

}
