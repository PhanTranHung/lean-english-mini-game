package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;



public class adddata extends JFrame {

	private JPanel contentPane;
	private Timer timer;
	JProgressBar progressBar;
	Connection conn;
	Statement stmt = null;
	JTextArea txtrCompelete;
	
	public adddata(Connection conn) throws SQLException 
	{
		this.conn = conn;
		stmt = conn.createStatement();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImage = new JLabel("image");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(20, 84, 79, 84);
		contentPane.add(lblImage);

		ImageIcon icon = new ImageIcon("ahihi.png");
		lblImage.setIcon(icon);

		JLabel lblThongbao = new JLabel("Bạn chưa có dữ liệu, cần nạp dữ liệu để chơi game!");
		lblThongbao.setBounds(10, 11, 414, 23);
		contentPane.add(lblThongbao);
		
		JButton btnNap = new JButton("Nạp");
		btnNap.setBounds(10, 180, 95, 32);
		contentPane.add(btnNap);
		btnNap.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				progressBar.setStringPainted(true);
				timer = new Timer(100, new progress());
				timer.start();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 73, 303, 139);
		contentPane.add(scrollPane);
		
		txtrCompelete = new JTextArea();
		scrollPane.setViewportView(txtrCompelete);
		
		progressBar = new JProgressBar();
		progressBar.setString("Ckờ đợj nà hạnk púk <3 <3");
		progressBar.setForeground(Color.RED);
		progressBar.setBounds(10, 39, 414, 23);
		contentPane.add(progressBar);
		
	}
	
	public void createchema() throws SQLException
	{		
		String schema = "CREATE SCHEMA `minigame` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;";
		stmt.executeUpdate(schema);
	}
	
	public void createtable() throws SQLException
	{
		String table1 = "CREATE TABLE `minigame`.`data` (\r\n"  
				+ "  `Stt` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `Vietnamese` VARCHAR(45) NOT NULL,\r\n"
				+ "  `English` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,\r\n"
				+ "  PRIMARY KEY (`Stt`, `English`))\r\n"
				+ "ENGINE = InnoDB\r\n"
				+ "DEFAULT CHARACTER SET = utf8\r\n"
				+ "COLLATE = utf8_unicode_ci;\r\n";	
		
		String table2 =  "CREATE TABLE `minigame`.`gamer` (\r\n"
				+ "  `id` INT NOT NULL AUTO_INCREMENT,\r\n" 
				+ "  `user` VARCHAR(45) NOT NULL,\r\n"
				+ "  `Point` VARCHAR(45) NOT NULL,\r\n"
				+ "  PRIMARY KEY (`id`))\r\n"
				+ "ENGINE = InnoDB\r\n"
				+ "DEFAULT CHARACTER SET = utf8\r\n"
				+ "COLLATE = utf8_unicode_ci;\r\n";
				

		stmt.executeUpdate(table1);	
		stmt.executeUpdate(table2);
	}
		
	public void data() throws SQLException
	{
		String[]data = new String[21];
		data[0]	 = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Gọt bút chì', 'Sharpener');";
		data[1]	 = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Lửa trại', 'Campfire');";
		data[2]	 = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Thực hành', 'Practice');";
		data[3]	 = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Môn Địa lí', 'Geography');";
		data[4]	 = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Học', 'Learn');";
		data[5]	 = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Môn Hóa học', 'Chemistry');";
		data[6]	 = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Đào tạo chính quy', 'Regular Full-Tim');";
		data[7]	 = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Giáo viên', 'Teacher');";
		data[8]	 = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Môn Kinh tế vĩ mô', 'Macroeconomics');";
		data[9]	 = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Sinh viên', 'Student');";
		data[10] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Làm việc nhóm', 'Teamwork');";
		data[11] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Thi tự luận', 'Subjective Test');";
		data[12] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Văn học', 'Literature');";
		data[13] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Nhảy', 'Dance');";
		data[14] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Bản đồ', 'Map');";
		data[15] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Trình bày', 'Perform');";
		data[16] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Máy tính', 'Computer');";
		data[17] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Môn Sinh học', 'Biology');";
		data[18] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Môn Toán', 'Mathematics');";
		data[19] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Thi trắc nghiệm', 'Objective Test');";
		data[20] = "INSERT INTO `minigame`.`data` (`Vietnamese`, `English`) VALUES ('Giờ giải lao', 'Break Time');";
		
		for(int i = 0; i<21; i++)
		{
			stmt.executeUpdate(data[i]);
		}
		
	}
	
	private class progress implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			int val = progressBar.getValue();
			try 
			{
				if (val == 10)
					createchema();
				else if (val == 30)
					createtable();
				else if (val == 65)
					data();
				else if (val >= 100)
				{
					timer.stop();
					
					Minigame frame = new Minigame(conn);
					frame.setVisible(true);
					setVisible(false);
					
					return;
				}
			}
			catch (SQLException e)
			{
				System.out.println("Lỗi: " + e.getMessage());
			}
			
			progressBar.setValue(++val);
			
            txtrCompelete.setText(txtrCompelete.getText() + String.format("Completed %d%% of task.\n", val));
		}
		
	}
}
