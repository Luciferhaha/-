package Client;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Network.ChessBoard2;
import Server.Server;
import UI2.UserChatPad;
import UI2.UserControlPad;
import UI2.UserInputPad;
import UI2.UserListPad;

<<<<<<< HEAD
// 浜斿瓙妫嬪鎴风
public class MainClient extends JFrame implements ActionListener, KeyListener
{
	// 瀹㈡埛绔鎺ュ彛
	Socket clientSocket;
	// 鏁版嵁杈撳叆娴�
	DataInputStream inputStream;
	// 鏁版嵁杈撳嚭娴�
	DataOutputStream outputStream;
	// 鐢ㄦ埛鍚�
	String chessClientName = null;
	// 涓绘満鍦板潃
	String host = null;
	// 涓绘満绔彛
	int port = 4331;
	// 鏄惁鍦ㄨ亰澶�
	boolean isOnChat = false;
    // 鏄惁鍦ㄤ笅妫�
	boolean isOnChess = false;
	// 娓告垙鏄惁杩涜涓�
	boolean isGameConnected = false;
	// 鏄惁涓烘父鎴忓垱寤鸿��
	boolean isCreator = false; 
	// 鏄惁涓烘父鎴忓姞鍏ヨ��
	boolean isParticipant = false;
	// 鐢ㄦ埛鍒楄〃鍖�
	UserListPad userListPad = new UserListPad();
	// 鐢ㄦ埛鑱婂ぉ鍖�
	UserChatPad userChatPad = new UserChatPad();
	// 鐢ㄦ埛鎿嶄綔鍖�
	UserControlPad userControlPad = new UserControlPad();
	// 鐢ㄦ埛杈撳叆鍖�
	UserInputPad userInputPad = new UserInputPad();
	// 涓嬫鍖�
	public ChessBoard2 jpanel=new ChessBoard2();
	// 闈㈡澘鍖�
=======
// chess client
public class MainClient extends JFrame implements ActionListener, KeyListener
{
	// client socket
	Socket clientSocket;
	// data input stream
	DataInputStream inputStream;
	// data output stream
	DataOutputStream outputStream;
	// name of user
	String chessClientName = null;
	// host ip
	String host = null;
	// host port
	int port = 4331;
	// whether chating
	boolean isOnChat = false;
    // whether move
	boolean isOnChess = false;
	// whether the game is going
	boolean isGameConnected = false;
	// whether it is the creator of thr game
	boolean isCreator = false; 
	
	boolean isParticipant = false;
	// the area of user list
	UserListPad userListPad = new UserListPad();
	// the area of user chat
	UserChatPad userChatPad = new UserChatPad();
	// the area of user operation
	UserControlPad userControlPad = new UserControlPad();
	// the area of input
	UserInputPad userInputPad = new UserInputPad();
	// move
	public ChessBoard2 jpanel=new ChessBoard2();
	// board
>>>>>>> origin/master
	Panel southPanel = new Panel();
	Panel northPanel = new Panel();
	Panel centerPanel = new Panel();
	Panel eastPanel = new Panel();
	

	// create the frame
	public MainClient()
	{
		super("Chess Client");

		//new Background();
        //setVisible(true);
        
		setLayout(new BorderLayout());	
		host = userControlPad.ipInputted.getText();
		eastPanel.setLayout(new BorderLayout());
		eastPanel.add(userListPad, BorderLayout.NORTH);
//		eastPanel.add(userChatPad, BorderLayout.CENTER);
		eastPanel.add(userControlPad, BorderLayout.CENTER);
//		eastPanel.setBackground(Color.LIGHT_GRAY);
		userInputPad.contentInputted.addKeyListener(this);
//		System.out.println(userControlPad.ipInputted.getText());
		jpanel.host = userControlPad.ipInputted.getText();
		
		String path0 = "icon.png";
        ImageIcon icon = new ImageIcon(path0);
        setIconImage(icon.getImage());
		
		centerPanel.add(jpanel, BorderLayout.CENTER);
//		centerPanel.add(userInputPad, BorderLayout.SOUTH);
//		centerPanel.setBackground(Color.LIGHT_GRAY);
		userControlPad.connectButton.addActionListener(this);
		userControlPad.createButton.addActionListener(this);
		userControlPad.joinButton.addActionListener(this);
		userControlPad.cancelButton.addActionListener(this);
		userControlPad.exitButton.addActionListener(this);
		userControlPad.createButton.setEnabled(false);
		userControlPad.joinButton.setEnabled(false);
		userControlPad.cancelButton.setEnabled(false);
		
//		southPanel.add(userControlPad, BorderLayout.CENTER);
//		southPanel.setBackground(Color.LIGHT_GRAY);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if (isOnChat)
<<<<<<< HEAD
				{ // 鑱婂ぉ涓�
					try
					{  // 鍏抽棴瀹㈡埛绔鎺ュ彛
=======
				{ // chatting
					try
					{  // close client socket
>>>>>>> origin/master
						clientSocket.close();
					}
					catch (Exception ed){}
				}
				if (isOnChess || isGameConnected)
<<<<<<< HEAD
				{ // 涓嬫涓�
					try
					{   // 鍏抽棴涓嬫绔彛
=======
				{ //move
					try
					{   // close
>>>>>>> origin/master
						jpanel.chessSocket.close();
					}
					catch (Exception ee){}
				}
				System.exit(0);
			}
		});

		add(eastPanel, BorderLayout.EAST);
		add(centerPanel, BorderLayout.CENTER);
//		add(southPanel, BorderLayout.SOUTH);
		repaint();

		this.setTitle("INTERNETIONAL CHESS");
		//acquire the size of screen.
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		this.setBounds((width - 900) / 2,
	            (height - 780) / 2, 900, 780);
		
		jpanel=new ChessBoard2();
		this.add(jpanel);
		this.setVisible(true);
		// fix the size first
		this.setResizable(false);
		//System out
		this.validate();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

<<<<<<< HEAD
	// 鎸夋寚瀹氱殑IP鍦板潃鍜岀鍙ｈ繛鎺ュ埌鏈嶅姟鍣�
=======
	// special ip and port to the server
>>>>>>> origin/master
	public boolean connectToServer(String serverIP, int serverPort) throws Exception
	{
		try
		{
<<<<<<< HEAD
			// 鍒涘缓瀹㈡埛绔鎺ュ彛
			clientSocket = new Socket(serverIP, serverPort);
			// 鍒涘缓杈撳叆娴�
			inputStream = new DataInputStream(clientSocket.getInputStream());
			// 鍒涘缓杈撳嚭娴�
			outputStream = new DataOutputStream(clientSocket.getOutputStream());
			// 鍒涘缓瀹㈡埛绔嚎绋�
			ClientThread clientthread = new ClientThread(this);
			// 鍚姩绾跨▼锛岀瓑寰呰亰澶╀俊鎭�
=======
			// create client socket
			clientSocket = new Socket(serverIP, serverPort);
			// create input stream
			inputStream = new DataInputStream(clientSocket.getInputStream());
			// create output stream
			outputStream = new DataOutputStream(clientSocket.getOutputStream());
			// create client thread
			ClientThread clientthread = new ClientThread(this);
			// start thread
>>>>>>> origin/master
			clientthread.start();
			isOnChat = true;
			return true;
		}
		catch (IOException ex)
		{
<<<<<<< HEAD
			this.userControlPad.tipsField.setText("Connection Disabled!\n");
=======
			this.userControlPad.tipsField.setText("can not connect!\n");
>>>>>>> origin/master
		}
		return false;
	}

<<<<<<< HEAD
	// 瀹㈡埛绔簨浠跺鐞�
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == userControlPad.connectButton)
		{ // 杩炴帴鍒颁富鏈烘寜閽崟鍑讳簨浠�
			host = jpanel.host = userControlPad.ipInputted.getText(); // 鍙栧緱涓绘満鍦板潃
			try
			{
				if (connectToServer(host, port))
				{   // 鎴愬姛杩炴帴鍒颁富鏈烘椂锛岃缃鎴风鐩稿簲鐨勭晫闈㈢姸鎬�
=======
	// process the event of client
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == userControlPad.connectButton)
		{ // connect the host
			host = jpanel.host = userControlPad.ipInputted.getText(); // get ip of host
			try
			{
				if (connectToServer(host, port))
				{   
>>>>>>> origin/master
					userChatPad.chatTextArea.setText("");
					userControlPad.connectButton.setEnabled(false);
					userControlPad.createButton.setEnabled(true);
					userControlPad.joinButton.setEnabled(true);
<<<<<<< HEAD
					this.userControlPad.tipsField.setText("Connect success, please wait.");
=======
					this.userControlPad.tipsField.setText("connect success!");
>>>>>>> origin/master
				}
			}
			catch (Exception ei)
			{
<<<<<<< HEAD
				this.userControlPad.tipsField.setText("Connection disabled!\n");
			}
		}
		if (e.getSource() == userControlPad.exitButton)
		{ // 绂诲紑娓告垙鎸夐挳鍗曞嚮浜嬩欢
			if (isOnChat)
			{  // 鑻ョ敤鎴峰浜庤亰澶╃姸鎬佷腑
				try
				{ // 鍏抽棴瀹㈡埛绔鎺ュ彛
=======
				this.userControlPad.tipsField.setText("can't connect!\n");
			}
		}
		if (e.getSource() == userControlPad.exitButton)
		{ // exit the game
			if (isOnChat)
			{  // chatting
				try
				{ // close client socket
>>>>>>> origin/master
					clientSocket.close();
				}
				catch (Exception ed){}
			}
			if (isOnChess || isGameConnected)
<<<<<<< HEAD
			{ // 鑻ョ敤鎴峰浜庢父鎴忕姸鎬佷腑
				try
				{ // 鍏抽棴娓告垙绔彛
=======
			{ 
				try
				{ // close the port
>>>>>>> origin/master
					jpanel.chessSocket.close();
				}
				catch (Exception ee){}
			}
			System.exit(0);
		}
		if (e.getSource() == userControlPad.joinButton)
<<<<<<< HEAD
		{ // 鍔犲叆娓告垙鎸夐挳鍗曞嚮浜嬩欢
			String selectedUser = (String)userListPad.userList.getSelectedItem(); // 鍙栧緱瑕佸姞鍏ョ殑娓告垙
			if (selectedUser == null || selectedUser.startsWith("[inchess]") ||
					selectedUser.equals(chessClientName))
			{ // 鑻ユ湭閫変腑瑕佸姞鍏ョ殑鐢ㄦ埛锛屾垨閫変腑鐨勭敤鎴峰凡缁忓湪娓告垙锛屽垯缁欏嚭鎻愮ず淇℃伅
				this.userControlPad.tipsField.setText("Choose a user!");
			}
			else
			{ // 鎵ц鍔犲叆娓告垙鐨勬搷浣�
				try
				{
					if (!isGameConnected)
					{ // 鑻ユ父鎴忓鎺ュ彛鏈繛鎺�
						if (jpanel.connectServer(jpanel.host, jpanel.port))
						{ // 鑻ヨ繛鎺ュ埌涓绘満鎴愬姛
=======
		{ 
			String selectedUser = (String)userListPad.userList.getSelectedItem(); // get the game that want to join
			if (selectedUser == null || selectedUser.startsWith("[inchess]") ||
					selectedUser.equals(chessClientName))
			{ 
				this.userControlPad.tipsField.setText("必须选择一个用户!");
			}
			else
			{ // join the game
				try
				{
					if (!isGameConnected)
					{ // if the socket can not connect
						if (jpanel.connectServer(jpanel.host, jpanel.port))
						{ // if connect the host succsessfully
>>>>>>> origin/master
							isGameConnected = true;
							isOnChess = true;
							isParticipant = true;
							userControlPad.createButton.setEnabled(false);
							userControlPad.joinButton.setEnabled(false);
							userControlPad.cancelButton.setEnabled(true);
							jpanel.firThread.sendMessage("/joingame "
									+ (String)userListPad.userList.getSelectedItem() + " "
									+ chessClientName);
							System.out.println("connected2");
						}
					}
					else
<<<<<<< HEAD
					{ // 鑻ユ父鎴忕鍙ｈ繛鎺ヤ腑
=======
					{ // if the port is connecting
>>>>>>> origin/master
						isOnChess = true;
						isParticipant = true;
						userControlPad.createButton.setEnabled(false);
						userControlPad.joinButton.setEnabled(false);
						userControlPad.cancelButton.setEnabled(true);
						jpanel.firThread.sendMessage("/joingame "
								+ (String)userListPad.userList.getSelectedItem() + " "
								+ chessClientName);
					}
				}
				catch (Exception ee)
				{
					isGameConnected = false;
					isOnChess = false;
					isParticipant = false;
					userControlPad.createButton.setEnabled(true);
					userControlPad.joinButton.setEnabled(true);
					userControlPad.cancelButton.setEnabled(false);
<<<<<<< HEAD
					this.userControlPad.tipsField.setText("Connection disabled: \n" + ee);
=======
					this.userControlPad.tipsField.setText("can't connect: \n" + ee);
>>>>>>> origin/master
				}
			}
		}
		if (e.getSource() == userControlPad.createButton)
<<<<<<< HEAD
		{ // 鍒涘缓娓告垙鎸夐挳鍗曞嚮浜嬩欢
			try
			{
				if (!isGameConnected)
				{ // 鑻ユ父鎴忕鍙ｆ湭杩炴帴
					if (jpanel.connectServer(jpanel.host, jpanel.port))
					{ // 鑻ヨ繛鎺ュ埌涓绘満鎴愬姛
=======
		{ // create button hit event
			try
			{
				if (!isGameConnected)
				{ 
					if (jpanel.connectServer(jpanel.host, jpanel.port))
					{ // if the game connect the host successfully
>>>>>>> origin/master
						isGameConnected = true;
						isOnChess = true;
						isCreator = true;
						userControlPad.createButton.setEnabled(false);
						userControlPad.joinButton.setEnabled(false);
						userControlPad.cancelButton.setEnabled(true);
						jpanel.firThread.sendMessage("/creatgame "
								+ "[inchess]" + chessClientName);
					}
				}
				else
<<<<<<< HEAD
				{ // 鑻ユ父鎴忕鍙ｈ繛鎺ヤ腑
=======
				{ // if the port is connecting
>>>>>>> origin/master
					isOnChess = true;
					isCreator = true;
					userControlPad.createButton.setEnabled(false);
					userControlPad.joinButton.setEnabled(false);
					userControlPad.cancelButton.setEnabled(true);
					jpanel.firThread.sendMessage("/creatgame "
							+ "[inchess]" + chessClientName);
				}
			}
			catch (Exception ec)
			{
				isGameConnected = false;
				isOnChess = false;
				isCreator = false;
				userControlPad.createButton.setEnabled(true);
				userControlPad.joinButton.setEnabled(true);
				userControlPad.cancelButton.setEnabled(false);
				ec.printStackTrace();
<<<<<<< HEAD
				this.userControlPad.tipsField.setText("Connection disabled: \n"
=======
				this.userControlPad.tipsField.setText("can't connect: \n"
>>>>>>> origin/master
						+ ec);
			}
		}
		if (e.getSource() == userControlPad.cancelButton)
<<<<<<< HEAD
		{ // 閫�鍑烘父鎴忔寜閽崟鍑讳簨浠�
			if (isOnChess)
			{ // 娓告垙涓�
=======
		{ 
			if (isOnChess)
			{ // gaming
>>>>>>> origin/master
				jpanel.firThread.sendMessage("/giveup " + chessClientName);
//				jpanel.setVicStatus(-1 * jpanel.chessColor);
				userControlPad.createButton.setEnabled(true);
				userControlPad.joinButton.setEnabled(true);
				userControlPad.cancelButton.setEnabled(false);
<<<<<<< HEAD
				this.userControlPad.tipsField.setText("Please create or join a game!");
			}
			if (!isOnChess)
			{ // 闈炴父鎴忎腑
				userControlPad.createButton.setEnabled(true);
				userControlPad.joinButton.setEnabled(true);
				userControlPad.cancelButton.setEnabled(false);
				this.userControlPad.tipsField.setText("Please create or join a game!");
=======
				this.userControlPad.tipsField.setText("create or join !");
			}
			if (!isOnChess)
			{ // not gaming
				userControlPad.createButton.setEnabled(true);
				userControlPad.joinButton.setEnabled(true);
				userControlPad.cancelButton.setEnabled(false);
				this.userControlPad.tipsField.setText("create or join!");
>>>>>>> origin/master
			}
			isParticipant = isCreator = false;
		}
	}

	public void keyPressed(KeyEvent e)
	{
		TextField inputwords = (TextField) e.getSource();
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
<<<<<<< HEAD
		{ // 澶勭悊鍥炶溅鎸夐敭浜嬩欢
			if (userInputPad.userChoice.getSelectedItem().equals("All User"))
			{ // 缁欐墍鏈変汉鍙戜俊鎭�
				try
				{
					// 鍙戦�佷俊鎭�
=======
		{ 
			if (userInputPad.userChoice.getSelectedItem().equals("all users"))
			{ 
				try
				{
					// send message
>>>>>>> origin/master
					outputStream.writeUTF(inputwords.getText());
					inputwords.setText("");
				}
				catch (Exception ea)
				{
<<<<<<< HEAD
					this.userControlPad.tipsField.setText("Cannot connect to the server.\n");
=======
					this.userControlPad.tipsField.setText("can't connect to server!\n");
>>>>>>> origin/master
					userListPad.userList.removeAll();
					userInputPad.userChoice.removeAll();
					inputwords.setText("");
					userControlPad.connectButton.setEnabled(true);
				}
			}
			else
<<<<<<< HEAD
			{ // 缁欐寚瀹氫汉鍙戜俊鎭�
=======
			{ // send message
>>>>>>> origin/master
				try
				{
					outputStream.writeUTF("/" + userInputPad.userChoice.getSelectedItem()
							+ " " + inputwords.getText());
					inputwords.setText("");
				}
				catch (Exception ea)
				{
<<<<<<< HEAD
					this.userControlPad.tipsField.setText("Cannot connect to the server.\n");
=======
					this.userControlPad.tipsField.setText("can't connect to server!\n");
>>>>>>> origin/master
					userListPad.userList.removeAll();
					userInputPad.userChoice.removeAll();
					inputwords.setText("");
					userControlPad.connectButton.setEnabled(true);
				}
			}
		}
	}

	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public static void main(String[] args) {
		new MainClient();
	}

}
