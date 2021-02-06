package pt.tiago.boundary;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import pt.tiago.control.HistoryDataRestClient;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/stats")
public class StatsResource {

    @Inject
    @RestClient
    HistoryDataRestClient historyDataRestClient;

    @GET
    @Path("/history/{day}/{country}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHistoryData(@PathParam("day") String day, @PathParam("country") String country) {
        return historyDataRestClient.getHistoryData(day.toString(), country);
    }

}