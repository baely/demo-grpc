FROM golang:1.20 AS builder

WORKDIR /app

COPY ./go.mod ./go.sum /app/
COPY ./go/* /app/go/

# RUN go clean -cache
# RUN go mod tidy
# RUN go get github.com/baely/demo-grpc/go/gen
# RUN go build -o /grpc-demo ./go
RUN CGO_ENABLED=0 GOOS=linux go build -o /grpc-demo ./go

FROM alpine
COPY --from=builder /grpc-demo /grpc-demo

EXPOSE 8081

CMD [ "/grpc-demo" ]
