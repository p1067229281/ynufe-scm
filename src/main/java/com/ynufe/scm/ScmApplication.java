package com.ynufe.scm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.ynufe.scm.repository")
@Slf4j
public class ScmApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ScmApplication.class, args);
        String serverPort = context.getEnvironment().getProperty("server.port");
        log.info("Scm started at http://localhost:" + serverPort);
    }

}
