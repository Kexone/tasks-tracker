package com.tt.taskstracker.issue.service;

import com.tt.taskstracker.dto.Issue;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface IssueService {

    Collection<Issue> getIssues();
    Issue getIssue(String id);
    Issue createIssue(Issue issue);
    Issue updateIssue(Issue issue);
    boolean changeStatus(String id, String status);
}
