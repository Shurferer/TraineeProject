package com.pvt.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="company", catalog="project")
public class Company implements Serializable {
	
        @Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Company_ID", unique = true, nullable = false)
        private int companyID;
        
        @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "ID", nullable = false)
        private User requester;
        
        @Column(name = "name", unique = false, nullable = false, length = 10)
        private String name;
	         
        @Column(name = "phone", unique = false, nullable = false, length = 10)
        private int phone;
        
        public Company (){};
	
        public Company (String name, int phone){
		this.name=name;
		this.phone =phone;
	}
	public int getCompanyID (){return companyID;}
        public User getRequester (){return requester;}
	public String getName(){return name;}
	public int getPhone (){return phone;}
        
        public void setCompanyID (int id){companyID = id;}
        public void setRequester (User req){requester = req;}
        public void setName (String name) {this.name = name;}
        public void setPhone (int phone) {this.phone = phone;}
}
