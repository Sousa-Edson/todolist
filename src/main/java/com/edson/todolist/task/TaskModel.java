package com.edson.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_task")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String description;
    @Column(length = 50)
    private String title;

    @CreationTimestamp
    private LocalDateTime startAt;

    @CreationTimestamp
    private LocalDateTime endAt;

    private String priority;

    @CreationTimestamp
    private LocalDateTime createAt;

    private UUID idUser;

    public void setTitle(String title) throws Exception {
        if (title.length() > 50) {
            throw new Exception("O campo title deve contem no maximo 50 caracteres");
        }
        this.title = title;
    }
}
