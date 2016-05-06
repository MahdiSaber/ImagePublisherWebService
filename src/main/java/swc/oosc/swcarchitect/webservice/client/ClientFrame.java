package swc.oosc.swcarchitect.webservice.client;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import javax.json.Json;
import javax.json.JsonObject;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.format.InputAccessor;

public class ClientFrame extends JFrame {
	
	//private final JLabel lbl_name;
	private final JLabel lbl_state;
	private final JCheckBox btn_state;
	private final JButton btn_file_open;
	private final JTextArea tx_file_name; 
	private final JButton btn_send;
//	private final JButton btn_state_check;
	
	private final JPanel top_panel;
	private final JPanel down_panel;
	private final JFileChooser chooser;
	
	int returnVal=-1;
	
	public ClientFrame()
	{
		super("Client to Call the WebService");
		
		chooser = new JFileChooser();
		
		top_panel = new JPanel();
		lbl_state = new JLabel("Approved: ");
		btn_state = new JCheckBox();
		btn_state.addActionListener(new StateHandler());
		top_panel.add(lbl_state);
		top_panel.add(btn_state);	
		top_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.getContentPane().add(top_panel, BorderLayout.NORTH);
		
		tx_file_name = new JTextArea("Here, you will see the final JSON before and after sending!");
		this.getContentPane().add(tx_file_name, BorderLayout.CENTER);
		
		down_panel = new JPanel();
		down_panel.setSize(600,200);
		down_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		btn_file_open = new JButton("File Chooser ...");
		btn_file_open.addActionListener(new OpenHandler());
		btn_send = new JButton("Send!");
		btn_send.addActionListener(new SendHandler());
		down_panel.add(btn_file_open);
		down_panel.add(btn_send);

		this.getContentPane().add(down_panel, BorderLayout.SOUTH);
		

	}
	
	private class OpenHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images & PNG", "jpg", "gif", "png");
		    chooser.setFileFilter(filter);
		    returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
//		       System.out.println("You chose to open this file: " +
//		            chooser.getSelectedFile().getName());
		       
		       tx_file_name.setText(createJsontoSend(chooser));
		    }
			
		}
		
		private String createJsontoSend(JFileChooser chooser)
		{
			String s = chooser.getSelectedFile().getAbsolutePath();
			s = Paths.get(s).toUri().toString();
			
			JsonObject jsonObject = Json.createObjectBuilder().add("name", chooser.getSelectedFile().getName())
					.add("location", s)
					.add("state",btn_state.isSelected())
					.build();
			return jsonObject.toString();
		}
	}
	
	private class StateHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(returnVal!=-1 && returnVal == JFileChooser.APPROVE_OPTION) 
			{
		
			String s = chooser.getSelectedFile().getAbsolutePath();
			s = Paths.get(s).toUri().toString();
			
			JsonObject jsonObject = Json.createObjectBuilder().add("name", chooser.getSelectedFile().getName())
					.add("location", s)
					.add("state",btn_state.isSelected())
					.build();
			tx_file_name.setText(jsonObject.toString());
			}
			
		}
		
	}
	
	private class SendHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(returnVal!=-1 && returnVal == JFileChooser.APPROVE_OPTION)
			{
				SendEntity payload = new SendEntity();
				
				payload.setName(chooser.getSelectedFile().getName());
				payload.setState(btn_state.isSelected());
				
				String s = chooser.getSelectedFile().getAbsolutePath();
				s = Paths.get(s).toUri().toString();
				try {
					payload.setLocation(new URI(s));
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Client client = ClientBuilder.newClient();
				InputStream r=client.target("http://localhost:8080/webservice/image/")
											 .request(MediaType.APPLICATION_JSON)
											 .post(Entity.json(payload), InputStream.class);
				
				tx_file_name.setText("Your request has been sent ...");
				
				String theString=null;
				try {
					theString = IOUtils.toString(r, "UTF-8");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				tx_file_name.setText("Your response is: \n"+theString);
				
				
			}
			
		}
	
	}
	

}
