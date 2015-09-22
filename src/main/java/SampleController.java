import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dmitrii on 9/22/15.
 */
@RestController
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/test")
    @ResponseBody
    String home() {
        return "hello, world!";
    }


    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}

