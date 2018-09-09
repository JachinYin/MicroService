# MicroService

我的第一个微服务实战项目，提供了广东省部分城市的天气数据查询，具有清晰良好的前端展示页面，可以选择不同的城市，并且显示该城市3天内的天气变化情况。天气信息包括天气，最高最低温，风速风向等。

## 功能

- 显示某城市的天气数据
- 可以自由切换城市
- 显示某城市 3 天内的天气变化

## 系统结构

整个应用使用了微服务架构设计，设计多个微服务实例

- 01. **micro-weather-eureka-server**：提供服务注册与发现功能
- 02.**micro-weather-city-server**：提供本地城市列表的微服务
- 03.**micro-weather-collection**：根据 01 号服务提供的城市列表，收集第三方接口提供的城市天气数据，并将数据缓存至 Redis 中
- 04.**micro-weather-data-server**：提供天气数据 API 微服务，为其他有需要的实例提供天气数据
- 05.**micro-weather-zuul**：API  路由网关，统一 API 入口，主要统一 03 和 04 号服务，所有的有关这两个服务的请求都将会发送到该网关，再由该网关进行转发
- 06.**micro-weather-report-server**：天气预报微服务，提供前端界面，可视化天气数据

## 使用技术

- Spring Boot 2.0.4 Release
- Spring Cloud Finchley.SR1
- Eureka
- Feign
- Zuul
- Hystrix
- Redis-x64-3.2.100
- BootStrap
- Thymeleaf

