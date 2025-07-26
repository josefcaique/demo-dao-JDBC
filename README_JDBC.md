
# 🧪 Projeto de Aprendizado: CRUD com JDBC em Java

Este projeto foi desenvolvido como parte do meu processo de **aprendizado em Java**. O foco principal foi entender como funciona a conexão com banco de dados utilizando **JDBC puro**, sem frameworks, aplicando o padrão DAO e boas práticas de organização de código.

---

## 🎯 Objetivo

Implementar uma aplicação simples com funcionalidades de CRUD (Create, Read, Update, Delete) usando Java, seguindo os conceitos:

- JDBC (Java Database Connectivity)
- Padrão DAO (Data Access Object)
- Organização em camadas: entidade, DAO, conexão
- Tratamento de exceções e boas práticas

---

## 📁 Estrutura do Projeto

```
src/
├── dao/
│   ├── DaoFactory.java
│   ├── DepartmentDao.java
│   └── SellerDao.java
│
├── dao/impl/
│   ├── DepartmentDaoJDBC.java
│   └── SellerDaoJDBC.java
│
├── db/
│   ├── DB.java
│   ├── DbException.java
│   └── DbIntegrityException.java
│
├── entities/
│   ├── Department.java
│   └── Seller.java
│
└── Main.java
```

---

## 🛠️ Como executar

1. Configure seu banco de dados local (MySQL, por exemplo)
2. Altere os dados de conexão em `db.properties`
3. Compile e execute o `Main.java` para testar os métodos CRUD

---

## 📦 Funcionalidades

- Listar todos os vendedores
- Buscar vendedor por ID ou departamento
- Inserir novo vendedor
- Atualizar dados de um vendedor
- Deletar um vendedor
- Mesma estrutura para `Department`

---

## 🧠 Aprendizados

✅ Como funciona o JDBC  
✅ Como separar responsabilidades com DAO  
✅ Como mapear entidades  
✅ Como organizar um projeto Java puro sem frameworks  

---

## 👤 Autor

**Josef Caique**  
📚 Projeto desenvolvido exclusivamente para fins educacionais.

---

## 📄 Licença

Uso livre para estudo e aprendizado.
