### Integration of the Spring application with the [yandex mail service](https://mail.yandex.ru/) for sending emails.

* Java 17
* Gradle 7.4
* Spring boot 3.0

###### Change the username and password from the mail service.
```
# application.yaml

username: set-your-email
password: set-your-password
```

###### Change the sender's address when sending.
```
# MailService.java

mimeMessageHelper.setFrom("set-your-email");
```

###### Launch a project
```
gradle bootRun
```