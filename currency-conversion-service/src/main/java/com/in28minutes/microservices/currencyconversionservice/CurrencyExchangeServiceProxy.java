package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")

//@FeignClient(name = "netflix-zuul-api-gateway-server")
@FeignClient(name = "netflix-zuul-api-gateway-server", url="netflix-zuul-api-gateway-server:8765")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
//    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    @GetMapping(value = "/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrenctConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
