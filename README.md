# Atlore

Atlore is a workspace platform for knowledge management, project organization, and team collaboration. The goal is to bring documents, notes, tasks, and structured content into a single product with a clean information model and a scalable backend foundation.

## Vision

Atlore is being built as a modern web application with support for:

- authentication and profile management
- workspaces and member roles
- nested pages and structured content
- search and organization workflows
- sharing, permissions, and notifications

## Tech Stack

Current stack direction:

- Backend: Java, Spring Boot, Spring Security, Spring Data JPA, Flyway
- Database: PostgreSQL
- Cache / infra support: Redis
- Frontend: React, TypeScript, Tailwind CSS
- Local infrastructure: Docker Compose

## Architecture Direction

The project starts as a modular monolith. That keeps the codebase easier to reason about while still allowing strong boundaries between domains such as auth, users, workspaces, and pages.

## Current Status

The repository currently includes:

- backend bootstrap with Spring Boot
- local PostgreSQL and Redis services via Docker Compose
- base configuration for Flyway, JPA, Redis, and Actuator
- initial schema migration wiring

## Repository Structure

```text
atlore/
  backend/
  docs/
  docker-compose.yml
  README.md
```

## Local Development

### Prerequisites

- Java 21
- Maven
- Docker Desktop

### Start Infrastructure

From the repository root:

```powershell
docker compose up -d
```

### Start Backend

From `backend/`:

```powershell
mvn spring-boot:run
```

### Health Check

```text
http://localhost:8080/actuator/health
```

## Roadmap

Project planning and milestone notes live in:

- [Engineering Roadmap](docs/engineering-roadmap.md)
- [Backend v0.1 Plan](docs/backend-v0.1.md)

## Near-Term Goals

- establish a clean backend foundation
- implement authentication and user management
- add workspace and membership flows
- build the first page lifecycle endpoints
- introduce repeatable tests and stronger production defaults
