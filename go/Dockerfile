FROM golang:1.20 AS builder

WORKDIR /app

COPY ./go.mod ./go.mod
COPY ./go.sum ./go.sum

COPY ./cmd ./cmd
COPY ./internal ./internal

RUN go mod tidy
RUN go build -o /grpc-demo ./cmd

FROM alpine
COPY --from=builder /grpc-demo /grpc-demo

EXPOSE 8081

CMD [ "/grpc-demo" ]
