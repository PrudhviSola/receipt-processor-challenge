package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundDollarRuleTest {
    private final RoundDollarRule rule = new RoundDollarRule();

    @ParameterizedTest
    @CsvSource({
            "100.00, 50",
            "99.99, 0",
            "50.00, 50"
    })
    void testCalculatePoints_VariousAmounts_ReturnsCorrectPoints(double amount, int expectedPoints) {
        // Arrange
        ReceiptDTO receipt = new ReceiptDTO();
        receipt.setTotal(String.valueOf(amount));

        int points = rule.calculatePoints(receipt);

        assertEquals(expectedPoints, points);
    }
}
