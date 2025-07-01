# 🍝 Spaghetti API

This project is intentionally messy and chaotic, meant to simulate a legacy or poorly written Spring Boot API. It will later be refactored and improved progressively.

## 🚧 Current State: Chaos
- No architecture
- Mixed responsibilities
- No DTOs, validations or tests
- Weird naming and structure
- Controllers acting as services and repositories

## 🧭 Project Goal
Start with a terrible codebase and evolve it by applying:
- ✅ DDD (Domain-Driven Design)
- ✅ Clean Architecture (Ports & Adapters)
- ✅ Spring Boot 3 best practices
- ✅ Unit and integration testing
- ✅ DTOs, error handling, standard responses

## 📁 Current Folder Structure
```
src/main/java/com/example/spaghetti
├── ControllerService.java
├── MainConfig.java
├── ModelRepoController.java
├── SpaghettiApplication.java
├── Utils.java
```

## 🧪 Evolution Plan
1. Step 0 – Spaghetti (now)
2. Step 1 – Split layers (controller/service/repository/model)
3. Step 2 – Introduce Clean Arch + DDD
4. Step 3 – Add tests, validations, error handling, DTOs

## ▶️ Running the App
```bash
git clone https://github.com/your-user/spaghetti-api.git
cd spaghetti-api
./mvnw spring-boot:run
```
Access:
- http://localhost:8080/items
- http://localhost:8080/things/list

## ✍️ Author
Gabriela Goudromihos Puig — proving that bad code can become great.

---
Ready to clean it up? Let’s go from chaos to clarity.
