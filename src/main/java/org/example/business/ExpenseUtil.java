package org.example.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Expense;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseUtil {

    ObjectMapper objectMapper = new ObjectMapper();

    public void writeExpenseList(File file, List<Expense> taskList) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, taskList);
    }

    public List<Expense> getExpenseList(File expenseFile) throws IOException {
        List<Expense> expenseList = new ArrayList<>();
        if (expenseFile.exists() && expenseFile.length() > 0)
        {
            expenseList = objectMapper.readValue(expenseFile, objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Expense.class));
        }
        return expenseList;
    }

}
