# GEOIP-mmdb-generator
GEOIP2-mmdb-generator is a tool made to convert entries of IP and information into a perl script, which is then used to compile the .mmdb GEOIP2 database used by Logstash. 

#### Prerequisite
To run this tool you will need: 
- Java Runtime Environment
-  A connected internet

To run the generated perl script file that will compile the database you will need: 
- CPAN
- Maxmind::Database::Writer
- Maxmind :: DB :: Reader



#### steps to use the Generator: 
To use the mmdb generator: 
1.clone the repository, compile and run the main.java, or if you use an Java editor, import the project
```sh
$ git clone https://github.com/Kamagawa/geoIP2-mmdb-generator.git
$ cd geoIP2-mmdb-generator
```
2.Copy and paste the source file into the project folder, the source file will have IP addresses and info in the following format: 
```sh

```
2. 