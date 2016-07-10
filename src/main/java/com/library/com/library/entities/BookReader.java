package com.library.com.library.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedQueries(value = { @NamedQuery(name = "BookReader.all", query = "select br from BookReader br") })
@NamedEntityGraph(name = "graph.BookReader", 
attributeNodes = @NamedAttributeNode(value = "orderPacks", subgraph = "orderPack"), 
subgraphs = @NamedSubgraph(name = "orderPack", attributeNodes = @NamedAttributeNode("books")))
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
