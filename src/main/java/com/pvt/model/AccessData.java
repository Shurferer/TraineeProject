package com.pvt.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name = "Access" ,catalog = "project")
public class AccessData implements Serializable {
    
        @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "access_ID", unique = true, nullable = false)
    	private int accessID;
    
        @Column(name = "login", unique = true, nullable = false)
        private String login;
        
        @Column(name = "password", unique = false, nullable = false)
        private String password;
        
        @OneToOne(fetch = FetchType.LAZY)
        @PrimaryKeyJoinColumn
        private User user;

        public AccessData() {
        }

        public AccessData( String login, String password) {
        this.login = login;
        this.password = password;
        }
            
        public void setLogin (String str) {login = str;}
        public void setPassword(String str) {password = str;}
        public void setUser(User user) {this.user=user;}
        public void setAccessID (int id){accessID=id;}
        
        public String getLogin (){return login;}
        public String getPassword(){return password;}
        public User getUser() {return user;}
        public int getAccessID(){return accessID;}
        
        public String toString (){
            return "Login: " + login+ " ; Pass: " + password + "; User: " + user;
                    
        }
}
