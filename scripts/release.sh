#!/bin/bash

basepath=$(cd `dirname $0`; cd ..; pwd)
cd $basepath

mkdir -p release
rm -rf release/*

cp -r target/classes/* release/
rm -rf release/META-INF

# copy launchers
cp scripts/launchers/* release/ 

# todo package dependencies