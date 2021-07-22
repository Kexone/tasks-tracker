package com.tt.taskstracker.issue.mapper;

import com.tt.taskstracker.dto.Issue;
import com.tt.taskstracker.issue.repository.IssueDao;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IssueMapper {
    Issue IssueDaoToIssue(IssueDao issueDao);
}
