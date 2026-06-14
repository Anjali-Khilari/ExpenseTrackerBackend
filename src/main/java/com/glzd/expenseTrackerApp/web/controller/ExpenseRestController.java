package com.glzd.expenseTrackerApp.web.controller;

import com.glzd.expenseTrackerApp.business.model.Expense;
import com.glzd.expenseTrackerApp.business.services.ExpenseService;
import com.glzd.expenseTrackerApp.web.dto.ExpenseRequest;
import com.glzd.expenseTrackerApp.web.dto.ExpenseResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseRestController {

    private final ExpenseService expenseService;

    public ExpenseRestController(
            ExpenseService expenseService) {

        this.expenseService = expenseService;
    }

    // CREATE
    @Operation(
            summary = "Create a new expense",
            description = "Creates an expense for the currently logged-in user"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExpenseResponse createExpense(
    		@Valid @RequestBody ExpenseRequest request) {

        Expense expense = new Expense();

        expense.setName(request.getName());
        expense.setExpenseType(request.getExpenseType());
        expense.setAmount(request.getAmount());
        expense.setDate(request.getDate());

        Expense savedExpense =
                expenseService.save(expense);

        return mapToResponse(savedExpense);
    }


    // GET ALL
    @Operation(
            summary = "Get all expenses",
            description = "Returns paginated expenses belonging to the authenticated user"
    )
    @GetMapping
    public Page<ExpenseResponse> getExpenses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Expense> expenses =
                expenseService.getCurrentUserExpenses(
                        PageRequest.of(page, size)
                );

        return expenses.map(this::mapToResponse);
    }


    // GET BY ID
    @Operation(
            summary = "Get expense by ID",
            description = "Returns a single expense if it belongs to the authenticated user"
    )
    @GetMapping("/{id}")
    public ExpenseResponse getExpenseById(
            @PathVariable Long id) {

        Expense expense =
                expenseService.findByIdForCurrentUser(id);

        return mapToResponse(expense);
    }


    // UPDATE
    @Operation(
            summary = "Update an expense",
            description = "Updates an existing expense owned by the authenticated user"
    )
    @PutMapping("/{id}")
    public ExpenseResponse updateExpense(
            @PathVariable Long id,
            @Valid @RequestBody ExpenseRequest request) {

        Expense expense =
                expenseService.findByIdForCurrentUser(id);

        expense.setName(request.getName());
        expense.setExpenseType(request.getExpenseType());
        expense.setAmount(request.getAmount());
        expense.setDate(request.getDate());

        Expense updatedExpense =
                expenseService.save(expense);

        return mapToResponse(updatedExpense);
    }


    // DELETE
    @Operation(
            summary = "Delete an expense",
            description = "Deletes an expense belonging to the authenticated user"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpense(
            @PathVariable Long id) {

        expenseService.deleteById(id);
    }


    // TEST API
    @GetMapping("/test")
    public String test() {

        return "Expense API Working";
    }


    // DTO Mapper
    private ExpenseResponse mapToResponse(
            Expense expense) {

        ExpenseResponse response =
                new ExpenseResponse();

        response.setId(expense.getId());
        response.setName(expense.getName());
        response.setExpenseType(expense.getExpenseType());
        response.setAmount(expense.getAmount());
        response.setDate(expense.getDate());

        return response;
    }
}