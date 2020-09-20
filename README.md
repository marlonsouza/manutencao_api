# manutencao_api


To Run
```
./mvnw spring-boot:run
```

## User

###### Para cadastrar um usuário

```
POST
http://localhost:8080/user
```

Definição UserDTO:
```json
{
   "email": {
      "type": "string"
    },
    "nome": {
      "type": "string"
    },
    "password": {
      "type": "string"
    }
}
```

######Para efetuar login com Oauth2

```
POST
http://localhost:8080/oauth/token
Basic Auth username:projuris password:123
username: projuris@projuris.com
password: <vazio>

```

**Todas as demais requisições vão necessitar do Bearer token**

## Equipamento
###### Para cadastrar um equipamento

```
POST
http://localhost:8080/equipamento
```

Definição Equipamento:
```json
{
    "marca": {
      "type": "string"
    },
    "tipo": {
      "type": "string"
    }
}
```

###### Para listar equipamentos
```
GET
http://localhost:8080/equipamento
```

## Cliente
###### Para cadastrar um cliente

```
POST
http://localhost:8080/cliente
```

Definição Cliente:
```json

{
    "email": {
      "type": "string"
    },
    "endereco": {
      "type": "string"
    },
    "nome": {
      "type": "string"
    },
    "telefone": {
      "type": "string"
    }
}
```

###### Para listar clientes
```
GET
http://localhost:8080/cliente
```

##Ordem de serviço
###### Para cadastrar uma ordem de serviço
```
POST
http://localhost:8080/ordem
```

Definição de Ordem de Serviço:
```json

{
    "descricao": {
      "type": "string"
    },
    "idCliente": {
      "type": "integer",
      "format": "int64"
    },
    "idEquipamento": {
      "type": "integer",
      "format": "int64"
    },
    "inicioServico": {
      "type": "string",
      "format": "date-time"
    },
    "finalServico": {
      "type": "string",
      "format": "date-time"
    }
}
```

###### Para iniciar trabalho em uma ordem de serviço
```
PUT
http://localhost:8080/ordem/{numeroOrdem}/iniciar
```

###### Para finalizar trabalho em uma ordem de serviço
```
PUT
http://localhost:8080/ordem/{numeroOrdem}/finalizar
```
