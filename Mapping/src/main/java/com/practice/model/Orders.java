package com.practice.model;
import java.time.LocalDate;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate start_date;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate end_date;
	
	@OneToOne(mappedBy = "order")
	@JsonBackReference
	private Customer cust;
	
}
