package com.fetch.receipt.processor.challenge.rule;


import com.fetch.receipt.processor.challenge.dto.ItemDTO;
import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemCountRuleTest {
    private final ItemCountRule rule = new ItemCountRule();

    @Test
    public void testCalculatePoints_validReceiptWithEvenItems() {

        ReceiptDTO receipt = new ReceiptDTO();
        ItemDTO item1 = new ItemDTO();
        item1.setShortDescription("Mountain Dew 12PK");
        item1.setPrice("6.49");

        ItemDTO item2 = new ItemDTO();
        item1.setShortDescription("Emils Cheese Pizza");
        item1.setPrice("12.25");

        ItemDTO item3 = new ItemDTO();
        item1.setShortDescription("Knorr Creamy Chicken");
        item1.setPrice("1.26");

        ItemDTO item4 = new ItemDTO();
        item1.setShortDescription("Doritos Nacho Cheese");
        item1.setPrice("3.35");

        receipt.setItems(List.of(item1, item2, item3, item4));

        int points = rule.calculatePoints(receipt);

        assertEquals(10, points, "Points should be 10 for 4 items (2 pairs of 2 items each)");
    }

    @Test
    public void testCalculatePoints_validReceiptWithOddItems() {

        ReceiptDTO receipt = new ReceiptDTO();
        ItemDTO item1 = new ItemDTO();
        item1.setShortDescription("Mountain Dew 12PK");
        item1.setPrice("6.49");

        ItemDTO item2 = new ItemDTO();
        item1.setShortDescription("Emils Cheese Pizza");
        item1.setPrice("12.25");

        ItemDTO item3 = new ItemDTO();
        item1.setShortDescription("Knorr Creamy Chicken");
        item1.setPrice("1.26");

        receipt.setItems(List.of(item1, item2, item3));

        int points = rule.calculatePoints(receipt);

        assertEquals(5, points, "Points should be 5 for 3 items (1 pair and 1 leftover item)");
    }

    @Test
    public void testCalculatePoints_emptyReceipt() {

        ReceiptDTO receipt = new ReceiptDTO();

        int points = rule.calculatePoints(receipt);

        assertEquals(0, points, "Points should be 0 for an empty receipt");
    }

    @Test
    public void testCalculatePoints_nullReceipt() {

        int points = rule.calculatePoints(null);

        assertEquals(0, points, "Points should be 0 for a null receipt");
    }

}
