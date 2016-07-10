package com.library.entities;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Tomasz Dębski
 *
 */
@Entity
@Table(name = "BookReader")
public class BookReader {

	@Id
	@GeneratedValue
	private long id;

	@Column(name="username")
	private String readerName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "bookReader", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<OrderPack> orderPacks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public Set<OrderPack> getOrderPacks() {
		return orderPacks;
	}

	public void setOrderPacks(Set<OrderPack> orderPacks) {
		this.orderPacks = orderPacks;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
