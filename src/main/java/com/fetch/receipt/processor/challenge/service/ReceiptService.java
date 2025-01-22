package com.fetch.receipt.processor.challenge.service;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;

public interface ReceiptService {
    String processReceipt(ReceiptDTO receipt);
    Integer getPoints(String id);
}
