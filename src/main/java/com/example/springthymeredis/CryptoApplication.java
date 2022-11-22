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

// @SpringBootApplication: auto scans the project and allows us to inject beans using @Autowired
// Remember: Launch Redis db before running this. \Redis-x64-5.0.14.1\redis-server.exe
@SpringBootApplication
public class CryptoApplication implements CommandLineRunner {

	// FYI: @Autowired allows Spring to inject collaborating beans into our bean
	// @Autowired on properties: eliminates the need for getters/setters
	// it does different things, depending on where its called
	@Autowired
	ProjectRepository ir;

	public static void main(String[] args) {
		SpringApplication.run(CryptoApplication.class, args);
	}

	// FYI: @Override indicates the subclass is replacing inherited behavior
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Saving");
		Project i = new Project();
		i.setProjectId("id1");
		i.setProjectName("Ethereum");
		i.setProjectSymbol("ETH");
		i.setProjectDecimals(10);
		i.setProjectTotalSupply(1000);
		ir.save(i);

		Project d = new Project();
		d.setProjectId("id2");
		d.setProjectName("dogecoin");
		d.setProjectSymbol("dog");
		d.setProjectDecimals(10);
		d.setProjectTotalSupply(1000);
		ir.save(d);

		System.out.println("Saved");

		// search for something specific
		//Get the item
		Project iget = ir.findById("id1").get();
		System.out.println("getting item with name "+iget.getProjectName());
		
		//Update item
//		iget.setProjectName("table");
//		ir.save(iget);
//		Project iafterUpdate = ir.findById("id1").get();
//		System.out.println("Project name after update is "+iafterUpdate.getProjectName());
		
		//Delete item
//		ir.delete(iafterUpdate);
//		Project iafterDelete = ir.findById("id1").get();
//		System.out.println("Project name after delete is "+iafterDelete.getProjectName());
	}
}
