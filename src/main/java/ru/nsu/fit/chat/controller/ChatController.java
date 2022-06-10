package ru.nsu.fit.chat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nsu.fit.chat.dto.UserInfoDto;

@Controller
@RequestMapping("/")
public class ChatController {

    @GetMapping("/chat")
    public String chat(@AuthenticationPrincipal User user, Model model) {
        UserInfoDto userInfo = new UserInfoDto();
        userInfo.setUsername(user.getUsername());
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("isDevMode",true);
        return "chat";
    }
}
