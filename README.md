# SpringBoot-Cache

A mono-repository containing multiple **Spring Boot caching examples**, from default in-memory caching to Redis-based distributed caching. This repo is designed for learning, experimentation, and interview preparation.

---

## 📦 Projects Included

### 1️⃣ springboot-default-cache

Demonstrates **Spring Boot default caching** using `ConcurrentMapCacheManager`.

**Key Concepts:**
- `@EnableCaching`
- `@Cacheable`, `@CachePut`, `@CacheEvict`
- In-memory caching
- Cache hit vs miss behavior

📁 Path:
```
springboot-default-cache/
```

---

### 2️⃣ springboot-redis-cache

Demonstrates **Redis-based caching** with Spring Boot.

**Key Concepts:**
- Redis as cache provider
- `RedisCacheManager`
- Serialization & TTL
- Distributed caching

📁 Path:
```
springboot-redis-cache/
```

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Cache
- Redis
- Maven

---

## 🚀 How to Run

### Clone the repository

```bash
git clone https://github.com/Shreyash-03-codes/SpringBoot-Cache.git
cd SpringBoot-Cache
```

### Run a specific project

```bash
cd springboot-default-cache
mvn spring-boot:run
```

OR

```bash
cd springboot-redis-cache
mvn spring-boot:run
```

---

## 🧠 Why Caching?

- Improve application performance
- Reduce database load
- Handle high traffic efficiently
- Essential backend interview topic

---

## 🎯 Ideal For

- Backend developers
- Spring Boot learners
- Interview preparation
- Performance optimization practice

---

## 👨‍💻 Author

**Shreyash Gurav**  
Backend Developer | Spring Boot Enthusiast

---

⭐ If this repository helped you, consider giving it a star!

