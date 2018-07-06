package com.log.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.log.datasource.GetDataSource;

//@Configuration
//@Component
//@PropertySource("classpath:application.properties")
//@En
@Service 
public class EMailService {
	
	private String email;
	@Value("${mail.pwd}")
	private String password;
	@Value("${mail.subject}")
	private String subject;
	@Value("${mail.url}")
	private String mailURL;
	
	@Value("${mail.id}")
	public void setEmail(String email)
	{
		this.email = email;
	}
	@Autowired
	JdbcTemplate jdbc;
    public void sendMail(String emailTSend, String text) {
        //Setting up configurations for the email connection to the Google SMTP server using TLS
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        //Establishing a session with required user details
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        try {
            //Creating a Message object to set the email content
            MimeMessage msg = new MimeMessage(session);
            //Storing the comma seperated values to email addresses
            String to = emailTSend;//"skruksana94@gmail.com,meghana.amg64@gmail.com,prasanthik4700@gmail.com";
            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
            addresses in an array of InternetAddress objects*/
            InternetAddress[] address = InternetAddress.parse(to, true);
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
            msg.setSubject(subject+"       "+timeStamp);
            msg.setSentDate(new Date());
            msg.setText("This is System Generated mail!!! Please click the bellow link to verify you!!   "+mailURL+text);
            msg.setHeader("XPriority", "1");
            Transport.send(msg);
            System.out.println("Mail has been sent successfully");
        } catch (MessagingException mex) {
            System.out.println("Unable to send an email" + mex);
        }
    }
    public List getEmails() {
		GetDataSource ds = new GetDataSource();
		System.out.println("99999999999999999999"+jdbc);
		String sql = "SELECT email,text FROM email_log where is_sent='N'";
		
		List a = new ArrayList();
		 
		List<ArrayList> data = jdbc.query(sql, new RowMapper<ArrayList>(){
            public ArrayList mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	ArrayList temp = new ArrayList();
            	ResultSetMetaData rsmt = rs.getMetaData();
            	for(int i=1;i<=rsmt.getColumnCount();i++)
            	{
            		//System.out.println("iiiiiiiiiiiiii"+i);
            		temp.add(rs.getString(i));
            	}
                
                return temp;
            }
       });	
		System.out.println(data);
		return data;	
	}
}