package com.bulletjournal.repository;

import com.bulletjournal.notifications.ProjectItemAuditable;
import com.bulletjournal.repository.models.Task;
import com.bulletjournal.repository.models.TaskAuditable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskAuditableDaoJpa {
  @Autowired
  private TaskAuditableRepository taskAuditableRepository;

  @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
  public void create(List<ProjectItemAuditable> projectItemAuditables) {
    this.taskAuditableRepository.saveAll(
        projectItemAuditables.stream()
            .map(ProjectItemAuditable::toRepositoryTaskAuditable)
            .collect(Collectors.toList()));
  }

  @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
  public Page<TaskAuditable> getHistory(Task task, int pageInd, int pageSize) {
    return this.taskAuditableRepository.findAllByTask(
            task, PageRequest.of(pageInd, pageSize, Sort.by("activityTime").descending()));
  }
}
