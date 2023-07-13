package main

import (
	"github.com/baely/demo-grpc/go/internal/server"
)

func main() {
	s := server.HelloWorldServer{}
	s.Run()
}
