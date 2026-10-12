package com.audiototext.audiototect.controller;


import com.audiototext.audiototect.services.AudioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/audio")
public class AudioController {

    //handler method: that will
    //use resource folder for classpath and it will call to spring ai then by using open ai or local ollama ai model it will generate audio to text
//resource folder means it will pickup the file from the classpath
    //we can load the resource by using @value inside our class


    private final AudioService audioService;

    public AudioController(AudioService audioService) {
        this.audioService = audioService;
    }


    //in this api dynamic file is sending for convert audio to text
    @PostMapping("/text")
    public ResponseEntity<String> speechToText(
            @RequestParam("audioFile")MultipartFile audioFile
            ) {

        String responseText = audioService.convertAudioToText(audioFile.getResource());
        return ResponseEntity.ok(responseText);


    }


    @PostMapping("/transcript")
    public ResponseEntity<String> transcriptAudio(
        @Value("${classpath:sample.m4a}") Resource inputAudio) {

        //now by using springai we have to convert audio to text

        String responseText = audioService.convertAudioToText(inputAudio);
        return ResponseEntity.ok(responseText);

        }


    @PostMapping("/transcript-with-options")
    public ResponseEntity<String> transcriptAudioWithOptions(
            @Value("${classpath:sample.m4a}") Resource inputAudio) {

        //now by using springai we have to convert audio to text

        String responseText = audioService.convertAudioToTextWithOptions(inputAudio);

        return ResponseEntity.ok(responseText);

    }



}
