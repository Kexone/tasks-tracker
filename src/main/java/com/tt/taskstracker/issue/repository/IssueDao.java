package com.tt.taskstracker.issue.repository;

import com.tt.taskstracker.dto.IssueStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "issues")
public class IssueDao {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private IssueStatus status;

    @Column(name = "reason")
    private String reason;

    @Column(name = "solverId")
    private String solverId;
}
