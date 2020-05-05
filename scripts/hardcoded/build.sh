rm -fr $HOME/.m2/repository
rm -fr $PWD/output/classpath
rm -fr $PWD/output/modulepath
mvn -P hardcoded -Dbluezone.cp=$PWD/output/classpath -Dbluezone.mp=$PWD/output/modulepath clean install -U
