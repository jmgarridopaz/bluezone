# BlueZone
## An example application implementing Hexagonal Architecture

See the article series: [https://jmgarridopaz.github.io/content/hexagonalarchitecture-ig/intro.html]

### Development environment:

- Java 9 (jdk-9.0.4)

- Maven 3.5.4

- Eclipse IDE 2019-12 (4.14.0)

- Ubuntu 18.04.5 LTS (Linux 5.4.0-48-generic)

### Compile and Run Instructions:

- Download and extract this github repo to a local directory on your computer ( `<bluezone_dir>` )

- Compile all modules (you need to do this just the first time before running):
  
  ~~~
  cd <bluezone_dir>
  ./scripts/build.sh
  ~~~

- Run hardcoded driver ports tests:
  
  ~~~
  cd <bluezone_dir>
  ./scripts/hardcodedhexagon/run_forparkingcars_test.sh
  ~~~
  
  ~~~
  cd <bluezone_root_dir>
  ./scripts/hardcodedhexagon/run_forcheckingcars_test.sh
  ~~~
