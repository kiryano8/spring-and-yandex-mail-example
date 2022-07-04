package spring.master.yandexmail.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.master.yandexmail.payload.SendMailModel;
import spring.master.yandexmail.service.MailService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

    private final MailService mailService;

    @GetMapping("/mail")
    public String getPage(Model model) {
        model.addAttribute("formModel", new SendMailModel());
        return "mail-form";
    }

    @PostMapping("/mail")
    public String sendMail(Model model, @ModelAttribute(name = "formModel") SendMailModel sendMailModel) {
        try {
            mailService.send(sendMailModel, "Spring and yandex mail");
            model.addAttribute("successMessage", "The email has been sent successfully.");
            return "mail-form";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "mail-form";
        }
    }
}
