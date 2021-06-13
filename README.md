# Spring Boot JPA application accessing an SQL database

## Introduction

This is a Spring Boot application that accesses an SQL database.  The data model is a `User` that has an id, name and email address.  There is one controller with two endpoints:

* `/demo/all` - lists all users  (GET REQUEST)
* `/demo/add` - add a user (POST REQUEST)

> This sample is based on the Spring [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/) guide.

## Building and running locally

We can build and run this app locally using an embedded HSQL database.

To build the app as an uberjar run:

```
./mvnw clean package 
```

To start the application locally with an embedded database run:

```
./mvnw spring-boot:run
```

See [Accessing the app](#accessing-the-app) for commands to test the app.

## Building and deploying to a Kubernetes cluster

You need to have recent version of the following installed:

- Docker - https://docs.docker.com/get-docker/
- The kubectl CLI - https://kubernetes.io/docs/tasks/tools/
- Skaffold - https://skaffold.dev/docs/install/
- Helm v3 - https://helm.sh/docs/intro/install/

We are using a Helm deployed [MariaDB](https://mariadb.com/) database for this example. You could use PostgreSQL or any other SQL database by changing dependencies for the JDBC driver used. 

You can run this app using a local Kubernetes cluster like [kind](https://kind.sigs.k8s.io/), [minikube](https://minikube.sigs.k8s.io/docs/start/) or [Docker Desktop](https://www.docker.com/products/docker-desktop). You can also use a remote cluster and any hosted Kubernetes cluster should work for deploying this app.

### Deploying the database

We are using a [Bitnami](https://bitnami.com/) Helm chart so we need to add the Bitnami chart repository to our Helm installation:

```
helm repo add bitnami https://charts.bitnami.com/bitnami
```

Now we can deploy the database setting a username and database name that we can use later to connect to the database from our app. The password will be stored in a secret and we will mount the Secret as volume in the Deployment so the password can be used when setting the Spring Boot configuration properties for the app.

To deploy the MariaDB database run:

```
skaffold run -p db
```

To delete the database after undeploying the app run:

```
skaffold delete -p db
```

This still leaves behind a PersistenVolumeClaim (pvc) that we should delete by running the following:

```
kubectl delete pvc -l=app.kubernetes.io/name=mariadb
```

### Using a local Kubernetes cluster

To build the app run this command:

```
skaffold build -p app,local --default-repo dev.local
```

To build and deploy the app run the following command:

```
skaffold run -p app,local --default-repo dev.local --port-forward
```

> This will port-forward to a local 8080 port so you can access the app's endpoints.

See [Accessing the app](#accessing-the-app) for commands to test the app.

### Using a remote Kubernetes cluster

For remote clusters you need to push the container image to a registry that is accessible from the remote cluster. You can set a [default repo](https://skaffold.dev/docs/environment/image-registries/) prefix to be used by skaffold or provide it as an option. For this example we'll set it as an environment variable to be used with the commands later. For Docker Hub this would be your Docker ID. 

```
export REPO_PREFIX=<repo-prefix>
```

To build the app run the following command:

```
skaffold build --default-repo $REPO_PREFIX
```

To build and deploy the app run the following command:

```
skaffold run -p app --default-repo $REPO_PREFIX --port-forward
```

> This will port-forward to a local 8080 port so you can access the app's endpoints.

See [Accessing the app](#accessing-the-app) for commands to test the app.

### Undeploying the app

Run the following commands:

```
skaffold delete -p app
```

## Accessing the app

To view the users run:

```
curl -w'\n' 'localhost:8080/demo/all'
```

To add a user run:

```
curl -w'\n' localhost:8080/demo/add \
 -d name=First \
 -d email=someemail@someemailprovider.com
```
