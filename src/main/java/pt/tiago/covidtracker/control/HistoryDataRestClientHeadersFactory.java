package pt.tiago.covidtracker.control;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

@ApplicationScoped
public class HistoryDataRestClientHeadersFactory implements ClientHeadersFactory {

    @Inject
    @ConfigProperty(name = "covid.tracker.api/mp-rest/url")
    String url;

    @Inject
    @ConfigProperty(name = "covid.tracker.api.key")
    String key;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> multivaluedMap, MultivaluedMap<String, String> multivaluedMap1) {
        MultivaluedMap<String, String> result = new MultivaluedMapImpl<>();
        result.add("x-rapid-host", url);
        result.add("x-rapidapi-key", key);
        return result;
    }
}
