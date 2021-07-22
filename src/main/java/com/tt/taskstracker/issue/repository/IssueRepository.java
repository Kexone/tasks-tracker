package com.tt.taskstracker.issue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<IssueDao, String> {

    //@Modifying
    //@Query("update IssueDto i set i.description=?1, i.reason=?1, i.solverId=?1, i.status=?1 where i.id=?1")
    //int setIssueById(IssueDto issue);
}
