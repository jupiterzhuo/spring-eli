package id.equity.DISpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import id.equity.DISpring.config.Config;
import id.equity.DISpring.consumer.Consumer;

@SpringBootApplication
public class DiSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DiSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("Saya Tampan");
		String message = "Hello ini adalah message";
		String email = "jupiterc@gmail.com";
		String phone = "+6293299382828";
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config.class);
		
		Consumer app = ctx.getBean(Consumer.class);
		app.processMessage(message, email);
		ctx.close();
	}

}
