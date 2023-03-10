// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

// Fake TTS for test purposes
public class FakeTTSFacade extends TTSFacade
{
	private Voice voice;
	
	private String playedContents = "";
	
	private float playedVolume;
	
	private float playedPitch;
	
	private float playedRate;
	
	public FakeTTSFacade()
	{
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		this.voice = VoiceManager.getInstance().getVoice("kevin");
		if(this.voice != null)
		{
			voice.allocate();
		}
		this.voice.setVolume(3);
		this.voice.setPitch(150);
		this.voice.setRate(190);
	}
	
	public String getPlayedContents()
	{
		String retString = this.playedContents;
		return retString;
	}
	
	public float getPlayedVolume()
	{
		return this.playedVolume;
	}
	
	public float getPlayedPitch()
	{
		return this.playedPitch;
	}
	
	public float getPlayedRate()
	{
		return this.playedRate;
	}
	
	// Play given contents and add them to playedContents
	public void play(String contents)
	{
		this.playedContents += contents + " ";
		super.play(contents);
	}
	
	// Set given audio parameters and save them 
	public void tuneAudioParameters(float volume,float pitch,float rate)
	{
		this.playedVolume = volume;
		this.playedPitch = pitch;
		this.playedRate = rate;
		super.tuneAudioParameters(volume, pitch, rate);
	}
}
