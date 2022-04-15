# Kakara Core  [![kakara Repository](https://repo.kingtux.me/badge/maven/kakara/org/kakara.core/common/badge)](https://repo.kingtux.me/project/maven/kakara/org.kakara.core:common)
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
