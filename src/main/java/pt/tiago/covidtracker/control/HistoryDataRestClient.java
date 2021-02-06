package pt.tiago.covidtracker.control;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey="covid.tracker.api")
@RegisterClientHeaders(HistoryDataRestClientHeadersFactory.class)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public interface HistoryDataRestClient {

    @GET
    @Path("/history")
    String getHistoryData(@QueryParam("day") String day, @QueryParam("country") String country);

}
