package evhen_project.makeup.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(url = "http://data.fixer.io/api", name="fixer")
@Component
public interface CurrencyClient {
//    @RequestMapping(method = RequestMethod.GET, value = "/latest")
//    CurrencyDto getCurrencies(@RequestParam String access_key);
}