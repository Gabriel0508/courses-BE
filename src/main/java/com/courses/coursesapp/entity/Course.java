package com.courses.coursesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "course", schema = "public")
public class Course implements Serializable{

    @Serial
    private static final long serialVersionUID = 1945670924947820279L;

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "uuid")
//    private UUID uuid;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id")
    private AppUser owner;

    @Column(name = "ins_date", nullable = false)
    private LocalDateTime insDate = LocalDateTime.now();
}
