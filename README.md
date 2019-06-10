# 基于shiro的权限认证服务构建

**account-server提供了一种基于springboot-jwt-shiro的权限管理构建思路，以达到对按钮级别权限的细粒度控制。**

**用户登录后，后端会在返回报文头部颁发jwt，同时在redis中记录refreshToken（即记录当前登录的时间戳）。在后续的资源访问中需要在请求头部携带该token，经过权限认证、授权通过后方可访问具体接口。在没有权限、token异常的情况下均会拦截。当jwt过期后后端会自动刷新该token（若refreshToken未过期），当refreshToken过期后，会强制用户重新登录**。

**每次用户登录，都会刷新redis中时间戳。由于每次认证的时候都会比较jwt负载段携带的时间戳，所以基于以上refreshToken的时间戳机制，可以简单时间单点登录的功能**

---

### 采用技术
- springboot
- shiro
- jwt
- redisson
- mybatis-plus
- druid
                                         
