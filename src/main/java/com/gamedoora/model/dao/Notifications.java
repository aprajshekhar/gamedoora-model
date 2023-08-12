package com.gamedoora.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notifications")
public class Notifications extends Audit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "entity_type")
    private String type;

    @Column(name = "entity_id")
    private long entityId;

    @Column(name = "context")
    private String context;

    @Column(name = "action_url")
    private String actionUrl;

    @Column(name = "is_email" ,columnDefinition = "BOOLEAN NOT NULL")
    private boolean isEmail;

    @Column(name = "is_notification" , columnDefinition = "BOOLEAN NOT NULL")
    private boolean isNotification;

    @ManyToMany(mappedBy = "notifications")
    Set<Users> usersSet;

    /* ColumnDefinition syntax has been updated, using nullable=false doesn't seem to work consistently.*/

}