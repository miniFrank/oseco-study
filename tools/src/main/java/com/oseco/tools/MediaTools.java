package com.oseco.tools;

import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.log.LogLevel;
import uk.co.caprica.vlcj.log.NativeLog;
import uk.co.caprica.vlcj.player.base.MediaApi;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.component.CallbackMediaPlayerComponent;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * https://github.com/JetBrains/compose-jb/pull/1088
 * @author panguanghua
 */

public class MediaTools {
    public static void main(String[] args) {
        boolean isDiscover = new NativeDiscovery().discover();
        System.out.println("isDiscover:" + isDiscover);
        final CallbackMediaPlayerComponent mediaPlayerComponent
                = new CallbackMediaPlayerComponent();
        NativeLog nativeLog = mediaPlayerComponent.mediaPlayerFactory().application().newLog();
        nativeLog.setLevel(LogLevel.DEBUG);
        nativeLog.addLogListener((logLevel, s, s1, integer, s2, s3, integer1, s4) -> {
            System.out.println(s + s1 + integer + s2 + s3 + integer1 + s4);
        });

        JFrame frame = new JFrame("My First Media Player");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                System.exit(0);
            }
        });


        mediaPlayerComponent.mediaPlayer().events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void playing(MediaPlayer mediaPlayer) {
                System.out.println("-------------------------playing-----------------");
            }

            @Override
            public void finished(MediaPlayer mediaPlayer) {
                System.out.println("-------------------------finished-----------------");
            }

            @Override
            public void error(MediaPlayer mediaPlayer) {
                System.out.println("-------------------------error-----------------");
            }
        });

        frame.setContentPane(mediaPlayerComponent);
        frame.setVisible(true);

        final MediaApi mediaApi = mediaPlayerComponent
                .mediaPlayer()
                .media();

//        SwingUtilities.invokeLater(() -> mediaApi
//                .play("file:///Users/panguanghua/Desktop/test.mp4"));
        mediaApi
                .play("file:///Users/panguanghua/Desktop/test.mp4");
        try {
            Thread.currentThread().join();
        }
        catch(InterruptedException e) {
        }
    }
}
