#!/usr/bin/env bash
cd $(dirname $0)
cd ../src/main/angular
echo -e "\033[44;37;5m Build Begin \033[0m"
ng build
echo -e "build: \033[32;49;1m [DONE] \033[39;49;0m"
echo -e "\033[44;37;5m upload Begin \033[0m"
pwd
scp -i '~/.ssh/ErrandsPair.pem' ./dist ec2-user@18.191.103.130:~/upload/
echo -e "upload: \033[32;49;1m [DONE] \033[39;49;0m"


