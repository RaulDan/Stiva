import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class View {

	
	public JFrame st=new JFrame("STIVA");//Fereastra GUI care va contine stiva
	
	private JButton push;//Butonul de push
	
	private JButton pop;//Butonul de pop
	
	private JButton clear;//Butonul de stergere al tuturor elementelor din stiva
		
	private static int crr=-1;//Contorul elementelor puse in stiva
	
	private GridBagConstraints t1;;//Folosit la aliniere
	
	private JTextField[] v;//Elementele de tip JTextField in care se pun datele date de utilizator
	
	private JPanel cont;///Panoul care va contine butoanele necesare manipularii stivei
	
	private JPanel but;//Panoul care va contine butoanele necesare manipularii stivei
	
	
	View()
	{
		//Instantierea atributelor clasei
		
		st=new JFrame("Stiva");
		push=new JButton("PUSH");
		pop=new JButton("POP");
		clear=new JButton("CLEAR");
		
		t1=new GridBagConstraints();//Tipul de aliniere folosit
		v=new JTextField[50];//Elementele de tip JTextField in care se pun datele date de utilizator
		cont=new JPanel();///Panoul care va contine butoanele necesare manipularii stivei
		but=new JPanel();//Panoul care va contine butoanele necesare manipularii stivei
		
		
		//Alinierea butoanelor unul sub altul
		but.setLayout(new GridBagLayout());
		but.setAlignmentX(JFrame.LEFT_ALIGNMENT);
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.HORIZONTAL;
		but.add(push,c);
		push.setAlignmentX(JFrame.LEFT_ALIGNMENT);
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		but.add(pop,c);
		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.HORIZONTAL;
		but.add(clear,c);
		
		//Aranjarea elementelor care vor fi puse in stiva
		cont.setLayout(new GridBagLayout());
		
		for(int i=0;i<40;i++) 
		{
			v[i]=new JTextField(50);
			v[i].setBackground(Color.yellow);
			v[i].setEditable(false);
			v[i].setHorizontalAlignment(SwingConstants.CENTER);
			
		}
			
		//Definirea interfetei grafice utilizator in care vor fi puse elementele stivei
		st.setBackground(Color.red);
		st.setSize(1500,910);
		st.setLayout(new FlowLayout());
		st.add(but,BorderLayout.WEST);
		st.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		st.setVisible(true);
		
	}
	

	public void setT(int x,int y)
	{
		this.t1.gridx=x;
		this.t1.gridy=y;
	}
	
	
	
	public static int getCrr() {
		return crr;
	}



	public static void setCrr(int crr) {
		View.crr = crr;
	}



	public void SetComponent(String s,int crr) //Metoda prin care pun un element in stiva(Operatia de Push)
	{
		
		
			v[crr].setText(s);
			setT(0,51-crr);
			cont.add(this.v[crr],t1);
			cont.revalidate();
			st.add(cont,BorderLayout.CENTER);
			st.setVisible(true);
		
		
		
		
		
	}
	
	
	
	public void Delete(int crr)//Metoda prin care fac pop din stiva
	{
		
				
		this.cont.remove(this.v[crr]);
		this.cont.revalidate();
		st.add(cont,BorderLayout.CENTER);
		st.setVisible(true);
		crr--;
		
	}
	
	public void DeleteAll()//Metoda prin care sterg toate obiectele de pe stiva
	{
		this.cont.removeAll();
		this.cont.revalidate();
		st.add(cont,BorderLayout.CENTER);
		st.setVisible(true);
	}
	
	
	//Metode prin care adaug la fiecare buton un actionListener
	void addPushListener(ActionListener mm)
	{
		push.addActionListener(mm);
	}
	
	void addPopListener(ActionListener nn)
	{
		pop.addActionListener(nn);
	}
	
	void addClearListener(ActionListener pp)
	{
		clear.addActionListener(pp);
	}
	
	
	
}
