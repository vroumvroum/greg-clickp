FROM tomcat:8-jre8
MAINTAINER "Gregoire BEAUDEQUIN <gregoire.beaudequin@gmail.com>"

ADD run.sh run.sh
RUN chmod +x run.sh 

ADD settings.xml /usr/local/tomcat/conf/
ADD tomcat-users.xml /usr/local/tomcat/conf/

CMD ./run.sh
