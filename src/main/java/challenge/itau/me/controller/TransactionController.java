package challenge.itau.me.controller;

import challenge.itau.me.dto.TransactionRequestDto;
import challenge.itau.me.model.Transaction;
import challenge.itau.me.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody
    TransactionRequestDto requestDto){
        transactionService.addTransaction(new Transaction(requestDto.valor(), requestDto.dataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
