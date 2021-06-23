package com.shad.dojos_Ninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="dojos")
public class Dojo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(updatable=false)
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
   
    @PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }

    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    
	/**
	 * sets up a OneToMany relationship
	 */
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;

    public Dojo() {}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * sets the id to @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the name to @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the createdAt date
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * sets the createdAt date to the @param createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt date
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * set the updatedAt date to @param updatedAt
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return a list of ninjas
	 */
	public List<Ninja> getNinjas() {
		return ninjas;
	}

	/**
	 * creates a list of ninjas from @param ninjas
	 */
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
    
}


