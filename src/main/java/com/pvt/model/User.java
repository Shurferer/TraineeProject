package com.pvt.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="user", catalog="project")
public  class User implements Serializable{
       
        @Id
        @GeneratedValue(strategy = IDENTITY)
	@Column(name = "UserID", unique = true, nullable = false)
        private int ID;	
        
        @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
        private AccessData accessData;
        
        @Column(name = "Name", unique = false, nullable = false)
        protected String name ;
	
        @Column (name="phone", unique = false, nullable = false, length = 10)
        protected int phone = 000; 	
        
        @OneToMany(fetch = FetchType.EAGER, mappedBy = "requester" ,cascade=CascadeType.ALL)
        private Set<Request> requests = new HashSet<Request>(0);
        
        @OneToMany(fetch = FetchType.EAGER, mappedBy = "requester", cascade=CascadeType.ALL )
        private Set<Company> companies = new HashSet<Company>(0);
	
        public  User(){};

	public User (String name){ 
		this.name = name;
		}
        
	public void setName (String name){this.name = name;	}
	public String getName (){return name;}	
	public String getLogin(){ return accessData.getLogin();}
	public String getPassword(){ return accessData.getPassword();}
        public Set<Request> getRequests() {return requests;} 
        public Set<Company> getCompanies() {return companies;} 
        public AccessData getAccessData(){return accessData;}

	public void setID (int ID){this.ID=ID;}
	public int getID (){return ID;}
        public void setPhone(int phone){this.phone = phone;}
	public int getPhone (){return phone;}
        public void setRequests(Set<Request> requests){this.requests = requests;}
        public void setCompanies (Set<Company> companies){this.companies = companies;}
        public void setAccessData (AccessData access){accessData=access;}

        @Override
	public String toString(){return "Name: " + name + ". Phone : " + phone ;}
        

}
