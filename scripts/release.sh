#!/bin/bash

basepath=$(cd `dirname $0`; cd ..; pwd)
cd $basepath

mkdir -p release
rm -rf release/*

# compile
mvn clean
mvn compile

cp -r target/classes/* release/
cp -r target/mvnlib/* release/
rm -rf release/META-INF

# clean
mvn clean

# copy launchers
cp scripts/launchers/* release/
chmod +x release/*.sh


# todo zip file