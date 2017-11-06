# harald-fairhair
Reminder spring based project

### Env Prerequisites:
``` bash
✗ java -version
java version "1.8.0_152"
Java(TM) SE Runtime Environment (build 1.8.0_152-b16)
Java HotSpot(TM) 64-Bit Server VM (build 25.152-b16, mixed mode)

✗ gradle -v
  
------------------------------------------------------------
Gradle 4.0.1
------------------------------------------------------------
  
Build time:   2017-07-07 14:02:41 UTC
Revision:     38e5dc0f772daecca1d2681885d3d85414eb6826
  
Groovy:       2.4.11
Ant:          Apache Ant(TM) version 1.9.6 compiled on June 29 2015
JVM:          1.8.0_152 (Oracle Corporation 25.152-b16)
OS:           Mac OS X 10.13.1 x86_64

✗ docker -v
Docker version 17.09.0-ce, build afdb6d4

✗ docker-compose -v
docker-compose version 1.16.1, build 6d1ac21
```

### How to start:

* `./gradlew bootRun`
* `./gradlew clean build && java -jar build/libs/*.jar`

### How to invoke test:

``` bash
gradle test
```

### Docker env:

#### Docker compose start:

* `docker-compose up`
* `docker-compose start`

### Heroku deploy link

[https://harald-fairhair.herokuapp.com](https://harald-fairhair.herokuapp.com)
