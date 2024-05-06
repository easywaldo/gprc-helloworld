```shell
grpcurl -plaintext -d '{"name": "easyrosie"}' localhost:6565 helloworld.Greeter/SayHello
{
"message": "Hello easyrosie"
}
```