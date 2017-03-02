#!/bin/bash

DOMAIN_NAME=domain1
SERVER_NAME=localhost
MINIMUM=2
MAX_POOL_SIZE=10
MAX_WAIT=10
DB_PORT=3306
DB_NAME=postit
DB_USER=postit
DB_PASSWORD=postit
PAYARA_HOME=/home/tss/payara41/glassfish/bin
echo ${DB_PORT}
${PAYARA_HOME}/asadmin start-domain ${DOMAIN_NAME}
${PAYARA_HOME}/asadmin delete-jdbc-connection-pool --cascade  ${DB_NAME}Pool
${PAYARA_HOME}/asadmin create-jdbc-connection-pool --steadypoolsize ${MINIMUM} --maxwait ${MAX_WAIT} --maxpoolsize ${MAX_POOL_SIZE} --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource --restype javax.sql.DataSource --property PortNumber=${DB_PORT}:Password=${DB_PASSWORD}:User=${DB_USER}:ServerName=${SERVER_NAME}:DatabaseName=${DB_NAME} ${DB_NAME}Pool
${PAYARA_HOME}/asadmin create-jdbc-resource --port 4848 --connectionpoolid ${DB_NAME}Pool jdbc/${DB_NAME}
${PAYARA_HOME}/asadmin ping-connection-pool ${DB_NAME}Pool
${PAYARA_HOME}/asadmin stop-domain ${DOMAIN_NAME}

