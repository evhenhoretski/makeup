package evhen_project.makeup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class MakeupApplication
        //implements CommandLineRunner
{

//    @Autowired
//    private CurrencyService currencyService;
//    @Autowired
//    private CacheManager cacheManager;

    public static void main(String[] args) {
        SpringApplication.run(MakeupApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//        currencyService.getCurrency();
//
//    }
}
