package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuarterMultipleRuleTest {
    private final QuarterMultipleRule rule = new QuarterMultipleRule();

    @Test
    public void testCalculatePoints_withNullReceipt_returnsNoPoints() {

        // Act
        int points = rule.calculatePoints(null);

        // Assert
        assertEquals(0, points, "Points should be 0 if the receipt is null");
    }

    @Test
    public void testCalculatePoints_withNullTotal_returnsNoPoints() {
        // Arrange
        ReceiptDTO receipt = new ReceiptDTO();
        receipt.setTotal("null");

        // Act
        int points = rule.calculatePoints(receipt);

        // Assert
        assertEquals(0, points, "Points should be 0 if the total is null");
    }

    @Test
    public void testCalculatePoints_withMultipleOfQuarter_returnsPoints() {
        // Arrange
        ReceiptDTO receipt = new ReceiptDTO();
        receipt.setTotal("12.00");// Total is a multiple of 0.25

        // Act
        int points = rule.calculatePoints(receipt);

        // Assert
        assertEquals(25, points, "Points should be 25 for a total that is a multiple of 0.25");
    }

    @Test
    public void testCalculatePoints_withNonMultipleOfQuarter_returnsNoPoints() {
        // Arrange
        ReceiptDTO receipt = new ReceiptDTO();
        receipt.setTotal("12.30");// Total is not a multiple of 0.25

        // Act
        int points = rule.calculatePoints(receipt);

        // Assert
        assertEquals(0, points, "Points should be 0 for a total that is not a multiple of 0.25");
    }
}
