package com.log.beans;

public class User 
{
	String SNo;
	String Student_Id ;
	String firstname  ;
	String lastname ;
	int role_id ; 
	String email ;
	String phone;
	int state_id ; 
	int district_id ;
	int city_id ;
	int college_id ;
	String is_final_year ;
	String phn_verify  ;
	String email_verify;
	
	public String toString()
	{
		return "SNo"+SNo+":\nstudent_Id"+Student_Id+":\nfirstname:"+firstname+":\nlastname"+lastname+":\nrole_id"+role_id+":\nemail"+email+":\nphone"+phone
				+":\nstate_id"+state_id+"district_id:\n"+district_id+"city_id:\n"+city_id+"college_id:\n"+college_id+"is_final_year:\n"+is_final_year+"phn_verify:\n"+phn_verify+"email_verify:\n"+email_verify;
	}
	
	public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSNo(String SNo) {
        this.SNo = SNo;
    }

    public void setStudent_Id(String student_Id) {
        Student_Id = student_Id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }

    public void setIs_final_year(String is_final_year) {
        this.is_final_year = is_final_year;
    }

    public void setPhn_verify(String phn_verify) {
        this.phn_verify = phn_verify;
    }

    public void setEmail_verify(String email_verify) {
        this.email_verify = email_verify;
    }
    public String getSNo() {
        return SNo;
    }

    public String getStudent_Id() {
        return Student_Id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getRole_id() {
        return role_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getState_id() {
        return state_id;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public int getCollege_id() {
        return college_id;
    }

    public String getIs_final_year() {
        return is_final_year;
    }

    public String getPhn_verify() {
        return phn_verify;
    }

    public String getEmail_verify() {
        return email_verify;
    }

}
