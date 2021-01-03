# Kakara Core  [![Kakara Core](https://cmb.potatocorp.dev/kakara/org.kakara.core/common/badge.png)](https://cmb.potatocorp.dev/)

The API/Mod API core for Kakara.

## Core Modules
Core has been split into a 5 modules
 - `common`
	 - Contains all common classes between a server and client
 - `server`
	 - Server Specific classes
	 - Also extensions of common classes with setters
 - `client`
	 - Contains Client Specific Classes
 - `network`
	 - Contains classes that are network related. Does not extend common
 - `auth`
	 - Contains classses that are auth related. Does not extend common


## Accessing the Depend
### Maven
#### Repo
```xml
<repository>
 <id>kakara-repo</id>
 <url>https://repo.kingtux.me/storages/maven/kakara</url>
</repository>
```
#### Depend
```xml
<dependency>
 <groupId>org.kakara.core</groupId>
 <artifactId>{core_module}</artifactId>
 <version>1.0-RW-SNAPSHOT</version>
</dependency>
```
### Gradle
#### Repo
```
maven("https://repo.kingtux.me/storages/maven/kakara")
```
##### Depend
```
compileOnly 'org.kakara.core:{core_module}:1.0-RW-SNAPSHOT'
```
