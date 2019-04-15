package com.in28minutes.microservices.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping(value = "/currency-convert/from/{from}/to/{to}/quantity/{quantity}")
    public CurrenctConversionBean convertCurrenct(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("from", from);
        urlVariables.put("to", to);

        ResponseEntity<CurrenctConversionBean> responseEntity =
//                new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrenctConversionBean.class, urlVariables);
                new RestTemplate().getForEntity("http://currency-exchange-service:8000/currency-exchange/from/{from}/to/{to}", CurrenctConversionBean.class, urlVariables);
        System.out.println("concurency convert1: ");
        CurrenctConversionBean response = responseEntity.getBody();

        return new CurrenctConversionBean(response.getId(),
                response.getFrom(),
                response.getTo(),
                response.getConversionMultiple(),
                quantity,
                quantity.multiply(response.getConversionMultiple()),
                response.getPort());
    }



    @GetMapping(value = "/currency-convert-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrenctConversionBean convertCurrenctFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrenctConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
        logger.info("{}", response);
        System.out.println("concurency convert2: ");

        return new CurrenctConversionBean(response.getId(),
                response.getFrom(),
                response.getTo(),
                response.getConversionMultiple(),
                quantity,
                quantity.multiply(response.getConversionMultiple()),
                response.getPort());
    }
}
