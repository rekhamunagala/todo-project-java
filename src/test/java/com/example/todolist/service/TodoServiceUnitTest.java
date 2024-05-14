package com.example.todolist.service;

import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TodoServiceUnitTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoServiceImpl todoService;

    @Test
    public void testGetAllTodos() {
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setDescription("Test Todo");
        todo.setCompleted(false);

        when(todoRepository.findAll()).thenReturn(Collections.singletonList(todo));

        List<Todo> todos = todoService.getAllTodos();

        assertEquals(1, todos.size());
        assertEquals(todo, todos.get(0));
    }

    // Other unit tests for service methods...
}
