package org.rizki.mufrizal.dynamic.task.controller;

import org.rizki.mufrizal.dynamic.task.service.TaskSchedulingService;
import org.rizki.mufrizal.dynamic.task.task.TaskDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "/schedule")
public class JobSchedulingController {

    @Autowired
    private TaskSchedulingService taskSchedulingService;

    @Autowired
    private TaskDefinition taskDefinition;

    @PostMapping(path = "/task/add")
    public ResponseEntity<?> scheduleATask(@RequestBody Map<String, String> map) {
        taskSchedulingService.scheduleATask(UUID.randomUUID().toString(), taskDefinition, map.get("cron"));
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping(path = "/remove/{jobid}")
    public ResponseEntity<?> removeJob(@PathVariable String jobid) {
        taskSchedulingService.removeScheduledTask(jobid);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}