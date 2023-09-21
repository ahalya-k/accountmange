package com.example.dvaraproject.ecom.role;

import com.example.dvaraproject.ecom.user.User;
import org.hibernate.annotations.NaturalId;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String name;
    

    public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	@JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }
     public void removeAllUsersFromRole(){
        if (this.getUsers() != null){
            List<User> usersInRole = this.getUsers().stream().toList();
            usersInRole.forEach(this::removeUserFromRole);
        }
     }
    public void removeUserFromRole(User user) {
        user.getRoles().remove(this);
        this.getUsers().remove(user);
    }
    public void assignUserToRole(User user){
        user.getRoles().add(this);
        this.getUsers().add(user);
    }


}