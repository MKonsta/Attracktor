package com.example.hw60.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class DemoController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @PostMapping("/addpost")
    public String rootSave(@RequestParam("content") String content,
                           @RequestParam("photo") MultipartFile photo,
                           @RequestParam("userId") String userid) throws IOException {

        File photoFile = new File("src\\main\\resources\\static\\images\\" + photo.getOriginalFilename());
        FileOutputStream os = new FileOutputStream(photoFile);
        os.write(photo.getBytes());

        os.close();

        return "success";
    }


    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }

    @PostMapping("/index/post")
    public String postDemo(@RequestParam("text") String text, @RequestParam("pic") String pic, @RequestParam("id") String id) {
        System.out.println(text);
        System.out.println(pic);
        System.out.println(id);
        return "redirect:/index/";
    }

    @PostMapping("/post")
    public void postItem(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("id") String id) {
        System.out.println(login);
        System.out.println(password);
        System.out.println(id);
    }
}
