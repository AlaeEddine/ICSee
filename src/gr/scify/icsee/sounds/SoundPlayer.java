package gr.scify.icsee.sounds;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.HashMap;

import gr.scify.icsee.R;

public class SoundPlayer {
    public static final int S1 = R.raw.alienxxxbeep;
    public static final int S2 = R.raw.greencouchbeeps;
    public static final int S3 = R.raw.keykrushermicrowavebeep;
    public static final int S4 = R.raw.kodackbeepbeep;
    public static final int S5 = R.raw.kwahmah02fivebeeps;
    public static final int S6 = R.raw.pan14tonebeep;

    private static SoundPool sp;                    // SoundPool to play the sounds
    private static HashMap<Integer, Integer> spMap; // Keeps the ID of each sound

    public static void initSounds(Context context) {
        // Init soundpool
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);

        // Init hashmap
        spMap = new HashMap<Integer, Integer>();
        spMap.put(S1, sp.load(context, S1, 1));
        spMap.put(S2, sp.load(context, S2, 1));
        spMap.put(S3, sp.load(context, S3, 1));
        spMap.put(S4, sp.load(context, S4, 1));
        spMap.put(S5, sp.load(context, S5, 1));
        spMap.put(S6, sp.load(context, S6, 1));
    }

    public static void playSound(Context context, int soundID) {
        if (sp == null || spMap == null) {
            initSounds(context);
        }

        float volume = 1;

        sp.play(spMap.get(soundID), volume, volume, 1, 0, 1f);
    }
}
