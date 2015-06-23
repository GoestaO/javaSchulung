package com.goesta.swingworkerExample;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public void makeGUI() {
		final JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout());

		JButton b = new JButton("Answer!");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executors.newSingleThreadExecutor()
						.execute(new AnswerWorker(f));
			}
		});

		f.getContentPane().add(b);
		f.getContentPane().add(new JButton("Nothing"));
		f.pack();
		f.setVisible(true);
	}

}
