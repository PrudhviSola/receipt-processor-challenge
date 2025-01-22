package com.fetch.receipt.processor.challenge.controller;

import com.fetch.receipt.processor.challenge.dto.PointsResponseDTO;
import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import com.fetch.receipt.processor.challenge.dto.ReceiptResponseDTO;
import com.fetch.receipt.processor.challenge.service.ReceiptService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/process")
    public ResponseEntity<ReceiptResponseDTO> processReceipt(@Valid @RequestBody ReceiptDTO receipt) {
        String id = receiptService.processReceipt(receipt);
        return ResponseEntity.ok(new ReceiptResponseDTO(id));
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<PointsResponseDTO> getPoints(@PathVariable String id) {
        Integer points = receiptService.getPoints(id);
        return ResponseEntity.ok(new PointsResponseDTO(points));
    }
}
