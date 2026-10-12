package com.audiototext.audiototect.services;


import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class AudioService {

    private final TranscriptionModel transcriptionModel;


    public AudioService(TranscriptionModel transcriptionModel) {
        this.transcriptionModel = transcriptionModel;
    }

    public String convertAudioToText(Resource inputAudio) {

    }

}


//TranscriptionModel provide unified/general api means this interface provide abstraction model for this we can use model like openai, gemini, anthropic
//Transcription Api provide api that helps us to convert our audio into text