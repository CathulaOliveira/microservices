package br.edu.utfpr.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fraud/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @Autowired
    private QueueSender queueSender;

    @PostMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable Integer customerId) {
        boolean isFraudulentCustomer = fraudCheckService
                .isFraudCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

    @PostMapping(path = "/mensagem/{msg}")
    public String enviarMensagem(@PathVariable String msg) {
        return queueSender.send(msg);
    }

}
