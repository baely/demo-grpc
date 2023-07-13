package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String serverAddress = System.getenv("SERVER_ADDR");
        if (serverAddress == null)
            serverAddress = "localhost:8081";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(serverAddress)
                .usePlaintext()
                .build();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("name: ");
            String name = scanner.nextLine();

            HelloClient client = new HelloClient(channel);
            client.helloWorld(name);
        }
    }
}
