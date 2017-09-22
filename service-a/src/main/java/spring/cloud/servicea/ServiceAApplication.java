package spring.cloud.servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.servicea.feign.ServiceBFeign;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@EnableAutoConfiguration
public class ServiceAApplication {

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }


    @Autowired
//    private final
    private ServiceBFeign serviceBFeign;

//    @Autowired
//    public ServiceAApplication(ServiceBFeign serviceBFeign) {
//        this.serviceBFeign = serviceBFeign;
//    }

    @GetMapping("/")
    public String hello() {



        return "hello world";
    }

    @GetMapping("/service/b")
    public String test() {
        String s = serviceBFeign.serviceBHello();
        System.out.println(s);
        return "service b success.";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }
}
