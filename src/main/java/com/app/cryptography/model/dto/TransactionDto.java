package com.app.cryptography.model.dto;

import com.app.cryptography.model.Transaction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransactionDto(@NotBlank String rawDocument,@NotBlank String rawCreditCard,@NotNull Long value) {
    public Transaction toEntity(){
        Transaction transaction = new Transaction();
        transaction.setRawUserDocument(rawDocument());
        transaction.setRawCreditCardToken(rawCreditCard());
        transaction.setValue(value());

        return transaction;
    }
}
