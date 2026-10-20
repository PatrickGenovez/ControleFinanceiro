#!/bin/bash
export JAVA_HOME="C:/Program Files/Java/jdk-26"
export PATH="$JAVA_HOME/bin:$PATH"
echo "==================================================="
echo "  Iniciando Controle Financeiro (Spring Boot)..."
echo "==================================================="
java -jar target/ControleFinanceiro-0.0.1-SNAPSHOT.jar
