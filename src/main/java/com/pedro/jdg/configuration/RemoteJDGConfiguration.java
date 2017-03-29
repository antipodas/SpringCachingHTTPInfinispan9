package com.pedro.jdg.configuration;


import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.spring.provider.SpringRemoteCacheManager;
import org.infinispan.spring.session.configuration.EnableInfinispanRemoteHttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableInfinispanRemoteHttpSession
@PropertySource("classpath:hotrod-client.properties")
public class RemoteJDGConfiguration {
	@Value("${hotrod.server_list}")
	private  String servers;
/*
    @Bean
    public RemoteCacheManager remoteCacheManager() {
        return new RemoteCacheManager(
                new org.infinispan.client.hotrod.configuration.ConfigurationBuilder()
                        .addServers("localhost:11222")
                        .build()); 
	
    }*/
	@Bean
	   public SpringRemoteCacheManager springCacheManager() {
	/*	System.out.println(servers);
        org.infinispan.client.hotrod.configuration.Configuration config = new ConfigurationBuilder()
        		.addServers("localhost:11222")
                .build();
	      return new SpringRemoteCacheManager(new RemoteCacheManager(config)); */
		org.infinispan.client.hotrod.configuration.Configuration config = new ConfigurationBuilder()
        		.addServers(servers)
                .build(); 
		 return new SpringRemoteCacheManager(new RemoteCacheManager(config));
		
	   }

}
