package com.iconfluence.sms.model;

import javax.persistence.*;

@Entity
@Table( name = "user" )
public class User {

	@Id
	@Column( name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column( name = "code" )
	private String code;
	
	@Column( name = "name" )
	private String name;
	
	@Column( name = "rid" )
	private int rid;
	
	@Column( name = "pid" )
	private int pid;
	
	@Column( name = "status" )
	private String status;
	
	public User() {
		
	}
	
    public User(String code, String name, int rid, int pid, String status) {
		this.setCode(code);
		this.setName(name);
		this.setStatus(status);
		this.setPid(pid);
		this.setRid(rid);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	
}
