package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ItemDTO;
import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemDescriptionRuleTest {
    private final ItemDescriptionRule rule = new ItemDescriptionRule();

    @Test
    void testCalculatePoints_DescriptionMultipleOfThree_ReturnsCorrectPoints() {
        // Arrange
        ReceiptDTO receipt = new ReceiptDTO();
        ItemDTO item1 = new ItemDTO();
        item1.setShortDescription("Dew"); // length 3
        item1.setPrice("10.00");

        ItemDTO item2 = new ItemDTO();
        item2.setShortDescription("Emils Cheese"); // length 12
        item2.setPrice("5.00");

        receipt.setItems(List.of(item1, item2));

        // Act
        int points = rule.calculatePoints(receipt);

        // Assert
        assertEquals(3, points); // ceil(10.00 * 0.2) + ceil(5.00 * 0.2)
    }

    @Test
    void testCalculatePoints_DescriptionNotMultipleOfThree_ReturnsCorrectPoints() {
        // Arrange
        ReceiptDTO receipt = new ReceiptDTO();
        ItemDTO item1 = new ItemDTO();
        item1.setShortDescription("Dews"); // length 4
        item1.setPrice("10.00");

        ItemDTO item2 = new ItemDTO();
        item2.setShortDescription("Emils"); // length 5
        item2.setPrice("5.00");

        receipt.setItems(List.of(item1, item2));

        // Act
        int points = rule.calculatePoints(receipt);

        // Assert
        assertEquals(0, points);
    }

}