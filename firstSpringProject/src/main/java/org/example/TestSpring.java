package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ClassicalMusic classicalMusic = context.getBean("classicalMusicBean", ClassicalMusic.class);
        PopMusic popMusic = context.getBean("popMusicBean", PopMusic.class);
        RockMusic rockMusic = context.getBean("rockMusicBean", RockMusic.class);
        System.out.println(classicalMusic.getSong());
        System.out.println(popMusic.getSong());
        System.out.println(rockMusic.getSong());

       /* MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();

        System.out.println(musicPlayer);
        System.out.println(secondPlayer);

        musicPlayer.setVolume(10);

        System.out.println(musicPlayer.getVolume());
        System.out.println(secondPlayer.getVolume());*/

        context.close();
    }
}
