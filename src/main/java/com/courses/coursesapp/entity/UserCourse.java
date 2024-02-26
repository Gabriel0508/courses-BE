package com.courses.coursesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_course", schema = "public")
public class UserCourse {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Column(name = "is_favourite")
    private Boolean isFavourite;

    @Column(name = "is_subscribed")
    private Boolean isSubscribed;

    @Column(name = "is_done")
    private Boolean isDone;

    @Column(name = "ins_date", nullable = false)
    private LocalDateTime insDate = LocalDateTime.now();
}
