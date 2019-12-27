package com.demo.javamail.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.javamail.resources.EmailDto;
import com.demo.javamail.resources.MailResult;

import java.util.List;
import java.util.Optional;
@Repository
public class MailRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EmailDto> findMailMessageWithStatusZero() {

	List<EmailDto> result = jdbcTemplate.query(
		"SELECT id, name, mail_address, subject, message, created_on, created_by FROM Mail_messages WHERE mail_status = '0' ",
		(rs, rowNum) -> new EmailDto(rs.getString("id"),
			rs.getString("name"), rs.getString("mail_address"), rs.getString("subject"), rs.getString("message"), rs.getString("created_on"), rs.getString("created_by"))
		);

	return result;

    }
    
    public List<EmailDto> findMailMessageAll() {

	List<EmailDto> result = jdbcTemplate.query(
		"SELECT id, name, mail_status, mail_address, subject, message, created_on, created_by FROM Mail_messages ",
		(rs, rowNum) -> new EmailDto(rs.getString("id"),
			rs.getString("name"), rs.getString("mail_status"), rs.getString("mail_address"), rs.getString("subject"), rs.getString("message"), rs.getString("created_on"), rs.getString("created_by"))
		);

	return result;

    }

    public int updateMailResult(MailResult result) {
	// insert into mail_results (id, mail_address, mail_result, mail_result_message, create_on, create_by) values 
	// ('1', 'stonesteel84@gmail.com', '1', 'send OK', '2019-12-27', 'send');
	int resultQuery = jdbcTemplate.update( "insert into mail_results (id, mail_address, mail_result, mail_result_message, create_on, create_by) "
		+ "values(?,?,?,?,?,?)",
		result.getId(), result.getMailAddress(), result.getMailResult(), result.getMailResultMessage(), result.getCreatedOn(), result.getCreatedBy());

	if(resultQuery != 0) {
	    return 10;
	}

	return 0;
    }

    public int updateMailStatus(EmailDto dto) {
	jdbcTemplate.update(
		"update Mail_messages set mail_status = ? where id = ?",
		dto.getMailStatus(), dto.getId());
	return 0;
    }

    public Optional<EmailDto> findMailMessageById(String id) {

	Optional<EmailDto> result = jdbcTemplate.queryForObject(
		"SELECT name, mail_address, subject, message, created_on, created_by FROM Mail_messages WHERE id = ? ",
		new Object[]{id},
		(rs, rowNum) ->
		Optional.of(new EmailDto(
			rs.getString("id"), 
			rs.getString("name"), 
			rs.getString("mail_address"), 
			rs.getString("subject"), 
			rs.getString("message"), 
			rs.getString("created_on"), 
			rs.getString("created_by"))));

	return result;

    } 
}
