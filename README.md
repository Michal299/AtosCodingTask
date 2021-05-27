# AtosCodingTask
Coding task made for recruitment process for summer intership to Atos company.
Project contains simple test which covers basic cases of usage created classes. 
Also there is xsd scheme for xml validation.

## Requirements
* Apache Maven 3.5.x+
* Open JDK 8.x+

## Building
In order to build project generating jar archive use:
```bash
mvn assembly:assembly
```

## Running
To run project use:

```bash
java -jar target\CodingTask-1.0-SNAPSHOT.jar
```
## Usage
At the beggining you will be asked to give name of file with currencies. 
The file must be valid and compatible with file: http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml.
There is already simple file in project file, named currency.xml, which contains file from the link above.

After load currencies you need to type value and currency name to make conversion.

If you want to stop using application, just enter value smaller than zero.


## Author
Michał Błajet
