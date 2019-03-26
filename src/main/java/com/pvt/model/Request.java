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
@Table(name="request", catalog="project")
public class Request implements Serializable {
        
        @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "ID", nullable = false)
        private User requester;
        @Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Request_ID", unique = true, nullable = false)
        private int requestID;
	
        @Column(name = "job", unique = false, nullable = false, length = 10)
        private String job;
        
        @Column(name = "role", unique = false, nullable = false, length = 10)
        private String role;

        @Column(name = "payment", unique = false, nullable = false, length = 10)
	private int payment;
	
        @Column(name = "hoursinWeek", unique = false, nullable = false, length = 10)
        private int hoursinWeek;
	
        @Column(name = "type", unique = false, nullable = false, length = 10)
        private int type;
        
        public Request (){};
	public Request (String job, int payment,int hoursinWeek,int type){
		this.job =job;
		this.payment= payment;
		this.hoursinWeek=hoursinWeek;
		this.type=type;
                if (type==1) role="worker";
                else role="employee";
	}
	public int getRequestID(){return requestID;}
        public void setRequestID (int set){requestID = set;}
        
        public User getRequester(){return requester;}
        public void setRequester (User req){requester = req;}
	
        public String getJob(){ return job;}
        public void setJob (String str){job=str;}
        
        public String getRole(){ return role;}
        public void setRole (String str){role=str;}
	
        public int getPayment(){return payment;}
        public void setPayment (int set){payment = set;}
	
        public int getHoursinWeek(){return hoursinWeek;}
        public void setHoursinWeek (int hour) {hoursinWeek = hour;}
	
        public int getType(){return type;}
        public void setType (int type){this.type = type;}
        
	public String toString (){ return "Client " + requester.getName()+ " made next request: job - "+ job+
								", payment - "+ payment+ ", hoursinWeek - "+ hoursinWeek + ". Client in this "
								+ " request signed as "+ getRole();
	}
}
