// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

// Converts text to audio
public class TTSFacade 
{
	private Voice voice;
	
	public TTSFacade()
	{
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		this.voice = VoiceManager.getInstance().getVoice("kevin");
		if(this.voice != null)
		{
			voice.allocate();
		}
		this.voice.setVolume(3);
		this.voice.setPitch(150);
		this.voice.setRate(150);
	}
	
	// Play given contents
	public void play(String contents)
	{
		this.voice.speak(contents);
	}
	
	// Set audio parameters
	public void tuneAudioParameters(float volume,float pitch,float rate)
	{
		this.voice.setVolume(volume);
		this.voice.setPitch(pitch);
		this.voice.setRate(rate);
	}
}
