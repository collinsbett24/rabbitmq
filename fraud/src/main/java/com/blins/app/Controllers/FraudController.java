package com.blins.app.Controllers;

import com.blins.app.Pojos.FraudCheckResponse;
import com.blins.app.Services.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    private final FraudCheckService fraudCheckService;


    @GetMapping(path="{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);

        return  new FraudCheckResponse(isFraudulentCustomer);

    }
}
