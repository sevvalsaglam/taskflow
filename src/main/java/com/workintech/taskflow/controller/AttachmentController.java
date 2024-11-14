package com.workintech.taskflow.controller;

import com.workintech.taskflow.entity.Attachment;
import com.workintech.taskflow.service.AttachmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/attachments")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @PostMapping
    public ResponseEntity<Attachment> createAttachment(@RequestBody @Valid Attachment attachment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(attachmentService.createAttachment(attachment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attachment> getAttachmentById(@PathVariable Long id) {
        return ResponseEntity.ok(attachmentService.getAttachmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<Attachment>> getAllAttachments() {
        return ResponseEntity.ok(attachmentService.getAllAttachments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attachment> updateAttachment(@PathVariable Long id, @RequestBody @Valid Attachment attachmentDetails) {
        return ResponseEntity.ok(attachmentService.updateAttachment(id, attachmentDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable Long id) {
        attachmentService.deleteAttachment(id);
        return ResponseEntity.noContent().build();
    }
}

