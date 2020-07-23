package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by uejobi on 2019/01/11.
 */

public class Sound {
    static MediaPlayer battle;
    static MediaPlayer bossBattle;
    static MediaPlayer lastBossBattle;
    static MediaPlayer secretBossBattle;
    static MediaPlayer dungeon;
    static MediaPlayer touch;
    static MediaPlayer decide;
    static MediaPlayer cancel;
    static MediaPlayer ban;
    static MediaPlayer damageAttack;
    static MediaPlayer damageRecieve;

    public void createBattleMedia(Context context){
        battle = MediaPlayer.create(context, R.raw.battle);
        battle.setVolume((float)PlayerData.BGMVolume / 10, (float)PlayerData.BGMVolume / 10);
        battle.setLooping(true);
    }

    public void createBossBattleMedia(Context context){
        bossBattle = MediaPlayer.create(context, R.raw.boss_battle);
        bossBattle.setVolume((float)PlayerData.BGMVolume / 10, (float)PlayerData.BGMVolume / 10);
        bossBattle.setLooping(true);
    }

    public void createLastBossBattleMedia(Context context){
        lastBossBattle = MediaPlayer.create(context, R.raw.last_boss_battle);
        lastBossBattle.setVolume((float)PlayerData.BGMVolume / 10, (float)PlayerData.BGMVolume / 10);
        lastBossBattle.setLooping(true);
    }

    public void createSecretBossBattleMedia(Context context){
        secretBossBattle = MediaPlayer.create(context, R.raw.secret_boss_battle);
        secretBossBattle.setVolume((float)PlayerData.BGMVolume / 10, (float)PlayerData.BGMVolume / 10);
        secretBossBattle.setLooping(true);
    }

    public void createDungeonMedia(Context context){
        dungeon = MediaPlayer.create(context, R.raw.dungeon);
        dungeon.setVolume((float)PlayerData.BGMVolume / 10, (float)PlayerData.BGMVolume / 10);
        dungeon.setLooping(true);
    }

    public void createTouchMedia(Context context){
        touch = MediaPlayer.create(context, R.raw.touch);
        touch.setVolume((float)PlayerData.SEVolume / 10, (float)PlayerData.SEVolume / 10);
        touch.setLooping(false);
    }

    public void createDecideMedia(Context context){
        decide = MediaPlayer.create(context, R.raw.decide);
        decide.setVolume((float)PlayerData.SEVolume / 10, (float)PlayerData.SEVolume / 10);
        decide.setLooping(false);
    }

    public void createCancelMedia(Context context){
        cancel = MediaPlayer.create(context, R.raw.cancel);
        cancel.setVolume((float)PlayerData.SEVolume / 10, (float)PlayerData.SEVolume / 10);
        cancel.setLooping(false);
    }

    public void createBanMedia(Context context){
        ban = MediaPlayer.create(context, R.raw.ban);
        ban.setVolume((float)PlayerData.SEVolume / 10, (float)PlayerData.SEVolume / 10);
        ban.setLooping(false);
    }

    public void createDamageAttackMedia(Context context){
        damageAttack = MediaPlayer.create(context, R.raw.damage_attack);
        damageAttack.setVolume((float)PlayerData.SEVolume / 10, (float)PlayerData.SEVolume / 10);
        damageAttack.setLooping(false);
    }

    public void createDamageRecieveMedia(Context context){
        damageRecieve = MediaPlayer.create(context, R.raw.damage_recieve);
        damageRecieve.setVolume((float)PlayerData.SEVolume / 10, (float)PlayerData.SEVolume / 10);
        damageRecieve.setLooping(false);
    }
}
