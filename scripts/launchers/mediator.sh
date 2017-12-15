#!/bin/bash

basepath=$(cd `dirname $0`; pwd)
java -classpath $basepath org.fmgroup.mediator.core.Core $*
