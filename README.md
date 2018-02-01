# xenon

# License

All of Xenon's code is available under the [MIT License](https://tldrlegal.com/license/mit-license).

# Build
```
# git clone
cd xenon/
mvn package
# this will create a docker image and tag it with the project.version
mvn dockerfile:build
docker push xenonsh/xenon:XXX-SNAPSHOT
```

# Deploy
```
# ssh into server host
# if there's another image running, make sure the port is not taken
#   docker ps
#   docker kill XXXXXXXXX
docker pull xenonsh/xenon:XXX-SNAPSHOT
docker run -d -it -p 8080:8080 xenonsh/xenon:XXX-SNAPSHOT
```

# Run Locally
```
docker run -p 8080:8080 xenon:XXX-SNAPSHOT
```
Open browser to `http://localhost:8080`.
