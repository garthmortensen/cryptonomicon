package com.example.springthymeredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.springthymeredis.CryptoApplication;
import com.example.springthymeredis.model.Project;
import com.example.springthymeredis.repository.ProjectRepository;

// FIXME: Relying upon circular references is discouraged and they are prohibited by default. Update your application to remove the dependency cycle between beans. As a last resort, it may be possible to break the cycle automatically by setting spring.main.allow-circular-references to true.
@SpringBootApplication
public class CryptoApplication implements CommandLineRunner {

	// TODO: What does @Autowired annotator do?
	@Autowired
	ProjectRepository ir;

	public static void main(String[] args) {
		SpringApplication.run(CryptoApplication.class, args);
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		//JedisConnectionFactory jf = new JedisConnectionFactory();
		//jf.setHostName("localhost");
		//jf.setPort(6379);
		//return jf;
		return new JedisConnectionFactory();
	}
	
	// TODO: what is this?
	// TODO: What does @Bean annotator do?
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> template = new RedisTemplate();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;		
	}

	// TODO: What does @Override annotator do?
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Saving");
//		Item i = new Item();
//		i.setItemId("id1");
//		i.setItemName("Chair");
//		i.setItemPrice(20.0);
//		i.setItemQty(2);
//		ir.save(i);
//		System.out.println("saved");
//		
		//Get the item
		Project iget = ir.findById("id1").get();
		System.out.println("getting item with name "+iget.getProjectName());
		
//		//Update item
//		iget.setItemName("table");
//		ir.save(iget);
//		Item iafterUpdate = ir.findById("id1").get();
//		System.out.println("Item name after update is "+iafterUpdate.getItemName());
//		
//		//Delete item
//		ir.delete(iafterUpdate);
//		Item iafterDelete = ir.findById("id1").get();
//		System.out.println("item name after delete is "+iafterDelete.getItemName());
	}
}
