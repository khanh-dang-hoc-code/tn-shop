package com.tech.tnshop.service;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public interface IEmailService {
//     void send(String to, String email);
     void send(String toEmail, String subject, String body);

}
