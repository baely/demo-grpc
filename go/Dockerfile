FROM golang:1.20 AS builder

WORKDIR /app

COPY ./* /app/

RUN go mod tidy
RUN go build -o /grpc-demo .

FROM alpine
COPY --from=builder /grpc-demo /grpc-demo

EXPOSE 8081

CMD [ "/grpc-demo" ]
