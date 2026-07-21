# Atlore

Atlore is a learning-first production-style project for building a modern workspace platform with Java, Spring Boot, PostgreSQL, Redis, React, and TypeScript.

The goal is not to let AI build everything for you. The goal is to use AI like a strong pair programmer while you learn how real systems are designed, implemented, tested, reviewed, and improved.

## What We Are Building

Based on the product overview, Atlore is a unified workspace platform with:

- authentication and profile management
- workspaces and member roles
- pages with nested content
- search, sharing, and notifications
- future AI-assisted features

## How We Should Work On This

Use this project to build engineering judgment, not just features.

- You should always know why a file exists, why a pattern was chosen, and what tradeoff it solves.
- We should build in small slices and verify each slice with tests, logs, and manual checks.
- We should prefer a modular monolith first, then split services only when there is a real reason.
- Every feature should teach one or two production concepts such as validation, transactions, caching, authorization, or observability.

## Current Repo State

The repo already has local infrastructure for:

- PostgreSQL
- Redis

See `docker-compose.yml`.

## Project Roadmap

- [Engineering Roadmap](docs/engineering-roadmap.md)
- [Backend v0.1 Plan](docs/backend-v0.1.md)

## Learning Rules For AI Pairing

- Ask for explanations whenever something feels magical.
- Do not merge or keep code you cannot explain back in your own words.
- After each feature, write down:
  - what problem it solves
  - why this design was chosen
  - what could go wrong in production
  - how you would test it
- Prefer building one vertical slice end to end over generating a huge codebase all at once.

## Recommended Build Order

1. Set up Git, backend skeleton, and local developer workflow.
2. Build authentication with proper validation, password hashing, JWT, and refresh tokens.
3. Build workspace and membership management with role checks.
4. Build basic page creation and retrieval with audit fields and soft delete/archive behavior.
5. Add tests, structured error handling, logging, and API documentation as first-class work.

## What "Job Ready" Looks Like Here

By the time we finish the early milestones, you should be able to:

- explain Spring Boot project structure confidently
- design entities and relationships before coding
- create REST APIs with validation and consistent responses
- reason about authentication and authorization boundaries
- debug failures using logs, tests, and database inspection
- talk through tradeoffs in interviews instead of only showing code

