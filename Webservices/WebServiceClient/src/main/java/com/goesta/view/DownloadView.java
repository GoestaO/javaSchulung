package com.goesta.view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DownloadView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea textArea;

	private JButton btnStart;
	private JPanel panelWest, panelSouth, panelEast, panelCenter, panelNorth;
	private JLabel lblImageType, lblSkuList, lblImageSize;

	private JCheckBox nonModel, style, premium;

	private JCheckBox thumbnailHdUrl, smallUrl, smallHdUrl, mediumUrl,
			mediumHdUrl, largeUrl, largeHdUrl;

	public DownloadView() {
		this.setName("Zalando Shop Image Downloader");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout(5, 5));
		createWidgets();
		addWidgets();
		setupInteractions();
		pack();
	}

	private void addWidgets() {
		getContentPane().add(BorderLayout.WEST, panelWest);
		getContentPane().add(BorderLayout.CENTER, panelCenter);
		getContentPane().add(BorderLayout.SOUTH, panelSouth);
		getContentPane().add(BorderLayout.EAST, panelEast);
		getContentPane().add(BorderLayout.NORTH, panelNorth);

		panelWest.add(lblImageType);
		panelWest.add(nonModel);
		panelWest.add(style);
		panelWest.add(premium);

		panelEast.add(lblImageSize);
		panelEast.add(thumbnailHdUrl);
		panelEast.add(smallUrl);
		panelEast.add(smallHdUrl);
		panelEast.add(mediumUrl);
		panelEast.add(mediumHdUrl);
		panelEast.add(largeUrl);
		panelEast.add(largeHdUrl);

		panelCenter.add(lblSkuList);
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.PAGE_AXIS));
		panelSouth.add(btnStart);
		panelCenter.add(textArea);

	}

	private void createWidgets() {
		textArea = new JTextArea(30, 13);
		btnStart = new JButton("Start");
		panelWest = new JPanel();
		panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.PAGE_AXIS));
		panelSouth = new JPanel();
		panelEast = new JPanel();
		panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.Y_AXIS));
		panelCenter = new JPanel();
		panelNorth = new JPanel();

		nonModel = new JCheckBox("NON_MODEL");
		style = new JCheckBox("STYLE");
		premium = new JCheckBox("PREMIUM");

		thumbnailHdUrl = new JCheckBox("Thumbnail");
		smallUrl = new JCheckBox("Small");
		smallHdUrl = new JCheckBox("Small HD");
		mediumUrl = new JCheckBox("Medium");
		mediumHdUrl = new JCheckBox("Medium HD");
		largeUrl = new JCheckBox("Large");
		largeHdUrl = new JCheckBox("Large HD");

		lblImageType = new JLabel("Image type");
		lblSkuList = new JLabel("SKU List");
		lblImageSize = new JLabel("Image Size");
	}

	private void setupInteractions() {

	}

}
