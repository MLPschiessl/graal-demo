FROM registry.access.redhat.com/ubi9-minimal:9.2
#Needs newer glibc version so we go for ubi 9

COPY target/graal-demo graal-demo

EXPOSE 8080

ENTRYPOINT ["./graal-demo"]