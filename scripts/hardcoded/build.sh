rm -fr $HOME/.m2/repository
rm -fr $PWD/scripts/hardcoded/output/classpath
rm -fr $PWD/scripts/hardcoded/output/modulepath
mvn -P hardcoded -Dbluezone.cp=$PWD/scripts/hardcoded/output/classpath -Dbluezone.mp=$PWD/scripts/hardcoded/output/modulepath clean verify
