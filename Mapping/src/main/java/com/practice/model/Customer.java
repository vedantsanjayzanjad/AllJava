package com.practice.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practice.customannotation.EvenOrNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
//import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;

	@NotEmpty(message = "Customer Name Should Not Empyt")
	@Column(name = "custName", length = 5)
	@Pattern(regexp = "[A-Z]{2}+[0-2]{2}+[E/N]{1}")
	private String custName;
	
	@Column(name = "password")
	private String password;

	@NotEmpty(message = "Customer Gender Should Not Empyt")
	@Column(name = "custGender")
	@Size(min = 4, max = 6)
	private String custGender;

	@Column(name = "custSalary")
	@EvenOrNull // custom anotation
	private int custSalary;
	
	@Column(name = "fileName")
	private String fileName;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "order_id", referencedColumnName = "o_id")
	private Orders order;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "order_id", referencedColumnName = "o_id")
//	@JsonBackReference
//	private Orders order;

//	@OneToMany(mappedBy = "cust")
//	@JsonBackReference
//	private Set<Orders> order = new HashSet<>();

//	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JsonBackReference
//	@JoinTable
//	(
//	name = "orders_cust",
//	joinColumns = {@JoinColumn(name = "cust", referencedColumnName = "custId")},
//	inverseJoinColumns = {@JoinColumn(name = "orders", referencedColumnName = "o_id")}
//	)
//	private Set<Orders> order = new HashSet<>();
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "customer_role", 
	joinColumns = @JoinColumn(name = "cust", referencedColumnName = "custId"),
	inverseJoinColumns = @JoinColumn(name = "roles", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authories = this.roles.stream()
		.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return authories;
	}

	@Override
	public String getUsername() {
		return this.custName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
}
