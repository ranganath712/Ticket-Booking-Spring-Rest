package com.tbs.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ticket_Info")
//@XmlAccessorType(value = XmlAccessType.FIELD)
//@XmlAccessorOrder
public class Ticket{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private Integer id;
	
	private String name;

	private Integer age;
	
	@Column(name = "phone_no")
	private Long phoneNo;
	
	private String source;
	
	private String destination;
	
	private String coach;

	private Double fare;

}
