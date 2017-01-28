package io.github.alicankustemur.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.github.alicankustemur.person.repository.base.BaseRepositoryFactoryBean;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "io.github.alicankustemur.person.repository" }, repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
