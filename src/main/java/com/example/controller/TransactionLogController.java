package com.example.controller;

import com.example.entity.TransactionLog;
import com.example.entity.User;
import com.example.entity.TransactionLogRepository;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
class TransactionLogController {

    private final TransactionLogRepository repository;

    TransactionLogController(TransactionLogRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/transactionlog")
    TransactionLog newTransactionLog(@RequestBody TransactionLog newTransactionLog) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String createdTime = dateFormat.format(calendar.getTime());
        newTransactionLog.setCreatedTime(createdTime);

        return repository.save(newTransactionLog);
    }

    @GetMapping("/transactionlog/{charId}")
    List<TransactionLog> transactionLogByCharId(@PathVariable String charId) {
        return repository.findByCharId(charId);
    }

    @GetMapping("/transactionlog/{charId}/{account}")
    List<TransactionLog> transactionLogByCharIdAndAccount(@PathVariable String charId, @PathVariable String account) {
        return repository.findByCharIdAndAccount(charId, account);
    }

}