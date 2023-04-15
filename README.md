# API Readme - Email Sender Service
This API provides functionality to send an email with and without attachments. It is implemented using JavaMailSender and Spring Boot.

# Getting Started
To use this API, you need to have Java installed on your computer. You will also need to set up an email account to use as the sender.

# Prerequisites
-	Java 8 or higher
-	Email account to use as the sender

# Installation
1.	Clone the repository.
2.	Set the following environment variables:
3.	EMAIL - The email address of the sender.
4.	PASSWORD - The password for the email account.
5.	Run the application using your preferred IDE or using the following command:
arduino


./mvnw spring-boot:run
API Endpoints
The following endpoints are available:

# Send email
This endpoint sends an email.

URL: /api/email/send

Method: POST

Request Body:
{
  "to": "example@example.com",
  "from": "example@example.com",
  "subject": "Test email",
  "message": "Hello, this is a test email."
}
Response Body:


{
  "httpStatus": "OK",
  "message": "Email sent successfully to example@example.com"
}

# Send email with attachment
This endpoint sends an email with an attachment.

URL: /api/v1/email/send-with-attachment

Method: POST

Request Body:

{
  "to": "example@example.com",
  "from": "example@example.com",
  "subject": "Test email with attachment",
  "message": "Hello, this is a test email with attachment.",
  "attachment": "/path/to/attachment"
}
Response Body:

{
  "httpStatus": "OK",
  "message": "Email sent successfully to example@example.com"
}
# Configuration
The following configuration options are available:

-  spring.mail.host=smtp.gmail.com
-  spring.mail.username=${EMAIL}
-  spring.mail.password=${PASSWORD}
-  spring.mail.port=587
-  spring.mail.properties.mail.smtp.auth=true
-  spring.mail.properties.mail.smtp.starttls.enable=true

# Authors
-	Ahmad Abeeb

# Acknowledgments
- Spring Boot
- JavaMailSender
- Lombok
