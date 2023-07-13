# Demo gRPC

Demo gRPC project with a java gRPC client connecting to a go gRPC server

All Java client files can be found in the /java directory
All Go server files can be found in the /go directory

Notable files:
 - [Hello World proto definition](./protos/helloworld.proto)
 - [Java client implementation](./java/src/main/java/org/example/HelloClient.java)
 - [Go server implementation](./go/internal/server/server.go)

## Run

Both client and server are dockerised and can be run via the below command

```shell
docker compose up --build server-go
```

and then run the java client (org.example.Main) in intelliJ or something lol
