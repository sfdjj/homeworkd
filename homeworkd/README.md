1.环境


1）springMVC+Spring+Mybatis+Mysql


2）数据库连接信息在resources/spring.xml中修改


property name="driverClassName" value="com.mysql.jdbc.Driver"


property name="url" value="jdbc:mysql://localhost:3306/${databaseName}?characterEncoding=UTF-8"


property name="username" value="root"


property name="password" value="11111111"

2.运行


在Intellij idea中直接配置tomcat，然后运行



3.接口说明


1）


URL：/counter/save


方式：POST


参数：


@param title 标题


@param number 总字数


@param chNumber 中文字数


@param enNumber 英文字数


@param puncNumber 标点数


2）


URL：/counter/getData


方式：GET


参数：无
