package Server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.JLabel;

//the class of host panel 
public class ServerMsgPanel extends Panel
{
	public TextArea msgTextArea = new TextArea("", 22, 50,
			TextArea.SCROLLBARS_VERTICAL_ONLY);
	public JLabel statusLabel = new JLabel("The current number of connections:", Label.LEFT);
	public Panel msgPanel = new Panel();
	public Panel statusPanel = new Panel();
	public ServerMsgPanel()
	{
		System.out.println("Mark5");
		setSize(350, 300);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		System.out.println("Mark6");
		msgPanel.setLayout(new FlowLayout());
		msgPanel.setSize(210, 210);
		System.out.println("Mark7");
		statusPanel.setLayout(new BorderLayout());
		statusPanel.setSize(210, 50);
		msgPanel.add(msgTextArea);
		statusPanel.add(statusLabel, BorderLayout.WEST);
		System.out.println("Mark8");
		add(msgPanel, BorderLayout.CENTER);
		add(statusPanel, BorderLayout.NORTH);
	}
}

