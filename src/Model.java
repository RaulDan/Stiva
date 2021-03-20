import javax.swing.JOptionPane;
public class Model {

	
	private String s=new String();//Datele date de utilizator care se vor pune pe stiva
	Model()//Constructorul
	{
		this.s=null;
		
	}
	
	public void read()//Metoda prin care citesc datele care se vor pune pe stiva, date care sunt de catre utilizator
	{
		this.s=JOptionPane.showInputDialog(null,"Enter what you want to push on the stack");
		
		
	}
	//Getters si Setter pentru sirul care va fi pus pe stiva
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
		
	}
	
	
	
}
