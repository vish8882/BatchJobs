#!/bin/bash

if [ $# -ne 1 ]
then
	echo "WRONG PARAMETERS"
	echo "USAGE: start.sh <JOB_NAME> <TENANT_NAME>"
	exit
fi

BASE=`dirname $0`

APPLICATION_TENANT=$2
LOG_FILE=$BASE/../logs/$APPLICATION_TENANT/$1.`date +"%Y%m%d-%H%M"`.log
LIB_DIR=$BASE/../lib
CONFIG_DIR=$BASE/../config/$APPLICATION_TENANT
MAIN_CLASS=org.springframework.batch.core.launch.support.CommandLineJobRunner


exec >> $LOG_FILE

source $CONFIG_DIR/commons.env

echo "Environment:"
echo "JAVA_CMD=$JAVA_CMD"
echo "LIB_DIR=$LIB_DIR"
echo "CONFIG_DIR=$CONFIG_DIR"
echo "MAIN_CLASS=$MAIN_CLASS"

echo "building classpath using JARs contained in: $LIB_DIR"
JARS_LIST=`ls ${LIB_DIR}/*.jar`
for i in ${JARS_LIST} ; do
  CLASSPATH=${CLASSPATH}:${i}
done

echo "adding config directory to the classpath"
CLASSPATH=$CONFIG_DIR:${CLASSPATH}

#JVM_PARAMETERS="-Xms1024m -Xmx1024m -XX:+DisableExplicitGC -Dcom.sun.management.jmxremote.port=9999 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -XX:+UseConcMarkSweepGC -XX:ParallelGCThreads=2 -XX:+PrintGC -Xloggc:../log/UserAdvTagsIngestor_gc.log -XX:+PrintGCDetails -XX:+PrintGCTimeStamps"
JVM_PARAMETERS=" -Xms1024m -Xmx1024m -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:ParallelGCThreads=2"
APP_PARAMETERS="launch-context.xml jobSubscriptionReport"

#ALREADY_RUNNING=$(ps -eaf | grep java | grep $MAIN_CLASS)
#
#if [ -n "$ALREADY_RUNNING" ]; then
#  echo "software already running, aborting..."
#  exit -1
#else
  ${JAVA_CMD} ${JVM_PARAMETERS} -classpath ${CLASSPATH} ${MAIN_CLASS} ${APP_PARAMETERS} $1 
#fi

EXIT_CODE=${?}

if [ ${EXIT_CODE} -ne 0 ] ; then
  echo "Error during execution. Program terminated with exit code: $EXIT_CODE"
  exit ${EXIT_CODE};
else
  echo "Execution of Subscription Report batch completed successfully."
fi
