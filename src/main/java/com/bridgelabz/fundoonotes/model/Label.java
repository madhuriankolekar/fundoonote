package com.bridgelabz.fundoonotes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="Labels")
@Data
public class Label {
	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column
		private Integer id;
		@Column
		private String lname;
		@Column
		private String sname;
		@Column
		private long mobileno;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public long getMobileno() {
			return mobileno;
		}
		public void setMobileno(long mobileno) {
			this.mobileno = mobileno;
		}
		

	}


