rm -fr $HOME/.m2/repository
rm -fr $PWD/scripts/hardcoded/output/
mvn -Phardcoded -Dbluezone.cp=$PWD/scripts/hardcoded/output/classpath -Dbluezone.mp=$PWD/scripts/hardcoded/output/modulepath clean verify
