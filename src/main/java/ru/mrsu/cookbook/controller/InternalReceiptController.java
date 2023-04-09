package ru.mrsu.cookbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mrsu.cookbook.model.Receipt;
import ru.mrsu.cookbook.model.ReceiptDto;

import java.util.List;

@RestController
public class InternalReceiptController {
//    @GetMapping("/internal/api/v1/categories")
//    List<String> getCategories() {
//         return null;
//     }

    @GetMapping("/internal/api/v1/receipts/{category}")
    List<ReceiptDto> getReceiptByCategory(@RequestParam String category) {
        return null;
    }

    @GetMapping("/internal/api/v1/receipts")
    List<ReceiptDto> getReceipts() {
        return null;
    }

    @GetMapping("/internal/api/v1/receipt?receipt={receiptId}")
    Receipt getReceiptById(@RequestParam Long receiptId) {
        return null;
    }


}
