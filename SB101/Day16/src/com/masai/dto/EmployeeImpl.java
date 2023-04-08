package com.masai.dto;

public class EmployeeImpl implements Employee {
	
	@Override
	public String toString() {
		return "employee Id=" + empId + ", Employee name=" + ename + ", Address=" + address + ", mobile=" + mobile
				+ ", deptid=" + deptid;
	}
	private String empId;
	private String ename;
	private String address;
	private long mobile;
	private String deptid;
	public EmployeeImpl(String empId, String ename, String address, long mobile, String deptid) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.address = address;
		this.mobile = mobile;
		this.deptid = deptid;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	
	
	
	
	
	
	
	

}
