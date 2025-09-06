package challenge.itau.me.controller;

import challenge.itau.me.dto.StatisticsResponseDto;
import challenge.itau.me.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
    private final TransactionService transactionService;

    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponseDto> getStatistics() {
        DoubleSummaryStatistics statistics = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticsResponseDto(statistics));
    }
}
