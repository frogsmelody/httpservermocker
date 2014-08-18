package com.harlap.test.http.httpmock;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class ClientTest {
    private static final String baseUrl = "http://localhost:8080";

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new HttpClientTest()).start();
        }
    }
    public static class HttpClientTest implements Runnable {
        public void run() {
            HttpClient client = new DefaultHttpClient();
            HttpGet req = new HttpGet(baseUrl + "/");
            try {
                HttpResponse response = client.execute(req);
                String responseBody = IOUtils.toString(response.getEntity().getContent());
                System.out.println(responseBody);
                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println(statusCode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
