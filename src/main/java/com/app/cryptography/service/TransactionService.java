package com.app.cryptography.service;

import com.app.cryptography.model.Transaction;
import com.app.cryptography.model.dto.TransactionDto;
import com.app.cryptography.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction saveTransaction(Transaction transaction){
       return transactionRepository.save(transaction);
    }

}
