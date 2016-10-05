FROM tomcat:8-jre8
MAINTAINER "Gregoire BEAUDEQUIN <gregoire.beaudequin@gmail.com>"

COPY ./run.sh / 
RUN chmod +x /run.sh
ENTRYPOINT ["/run.sh"]
