package org.luizvictortinini.services;


import org.luizvictortinini.helper.Constants;
import org.luizvictortinini.models.HeadsetStatus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URL;


public class UiService extends JFrame {

    private final HeadsetStatus headsetStatus;
    private final JFrame jFrame = new JFrame(Constants.HEADSET_NAME);
    private final JLabel lblHeadsetConnected = new JLabel();
    private final JLabel lblHeadsetOn = new JLabel();
    private final JLabel lblMicrophoneOpen = new JLabel();
    private final JButton btnChangeOutput = new JButton();


    public UiService(HeadsetStatus headsetStatus) {
        this.headsetStatus = headsetStatus;
        buildScreen();
    }

    public void showMessage(String message, boolean showAnyway) {
        if (!showAnyway && !headsetStatus.isShowMessages()) {
            return;
        }
        String[] cmd = new String[]{"notify-send", Constants.HEADSET_NAME, message};
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showMessage(String message) {
        showMessage(message, false);
    }


    private void buildScreen() {
        JPanel jPanel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(jPanel, BoxLayout.Y_AXIS);
        jPanel.setLayout(boxlayout);
        jPanel.setBorder(new EmptyBorder(new Insets(30, 20, 30, 20)));
        jPanel.add(lblHeadsetConnected);
        jPanel.add(lblHeadsetOn);
        jPanel.add(lblMicrophoneOpen);
        jPanel.add(btnChangeOutput);
        jFrame.setSize(300, 300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        loadScreenValues();
    }

    public void loadScreenValues() {
        setLabel(lblHeadsetConnected, Constants.LBL_HEADSET_CONNECTED, headsetStatus.isHeadsetConnected());
        setLabel(lblHeadsetOn, Constants.LBL_HEADSET_ON, headsetStatus.isHeadsetOn());
        setLabel(lblMicrophoneOpen, Constants.LBL_MICROPHONE_OPEN, headsetStatus.isMicrophoneOpen());
        URL url = UiService.class.getResource(getIcon());
        ImageIcon icon = new ImageIcon(url);
        jFrame.setState(JFrame.ICONIFIED);
        jFrame.setIconImage(icon.getImage());
    }

    private void setLabel(JLabel jLabel, String value, boolean isEnabled) {
        jLabel.setText(value + " " + String.valueOf(isEnabled).toUpperCase());
    }

    private String getIcon() {
        if (!headsetStatus.isHeadsetConnected()) {
            return Constants.ICON_BLACK;
        } else if (!headsetStatus.isHeadsetOn()) {
            return Constants.ICON_YELLOW;
        } else if (headsetStatus.isMicrophoneOpen()) {
            return Constants.ICON_BLUE;
        }
        return Constants.ICON_RED;
    }

}
