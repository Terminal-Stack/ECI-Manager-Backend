/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
/**
 *
 * @author anrodriguez
 */
@Configuration
public class Mongoconfig {

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

         MongoClientURI uri = new MongoClientURI(
                 
        "mongodb+srv://velomeister:ELsysQDpRiK3@ecimanagercluster-1bf4n.mongodb.net/test?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);

        return new SimpleMongoDbFactory( mongoClient, "EASYBICI");

    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }
}

