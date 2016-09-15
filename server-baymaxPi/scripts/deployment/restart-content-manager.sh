pkill -f auditor-manager-
cd ..
cd ..
java -Dfile.encoding=utf-8 -jar target/auditor-manager-0.0.1-SNAPSHOT.jar server auditor-manager-develop.yml &
