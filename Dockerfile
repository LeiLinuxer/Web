FROM tomcat:9-jdk8-openjdk

# 第二步：将本地webapp目录复制到容器内的Tomcat默认应用目录
# 注意：`src/main/webapp` 是你项目中Web资源的路径（需与实际一致）
# `/usr/local/tomcat/webapps/ROOT` 表示将项目作为Tomcat的“根应用”（访问时无需加项目名）
COPY src/main/webapp /usr/local/tomcat/webapps/ROOT

# 第三步：暴露Tomcat默认端口（容器内部端口）
EXPOSE 8080