#!/bin/sh
cd `dirname $0`

tar -xzvf  /program/game-jetty-1.0.0-bin.tar.gz -C /program
/program/bin/start.sh
