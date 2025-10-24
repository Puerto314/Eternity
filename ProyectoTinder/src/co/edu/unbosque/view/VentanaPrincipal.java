package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

	private JButton botonPerfil;
	private JButton botonChat;
	private JButton botonLike;
	private JButton botonCerrarSesion;
	private ImageIcon imagenFondo;
	private Image ajustar;
	private JLabel fondo;

	public VentanaPrincipal() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {

		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(10, 10, 800, 400);
		this.setTitle("Eternity");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		imagenFondo = new ImageIcon(getClass().getResource("/VentanaPrincipal.png"));
		ajustar = imagenFondo.getImage();
		fondo = new JLabel(new ImageIcon(ajustar));
		fondo.setBounds(0, 0, 800, 400);
		this.setContentPane(fondo);
		fondo.setLayout(null);

		botonPerfil = new JButton("Perfil");
		botonPerfil.setFont(new Font("Gotham Rounded", Font.BOLD, 12));
		botonPerfil.setBounds(571, 286, 74, 25);
		botonPerfil.setContentAreaFilled(false);
		botonPerfil.setFocusPainted(false);
		botonPerfil.setOpaque(false);
		botonPerfil.setBorderPainted(false);
		fondo.add(botonPerfil);

		botonChat = new JButton("Chat");
		botonChat.setFont(new Font("Gotham Rounded", Font.BOLD, 12));
		botonChat.setBounds(415, 286, 70, 25);
		botonChat.setContentAreaFilled(false);
		botonChat.setFocusPainted(false);
		botonChat.setOpaque(false);
		botonChat.setBorderPainted(false);
		fondo.add(botonChat);

		botonLike = new JButton("Buscar");
		botonLike.setFont(new Font("Gotham Rounded", Font.BOLD, 11));
		botonLike.setBounds(256, 286, 73, 25);
		botonLike.setContentAreaFilled(false);
		botonLike.setFocusPainted(false);
		botonLike.setOpaque(false);
		botonLike.setBorderPainted(false);
		fondo.add(botonLike);

		botonCerrarSesion = new JButton("Cerrar");
		botonCerrarSesion.setFont(new Font("Gotham Rounded", Font.BOLD, 11));
		botonCerrarSesion.setBounds(40, 287, 80, 48);
		botonCerrarSesion.setContentAreaFilled(false);
		botonCerrarSesion.setFocusPainted(false);
		botonCerrarSesion.setOpaque(false);
		botonCerrarSesion.setBorderPainted(false);
		fondo.add(botonCerrarSesion);

	}

	public JButton getBotonPerfil() {
		return botonPerfil;
	}

	public void setBotonPerfil(JButton botonPerfil) {
		this.botonPerfil = botonPerfil;
	}

	public JButton getBotonChat() {
		return botonChat;
	}

	public void setBotonChat(JButton botonChat) {
		this.botonChat = botonChat;
	}

	public JButton getBotonLike() {
		return botonLike;
	}

	public void setBotonLike(JButton botonLike) {
		this.botonLike = botonLike;
	}

	public JButton getBotonCerrarSesion() {
		return botonCerrarSesion;
	}

	public void setBotonCerrarSesion(JButton botonCerrarSesion) {
		this.botonCerrarSesion = botonCerrarSesion;
	}

	public ImageIcon getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(ImageIcon imagenFondo) {
		this.imagenFondo = imagenFondo;
	}

	public Image getAjustar() {
		return ajustar;
	}

	public void setAjustar(Image ajustar) {
		this.ajustar = ajustar;
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

}
