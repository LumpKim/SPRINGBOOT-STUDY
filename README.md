# SPRINGBOOT-STUDY
스프링 부트에 대해 공부하면서 배운 것들, 배우면서 느낀점들을 모아 놓은 레포지토리입니다.

## 참고자료

- [백기선](https://github.com/keesun) 님의 [스프링 부트의 개념과 활용](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/)
- 처음 배우는 스프링 부트 2(한빛미디어, 김영재님)
- [스프링 부트 레퍼런스 가이드](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/)

## 스프링 부트

### 스프링 부트란?

- 스프링 프레임워크를 더 빠르고 쉽게 사용할 수 있도록 도와주는 틀
- production-grade(제품 수준)의 독립적인(stand-alone) 스프링 기반 애플리케이션을 빠르고 쉽게 만들 수 있도록 도와준다.
- 스프링 플랫폼 및 서드파티 라이브러리에 대한 기본 설정을 제공한다.

### 스프링 부트의 목적

- 모든 스프링 개발을 할 때, 더 빠르고 폭넓은 사용성을 제공한다.
- 일일히 설정을 하지 않아도 되며, 얼마든지 설정을 커스터마이징할 수 있다.
- 비즈니스 로직에 필요한 기능들을 구현하는 데 있어 필요한 기능들을 제공한다.
- 더 이상 XML 설정과 code generation(조사 필요)을 쓰지 않는다.

### 프로젝트 생성

- Intellij Professional에 있는 기능인 Spring Initializr을 사용하는 방법
- start.spring.io 를 이용하여 기본 구조를 내려받는 방법
- Maven 혹은 Gradle로 프로젝트를 생성한 뒤 의존성을 직접 주입하는 방법
- 기타 등등

### 프로젝트 빌드

- IDE에서 빌드하거나 mvn, gradle에서 빌드 가능

- Maven을 이용해 빌드한 후 .jar파일을 생성하는 과정

  ```bash
  mvn package
  java -jar target/<your-project-name>.jar
  ```

### 스프링 부트 프로젝트 구조

- Maven 기본 프로젝트 구조와 동일

  - 소스 코드(/src/main/java)
  - 소스 리소스(/src/main/resource)
  - 테스트 코드(/src/test/java)
  - 테스트 리소스(/src/test/resource)

- 메인 애플리케이션의 위치

  - 기본 패키지(예시)

    `/src/main/java/jaehoon/kim/springinit/Application.class`

### 스프링 부트의 장점

- 설정을 하는 시간을 줄일 수 있다. 즉,  다른 업무의 능률을 더욱 높일 수 있다.
- 의존성 관리가 줄어들어 개발자가 해야 할 일들이 줄어든다.
- 의존성을 관리할 때 버전 명시를 안 해줘도 된다.
- 가끔 `SpringBoot Parent Tag` 를 사용할 수 없는 경우 다음과 같이 대처할 수 있다.
  - (Spring Boot Reference Guide | 13.2.2 | Using Spring Boot without the Parent POM) 참고
  - 가급적 `SpringBoot Parent Tag` 을 사용할 수 있도록 노력할 것

### Maven Dependencies

mvnrepository.com에서 각 라이브러리에 대한 의존성을 확인할 수 있다.

------

- 사용하는 스프링 버전을 변경하고 싶을 때에는 아래 코드를 참고하자.

  ```xml
  <properties>
    <spring.version>5.0.6.RELEASE</spring.version>
  </properties>
  ```

  <spring.version> 태그 사이에 원하는 스프링 버전을 기입하면 된다.

- 마찬가지로 사용하는 자바 버전을 변경하고 싶을 때에는 <spring.version> 태그 대신에 `<java.version>` 을 사용한다.

### 스프링 부트에서 사용하는 어노테이션

- @EnableAutoConfiguration(@SpringBootApplication 안에 숨어 있음)
- 빈은 두 단계에 걸쳐서 읽힘
  - 1단계: @ComponentScan
  - 2단계: @EnableAutoConfiguration
- @ComponentScan
  - @Component
  - @Configuration @Repository @Service @Controller @RestController
- @EnableAutoConfiguration
  - spring.factories
    - org.springframework.boot.autoconfigure.EnableAutoConfiguration
  - @Configuration
  - @ConditionalOnXxxYyyZzz