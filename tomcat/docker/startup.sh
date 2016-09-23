#!/bin/sh
cd `dirname $0`

java -Duser.timezone=GMT+08 -jar app.jar
