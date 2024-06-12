package org.example;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Main {
    public static void main(String[] args) {
       /* Response response = ClientBuilder.newClient()
                .target("https://jsonplaceholder.typicode.com/")
                .path("posts/1")
                .request(MediaType.APPLICATION_JSON_TYPE).get();

        String s = response.readEntity(String.class);
        System.out.println(s);
        */

        // Read Wikipedia website
        Client newClient = ClientBuilder.newClient();
        WebTarget target = newClient.target("https://en.wikipedia.org/");
        //WebTarget target = newClient.target("https://jsonplaceholder.typicode.com/");
        target = target.path("wik/Fluent_interface");
        Invocation.Builder builder = target.request(MediaType.TEXT_HTML);
        //Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON_TYPE);
        Response response1 = (Response) builder.get();
        String s2 = ((javax.ws.rs.core.Response) response1).readEntity(String.class);
        System.out.println(s2);



    }
}