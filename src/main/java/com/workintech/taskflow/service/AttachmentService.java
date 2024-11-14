package com.workintech.taskflow.service;


import com.workintech.taskflow.entity.Attachment;
import com.workintech.taskflow.exception.ApiException;
import com.workintech.taskflow.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    public Attachment createAttachment(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    public Attachment getAttachmentById(Long id) {
        return attachmentRepository.findById(id)
                .orElseThrow(() -> new ApiException("Attachment not found", HttpStatus.NOT_FOUND));
    }

    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    public Attachment updateAttachment(Long id, Attachment attachmentDetails) {
        Attachment existingAttachment = getAttachmentById(id);

        existingAttachment.setFileName(attachmentDetails.getFileName());
        existingAttachment.setFileType(attachmentDetails.getFileType());

        return attachmentRepository.save(existingAttachment);
    }

    public void deleteAttachment(Long id) {
        Attachment attachment = getAttachmentById(id);
        attachmentRepository.delete(attachment);
    }
}
