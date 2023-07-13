package main

import (
	"context"
	"fmt"
	"net"

	"google.golang.org/grpc"

	pb "github.com/baely/demo-grpc/go/gen"
)

type HelloWorldServer struct {
	pb.UnimplementedHelloWorldServiceServer
}

func (s *HelloWorldServer) Run() {
	// Create gRPC server
	gs := grpc.NewServer()

	// Register HelloWorldServer to handle HelloWorldService requests via the above gRPC server
	pb.RegisterHelloWorldServiceServer(gs, s)

	// Open network for incoming requests
	lis, err := net.Listen("tcp", ":8081")
	if err != nil {
		panic(err)
	}

	// Server requests
	if err := gs.Serve(lis); err != nil {
		panic(err)
	}
}

// HelloWorld implements the HelloWorld for the HelloWorldService defined in the proto file
func (s *HelloWorldServer) HelloWorld(ctx context.Context, req *pb.HelloWorldRequest) (*pb.HelloWorldResponse, error) {
	service := req.GetService()
	name := req.GetName()

	fmt.Printf("wow! this code was called from within %s code!\n", service)

	return &pb.HelloWorldResponse{
		Service: "Go",
		Message: fmt.Sprintf("Hello there, %s!", name),
	}, nil
}
