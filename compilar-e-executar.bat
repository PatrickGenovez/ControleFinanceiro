@echo off
chcp 65001 > nul
echo ===================================================
echo   Compilando com Maven...
echo ===================================================
call mvn package -DskipTests
if %ERRORLEVEL% equ 0 (
    echo.
    echo ===================================================
    echo   Iniciando Controle Financeiro (Spring Boot)...
    echo ===================================================
    java -jar target\ControleFinanceiro-0.0.1-SNAPSHOT.jar
) else (
    echo.
    echo [ERRO] Falha na compilacao. Verifique se o Maven esta instalado e no PATH.
)
pause
