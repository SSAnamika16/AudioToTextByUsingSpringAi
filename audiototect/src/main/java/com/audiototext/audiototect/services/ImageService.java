package com.audiototext.audiototect.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final ImageModel imageModel;

    private final Logger logger = LoggerFactory.getLogger(ImageService.class);

    public ImageService(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    OpenAiImageOptions imageOptions = OpenAiImageOptions.builder()
            .n(1)
//            .model("gpt-image-1")
//            .quality("medium")
            .quality("hd")
            .build();

//    logger.info("image options {}", imageOptions);



    public String generateImage(String prompt) {

        ImageResponse imageResponse = imageModel
                .call(new ImagePrompt(
                prompt,
//                OpenAiImageOptions.builder()
                imageOptions
        ));

        logger.info("image response {}" ,imageResponse);
        logger.info("image generations {}", imageResponse.getResult());


        return "Image generate";

    }


}
