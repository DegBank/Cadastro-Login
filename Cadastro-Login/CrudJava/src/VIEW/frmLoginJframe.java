package VIEW;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import javax.swing.JPasswordField;


public class frmLoginJframe extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JPasswordField txtSenhaUsuario;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginJframe frame = new frmLoginJframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmLoginJframe() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtUsuario = new JLabel("Nome de Usuário");
		txtUsuario.setBounds(59, 24, 204, 15);
		contentPane.add(txtUsuario);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(59, 62, 248, 19);
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		JLabel txtSenha = new JLabel("Senha");
		txtSenha.setBounds(59, 113, 70, 15);
		contentPane.add(txtSenha);
		
		
		JButton bntLogin = new JButton("Login");
		bntLogin.addActionListener(new ActionListener() {
			//Ação do Botão
			public void actionPerformed(ActionEvent arg0) {
				Logar();
				
			}
		});
		
		bntLogin.setBounds(157, 204, 117, 25);
		contentPane.add(bntLogin);
		
		txtSenhaUsuario = new JPasswordField();
		txtSenhaUsuario.setBounds(59, 140, 248, 19);
		contentPane.add(txtSenhaUsuario);
	}
	
	private void Logar() {
		try {
			
			String nome_usuario, senha_usuario;
			
			nome_usuario = txtNomeUsuario.getText();
			senha_usuario = txtSenhaUsuario.getText();
			
			UsuarioDTO objusuariodto = new UsuarioDTO();
			
			objusuariodto.setNome_usuario(nome_usuario);
			objusuariodto.setSenha_usuario(senha_usuario);
			
			UsuarioDAO objusuariodao = new UsuarioDAO();
			
			ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objusuariodto);
			
			if (rsusuariodao.next()) {
				
				frmPrincipal objfrmPrincipal = new frmPrincipal();
				objfrmPrincipal.setVisible(true);
				
				dispose();
			}else {
				
				JOptionPane.showMessageDialog(null, "Usuario ou Senha Inválidos");
			}
			
		} catch (SQLException erro) {
			
			JOptionPane.showMessageDialog(null, "FRMloginview" + erro.getMessage());
			
		}
	}
}
