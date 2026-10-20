@echo off
chcp 65001 > nul
set "JAVA_HOME=C:\Program Files\Java\jdk-26"
set "MAVEN_CMD=C:\Program Files\JetBrains\IntelliJ IDEA 2026.1.2\plugins\maven\lib\maven3\bin\mvn.cmd"
echo ===================================================
echo   Compilando com Maven...
echo ===================================================
call "%MAVEN_CMD%" package -DskipTests
if %ERRORLEVEL% equ 0 (
    echo.
    echo ===================================================
    echo   Iniciando Controle Financeiro (Spring Boot)...
    echo ===================================================
    "%JAVA_HOME%\bin\java.exe" -jar target\ControleFinanceiro-0.0.1-SNAPSHOT.jar
) else (
    echo.
    echo [ERRO] Falha na compilação.
)
pause
