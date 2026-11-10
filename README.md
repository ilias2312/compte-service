# compte-service - Micro-service de gestion de comptes bancaires

Lancement : `mvn spring-boot:run`  (port 8082, Java 17+)

| Etape | Test |
|-------|------|
| 4  DAO | `mvn test` (CompteRepositoryTest, @DataJpaTest) |
| 5-6  REST + Postman | GET/POST http://localhost:8082/comptes ; GET/PUT/DELETE http://localhost:8082/comptes/{id} |
| 7  Swagger | http://localhost:8082/swagger-ui.html - JSON : /v3/api-docs |
| 8  Spring Data REST | http://localhost:8082/api/comptes ; ?projection=mobile ; ?projection=solde ; /api/comptes/search/byType?t=EPARGNE |
| 11 GraphQL | GraphiQL : http://localhost:8082/graphiql - endpoint POST /graphql |
| H2 console | http://localhost:8082/h2-console  (jdbc:h2:mem:comptes-db) |

Corps JSON pour POST/PUT :
    { "solde": 7500, "type": "COURANT" }

Exemples GraphQL :
    query { allComptes { id solde type dateCreation } }
    query { compteById(id: 1) { id solde } }
    query { totalSolde { nombreComptes sommeSoldes moyenneSoldes } }
    mutation { saveCompte(compte: {solde: 3000, type: EPARGNE}) { id solde type } }
    mutation { updateCompte(id: 1, compte: {solde: 12000}) { id solde } }
    mutation { deleteCompte(id: 2) }
