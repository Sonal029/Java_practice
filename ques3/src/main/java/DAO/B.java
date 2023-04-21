package DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class B {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String bname;
	
	
	@OneToOne
	private A a;
	
	
	
	public A getA() {
		return a;
	}
	public void setA(A a) {
		this.a = a;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	
	public B() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public B( String bname) {
		super();
		this.bname = bname;
	}
	@Override
	public String toString() {
		return "B [eid=" + eid + ", bname=" + bname + "]";
	}

	
	
}
