package http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

class MyHttpHandler implements HttpHandler {
    static ArrayList<String> pathList = new ArrayList<>();
    static ArrayList<String> responseList = new ArrayList<>();

    static void get(String path, String response) {
        pathList.add(path);
        responseList.add(response);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equals("GET")) {
            var requestPath = exchange.getRequestURI().getPath();
            var requestQuery = exchange.getRequestURI().getQuery();

            if (true) { // For Debugging purpose
                System.out.println("RequestPath: " + requestPath);
                System.out.println("RequestQuery: " + requestQuery);
            }

            if (true) { // Print all the pathList
                System.out.println(requestPath + " " + requestPath.length());
                System.out.println(pathList.toString());
                System.out.println(responseList.toString());
            }

            // creating response
            String response = "Not Found 404";
            // iterate through all the list and find the matching path
            for (int i = 0; i < pathList.size(); i++) {
                if (requestPath.equals(pathList.get(i))) {
                    response = responseList.get(i);
                    break;
                }
            }

            // set response header
            exchange.getResponseHeaders().add("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, response.length());

            // set response body
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
}

public class DynamicEndpoint {
    public static void main(String[] args) {
        try {
            MyHttpHandler.get("/hello", "Hello World");
            MyHttpHandler.get("/hi", "Hi bro");
            MyHttpHandler.get("/hello/Laharjit", "Hello Laharjit");

            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/", new MyHttpHandler());
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
