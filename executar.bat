@echo off
chcp 65001 > nul
set "JAVA_HOME=C:\Program Files\Java\jdk-26"
set "PATH=%JAVA_HOME%\bin;%PATH%"
echo ===================================================
echo   Iniciando Controle Financeiro (Spring Boot)...
echo ===================================================
java -jar target\ControleFinanceiro-0.0.1-SNAPSHOT.jar
pause
