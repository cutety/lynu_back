# 洛阳师范学院信息技术学院新生实时报到系统

## 效果展示

![展示](https://user-images.githubusercontent.com/38933640/95731014-909ec100-0cb1-11eb-8480-bfe63fbb55e6.png)

## 环境配置

调试环境：Windows10、MacOS Catalina

IDE：IntelliJ IDEA

服务器环境：CentOS 7

数据库：MySQL 5.6

数据库连接池：druid

## 技术栈

### 后端

SpringBoot、Mybatis、WebSocket

### 前端

Vue、WebSocket、axios、nginx、Echarts、DataV

## 使用方法

* `git clone https://github.com/cutety/lynu_back.git`

* 在resource里面添加`application-dev.yml`配置相关配置项，一般只需要配置数据库即可（可以照着`application-prod.yml`进行配置
* 创建数据库`stu_it_info`，导入数据库文件`source stu_it_info.sql;`
* 前端地址https://github.com/cutety/big-screen-vue-datav，请配合前端使用



