## 코인끼리

- [프로젝트 소개](#프로젝트-소개)
    * [프로젝트 기능](#프로젝트-기능)
- [기술 스택](#기술-스택)
- [헥사고날 아키텍처](#헥사고날-아키텍처)
- [멀티 모듈](#멀티-모듈)
- [배포 파이프라인](#배포-파이프라인)
- [ERD](#erd)
- [패키지 구조](#패키지-구조)
- [개발 위키](#개발-위키)
- [컨벤션과 협업 전략](#컨벤션과-협업-전략)

## 프로젝트 소개

## 기술 스택

- Kotlin 1.9.23
- Gradle 8.6
- Spring Boot 3.2.5
- Spring Data JPA
- MySQL 8.3.0
- Redis 7.2.5
- Notion, Discord

## 헥사고날 아키텍처

![헥사고날 아키텍처](https://github.com/user-attachments/assets/19825ae3-bbda-4a59-abe5-8e8b7040062b)

## 멀티 모듈

![멀티 모듈](https://github.com/user-attachments/assets/8a9c5a46-19fd-4451-b0f1-4e454218dbc2)

- Root (최상위)
    - Domain
    - Application
    - Bootstrap
    - Infrastructure
        - Persistence
        - Redis
        - Upbit
        - OAuth2

## ERD

![ERD](https://github.com/user-attachments/assets/33a0f7e4-941f-4b9e-8817-8931a55857eb)

- Chat은 firebase의 영역입니다. 보기 쉽게 ERD에 같이 포함하여 표현했습니다.

## 패키지 구조

```
├── 📁 coinkiri-bootstrap
│   └── 📁 api
│       └── src
│           └── main
│               └── kotlin
│                   └── com.coinkiri
│                       └── api
│                           ├── adapter
│                           │   ├── controller
│                           │   ├── request
│                           │   └── response
│                           ├── config
│                           └── ApiApplication.kt
├── 📁 coinkiri-application
│   └── src
│       └── main
│           └── kotlin
│               └── com.coinkiri
│                   └── application
│                       └── config
│                           ├── interceptor
│                           ├── resolver
│                           ├── security
│                           └── ApplicationConfig.kt
│                       └── port
│                           ├── in
│                           └── out
│                       └── service
│                           ├── auth
│                           ├── coin
│                           ├── member
│                           └── token
├── 📁 coinkiri-domain
│   └── src
│       └── main
│           └── kotlin
│               └── com.coinkiri
│                   └── domain
│                       └── coin
│                       └── member
├── 📁 coinkiri-infrastructrue
│   ├── 📁 oauth2
│   │   └── src
│   │       └── main
│   │           └── kotlin
│   │               └── com.coinkiri
│   │                   └── oauth2
│   │                       ├── adapter
│   │                       └── config
│   ├── 📁 persistence
│   │   └── src
│   │       └── main
│   │           └── kotlin
│   │               └── com.coinkiri
│   │                   └── persistence
│   │                       ├── adapter
│   │                       └── config
│   ├── 📁 redis
│   │   └── src
│   │       └── main
│   │           └── kotlin
│   │               └── com.coinkiri
│   │                   └── redis
│   │                       ├── adapter
│   │                       └── config
│   └── 📁 upbit
│       └── src
│           └── main
│               └── kotlin
│                   └── com.coinkiri
│                       └── upbit
│                           ├── adapter
│                           └── config
│
├── 📁 common
│   └── src
│       └── main
│           └── kotlin
│               └── com.coinkiri
│                   └── common
│                       └── advice
│                       └── code
│                       └── config
│                       └── log
│                       └── response
└──
```

## 개발 위키

다음 링크에서 개발 위키를 확인할 수 있습니다.
[개발 위키](https://abalone-shake-786.notion.site/fb0dc47690a74b3093834013dd086a6c?v=c1f7d935b9994602abe64d4033a5bde6&pvs=74)

