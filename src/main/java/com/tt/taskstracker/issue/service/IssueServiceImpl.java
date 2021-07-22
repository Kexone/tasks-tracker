package com.tt.taskstracker.issue.service;

import com.tt.taskstracker.issue.mapper.IssueMapper;
import com.tt.taskstracker.dto.Issue;
import com.tt.taskstracker.dto.IssueStatus;
import com.tt.taskstracker.issue.repository.IssueDao;
import com.tt.taskstracker.issue.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IssueServiceImpl implements IssueService {


    private final IssueRepository issueRepository;
    private final IssueMapper issueMapper;

    public IssueServiceImpl(IssueRepository issueRepository, IssueMapper issueMapper) {
        this.issueRepository = issueRepository;
        this.issueMapper = issueMapper;
    }


    @Override
    public Collection<Issue> getIssues() {
        Collection<IssueDao> issues = issueRepository.findAll();
        return issues.stream()
                .map(issueMapper::IssueDaoToIssue)
                .collect(Collectors.toList());

    }

    @Override
    public Issue getIssue(String id) {
        Optional<IssueDao> issueDao = issueRepository.findById(id);
        return issueDao.map(issueMapper::IssueDaoToIssue)
                .orElse(null);
    }

    @Override
    public Issue createIssue(Issue issue) {
        IssueDao issue2Db = IssueDao.builder()
                .id(UUID.randomUUID().toString())
                .description(issue.getDescription())
                .reason(issue.getReason())
                .status(issue.getStatus())
                .solverId(issue.getSolverId())
                .build();
        return issueMapper.IssueDaoToIssue(issueRepository.save(issue2Db));
    }

    @Override
    public Issue updateIssue(Issue issue) {
        String issueIdFromDb = getIssue(issue.getId()).getId();
        IssueDao Issue2Update = IssueDao.builder()
                .id(issueIdFromDb)
                .description(issue.getDescription())
                .reason(issue.getReason())
                .status(issue.getStatus())
                .solverId(issue.getSolverId())
                .build();
        return issueMapper.IssueDaoToIssue(issueRepository.save(Issue2Update));
    }

    @Override
    public boolean changeStatus(String id, String status) {
        IssueDao issueFromDb = issueRepository.findById(id).orElse(null);
        if(issueFromDb == null) {
            return false;
        }
        IssueDao issue2save = issueFromDb;
        issue2save.setStatus(IssueStatus.valueOf(status));
        issueRepository.save(issue2save);
        return true;

    }
}
