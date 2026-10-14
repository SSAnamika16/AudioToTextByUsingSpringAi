package com.audiototext.audiototect.controller;


import com.audiototext.audiototect.services.ImageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    //images generate

    @PostMapping
    public String generate(@RequestParam("prompt") String prompt) {
        return imageService.generateImage(prompt);
    }


}
