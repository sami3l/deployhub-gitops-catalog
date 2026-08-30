# Architecture notes

The first release separates the browser interface, REST API and relational database. Each component has an explicit boundary and can be deployed or scaled independently.

```mermaid
flowchart LR
    U[User] --> F[Next.js frontend]
    F --> A[Spring Boot API]
    A --> P[(PostgreSQL)]
    G[GitHub Actions] --> F
    G --> A
```

The local environment uses Docker Compose. The public demo will use free managed resources; a later phase introduces Helm and GitOps without changing the application boundaries.
