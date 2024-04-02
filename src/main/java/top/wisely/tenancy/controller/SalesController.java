package top.wisely.tenancy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wisely.tenancy.entity.Sale;
import top.wisely.tenancy.repository.SalesRepository;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesRepository salesRepository;

    public SalesController(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @GetMapping
    public List<Sale> getSales() {
        return salesRepository.findAll();
    }
}