# katas-server

Build a server that can be used to host katas.

## Docker

* Build: `docker build --no-cache -t katas-server .`
* Run:
```
# --net=host for development, container has access to host network
# or dockerize your mongodb

docker run --net=host -p 9099:9099 katas-server
```
* Docker list: `docker ps`
* Stop: `docker container stop [name instance] `
* Logs: `docker container logs [name instance]`

## MongoDB
It's used a localhost MongoDB instance. **Check it's up and running.**


### config:
[docker-local-mongodb](https://tsmx.net/docker-local-mongodb/)

in /etc/mongod.conf

```
net:
  port: 27017
  bindIp: 127.0.0.1,172.17.0.1
```

in /etc/hosts
```
127.0.0.1	mongoservice
```

## CURL access


## Access on browser
http://localhost:9090/ <br>
http://localhost:9090/users <br>
http://localhost:9090/katas <br>

http://localhost:9090/swagger-ui/index.html <br>
http://localhost:9090/v3/api-docs/

## Databases

http://localhost:9090/h2-console/ (sa:admin) <br>
mongodb://mongoservice:27017/katas-java
