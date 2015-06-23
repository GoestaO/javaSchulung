package de.eiting.explosionExample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Entrypoint {
	public static void main(String[] args) {
		JPicturePanel p = new JPicturePanel();
		
		p.setBorderColor(Color.red);
		
		JButton startBtn = new JButton();
		startBtn.setBounds(16, 16, 64, 32);
		startBtn.setText("START");
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Executors.newSingleThreadExecutor().execute(new CountdownWorker(p));
			}
		});
		
		JFrame frame = new JFrame();
		
		frame.setTitle("Boom Frame");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(p, BorderLayout.CENTER);
		frame.add(startBtn, BorderLayout.NORTH);
		
		frame.setVisible(true);
	}
}
