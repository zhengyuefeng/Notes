# 全链路监控概述

在传统 SOA 架构体系中,系统调用层级不多,调用关系也不复杂,一旦出现问题,根据异常信息可以很快定位到问题木块并进行排查

在微服务的世界里,实例数目成百上前,实例之间的调用关系几乎是网状结构,靠人力去监控和排查问题不太可能

这个时候就需要一个完善的链路监控框架对于运维和开发来说,是不可或缺的

## Dapper 论文

![image-20200609214421617](assets/image-20200609214421617.png)

![image-20200609214453836](assets/image-20200609214453836.png)

![image-20200609215302422](assets/image-20200609215302422.png)