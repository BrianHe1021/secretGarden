#!/usr/bin/env bash
cd $(dirname $0)
cd ../
mvn clean package
echo -e "build: \033[32;49;1m [DONE] \033[39;49;0m"

scp -i '~/.ssh/he930810.pem' ./target/secretgarden-*.jar   ec2-user@52.89.73.163:~/upload/
echo -e "upload: \033[32;49;1m [DONE] \033[39;49;0m"
