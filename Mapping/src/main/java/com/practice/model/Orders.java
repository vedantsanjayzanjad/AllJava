package com.practice.model;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.modelmapper.internal.bytebuddy.asm.Advice.Local;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
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
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int o_id;
	
	@NotEmpty(message = "Start Date Name Should Not Empyt")
	private String start_date;
	
	@NotEmpty(message = "End Date Should Not Empyt")
	private String end_date;
	
//	@OneToOne(mappedBy = "order")
//	@JsonBackReference
//	private Customer cust;
	
//	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
//	@JsonBackReference
//	private Set<Customer> cust = new HashSet<>();
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "custId", referencedColumnName = "custId")
//	@JsonBackReference
//	private Customer cust;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@jakarta.persistence.JoinTable
	(
	name = "orders_cust",
	joinColumns = @JoinColumn(name = "orders", referencedColumnName = "o_id"),
	inverseJoinColumns = @JoinColumn(name = "customer", referencedColumnName = "custId")
	)
	private Set<Customer> cust = new HashSet<>();
}
