# Engineering Roadmap

This roadmap translates the product PDF into a realistic learning path for a production-style project.

## Guiding Architecture

Start with a modular monolith.

Why:

- it is easier to understand and debug than microservices
- it still teaches clean boundaries, separation of concerns, and scaling patterns
- most early-stage production systems should not start as microservices

Suggested backend stack:

- Java 21
- Spring Boot 3
- Spring Web
- Spring Security
- Spring Data JPA
- PostgreSQL
- Redis
- Flyway
- Testcontainers
- Docker

## Phase 0: Foundation

Goal: create a backend skeleton you can explain fully.

You should learn:

- Maven project structure
- application profiles
- configuration management
- dependency injection
- health checks
- Docker-based local development

Deliverables:

- Spring Boot app starts locally
- database and Redis connections work
- base package structure exists
- centralized exception handling exists
- request/response logging baseline exists
- Flyway migration system is set up

Definition of done:

- `docker compose up` starts dependencies
- app boots successfully against local services
- one health endpoint works
- one sample integration test passes

## Phase 1: Version 0.1

Goal: ship authentication, workspaces, and basic pages.

You should learn:

- entity modeling
- password hashing
- JWT access and refresh token flows
- role-based authorization
- DTO validation
- transactions
- audit fields

Deliverables:

- register, login, refresh token, logout
- create workspace
- invite member
- create page
- list workspace pages
- archive and restore page

Production concepts to practice:

- unique constraints
- optimistic assumptions vs explicit locking
- error response consistency
- soft delete vs hard delete
- authorization at service level, not only controller level

## Phase 2: Version 0.2

Goal: make pages richer and searchable.

You should learn:

- block-based content modeling
- full-text search basics
- pagination and filtering
- caching strategy

Deliverables:

- nested pages
- block/content model
- search endpoint
- recent search tracking

## Phase 3: Version 0.3

Goal: collaboration and file support.

You should learn:

- file upload flow
- object storage patterns
- access control for shared resources
- asynchronous processing basics

Deliverables:

- S3-compatible file upload
- sharing permissions
- comments
- activity logging

## Phase 4: Version 0.4

Goal: real-time collaboration and notifications.

You should learn:

- websockets or server-sent events
- event-driven design
- notification fan-out
- idempotency and race conditions

Deliverables:

- live collaboration foundation
- in-app notifications
- mention notifications

## Cross-Cutting Production Habits

These should be part of every phase, not postponed.

- use database migrations for schema changes
- write unit tests for business rules
- write integration tests for API and persistence flows
- log meaningful context without leaking secrets
- validate inputs at the API boundary
- keep secrets out of source control
- document decisions in short architecture notes

## What To Avoid Early

- microservices
- premature event-driven complexity
- generic "base service" abstractions
- skipping tests because the feature "works on my machine"
- letting AI generate large chunks you do not understand

## Interview Value

If you build this way, you will be able to speak clearly about:

- why you chose a modular monolith
- how JWT and refresh tokens work
- how RBAC is enforced
- how database schema changes are managed
- how you test controllers, services, and repositories
- what you would improve before production scale

