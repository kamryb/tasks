package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private TaskRepository repository;
    private Object TaskNotFoundException;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }
    public Optional<Task> getId(final Long id)  {
        return repository.findById(1L);
    }

    public Task saveTask(final Task task) {
        return repository.save(task);
    }

    public Optional<Task> getTask(final Long id) {
        return repository.findById(id);

        }

    public Task deleteById(Long taskId) {
        repository.deleteById(taskId);
        return null;
    }


    //   public Task getTaskById(final Long id) {
 //       return repository.findById(id).orElse(null);
 //   }



}
