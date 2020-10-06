# BlueZone
## An example application implementing Hexagonal Architecture

See the article series: [https://jmgarridopaz.github.io/content/hexagonalarchitecture-ig/intro.html]

### Development environment:

- Java 9 (jdk-9.0.4)

- Maven 3.5.4

- Eclipse IDE 2019-12 (4.14.0)

- Ubuntu 18.04.5 LTS

### Compile and Run Instructions:

- Download and extract this github repo to a local directory on your computer ( `<bluezone_root_dir>` )

- Test hardcoded hexagon: 

  - Compile:
  
  ~~~
  cd <bluezone_root_dir>
  ./scripts/hardcoded/build.sh
  ~~~

  - Run:
  
  ~~~
  cd <bluezone_root_dir>
  ./scripts/hardcoded/run.sh
  ~~~

  Tests results ===> `<bluezone_root_dir>/output/test/forparkingcars/index.html`
  
  (configurable at `<bluezone_root_dir>/scripts/input/bz_hardcoded.properties`)
