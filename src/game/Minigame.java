package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

public class Minigame extends JFrame {

	private int level = 1, index = 0, gioihanrd = 21;
	private String[] koten = new String[4];
	private Timer time;
	private String Cauhoi;
	private Random rd = new Random();
	int []A = new int[15];
//	int index = 3;
	
	JPanel panell;
	JButton btnPlay;
	JLabel lblGameover;
	JLabel lblIco;
	
	JPanel panel;
	JLabel lblLevel;
	JButton btnA;
	JButton btnB;
	JButton btnC;
	JButton btnD;
	JLabel lblTieude;
	JProgressBar progressBar;
	Timer timee ;
	
	JLayeredPane layeredPane;
	JLabel lblGioiThieu;
	JButton btnDaHieu;
	private JTextPane txtpnHuongdan;
	private JLabel lblanh1;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel(0,2);
	
	
	public Minigame(Connection conn) 
	{
		
//		String sql = "SELECT * FROM minigame.data WHERE Vietnamese = ? AND English = ?;";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 560);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panell = new JPanel();
		panell.setBorder(null);
		panell.setBounds(0, 0, 371, 521);
		contentPane.add(panell);
		panell.setLayout(null);
		panell.setEnabled(false);
		panell.hide();
		
		btnPlay = new JButton("Bắt đầu ");
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlay.setBounds(107, 430, 139, 37);
		panell.add(btnPlay);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					rdmang(A, 15);
					lblGameover.setText("LOSS");
					time = new Timer(40, new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int val = progressBar.getValue();
									
							if (val <= 0)
							{
								time.stop();
								
								int x = rd.nextInt(2);
								btnPlay.setText("Chơi lại");
								
								
								panel.setEnabled(false);
								panel.hide();
								
								panell.setEnabled(true);
								panell.show();
								
								return;
							}
							progressBar.setValue(--val);
						}
					});

					level = 0; index = 100;
					panell.setEnabled(false);
					panell.hide();
					
					panel.setEnabled(true);
					panel.show();
					khoitao(conn);
					
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		lblGameover = new JLabel("😎😎😎😎😂😎😎😎😎");
		lblGameover.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblGameover.setForeground(Color.RED);
		lblGameover.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameover.setBounds(0, 23, 371, 75);
		panell.add(lblGameover);
		
		lblIco = new JLabel("ico");
		lblIco.setHorizontalAlignment(SwingConstants.CENTER);
		lblIco.setBounds(20, 98, 331, 321);
		panell.add(lblIco);
		lblIco.setIcon(new ImageIcon("please.png"));
		
		panel = new JPanel();
		panel.setBounds(0, 0, 371, 521);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setEnabled(false);
		panel.hide();
		
		table = new JTable();
		table.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 51, 102)));
		table.setBackground(new Color(255, 255, 153));
		table.setBounds(20, 94, 329, 342);
		panel.add(table);
		table.hide();
		
		lblLevel = new JLabel("Level. " + level);
		lblLevel.setBounds(301, 11, 60, 14);
		panel.add(lblLevel);
		
		btnA = new JButton("A. " + koten[0]);
		btnA.setBounds(10, 371, 163, 43);
		panel.add(btnA);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					ResultSet rs = truyvan("SELECT * FROM minigame.data WHERE Vietnamese = '" + koten[0] + "' AND English = '" + Cauhoi + "';", conn);

					if (rs.next())
					{
						khoitao(conn);	
						progressBar.setValue(100);
					}
					else 
						progressBar.setValue(0);
					
				}
				catch (Exception e) 
				{
					System.out.println("Lỗi : " + e.getMessage());
				}
			}
		});
		
		
		btnB = new JButton("B. " + koten[1]);
		btnB.setBounds(198, 371, 163, 43);
		panel.add(btnB);
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					ResultSet rs = truyvan("SELECT * FROM minigame.data WHERE Vietnamese = '" + koten[1] + "' AND English = '" + Cauhoi + "';", conn);
					
					if (rs.next())
					{
						khoitao(conn);	
						progressBar.setValue(100);
					}
					else 
						progressBar.setValue(0);
					
				}
				catch (Exception e) 
				{
					System.out.println("Lỗi : " + e.getMessage());
				}

			}
		});
		
		
		btnC = new JButton("C. " + koten[2]);
		btnC.setBounds(10, 434, 163, 43);
		panel.add(btnC);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					ResultSet rs = truyvan("SELECT * FROM minigame.data WHERE Vietnamese = '" + koten[2] + "' AND English = '" + Cauhoi + "';", conn);
					
					if (rs.next())
					{
						khoitao(conn);
						progressBar.setValue(100);
					}
					else
						progressBar.setValue(0);
										
				}
				catch (Exception e) 
				{
					System.out.println("Lỗi : " + e.getMessage());
				}

				
			}
		});
		
		
		btnD = new JButton("D. " + koten[3]);
		btnD.setBounds(198, 434, 163, 43);
		panel.add(btnD);
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					ResultSet rs = truyvan("SELECT * FROM minigame.data WHERE Vietnamese = '" + koten[3] + "' AND English = '" + Cauhoi + "';", conn);
					
					if (rs.next())
					{
						khoitao(conn);	
						progressBar.setValue(100);
					}
					else 
						progressBar.setValue(0);
					
				}
				catch (Exception e) 
				{
					System.out.println("Lỗi : " + e.getMessage());
				}

			}
		});
		
		
		lblTieude = new JLabel("");
		lblTieude.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblTieude.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieude.setBounds(20, 51, 329, 309);
		panel.add(lblTieude);
		
		progressBar = new JProgressBar(0, 100);
		progressBar.setForeground(Color.BLUE);
		progressBar.setBounds(10, 25, 351, 14);
		panel.add(progressBar);
		
		JLabel lblAnh = new JLabel("anh");
		lblAnh.setBounds(0, 0, 371, 521);
		panel.add(lblAnh);
		lblAnh.setIcon(new ImageIcon("back.jpg"));
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 371, 521);
		contentPane.add(layeredPane);
		layeredPane.setEnabled(true);
		
		
		lblGioiThieu = new JLabel("Hướng dẫn");
		lblGioiThieu.setBounds(10, 11, 331, 41);
		layeredPane.add(lblGioiThieu);
		lblGioiThieu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblGioiThieu.setHorizontalAlignment(SwingConstants.CENTER);
		
				
		btnDaHieu = new JButton("Đã hiểu");
		btnDaHieu.setBackground(new Color(102, 255, 255));
		btnDaHieu.setBounds(123, 420, 102, 23);
		layeredPane.add(btnDaHieu);
		btnDaHieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panell.setEnabled(true);
				panell.show();
				
				layeredPane.setEnabled(false);
				layeredPane.hide();
			}
		});
		
		txtpnHuongdan = new JTextPane();
		txtpnHuongdan.setBackground(SystemColor.window);
		txtpnHuongdan.setForeground(new Color(30, 144, 255));
		txtpnHuongdan.setBounds(33, 123, 304, 221);
		layeredPane.add(txtpnHuongdan);
		txtpnHuongdan.setEditable(false);
		txtpnHuongdan.setText("Với lối chơi khá đơn giản."
							+ " Ở mỗi cấp độ, trò chơi sẽ hiển thị 1 bảng gồm những từ vựng tiếng Anh và những từ tiếng Việt tương ứng."
							+ " Việc của bạn là ghi nhớ chúng trong một khoảng thời gian nhất định và bắt đầu trả lời câu hỏi, với mỗi câu hỏi bạn sẽ có 4 giây để trả lời."
							+ " Nếu hết thời gian bạn vẫn chưa trả lời xong hoặc trả lời sai thì trò chơi sẽ kết thúc. Hoàn thành 10 cấp độ thì bạn sẽ chiến thắng."
							+ "\r\n\r\n\r\nTừ vựng được sử dụng trong trò chơi được lấy từ internet nên việc sai xót là khó tránh khỏi."
							+ " Nếu có sai xót vui lòng báo cáo với QTV.");
		
		lblanh1 = new JLabel();
		lblanh1.setBackground(SystemColor.window);
		lblanh1.setBounds(0, 0, 371, 521);
		layeredPane.add(lblanh1);
		lblanh1.setIcon(new ImageIcon("back1.png"));
	}
	
	public void khoitao(Connection conn) throws SQLException
	{
		
		if(index > level + 1)
		{
			time.stop();
			index = 0;
			level++;
			if (level >=16)
			{
				JOptionPane.showConfirmDialog(lblGameover, "Chúc mừng, đã hoàn thành trò chơi!!");
				progressBar.setValue(0);
			}
			rdmang(A, 15);
			for (int i = 0; i <= level + 1; i++)
			{
				ResultSet rs = truyvan("SELECT * FROM minigame.data WHERE Stt = " + A[i] + ";", conn);
				while (rs.next())
				{
					String Vietnamese = rs.getString("Vietnamese");
					String English = rs.getString("English");
					
					Object []row = new Object[] {English, Vietnamese};
					model.addRow(row);
				}
				table.setModel(model);
			}
			progressBar.setValue(100);
			table.show();
			timee = new Timer((level +2 )*40, new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0)
				{
					int val = progressBar.getValue();
					if (val <= 0)
					{
						timee.stop();
						table.hide();
						progressBar.setValue(100);
						time.start();
						btnA.show();
						btnB.show();
						btnC.show();
						btnD.show();
						model.setRowCount(0);
						return;
					}
					progressBar.setValue(--val);					
				}
			});
			timee.start();
			btnA.hide();
			btnB.hide();
			btnC.hide();
			btnD.hide();
			
			for (int i =0; i<= level; i++)
				for (int j =0; j<= level +1; j++)
				{
					int x = rd.nextInt(2);
					if (x ==0)
					{
						int a = A[i];
						A[i] = A[j];
						A[j] = a;
					}
//					System.out.print(" " + A[i]);
				}
		}
		lblLevel.setText("Level. " + level);

		try 
		{	
			int abcd = rd.nextInt(4);
			int []x = new int[4];
			rdmang(x, 4);
			
			for (int i = 0; i < 4; i++)
			{
//				kiểm tra xem có 2 đáp án giống nhau trong cùng 1 câu hỏi ko
				if(x[i] == A[index])
				{
					rdmang(x, 4);
					i = 0;
				}
				
				ResultSet rs = truyvan("SELECT * FROM minigame.data WHERE Stt = " + x[i] + ";", conn);
				
				if (rs.next())
					koten[i] = rs.getString("Vietnamese");
			}
			
//			set câu hỏi và đáp án bào vị trí bất kì a,b,c,d
			ResultSet rss = truyvan("SELECT * FROM minigame.data WHERE Stt = " + A[index] + ";", conn);
			if(rss.next())
			{
				koten[abcd] = rss.getString("Vietnamese");
				Cauhoi = rss.getString("English");
			}
		
			index++;
			
		}
		catch (Exception e1) 
		{
			System.out.println("Lỗi: " + e1.getMessage());
			e1.printStackTrace();
		}
		setDA();
		return;
	}
	
	public void rdmang(int []Mang, int spt)
	{
		for (int i =0; i< spt; i++)
		{
			Mang[i] = rd.nextInt(gioihanrd) + 1;
			kiemtra(Mang, i, gioihanrd);
		}	
	}
	
	public void kiemtra(int []A, int i, int gioihan)
	{
		int j = i-1;
		while (j >= 0)
		{
			if (A[i] == A[j])
			{
				A[i] = rd.nextInt(gioihan) + 1;
				j = i;
			}
			j--;
		}
	}
	
	public ResultSet truyvan(String sql, Connection conn)
	{
		ResultSet rss = null;
		try 
		{
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			rss = rs;
		} 
		catch (SQLException e) 
		{
			System.out.println("Lỗi: " + e.getMessage());
		}
		
		return rss;
	}

	public void setDA()
	{
		btnA.setText(koten[0]);
		btnB.setText(koten[1]);
		btnC.setText(koten[2]);
		btnD.setText(koten[3]);
		lblTieude.setText(Cauhoi);
	}

}

