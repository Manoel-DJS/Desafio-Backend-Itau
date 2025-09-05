package challenge.itau.me.service;

import challenge.itau.me.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransactionService {
    // Fila de Transacoes
    private final Queue<Transaction> transactions = new ConcurrentLinkedDeque<>();

    // Metodo para add Transacao na fila
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Metodo para limpar a fila de Transacao
    public void clearTransactions(){
        transactions.clear();
    }

    // Metodo
    public DoubleSummaryStatistics getStatistics(){
        OffsetDateTime nowDateTime = OffsetDateTime.now();
        return transactions.stream()
                .filter(t -> t.getDataHora().isAfter(nowDateTime.minusMinutes(1)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }
}
