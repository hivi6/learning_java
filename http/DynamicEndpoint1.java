package http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

class MyHttpHandler implements HttpHandler {
    static ArrayList<String> pathPatternList = new ArrayList<>();
    static ArrayList<String> responseList = new ArrayList<>();

    static void get(String pathPattern, String response) {
        pathPatternList.add(pathPattern);
        responseList.add(response);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equals("GET")) {
            var requestPath = exchange.getRequestURI().getPath();
            var requestQuery = exchange.getRequestURI().getQuery();

            if (true) { // debugging purpose
                System.out.println("requestPath: '" + requestPath + "'");
                System.out.println("requestQuery: '" + requestQuery + "'");
            }

            // test response
            var response = "Not Found 404";
            // check which pattern matches
            for (int i = 0; i < pathPatternList.size(); i++) {
                var pathPattern = pathPatternList.get(i);
                var tempResponse = responseList.get(i);

                var pattern = Pattern.compile(pathPattern);
                var match = pattern.matcher(requestPath);
                if (match.find()) {
                    response = tempResponse;
                    break;
                }
            }

            // set response header
            exchange.getResponseHeaders().add("Content-Type", "text/plain");
            if (response.equals("Not Found 404")) {
                exchange.sendResponseHeaders(404, response.length());
            } else {
                exchange.sendResponseHeaders(200, response.length());
            }
            // set response body
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
}

public class DynamicEndpoint1 {
    public static void main(String[] args) {
        try {
            MyHttpHandler.get("^/hi$", "Hi Bro!!");
            MyHttpHandler.get("^/hi/$", "Hi Bro///");
            MyHttpHandler.get("^/hi/(?<name>\\w+)$", "Hi <name>(not implemented)");
            MyHttpHandler.get("^/hi/(?<name>[^/]+)/(?<device>\\w+)$", "Hi <name> <device>(not implemented)");

            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/", new MyHttpHandler());
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
