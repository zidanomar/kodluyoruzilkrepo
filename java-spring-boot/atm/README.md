# ATM Bank

Fullstack ATM simulator. Spring Boot 4.0.6 backend + React / shadcn-ui frontend + PostgreSQL, all orchestrated with Docker Compose.

## Features

- Register / login with **Spring Security + JWT**; passwords stored as BCrypt hashes.
- Customer operations: **deposit**, **withdraw** (with insufficient-funds guard), **transfer**, paginated transaction history.
- Admin dashboard: paginated customer list, per-customer balance + transactions + login history, customers active today, manual unlock.
- **3 wrong login attempts → account locked** until admin unlock.
- Event-driven **logging** of every transaction and login (Observer pattern via `ApplicationEventPublisher`).
- Dual persistence for user registrations: database **and** CSV file (`./data/users.csv`).
- Design patterns: **Strategy** (`TransactionStrategy` + concrete Deposit/Withdraw/Transfer), **Factory** (`TransactionStrategyFactory`), **Template Method** (`AbstractTransactionStrategy`), **Observer** (`AuditListener`), **Builder** (Lombok).
- OOP: abstract `Auditable` + `AbstractTransactionStrategy`, interface `TransactionStrategy`, inheritance across strategies, enums `Role` / `TransactionType` / `TransactionStatus`, `Optional` and Stream API in services/DTO mappers.

## Layout

```
atm/
├── server/            # Spring Boot 4.0.6 backend
├── client/            # React + Vite + shadcn UI
├── docs/
│   ├── uml.md         # Mermaid UML diagrams
│   └── schema.dbml    # dbdiagram.io schema
├── docker-compose.yml
└── requirements.md
```

## Run with Docker Compose

```bash
docker compose up --build
```

Then:
- Frontend:  http://localhost:5173
- Backend:   http://localhost:8080 (Swagger UI: `/swagger-ui.html`)
- Postgres:  `localhost:5432`  (user `atm`, password `atm`, db `atmbank`)

Default admin: `admin / admin123` (seeded on first boot).

## Run locally (no Docker)

### Backend
```bash
cd server
# requires Java 21+ and Maven 3.9+
mvn spring-boot:run
```
Backend listens on `:8080`. Uses Postgres by default; export `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` to point elsewhere, or run an H2 profile (`-Dspring.profiles.active=test`).

### Frontend
```bash
cd client
npm install
npm run dev
```
Frontend on `:5173`. Set `VITE_API_BASE_URL` in `.env.local` if the backend is elsewhere.

## Key endpoints

| Method | Path                                          | Role      |
|--------|-----------------------------------------------|-----------|
| POST   | `/api/auth/register`                          | public    |
| POST   | `/api/auth/login`                             | public    |
| GET    | `/api/customer/me`                            | CUSTOMER  |
| POST   | `/api/customer/deposit`                       | CUSTOMER  |
| POST   | `/api/customer/withdraw`                      | CUSTOMER  |
| POST   | `/api/customer/transfer`                      | CUSTOMER  |
| GET    | `/api/customer/transactions?page=&size=`      | CUSTOMER  |
| GET    | `/api/admin/customers?page=&size=`            | ADMIN     |
| GET    | `/api/admin/customers/{id}`                   | ADMIN     |
| GET    | `/api/admin/customers/{id}/transactions`      | ADMIN     |
| GET    | `/api/admin/customers/{id}/logins`            | ADMIN     |
| GET    | `/api/admin/customers/active-today`           | ADMIN     |
| POST   | `/api/admin/customers/{id}/unlock`            | ADMIN     |

## Diagrams

- `docs/uml.md` renders Mermaid class + sequence diagrams (GitHub renders Mermaid natively).
- `docs/schema.dbml` drops straight into https://dbdiagram.io for an EER view.
