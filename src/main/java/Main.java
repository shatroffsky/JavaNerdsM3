import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.http.HttpClient;

public class Main {
  public static void main(String[] args) {

    CookieManager cookieManager = new CookieManager();
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
    HttpClient httpClient = HttpClient.newBuilder().cookieHandler(cookieManager).build();

//    HttpRequest request = HttpRequest.newBuilder()
//        .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
//        .header("Content-Type", "application/json")
//        .GET()
//        .build();
//
//    HttpResponse<String> send = httpClient.send(request, BodyHandlers.ofString());
//    String body = send.body();
//    System.out.println(body);
//
//    ObjectMapper objectMapper = new ObjectMapper();
//    RestResponse restResponse = objectMapper.readValue(body, RestResponse.class);
//    System.out.println(restResponse);


//    HttpRequest request = HttpRequest.newBuilder()
//        .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
//        .header("Content-Type", "application/json")
//        .POST(BodyPublishers.ofString("{ \"id\" : \"101\",\"body\" : \"Java Rush\", \"title\" : \"http client\" }"))
//        .build();
//
//    HttpResponse<String> send = httpClient.send(request, BodyHandlers.ofString());
//    System.out.println(send.statusCode());


//    HttpRequest request = HttpRequest.newBuilder()
//        .GET()
//        .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
//        .build();
//
//    CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(
//        request,
//        BodyHandlers.ofString());
//
//    future.thenApply(HttpResponse::body);
//    System.out.println("Done!");


  }
}
