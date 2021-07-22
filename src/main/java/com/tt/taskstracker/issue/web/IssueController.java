package com.tt.taskstracker.issue.web;


import com.tt.taskstracker.dto.Issue;
import com.tt.taskstracker.issue.model.IssueStatusValue;
import com.tt.taskstracker.issue.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;

@RestController
@RequestMapping(value = "/issues")
public class IssueController implements Serializable {

    final Logger logger = LoggerFactory.getLogger(IssueController.class);
    final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "hello world";
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Collection<Issue> getAllIssues() {
        logger.info("return all issues");
        return issueService.getIssues();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Issue getIssue(@PathVariable String id) {
        return issueService.getIssue(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Issue createIssue(@RequestBody Issue issue) {
       return issueService.createIssue(issue);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    Issue updateIssue(@RequestBody Issue issue) {
        return issueService.updateIssue(issue);
    }

    @RequestMapping(value = "/change-status/{id}", method = RequestMethod.PATCH)
    boolean changeStatus(@PathVariable String id, @RequestBody IssueStatusValue status ){
        return issueService.changeStatus(id, status.getStatus());
    }
}
