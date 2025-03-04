package com.app.cryptography.model;

import com.app.cryptography.service.CryptographyService;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userDocument")
    private String encriptedUserDocument;

    @Column(name = "creditCardToken")
    private String encriptedCreditCardToken;

    @Column(name = "value")
    private Long value;

    @Transient
    private String rawUserDocument;

    @Transient
    private String rawCreditCardToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncriptedUserDocument() {
        return encriptedUserDocument;
    }

    public void setEncriptedUserDocument(String encriptedUserDocument) {
        this.encriptedUserDocument = encriptedUserDocument;
    }

    public String getEncriptedCreditCardToken() {
        return encriptedCreditCardToken;
    }

    public void setEncriptedCreditCardToken(String encriptedCreditCardToken) {
        this.encriptedCreditCardToken = encriptedCreditCardToken;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getRawUserDocument() {
        return rawUserDocument;
    }

    public void setRawUserDocument(String rawUserDocument) {
        this.rawUserDocument = rawUserDocument;
    }

    public String getRawCreditCardToken() {
        return rawCreditCardToken;
    }

    public void setRawCreditCardToken(String rawCreditCardToken) {
        this.rawCreditCardToken = rawCreditCardToken;
    }

    //sempre que for inserir encripta os campos
    @PrePersist
    public void prePersist( ){
        this.encriptedUserDocument = CryptographyService.encript(rawUserDocument);
        this.encriptedCreditCardToken = CryptographyService.encript(rawCreditCardToken);
    }
    //sempre que for lido do banco decripta os campos
    @PostLoad
    public void postUpdate( ){
        this.rawUserDocument = CryptographyService.decript(encriptedUserDocument);
        this.rawCreditCardToken = CryptographyService.decript(encriptedCreditCardToken);
    }
}
