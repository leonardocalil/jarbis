package br.com.increaseit.internal.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
//@ComponentScan("br.com.increaseit.internal.data.*")
//@EntityScan("br.com.increaseit.internal.data.entity.*")
//@EnableJpaRepositories("br.com.increaseit.internal.data.repository.*")
public class MainInternalData {

	public static void main (String[] args) {
        SpringApplication.run(MainInternalData.class, args);
    }

}