package org.example;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.gen.protos.HelloWorldServiceGrpc;
import org.example.gen.protos.Helloworld.HelloWorldRequest;
import org.example.gen.protos.Helloworld.HelloWorldResponse;

public class HelloClient {
    private final HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub;
    public HelloClient(Channel channel) {
        blockingStub = HelloWorldServiceGrpc.newBlockingStub(channel);
    }

    public void helloWorld(String name) {
        HelloWorldRequest request = HelloWorldRequest.newBuilder()
                .setService("Java")
                .setName(name)
                .build();

        HelloWorldResponse response;

        try {
            response = blockingStub.helloWorld(request);
            System.out.println("wow! this code called a remote procedure written in " + response.getService());
            System.out.println("message: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
