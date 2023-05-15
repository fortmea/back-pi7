import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Aplicacao {
    public static void main(String[] args) throws IOException {
        ResourceConfig resourceConfig = new ResourceConfig().packages("resources");
        resourceConfig.register(new CORSFilter());
        resourceConfig.register(CORSFilter.class);
        URI uri = URI.create("http://localhost:8080/api/");
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(uri, resourceConfig);
        httpServer.start();
    }
}
