package com.example.shirodemo.config;


import com.kevin.demodependency.dao.PersonDAL;
import com.kevin.demodependency.dao.PersonDALImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DemoConfig {
    @Autowired
    MongoTemplate mongoTemplate;

    @Bean
    public PersonDAL getPersonDal(){
        return new PersonDALImpl(mongoTemplate);
    }
}
