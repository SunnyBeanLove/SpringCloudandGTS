mvn package  -Dmaven.test.skip=true
cp ../../lib/txc-client-2.0.72.jar client/lib/
cd client/bin
sed 's/demo-0.0.1-SNAPSHOT.jar/demo-0.0.1-SNAPSHOT.jar:"$REPO"\/txc-client-2.0.72.jar/' ./consumer.sh >consumer_run.sh
chmod +x *.sh
