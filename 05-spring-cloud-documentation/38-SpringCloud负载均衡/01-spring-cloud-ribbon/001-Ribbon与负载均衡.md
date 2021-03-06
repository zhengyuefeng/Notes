#  Ribbon与负载均衡

- [Ribbon是什么](#Ribbon是什么)
- [一句话概括](#一句话概括)
- [为什么要有负载均衡](#为什么要有负载均衡)

## Ribbon是什么

Ribbon是管理HTTP和TCP服务客户端的负载均衡器。

Ribbon具有一系列带有名称的客户端(Named Client)，也就是带有名称的Ribbon客户端(Ribbon Client)。

每个客户端由可配置的组件构成，负责一类服务的调用请求。Spring Cloud通过RibbonClientConfiguration为每个Ribbon客户端创建一个ApplicationContext上下文来进行组件装配。

Ribbon作为Spring Cloud的负载均衡机制的实现，可以与OpenFeign和RestTemplate进行无缝对接，让二者具有负载均衡的能力。


Ribbon 是一个客户端负载均衡器 , Feign 和 Zuul 默认集成了 Ribbon , 其核心就是

- 获取到服务列表, 可以是从注册中心或者是配置文件
- 根据负载均衡算法访问这个服务列表

#### 体现点

-  [丰富的负载均衡策略](02-Ribbon 负载均衡策略与自定义配置.md)
- 重试机制
- 支持多协议异步与响应式模型
- 容错
- 缓存
- 批处理

## 一句话概括

本质上是通过拦截 RestTemplate 根据服务 ID 查找服务实例并使用轮询算法(可配置)进行拦截修改 url 的机制

## 为什么要有客户端负载均衡

CAP原则中, 大部分互联网公司遵循的是AP原则, 应用实例的注册信息在集群的所有节点间并不是强一致的,这就需要客户端能够支持负载均衡以及失败重试(ribbon 或者 loadblancer)

## 负载均衡

负载均衡 Load Balance , 利用特定方式将流量分摊到多个操作单元上的一种手段,它对系统吞吐量与系统处理能力有质的提升

- 软负载 , Nginx 
- 硬负载, F5

或者

- 服务端负载均衡

> Nginx 和 F5 都属于集中式负载均衡,

- 客户端负载均衡

> 实例一般存储在 Eureka , Consul , Zookeeper ,etcd 这样的注册中心,此时的负载均衡器就是类似于 Ribbon 的 IPC (Inter-process Communication 进程间通讯)组件,因此,进程内负载均衡又叫客户端负载混合

<img src="assets/image-20200528123430064.png" alt="image-20200528123430064" style="zoom:50%;" />

