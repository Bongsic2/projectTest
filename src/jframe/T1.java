package jframe;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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

import clientChat.gameClient;
import music.MusicInfo;
import view.sounds.MusicBackGround;

public class T1 extends JFrame {
	private static String answer;
	private static BufferedWriter bw = gameClient.getBw();
	private static String readChatting;
	public static JTextArea chatChang;
	private Image SCI;
	private Graphics SCG;
	private Image FinalBackGround = new ImageIcon("../LineNo5_mh/src/view/playBackground.jpg").getImage();
	private JLabel menuB = new JLabel(new ImageIcon("../LineNo5_mh/src/view/menuGUI/MenuBar.png"));
	private ImageIcon exitover = new ImageIcon("../LineNo5_mh/src/view/menuGUI/ExitButtonMouseOver.png");
	private ImageIcon exitBasic = new ImageIcon("../LineNo5_mh/src/view/menuGUI/ExitButton.png");
	private JButton exit = new JButton(exitBasic);
	private int mouseX, mouseY;

	public static MusicBackGround introMusic = new MusicBackGround("/view/sounds/introMusic.mp3", true);
	public static List<String> SongSinger = new ArrayList<String>();
	public static String uri[] = new String[10];
	// private JFrame frame;
	private ArrayList<MusicInfo> list;
	ImageIcon QuitBtn = new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/QuitBtn1.png");
	ImageIcon QuitBtnMouseOver = new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/QuitBtnMouseOver1.png");
	ImageIcon waitingRoomBtn = new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/waitingBtn1.png");
	ImageIcon waitingRoomBtnMouserOver = new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/waintRoomMouse11.png");

	public T1() {

	}

	public T1(ArrayList<MusicInfo> listInfo) {
		this.list = listInfo;
		introMusic.start();
		getList();
		initialize();
	}

	public void getList() {
		for (int i = 0; i < list.size(); i++) {
			SongSinger.add(list.get(i).getSong() + " - " + list.get(i).getSinger());
			uri[i] = list.get(i).getUrl();
		}
	}

	public static void setReadChatting(String readChatting) { // 채팅창이 자꾸 위로 올라가서 사용
		T1.readChatting = readChatting;
	}

	public static String getReadChatting() {
		return readChatting;
	}

	public static String getAnswer() {
		return answer;
	}

	private void initialize() {

		setUndecorated(true); // 기본메뉴바 숨기기
		setBackground(new Color(0, 0, 0, 0)); // paintcomponect 했을때 배경이 회색이 아니라 흰색으로 바뀜
		setSize(1280, 720);
		setResizable(false); // 사이즈 변경불가
		setLocationRelativeTo(null); // 화면 중앙에 뜸
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLayout(null);

		// ----------------대기 버튼
		JButton roomBtn = new JButton(waitingRoomBtn);
		add(roomBtn);
		roomBtn.setBounds(734, 551, 232, 78);
		roomBtn.setBorderPainted(false);
		roomBtn.setContentAreaFilled(false);
		roomBtn.setFocusPainted(false);

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

		// -------------- 종료 버튼
		JButton endBtn = new JButton(QuitBtn);
		add(endBtn);
		endBtn.setBounds(1005, 551, 232, 78);
		endBtn.setBorderPainted(false);
		endBtn.setContentAreaFilled(false);
		endBtn.setFocusPainted(false);

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

		// ---------------- 1등
		JLabel rank1 = new JLabel("1등");
		rank1.setIcon(new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/1remove.png"));
		rank1.setBounds(50, 40, 50, 50);
		add(rank1);

		// ---------------- 2등
		JLabel rank2 = new JLabel("2등");
		rank2.setIcon(new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/2remove.png"));
		rank2.setBounds(50, 100, 50, 50);
		add(rank2);

		// ---------------- 3등
		JLabel rank3 = new JLabel("3등");
		rank3.setIcon(new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/3remove.png"));
		rank3.setBounds(50, 160, 50, 50);
		add(rank3);

		// -----------게임 끝나고 노래 리스트 나오는 창-------------------
		JList jlist = new JList(SongSinger.toArray());
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
						Desktop.getDesktop().browse(new URI(uri[index]));
					} catch (Exception e1) {

						e1.printStackTrace();

					}
				}
			}
		});
		add(jlist);

		exit.setBounds(1245, 0, 30, 30);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setIcon(exitover);
				exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exit.setIcon(exitBasic);
				exit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exit);

		menuB.setBounds(0, 0, 1280, 30);
		menuB.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuB.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); // 메뉴바 이동하게해줌
			}

		});
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(menuB);

		// ------------------- chat창-----------
		chatChang = new JTextArea();
		chatChang.setFont(new Font("굴림", Font.PLAIN, 20));
		chatChang.setEditable(false);
		chatChang.setOpaque(true);
		chatChang.setBackground(new Color(0, 0, 0, 200));
		chatChang.setForeground(new Color(255, 255, 255));
		chatChang.setBounds(55, 290, 580, 345);
		appendChat();

		add(chatChang);
		// --------- 텍스트 필드 ---------------
		JTextField Enter = new JTextField("", 10);
		Enter.setBounds(450, 600, 300, 81);
		Font font = new Font("Courier", Font.BOLD, 25);
		Enter.setFont(font);
		// BigLabel.add(Enter);

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
		add(Enter);
	}

	// 프레임에 이미지 넣는 코드
	public void paint(Graphics g) {
		SCI = createImage(1280, 700);
		SCG = SCI.getGraphics();
		screenDraw(SCG);
		g.drawImage(SCI, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(FinalBackGround, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
	// 여기 까지

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

	public static void main(String[] args) {
		new T1().initialize();
	}
}