package spring.master.yandexmail.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendMailModel {
    public String targetEmail;
    public String message;
}
