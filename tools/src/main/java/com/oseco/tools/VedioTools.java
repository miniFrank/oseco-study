package com.oseco.tools;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.VideoSurface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * refer to: https://github.com/caprica/vlcj/issues/887
 * @author panguanghua
 */

public class VedioTools {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Window Video Surface");
        jFrame.setBounds(100, 100, 900, 700);
        jFrame.setBackground(Color.red);
        jFrame.getContentPane().setBackground(Color.blue);

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.green);

        jFrame.getContentPane().setLayout(new BorderLayout());
        jFrame.getContentPane().add(jPanel);

        final MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        final EmbeddedMediaPlayer embeddedMediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();
        Window window = new Window(jFrame);
        window.setBackground(Color.gray);
        VideoSurface videoSurface = mediaPlayerFactory.videoSurfaces().newVideoSurface(window);
        embeddedMediaPlayer.videoSurface().set(videoSurface);
        window.setBounds(100, 100, 800, 600);
        window.setIgnoreRepaint(true);
        window.setAlwaysOnTop(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                embeddedMediaPlayer.controls().stop();
                embeddedMediaPlayer.release();
                mediaPlayerFactory.release();
                System.exit(0);
            }
        });

        jFrame.setVisible(true);
        window.setVisible(true);

        embeddedMediaPlayer.media().prepare("file:///Users/panguanghua/Desktop/test.mp4");
        embeddedMediaPlayer.media().play("file:///Users/panguanghua/Desktop/test.mp4");
    }
}
