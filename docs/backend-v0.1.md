# Backend v0.1 Plan

This is the first serious backend milestone: authentication, workspaces, and basic pages.

## Suggested Package Structure

Keep common infrastructure small, and keep domain logic grouped clearly.

```text
com.atlore
  common
    config
    exception
    response
    security
    validation
  auth
    controller
    dto
    entity
    repository
    service
  user
    controller
    dto
    entity
    repository
    service
  workspace
    controller
    dto
    entity
    repository
    service
  page
    controller
    dto
    entity
    repository
    service
```

This keeps the code understandable while still matching the layered style from the project overview.

## First Entities

Start with these:

- `User`
- `RefreshTokenSession`
- `Workspace`
- `WorkspaceMember`
- `Page`

Suggested relationships:

- one `User` can own many `Workspace`s
- one `Workspace` has many `WorkspaceMember`s
- one `WorkspaceMember` links a `User` to a `Workspace` with a role
- one `Workspace` has many `Page`s
- one `Page` can have a parent `Page` for nesting

## v0.1 API Scope

Authentication:

- `POST /api/v1/auth/register`
- `POST /api/v1/auth/login`
- `POST /api/v1/auth/refresh`
- `POST /api/v1/auth/logout`

Users:

- `GET /api/v1/users/me`
- `PATCH /api/v1/users/me`

Workspaces:

- `POST /api/v1/workspaces`
- `GET /api/v1/workspaces/{id}`
- `POST /api/v1/workspaces/{id}/members`

Pages:

- `POST /api/v1/pages`
- `GET /api/v1/pages/{id}`
- `GET /api/v1/workspaces/{workspaceId}/pages`
- `POST /api/v1/pages/{id}/archive`
- `POST /api/v1/pages/{id}/restore`

## Database Notes

Use Flyway migrations from the start.

Tables you will likely need first:

- `users`
- `refresh_token_sessions`
- `workspaces`
- `workspace_members`
- `pages`

Important constraints:

- `users.email` unique
- one workspace membership per user per workspace
- page belongs to exactly one workspace
- parent page must belong to the same workspace

## Security Notes

Make these choices intentionally:

- hash passwords with BCrypt
- keep access tokens short-lived
- store refresh tokens server-side with revocation support
- authorize by workspace membership and role
- never trust workspace IDs from the client without membership checks

## Response Design

Use a consistent envelope only if it adds value. Do not wrap everything blindly.

At minimum, keep:

- consistent success status codes
- consistent validation error format
- consistent business error format
- traceable log messages

## Testing Expectations

For v0.1, aim for:

- service-layer unit tests for auth and workspace rules
- repository integration tests for constraints and queries
- controller integration tests for happy path and authorization failures

## Recommended Build Sequence

1. Bootstrap Spring Boot project and config.
2. Add database migration support.
3. Model `User` and auth flow.
4. Add JWT security and current-user resolution.
5. Model workspace membership and roles.
6. Add page creation and retrieval.
7. Add archive and restore behavior.
8. Add tests and polish error handling.

## Questions You Should Be Able To Answer

Before moving past v0.1, make sure you can explain:

- why `WorkspaceMember` should be its own entity
- why refresh tokens should be revocable
- where authorization checks belong
- when to use DTOs instead of exposing entities
- why schema migrations matter in team development
