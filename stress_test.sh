#!/bin/bash

# Configurações
URL="http://localhost:8081/notificacoes"
TOTAL_REQUISICOES=50
DELAY=0.1

echo "🚀 Iniciando teste de carga no sistema de notificações..."
echo "Alvo: $URL | Total: $TOTAL_REQUISICOES mensagens"

for i in $(seq 1 $TOTAL_REQUISICOES)
do
  # Gerando um JSON dinâmico com IDs diferentes
  DATA="{\"id\": \"$i\", \"mensagem\": \"Mensagem de teste em massa número $i\", \"destino\": \"filipe@workspace.com\"}"
  
  # Enviando o POST via curl em background (&) para simular concorrência
  curl -s -X POST $URL \
       -H "Content-Type: application/json" \
       -d "$DATA" > /dev/null &
  
  echo "✅ Enviada notificação ID: $i"
  
  # Pequeno intervalo para não travar o socket local instantaneamente
  sleep $DELAY
done

wait
echo "✨ Teste finalizado! Verifique os logs do Spring e o Redis."
