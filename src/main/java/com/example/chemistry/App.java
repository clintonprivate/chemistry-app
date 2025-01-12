package com.example.chemistry;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Protocol App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false);

        // Create a panel with a gradient background
        JPanel panel = new JPanel(null) { // Use null layout for free positioning
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color color1 = new Color(173, 216, 230); // Light Blue
                Color color2 = new Color(25, 25, 112); // Midnight Blue
                GradientPaint gradient = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };

        // Create non-editable text labels
        JLabel label1 = new JLabel("Protocol App", SwingConstants.LEFT);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("SansSerif", Font.BOLD, 30));
        label1.setBounds(20, 20, 700, 50); // Set position and size

        JLabel label2 = new JLabel("Please upload your Excel file here: ", SwingConstants.LEFT);
        label2.setFont(new Font("SansSerif", Font.BOLD, 20));
        label2.setForeground(Color.WHITE);
        label2.setBounds(20, 120, 700, 30); // Set position and size

        JLabel label3 = new JLabel("For Martin", SwingConstants.CENTER);
        label3.setFont(new Font("SansSerif", Font.BOLD, 30));
        label3.setForeground(Color.WHITE);
        label3.setBounds(320, 380, 700, 50); // Set position and size

        // Create a file upload button
        JButton fileButton = new JButton("Upload File");
        fileButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        fileButton.setBounds(360, 116, 200, 40); // Set position and size
        fileButton.setFocusPainted(false);
        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(frame, "Select File", FileDialog.LOAD);
                fileDialog.setVisible(true);

                String filePath = fileDialog.getDirectory() + fileDialog.getFile();
                if (fileDialog.getFile() != null) {
                    JOptionPane.showMessageDialog(frame, "File selected: " + filePath, "File Upload", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Create a start button
        JButton startButton = new JButton("Start");
        startButton.setBounds(20, 200, 200, 40); // Set position and size
        startButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        startButton.setFocusPainted(false);

        // Add components to the panel
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(fileButton);
        panel.add(startButton);

        // Add panel to frame
        frame.add(panel);

        // Make the window visible
        frame.setVisible(true);
    }
}
