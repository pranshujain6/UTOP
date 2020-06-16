package Functionality;

import com.sun.speech.freetts.*;

public class Speak {
	
	Speak(String speaker,String contentOfSpeech)
	{
			
		Voice v = VoiceManager.getInstance().getVoice(speaker);
		v.allocate();
		v.setPitch(150.0F); 
		v.setVolume(1.0F); 
		v.setRate(160.0F);         
		v.speak(contentOfSpeech);
	}

}
