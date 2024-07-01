package com.nt.model.prod;

import lombok.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="MULTI_DB_PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer pid;
	
	@Column(length = 25)
	@NonNull
	private  String pname;
	@NonNull
	private  Double price;
	@NonNull
	private  Double  qty;
	@Column(length = 20)
	@NonNull
	private   String  vendor;

}
