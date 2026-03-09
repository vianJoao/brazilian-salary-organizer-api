# Salary Organizer API

API REST desenvolvida com Spring Boot para simulação financeira de renda mensal nos regimes CLT e PJ.

## Objetivo

Calcular:

- Renda mensal real
- Total de despesas
- Dinheiro restante
- Margem financeira
- Status financeiro

## Tecnologias

- Java 17+
- Spring Boot
- Lombok

## Endpoint

POST `/benefits/simulate`

### Exemplo de Request

```json
{
  "contractTypes": "PJ" ou "CLT",
  "salary": ,
  "hasThirteenth": ,
  "hasVacation": ,
  "hasHealthInsurance": ,
  "hasFoodVoucher": ,
  "foodVoucher": ,
  "foodExpense": ,
  "cardExpense": ,
  "fixedExpenses":,
  "taxRate": ,
  "accountantCost": 
}