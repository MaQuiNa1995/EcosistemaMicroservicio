package maquina1995.eureka.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Clase usada para el inicio del servidor de discovery a traves de spring boot
 * 
 * @author MaQuiNa1995
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
	SpringApplication.run(Main.class, args);
    }
}
