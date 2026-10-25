@echo off
chcp 65001 > nul
echo ===================================================
echo   Iniciando Controle Financeiro (Spring Boot)...
echo ===================================================
java -jar target\ControleFinanceiro-0.0.1-SNAPSHOT.jar
pause
