package com.study.crud.phone.controller;

import com.study.crud.phone.model.dto.PhoneDTO;
import com.study.crud.phone.model.service.PhoneService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/phone")
public class PhoneController {

    private final PhoneService phoneService;
    private final MessageSource messageSource;

    public PhoneController(PhoneService phoneService, MessageSource messageSource) {
        this.phoneService = phoneService;
        this.messageSource = messageSource;
    }

    @GetMapping("/list")
    public String selectAllList(Model model) {
        List<PhoneDTO> phoneList = phoneService.selectAllList();
        model.addAttribute("phoneList", phoneList);
        return "phone/list";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/regist")
    public String registPhone(@ModelAttribute PhoneDTO phone, RedirectAttributes rttr, Locale locale) {
        phoneService.registPhone(phone);
        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registPhone", null, locale));
        return "redirect:/phone/list";
    }

    @GetMapping("/delete")
    public void deletePage(Model model) {
        List<PhoneDTO> phoneList = phoneService.selectAllList();
        model.addAttribute("phoneList", phoneList);
    }

    @PostMapping("/delete")
    public String deletePhone(@ModelAttribute PhoneDTO phone, RedirectAttributes rttr, Locale locale) {
        phoneService.deletePhone(phone);
        rttr.addFlashAttribute("successMessage", messageSource.getMessage("deletePhone", null, locale));
        return "redirect:/phone/list";
    }
}
