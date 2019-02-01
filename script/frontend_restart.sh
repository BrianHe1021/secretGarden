#!/usr/bin/env bash
ssh -i '~/.ssh/ErrandsPair.pem' ec2-user@18.191.103.130 "
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
