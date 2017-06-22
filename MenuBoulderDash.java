import java.awt.event.*;
import javax.swing.*;


public class MenuBoulderDash extends JFrame{
	
	JPanel Panel = new JPanel();
	JButton PlayButton = new JButton ("Play");
	JButton ExitButton = new JButton("Exit");
	JButton SettingsButton = new JButton("Settings");
	
	public MenuBoulderDash(){
		this.setSize(1000, 570);
		this.setLocationRelativeTo(null);
		Panel.setLayout(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setContentPane(Panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		PlayButton.setBounds(0, 500, 333, 30);
		SettingsButton.setBounds(333, 500, 333, 30);
		ExitButton.setBounds(666, 500, 333, 30);
	
		JLabel image = new JLabel();
		image.setIcon(new ImageIcon("MenuBoulderDash.jpg"));
		image.setBounds(0, 0, 1000, 500);
		
		Panel.add(image);
		Panel.add(PlayButton);
		Panel.add(ExitButton);
		Panel.add(SettingsButton);
		
		/*
		
		PlayButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

               Rentrer ici la fonction;
            }

        });
		
		
		SettingsButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            	Rentrez ici la fonction
            }

        });
        
		*/
		
		ExitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }

        });

		
		
		this.repaint();
	}

	public static void main(String[] args) {
		new MenuBoulderDash();
		
	}

}
