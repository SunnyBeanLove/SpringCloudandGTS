#!/usr/bin/env bash
mvn package -Dmaven.test.skip=true
cp ../../lib/txc-client-2.0.66-1.jar client/lib/
cd client/bin
sed 's/eureka-test-0.0.1-SNAPSHOT.jar/eureka-test-0.0.1-SNAPSHOT.jar:"$REPO"\/txc-client-2.0.66-1.jar/' ./locator.sh >loactor_run.sh
chmod +x *.sh