-------------------项目说明---------------------

1 , 本项目技术采用 springboot+mybatis+springMvc+spring cloud 实现
2 , 认证中心使用spring security oauth2实现认证   具体项目参考 auth
3 , 本系统主要分为 通知中心 业务中心  账户中心  公共模块 认证中心
4 , 采用微服务体系,具体代码架构见项目
5 , 后期项目会实现队列集群,数据库集群,redis集群,spring cloud 集成dobbo 双机热备等大型体系系统中用到的技术
6 , 待解决问题是采用微服务架构体系如何实现分布式事务,准备采用 
具体选择方案如下 xa 2pc  3pc  rabbitmq  lcn TCC


部署方案
1- 初步使用docker + k8s 集群 到时候会将步骤发至git大家供讨论












博主三年工作经验,爱好技术.商务联系qq: 975172588
