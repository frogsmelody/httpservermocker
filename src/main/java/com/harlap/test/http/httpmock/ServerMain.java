package com.harlap.test.http.httpmock;

import com.harlap.test.http.MockHttpServer;

public class ServerMain {
    public static void main(String[] args) throws Exception {
        MockHttpServer mockHttpServer = new MockHttpServer(8080);
        mockHttpServer.start();
        mockHttpServer.expect(MockHttpServer.Method.GET, "/").respondWith(200, "text/plain", "Welcome");
    }
}
