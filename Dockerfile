FROM payara/server-full
COPY mdb-web/target/mdb-web.war $DEPLOY_DIR
COPY mdb-cartcredit/target/mdb-cartcredit.war $DEPLOY_DIR
COPY mdb-email/target/mdb-email.war $DEPLOY_DIR



