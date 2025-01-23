package org.example.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.Expense;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseUtil {

    private final ObjectMapper objectMapper;

    public ExpenseUtil() {
        this.objectMapper = new ObjectMapper();
        // JavaTimeModule ile LocalDate özelleştirmesi
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new ToStringSerializer());
        objectMapper.registerModule(javaTimeModule);

        // Tarih biçimi için ek bir ayar yapılıyor
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
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

    public int getLastId(List<Expense> expenseList)
    {
        return expenseList.getLast().getId();
    }
}
