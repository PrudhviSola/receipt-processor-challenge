package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeRangeRuleTest {
    private final TimeRangeRule rule = new TimeRangeRule();

    @ParameterizedTest
    @CsvSource({
            "14:30, 10",
            "13:59, 0",
            "16:01, 0"
    })
    void testCalculatePoints_DifferentTimes_ReturnsCorrectPoints(String time, int expectedPoints) {

        ReceiptDTO receipt = new ReceiptDTO();
        receipt.setPurchaseTime(LocalTime.parse(time));
        assertEquals(expectedPoints, rule.calculatePoints(receipt));
    }
}
