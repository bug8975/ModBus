package com.tjmj;

/**
 * Created by Administrator on 2016/12/30.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.net.InetAddress;

@Slf4j
@RestController
@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties({
        HttpClientProperties.class,
      ModbusProperties.class

})
public class ModBusController {


    @RequestMapping(value = "/hello")
    public ModelAndView doView() {
        System.out.println("doView");
        ModelAndView mv = new ModelAndView("logout");
        return mv;
    }

    public static void main(String[] args) throws Exception {
       // SpringApplication.run(HelloController.class, args);
        Environment env = SpringApplication.run(ModBusController.class, args).getEnvironment();
        System.out.println(env.getProperty("server.port"));
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n\t" +
                        "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
        System.out.println(env.getProperty("spring.mvc.view.prefix"));
    }

}