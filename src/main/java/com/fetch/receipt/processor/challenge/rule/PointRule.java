package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;

public interface PointRule {
    int calculatePoints(ReceiptDTO receipt);
}
