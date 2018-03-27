FROM payara/server-full
ENV ADMIN_USER admin
ENV ADMIN_PASSWORD admin
RUN $PAYARA_PATH/bin/asadmin start-domain && \
$PAYARA_PATH/bin/asadmin --user $ADMIN_USER --passwordfile=/opt/pwdfile create-jms-resource --restype javax.jms.Queue --property Name=queueProcessamento jms/queueProcessamento && \
$PAYARA_PATH/bin/asadmin --user $ADMIN_USER --passwordfile=/opt/pwdfile create-jms-resource --restype javax.jms.Topic --property Name=TopicFinalizacao jms/TopicFinalizacao 
COPY mdb-web/target/mdb-web.war $DEPLOY_DIR
COPY mdb-cartcredit/target/mdb-cartcredit.war $DEPLOY_DIR
COPY mdb-email/target/mdb-email.war $DEPLOY_DIR



