#!/bin/bash

basepath=$(cd `dirname $0`; pwd)
cd $basepath; java org.fmgroup.mediator.core.Core $*
