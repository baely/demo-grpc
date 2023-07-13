package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Main {
    public static void main(String[] args) {
//        String serverAddress = "localhost:8081";
        String serverAddress = System.getenv("SERVER_ADDR");
        ManagedChannel channel = ManagedChannelBuilder.forTarget(serverAddress)
                .usePlaintext()
                .build();

        HelloClient client = new HelloClient(channel);
        client.helloWorld("bailey");
    }
}
