#!/usr/bin/env bash
ssh -i '~/.ssh/he930810.pem' ec2-user@52.89.73.163 "
pwd;
mv secretgarden/angular secretgarden/angularbak;
pwd;
cp -rf upload/angular/ secretgarden/angular;
chmod 777 secretgarden/angular
chmod 777 secretgarden/angular/*
pwd;
sudo nginx -s reload;
sudo service nginx restart;
exit;"
echo -e "restart: \033[32;49;1m [DONE] \033[39;49;0m"
