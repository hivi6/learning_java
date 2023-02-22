package http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MyDynamicEndpoint {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new MyHomeHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHomeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestPath = exchange.getRequestURI().getPath();
            String query = exchange.getRequestURI().getQuery();

            // For debuging purposes
            if (true) {
                System.out.println("RequestPath: " + requestPath);
                System.out.println("Query: " + query);
            }

            String response = "";

            // Handle different endpoints
            if (requestPath.equals("/hello")) {
                response = "Hello, World!";
            } else if (requestPath.equals("/greeting")) {
                response = "Greetings!";
            } else {
                response = "Endpoint not found.";
            }

            // Set response headers
            exchange.getResponseHeaders().add("Content-Type", "text/plain");

            // Set response body
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
