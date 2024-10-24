## 코인끼리

- demo project : [github](https://github.com/COINKIRI/coinkiri-server-demo)
<br>


![메인 배너](https://github.com/user-attachments/assets/71ab5a04-3a47-4db0-a728-17722c3db1b9)

- [프로젝트 소개](#프로젝트-소개)
- [기술 스택](#기술-스택)
- [헥사고날 아키텍처](#헥사고날-아키텍처)
- [멀티 모듈](#멀티-모듈)
- [배포 파이프라인](#배포-파이프라인)
- [ERD](#erd)
- [패키지 구조](#패키지-구조)
- [개발 위키](#개발-위키)
- [컨벤션과 협업 전략](#컨벤션과-협업-전략)

## 프로젝트 소개

◼️**코인톡**
(개발 중)

코인톡은 기존의 서비스 흐름(코인의 상세 정보를 보고 해당 코인에 대한 의견을 나눔)과는 다르게 모든 코인에 대해 전체 톡을 실시간으로 확인하고, 흥미로운 채팅을 눌러 해당 코인의 상세로 들어갑니다.
코인에 대해 잘 모르는 사람이어도 단지 채팅 내용만을 보고 호기심을 가지고 어떤 코인인지 알아보게 합니다.

◼️**시세 조회**

업비트에 상장된 코인들의 시세 리스트를 확인할 수 있습니다. 코인 상세 조회를 통해 200일 차트, 당일의 증감률, 증감액, 고가, 저가 등 정보를 확인할 수 있습니다.

◼️**코인 백과**
(개발 중)

코인이 처음이고 익숙하지 않은 사람들이 기본적인 코인 용어, 개념, 코인 시장의 주요 흐름을 쉽게 이해할 수 있게 설명하는 자료를 제공합니다.

![기능 배너](https://github.com/user-attachments/assets/f06c8d45-99e0-4973-a5c6-d999fdaa931b)

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

## 컨벤션과 협업 전략

