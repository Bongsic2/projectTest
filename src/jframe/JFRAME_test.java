package jframe;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clientChat.GameInterface;
import clientChat.gameClient;
import music.MusicInfo;
import view.sounds.MusicBackGround;

public class JFRAME_test extends JFrame{
	private JFrame frame;
	private static String answer;
	private static BufferedWriter bw = gameClient.getBw();
	private static String readChatting;
	public static JTextArea chatChang;
	MusicInfo musicInfo;
	ImageIcon QuitBtn = new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/QuitBtn1.png");
	ImageIcon QuitBtnMouseOver = new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/QuitBtnMouseOver1.png");
	ImageIcon waitingRoomBtn = new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/waitingBtn1.png");
	ImageIcon waitingRoomBtnMouserOver = new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/waintRoomMouse11.png");
	public static MusicBackGround introMusic = new MusicBackGround("/view/sounds/introMusic.mp3", true);
	ArrayList<MusicInfo> list;
	// public static String a[] = new String[10];
	public static String b[] = new String[10];
	// public static ArrayList<String> a = new ArrayList<String>();
	public static List<String> a = new ArrayList<String>();

	public JFRAME_test() {

	}

	public JFRAME_test(ArrayList<MusicInfo> listInfo) {
		this.list = listInfo;
		introMusic.start();
		getList();
		initialize();

		// System.out.println(list.toString());
	}

	public void getList() {
		for (int i = 0; i < list.size(); i++) {
			a.add(list.get(i).getSong() + " - " + list.get(i).getSinger());
			// a[i] = list.get(i).getSong() + " - " + list.get(i).getSinger();
			b[i] = list.get(i).getUrl();

		}
		// cChat();
	}
//
//	public static void setReadChatting(String readChatting) { // 채팅창이 자꾸 위로 올라가서 사용
//		JFRAME.readChatting = readChatting;
//	}

	public String getReadChatting() {
		return readChatting;
	}

	public String getAnswer() {
		return answer;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel BigLabel = new JLabel(" ");
		BigLabel.setIcon(new ImageIcon("../LineNo5_mh/src/view/playBackground.jpg"));
		BigLabel.setBounds(0, 0, 1266, 663);
		frame.getContentPane().add(BigLabel);
		BigLabel.setLayout(null);

		JButton roomBtn = new JButton(waitingRoomBtn);
		BigLabel.add(roomBtn);
		roomBtn.setBounds(734, 551, 232, 78);
		roomBtn.setBorderPainted(false);
		roomBtn.setContentAreaFilled(false);
		roomBtn.setFocusPainted(false);

		JButton endBtn = new JButton(QuitBtn);
		BigLabel.add(endBtn);
		endBtn.setBounds(1005, 551, 232, 78);
		endBtn.setBorderPainted(false);
		endBtn.setContentAreaFilled(false);
		endBtn.setFocusPainted(false);

		JLabel rank1 = new JLabel("1등");
		rank1.setIcon(new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/1remove.png"));
		rank1.setBounds(50, 40, 50, 50);
		BigLabel.add(rank1);

		JLabel rank2 = new JLabel("2등");
		rank2.setIcon(new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/2remove.png"));
		rank2.setBounds(50, 100, 50, 50);
		BigLabel.add(rank2);

		JLabel rank3 = new JLabel("3등");
		rank3.setIcon(new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/3remove.png"));
		rank3.setBounds(50, 160, 50, 50);
		BigLabel.add(rank3);

		// -----------게임 끝나고 노래 리스트 나오는 창-------------------
		JList jlist = new JList(a.toArray());
		jlist.setFont(new Font("굴림", Font.PLAIN, 20));
		jlist.setForeground(Color.white);
		jlist.setOpaque(true);
		jlist.setBackground(new Color(0, 0, 0, 100));

		jlist.setBounds(750, 232, 460, 310);

		jlist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index = jlist.locationToIndex(e.getPoint());
				if (e.getClickCount() == 2) {
					try {
						Desktop.getDesktop().browse(new URI(b[index]));
					} catch (Exception e1) {

						e1.printStackTrace();

					}
				}
			}
		});
		BigLabel.add(jlist);

//		// ------------------- chat창-----------
//		JTextArea chatArea = new JTextArea();
//		chatArea.setFont(new Font("굴림", Font.PLAIN, 20));
//		chatArea.setEditable(false);
//		chatArea.setOpaque(true);
//		chatArea.setBackground(new Color(0,0,0,200));
//		chatArea.setForeground(new Color(255,255,255));
//		chatArea.setBounds(55, 290, 580, 345);
//		appendChat();
//		BigLabel.add(chatArea);

		// ------ 게임 종료 버튼 클릭 ------------------
		endBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				endBtn.setIcon(QuitBtnMouseOver);
				endBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				endBtn.setIcon(QuitBtn);
				endBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		// ----------- 대기 방으로 돌아가는 버튼 ------------------
		roomBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				roomBtn.setIcon(waitingRoomBtnMouserOver);
				roomBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				roomBtn.setIcon(waitingRoomBtn);
				roomBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		// --------- 텍스트 필드 ---------------
		JTextField Enter = new JTextField("", 10);
		Enter.setBounds(450, 600, 300, 81);
		Font font = new Font("Courier", Font.BOLD, 25);
		Enter.setFont(font);
		BigLabel.add(Enter);

		Enter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					getMsg(Enter.getText());
					Enter.setText("");
					Enter.requestFocus();
				}
			}
		});

		BigLabel.add(Enter);

		// ------------------- chat창-----------
		chatChang = new JTextArea();
		chatChang.setFont(new Font("굴림", Font.PLAIN, 20));
		chatChang.setEditable(false);
		chatChang.setOpaque(true);
		chatChang.setBackground(new Color(0, 0, 0, 200));
		chatChang.setForeground(new Color(255, 255, 255));
		chatChang.setBounds(55, 290, 580, 345);
		appendChat();

	}

	public static void appendChat() {
		chatChang.append(readChatting + "\n");
	}

	public static void getMsg(String msg) {
		answer = msg;

		try {
			bw.write(msg + " " + "\n");
			bw.flush();
		} catch (Exception e) {
			if (bw != null) {
				try {
					bw.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}

}
