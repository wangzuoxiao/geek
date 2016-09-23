@echo off & setlocal enabledelayedexpansion

title OfficeWeb

set LIB_JARS=""
cd ..\lib
for %%i in (*) do set LIB_JARS=!LIB_JARS!;..\lib\%%i
cd ..\bin

if ""%1"" == ""debug"" goto debug
if ""%1"" == ""jmx"" goto jmx

java -Xms32m -Xmx64m -XX:MaxPermSize=16M -classpath ..\conf;%LIB_JARS% com.game.mj.jetty.JettyStarter
goto end

:debug
java -Xms32m -Xmx64m -XX:MaxPermSize=16M -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n -classpath ..\conf;%LIB_JARS% com.game.mj.jetty.JettyStarter
goto end

:jmx
java -Xms32m -Xmx64m -XX:MaxPermSize=16M -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -classpath ..\conf;%LIB_JARS% com.game.mj.jetty.JettyStarter

:end
pause