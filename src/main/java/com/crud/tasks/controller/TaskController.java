package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/task")
public class TaskController {


    private static final String APPLICATION_JSON_VALUE = "1";
    @Autowired
    private DbService service;

    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
       return taskMapper.mapToTaskDtoList(service.getAllTasks());
      //  return new ArrayList<>();
    }

   @RequestMapping(method = RequestMethod.GET, value = "getTaskID")
   public TaskDto getTaskID() throws TaskNotFoundException {
      return (TaskDto) taskMapper.mapToTaskDto(service.getId(1L).orElseThrow(TaskNotFoundException::new));
      //  return new ArrayList<>();
   }


   @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto getTask(@RequestParam Long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(service.getTask(taskId).orElseThrow(TaskNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(@RequestParam Long taskId)  throws TaskNotFoundException {
      taskMapper.mapToTaskDto(service.deleteById(taskId));

    }



    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    public void createTask(@RequestBody TaskDto taskDto) {
        service.saveTask(taskMapper.mapToTask(taskDto));

    }


    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)));
    }



}
