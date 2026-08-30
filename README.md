# DeployHub

DeployHub is an independent, GitOps-ready application catalog built as a public DevOps case study. It demonstrates a containerized full-stack system, automated verificatio n, health checks and cloud-ready configuration.

> This is an original portfolio project. It contains no employer source code, infrastructure details, credentials or proprietary assets.

## Architecture

- **Frontend:** Next.js and TypeScript
- **API:** Java 17 and Spring Boot
- **Database:** PostgreSQL (H2 for local API-only development)
- **Delivery:** Docker Compose and GitHub Actions
- **Operations:** Actuator health probes and non-root containers

## Run the complete stack

Requirements: Docker with the Compose plugin.

```bash
cp .env.example .env
docker compose up --build
```

Open:

- Frontend: http://localhost:3000
- API: http://localhost:8080/api/applications
- Health: http://localhost:8080/actuator/health

Stop the services with `docker compose down`. Add `--volumes` only when you intentionally want to delete local database data.

## Repository layout

```text
frontend/             Next.js user interface
backend/              Spring Boot REST API
infrastructure/       Cloud and GitOps configuration (next phase)
docs/                 Architecture and case-study material
.github/workflows/    Continuous integration
compose.yaml          Local multi-container environment
```

## Roadmap

- [x] Application catalog API and interface
- [x] PostgreSQL-backed local container stack
- [x] Backend and frontend CI checks
- [ ] Deployment request workflow and history
- [ ] Cloud deployment
- [ ] Container vulnerability scanning
- [ ] Helm chart and GitOps environment

## License

MIT

