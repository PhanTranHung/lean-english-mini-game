package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Login extends JFrame 
{
	
	
	public Login() 
	{		
		
		JPasswordField tfPassword;
		JTextField tfUsername;
		JButton btnLogIn;
		JLabel lblCanhbao;
		JLabel lblThongbao;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 183);
		setTitle("Đăng nhập MySQL");
		
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setBounds(10, 50, 70, 14);
		contentPane.add(lblUserName);
		
		
		tfUsername = new JTextField();
		tfUsername.setBounds(90, 47, 125, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(225, 50, 61, 14);
		contentPane.add(lblPassword);
		
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(296, 47, 125, 20);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		
		lblThongbao = new JLabel("Vui lòng đăng nhập MySQL để bắt đầu sử dụng");
		lblThongbao.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongbao.setBounds(10, 11, 433, 25);
		contentPane.add(lblThongbao);
		
		
		lblCanhbao = new JLabel();
		lblCanhbao.setHorizontalAlignment(SwingConstants.CENTER);
		lblCanhbao.setBounds(10, 75, 433, 25);
		contentPane.add(lblCanhbao);

		
		btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(182, 111, 89, 23);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (tfUsername.getText().length() == 0 || tfPassword.getText().length() == 0 )
				{
					lblCanhbao.setText("Không được để trống trường Username hoặc Password!");
					return;
				}
				try 
				{
					
					Connection conn = new connectionn().ketnoi(tfUsername.getText(), tfPassword.getText(), "jdbc:mysql://localhost:3306");
					if (conn == null)
					{
						lblCanhbao.setText("Sai tài khoản hoặc mật khẩu, vui lòng thử lại");
						return;
					}
					else
					{
						lblCanhbao.setText("Đăng nhập thành công!");
						Thread.sleep(100);
					}
					
					//Thread.sleep(5000);
					Connection kn = new connectionn().ketnoi(tfUsername.getText(), tfPassword.getText(), "jdbc:mysql://localhost:3306/minigame");
					if (kn == null)
					{
						conn = new connectionn().ketnoi(tfUsername.getText(), tfPassword.getText(), "jdbc:mysql://localhost:3306");
						adddata frame = new adddata(conn);
						frame.setVisible(true);
						setVisible(false);
						return;
					}
					else
					{
						Minigame frame = new Minigame(kn);
						frame.setVisible(true);
						setVisible(false);
					}	
				} 
				catch (Exception e) 
				{
					System.out.print("Lỗi: " + e.getMessage());
				}
				
				
				
			}
		});
	}
}
