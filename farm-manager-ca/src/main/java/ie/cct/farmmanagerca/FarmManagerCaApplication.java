package ie.cct.farmmanagerca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ie.cct.farmmanagerca*") //Tell Spring which package to scan 
public class FarmManagerCaApplication { 
	public static void main(String[] args) {
		SpringApplication.run(FarmManagerCaApplication.class, args);
	}

}
