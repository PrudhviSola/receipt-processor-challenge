package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddDayRuleTest {
    private final OddDayRule rule = new OddDayRule();

    @Test
    public void testCalculatePoints_withNullReceipt_returnsNoPoints() {

        // Act
        int points = rule.calculatePoints(null);

        // Assert
        assertEquals(0, points, "Points should be 0 if the receipt is null");
    }

    @Test
    public void testCalculatePoints_withOddDay_returnsPoints() {
        // Arrange
        ReceiptDTO receipt = new ReceiptDTO();
        receipt.setPurchaseDate(LocalDate.of(2022, 1, 15));

        // Act
        int points = rule.calculatePoints(receipt);

        // Assert
        assertEquals(6, points, "Points should be 6 for odd days");
    }

    @Test
    public void testCalculatePoints_withEvenDay_returnsNoPoints() {
        // Arrange
        ReceiptDTO receipt = new ReceiptDTO();
        receipt.setPurchaseDate(LocalDate.of(2022, 1, 16));

        // Act
        int points = rule.calculatePoints(receipt);

        // Assert
        assertEquals(0, points, "Points should be 0 for even days");
    }
}
