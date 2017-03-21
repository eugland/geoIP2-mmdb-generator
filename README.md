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

1. Clone the repository, compile the java program, or if you use an Java editor, import the project (there will be a simple executable in final release)
```sh
> git clone https://github.com/Kamagawa/geoIP2-mmdb-generator.git
> cd geoIP2-mmdb-generator
```
2. Copy and paste the source file into the project folder, the source file (raw.txt) will have IP addresses and info in the following format: 
raw.txt
```sh
 10.125.25.0 - 10.125.25.255 (Canada, Ontario, Toronto)
```
3. run the program, and you will see a file named script.pl. This is the file you will use to compile the mmdb databse
4. now run script.pl (this step will be automated in final release)
```sh
 >perl script.pl
```
5. If the compilation ran successfully, you will see a file named "internal-databse.mmdb"