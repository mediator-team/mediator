#!/bin/bash

MAVEN_TARGET=target
PACKAGE_TARGET=release

basepath=$(cd `dirname $0`; cd ..; pwd)
cd $basepath

bold=$(tput bold)
normal=$(tput sgr0)

case $1 in
    package)
        mkdir -p $PACKAGE_TARGET
        rm -rf $PACKAGE_TARGET/*

        # compile
        mvn clean
        mvn compile

        cp -r $MAVEN_TARGET/classes/* $PACKAGE_TARGET/
        cp -r $MAVEN_TARGET/mvnlib/* $PACKAGE_TARGET/
        rm -rf $PACKAGE_TARGET/META-INF

        # copy launchers
        cp scripts/launchers/* $PACKAGE_TARGET/
        chmod +x $PACKAGE_TARGET/*.sh

        zip $PACKAGE_TARGET.zip -r $PACKAGE_TARGET
    ;;

    clean)
        mvn clean
        rm -rf $PACKAGE_TARGET
        rm -rf $PACKAGE_TARGET.zip
    ;;

    *)
        # print help
        echo "Mediator Compiling and Packaging Script"
        echo ""
        echo "    ${bold}usage: <release.sh> <command>${normal}"
        echo ""
        echo "supported <command>"
        echo "---"
        echo "- ${bold}package${normal} : compile and copy (both Mediator class files and dependencies) to ${PACKAGE_TARGET}, and generating launcher scripts together with zip packages"
        echo "- ${bold}clean${normal}   : clean all generated files"
esac