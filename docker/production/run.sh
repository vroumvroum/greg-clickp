#!/bin/bash

set -x
env

#Copy war to deploy
if [ "$VERSION_APP" == "latest" ]; then 
   wget $(curl -s https://api.github.com/repos/vroumvroum/greg-clickp/releases/latest | grep 'browser_' | cut -d\" -f4); 
else
   wget https://github.com/vroumvroum/greg-clickp/releases/$VERSION_APP/clickCount.war
fi

#Put war to auto deploy directory
cp ./clickCount.war ./webapps

#Starting Catalina
catalina.sh run

