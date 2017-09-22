package spring.cloud.servicea.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wenji on 2017/8/7
 */
@FeignClient(name = "service-b")
public interface ServiceBFeign {


    @RequestMapping(method = RequestMethod.GET, value = "/")
    String serviceBHello();

}
