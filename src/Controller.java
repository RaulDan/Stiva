import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controller {
	
	private Model mm;//Modelul
	private View vv;//View
	private static int crr=-1;//Contorul elementelor din stiva
	Controller(Model m,View v)
	{
		mm=m;
		vv=v;
		v.addPushListener(new PushListener());
		v.addPopListener(new PopListener());
		v.addClearListener(new ClearListener());
		
	}
	
	class PushListener implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e)   {
			// TODO Auto-generated method stub
			
			mm.read();
			String s=mm.getS();//Citesc datele de intrare date de utilizator si daca acesta a confirmat, voi pune datele pe stiva
			if(s!=null) {
				vv.SetComponent(s,++crr);
			}
			
			
				
		
			
		}
		
	}
	//Scot un element din stiva, iar daca nu sunt elemente in stiva, se va afisa un mesaj de eroare
	class PopListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			try
			{
				vv.Delete(crr);
				View.setCrr(crr--);
			}
			catch(Exception ee){
				JOptionPane.showMessageDialog(null, "Stiva este goala","Eroare",JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			
		}
		
	}
	
	//Sterg toate elementele din stiva, iar daca stiva este goala va aparea un mesaj de atentionare
	class ClearListener implements ActionListener
	{
		//Metoda prin care sterg toate elementele din stiva
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(-1==crr) {
				JOptionPane.showMessageDialog(null,"Stiva este goala","Atentionare",JOptionPane.WARNING_MESSAGE);
			}
			else{
				vv.DeleteAll();
				View.setCrr(-1);
			}
			
		}
		
	}
	
		

}
