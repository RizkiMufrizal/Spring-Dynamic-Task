package org.rizki.mufrizal.dynamic.task.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskDefinition implements Runnable {
    @Override
    public void run() {
        log.info("Hello World");
    }
}