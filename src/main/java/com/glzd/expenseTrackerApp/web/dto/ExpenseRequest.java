package com.glzd.expenseTrackerApp.web.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseRequest {

    
    
    
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Expense type cannot be empty")
    private String expenseType;

    @DecimalMin(value = "0.01",
            message = "Amount must be greater than 0")
    private BigDecimal amount;
   

    @NotNull(message = "Date is required")
    private LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}