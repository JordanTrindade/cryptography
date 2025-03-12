package com.app.cryptography.controller;

import com.app.cryptography.model.Transaction;
import com.app.cryptography.model.dto.TransactionDto;
import com.app.cryptography.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping(value = "/transaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody @Valid TransactionDto transactionDto){


        return ResponseEntity.ok().body(transactionService.saveTransaction(transactionDto.toEntity()));
    }
}
