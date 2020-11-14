package arnab;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

class button extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font f = new Font("Ariel", Font.BOLD, 22);
	private String namestr = "neub.png";
	private ImageIcon icn;
	
	button(int x, int y, int img)
	{
		if(img>=0 && img<=9) {
			namestr = "num"+Integer.toString(img)+".png";
			icn = new ImageIcon(getClass().getResource(namestr));
		}
		
		setIcon(icn);
		setBorderPainted(false);
		setBounds(x, y, 50, 50);
		setBackground(Color.black);
		setForeground(Color.white);
		setBorderPainted(false);
		setFont(f);
	}
}

public class Main extends JFrame implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container c;
	private JTextField disp;
	private button plus, min, mul, div, eq, zero, arnab, ans, clr, point, per, sqrt, sqr, mem, memr, memp, cube, cube_root, ten, mod, abs, neub_bt;
	private JButton back;
	private Font f = new Font("Ariel", Font.BOLD, 32);
	private Font f2 = new Font("Ariel", Font.BOLD, 15);
	private Font f3 = new Font("Ariel", Font.ITALIC, 9);
	private Font f4 = new Font("Ariel", Font.ITALIC, 15);
	private int x = 10, y = 240, i, j, btnum = 1, simb = -1, imgc = 1;
	private button bt[][] = new button[3][3];
	private double initVal = 0, initVal2 = -1, result = 0, intor = 10, answer = 0, xc = 10, xc2 = 10, mm = 0;
	private boolean eq_pressed = false, pnt_pressed = false;
	private JTextField log;
	private String str = "";
	private ImageIcon icon, bck, neub, zer, pls, mns, mlt, dv, eql, perc, pnt, sq, cr, an, sqrr, mmp, dev, disp_bg, mplus, mp, cbe, cbrt, tenp, modd, abss;
	private JLabel dispbg;
	
	
	public Main()
	{
		initCmp();
		
		addKeyListener(this);
	    setFocusable(true);
	    setFocusTraversalKeysEnabled(false);
	    
		setVisible(true);
		setBounds(270, 150, 385, 460);
		setTitle("Calc 3.0 by Arnab");
		setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public void initCmp()
	{
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);
		
		icon = new ImageIcon(getClass().getResource("rain.png"));
		this.setIconImage(icon.getImage());
		bck = new ImageIcon(getClass().getResource("bck4.png"));
		neub = new ImageIcon(getClass().getResource("neub.png"));	
		zer = new ImageIcon(getClass().getResource("num0.png"));
		pls = new ImageIcon(getClass().getResource("plus.png"));
		mns = new ImageIcon(getClass().getResource("minus.png"));
		mlt = new ImageIcon(getClass().getResource("mul.png"));
		dv = new ImageIcon(getClass().getResource("div.png"));
		eql = new ImageIcon(getClass().getResource("eql.png"));
		perc = new ImageIcon(getClass().getResource("perc.png"));
		pnt = new ImageIcon(getClass().getResource("pnt.png"));
		sq = new ImageIcon(getClass().getResource("root.png"));
		an = new ImageIcon(getClass().getResource("ans.png"));
		cr = new ImageIcon(getClass().getResource("clr.png"));
		sqrr = new ImageIcon(getClass().getResource("square2.png"));
		mmp = new ImageIcon(getClass().getResource("m.png"));
		dev = new ImageIcon(getClass().getResource("dev.png"));
		disp_bg = new ImageIcon(getClass().getResource("display_calc.png"));
		mplus = new ImageIcon(getClass().getResource("mplus.png"));
		mp = new ImageIcon(getClass().getResource("mmin.png"));
		cbe = new ImageIcon(getClass().getResource("cube.png"));
		cbrt = new ImageIcon(getClass().getResource("cubert.png"));
		tenp = new ImageIcon(getClass().getResource("tenp.png"));
		modd = new ImageIcon(getClass().getResource("mod.png"));
		abss = new ImageIcon(getClass().getResource("abs.png"));

		
		disp = new JTextField();
		disp.setBounds(15, 10, 300, 65);
		disp.setOpaque(false);
		disp.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		disp.setBackground(Color.black);
		disp.setForeground(Color.black);
		disp.setFont(f);
		disp.setText("0");
		disp.setEditable(false);
		c.add(disp);
		
		dispbg = new JLabel();
		dispbg.setIcon(disp_bg);
		dispbg.setBackground(Color.black);
		dispbg.setVisible(true);
		dispbg.setOpaque(true);
		dispbg.setBounds(10, 10, 315, 65);
		dispbg.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		c.add(dispbg);
		
		log = new JTextField();
		log.setBounds(10, 80, 350, 30);
		log.setEditable(false);
		log.setForeground(Color.black);
		log.setBackground(Color.gray);
		log.setFont(f4);
		log.setText(str);
		log.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		c.add(log);
		
		for(i=0; i<3; i++)
		{
			for(j=0; j<3; j++)
			{
				System.out.println(btnum);
				bt[i][j] = new button(x, y, imgc);
				c.add(bt[i][j]);				
				x+=60;
				btnum++;
				imgc++;
			}
			y-=60;
			x = 10;
		}
		
		arnab = new button(10, 300, 0);
		arnab.setIcon(dev);
		arnab.setBackground(Color.black);
		arnab.setForeground(Color.black);
		c.add(arnab);
		
		zero = new button(70, 300, 0);
		zero.setIcon(zer);
		c.add(zero);
		
		eq = new button(130, 300, 0);
		eq.setIcon(eql);
		eq.setBackground(Color.black);
		c.add(eq);
		
		plus = new button(190, 300, 0);
		plus.setIcon(pls);
		plus.setBackground(Color.black);
		plus.setForeground(Color.black);
		c.add(plus);
		
		min = new button(190, 240, 0);
		min.setIcon(mns);
		min.setBackground(Color.black);
		min.setForeground(Color.black);		
		c.add(min);
		
		mul = new button(190, 180, 0);
		mul.setIcon(mlt);
		mul.setBackground(Color.black);
		mul.setForeground(Color.black);		
		c.add(mul);
		
		div = new button(190, 120, 0);
		div.setIcon(dv);
		div.setBackground(Color.black);
		div.setForeground(Color.black);		
		c.add(div);
		
		point = new button(250, 300, 0);
		point.setIcon(pnt);
		point.setBackground(Color.black);
		point.setForeground(Color.black);
		c.add(point);
		
		per = new button(250, 240, 0);
		per.setIcon(perc);
		per.setBackground(Color.black);
		per.setForeground(Color.black);
		per.setFont(f2);
		c.add(per);
		
		ans = new button(250, 180, 0);
		ans.setIcon(an);
		ans.setBackground(Color.black);
		ans.setForeground(Color.black);
		ans.setFont(f3);
		c.add(ans);
		
		clr = new button(250, 120, 0);
		clr.setIcon(cr);
		clr.setBackground(Color.black);
		c.add(clr);
		
		back = new JButton(bck);
		back.setBounds(330, 30, 35, 25);
		back.setBackground(Color.white);
		back.setForeground(Color.red.brighter());
		c.add(back);
		
		sqrt = new button(130, 360, 0);
		sqrt.setIcon(sq);
		sqrt.setForeground(Color.black);
		sqrt.setBackground(Color.black);
		c.add(sqrt);
		
		
		sqr = new button(10, 360, -1);
		sqr.setIcon(sqrr);
		sqr.setBorderPainted(false);
		c.add(sqr);
		
		mem = new button(310, 180, -1);
		mem.setIcon(mmp);
		mem.setBorderPainted(false);
		c.add(mem);
		
		memr = new button(310, 120, -1);
		memr.setIcon(mp);
		memr.setSize(50, 20);
		memr.setBorderPainted(false);
		c.add(memr);
		
		memp = new button(310, 150, -1);
		memp.setIcon(mplus);
		memp.setSize(50, 20);
		memp.setBorderPainted(false);
		c.add(memp);
		
		cube = new button(70, 360, -1);
		cube.setBackground(Color.black);
		cube.setIcon(cbe);
		cube.setBorderPainted(false);
		c.add(cube);
		
		cube_root = new button(190, 360, -1);
		cube_root.setBackground(Color.black);
		cube_root.setIcon(cbrt);
		c.add(cube_root);
		
		ten = new button(250, 360, -1);
		ten.setBackground(Color.black);
		ten.setIcon(tenp);
		c.add(ten);
		
		mod = new button(310, 240, -1);
		mod.setBackground(Color.black);
		mod.setIcon(modd);
		c.add(mod);
		
		abs = new button(310, 300, -1);
		abs.setBackground(Color.black);
		abs.setIcon(abss);
		c.add(abs);
		
		neub_bt= new button(310, 360, -1);
		neub_bt.setBackground(Color.black);
		neub_bt.setIcon(neub);
		c.add(neub_bt);
		
		ButtonSetup();
	}
	
	public void ButtonSetup() {
		
		abs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(result==0 && initVal!=0)
				{
					logger(" |"+Double.toString(initVal)+"|");
					if(initVal<0)
						initVal = Math.abs(initVal);
					disp.setText(Double.toString(initVal));
				}
				else
				{
					logger(" |"+Double.toString(result)+"|");
					if(result<0)
						result = Math.abs(result);
					disp.setText(Double.toString(result));
				}
				
			}
		});
		
		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simbAction(7);
				logger(" MOD");
			}
		});
		
		ten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(result==0 && initVal!=0)
				{
					logger(" 10^"+Double.toString(initVal));
					initVal = Math.pow(10, initVal);
					disp.setText(Double.toString(initVal));
				}
				else
				{
					logger(" 10"+Double.toString(result));
					result = Math.pow(10, result);
					disp.setText(Double.toString(result));
				}
			}
		});
		
		cube_root.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger("Cube_Root");
				if(result==0 && initVal!=0)
				{
					initVal = Math.cbrt(initVal);
					disp.setText(Double.toString(initVal));
				}
				else
				{
					result = Math.cbrt(result);
					disp.setText(Double.toString(result));
				}
			}
		});
		
		cube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger("^3");
				if(result==0 && initVal!=0)
				{
					initVal = initVal*initVal*initVal;
					disp.setText(Double.toString(initVal));
				}
				else
				{
					result = result*result*result;
					disp.setText(Double.toString(result));
				}
			}
		});
		
		sqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger("SqRt");
				if(result==0 && initVal!=0)
				{
					initVal = Math.sqrt(initVal);
					disp.setText(Double.toString(initVal));
				}
				else
				{
					result = Math.sqrt(result);
					disp.setText(Double.toString(result));
				}
			}
		});
		
		sqr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger("^2");
				if(result==0 && initVal!=0)
				{
					initVal = initVal*initVal;
					disp.setText(Double.toString(initVal));
				}
				else
				{
					result = result*result;
					disp.setText(Double.toString(result));
				}
			}
		});
		
		memr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger(" M-");
				mm = 0;
			}
		});
		
		mem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger(" M");
				initVal = mm;
				disp.setText(Double.toString(initVal));
			}
		});
		
		memp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger(" M+");
				if(result==0 && initVal!=0)
				{
					mm = initVal;
				}
				else
				{
					mm = result;
				}
			}
		});
		
		arnab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger(" ***Redirecting To Browser*** ");
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.facebook.com/iftekharahmed.arnab.0/"));
				}
				catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
		
		neub_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger(" ***Redirecting To Browser*** ");
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.neub.edu.bd/"));
				}
				catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
		
		eq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(initVal2==-1 && initVal!=0)
				{
					disp.setText(Double.toString(initVal));
				}
				else {
					eq_pressed = true;
					Rslt();
					simb = -1;
				}
				logger(" =");	
			}
		});
		
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simbAction(2);
				logger(" +");
			}
		});
		
		min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simbAction(3);
				logger(" -");
			}
		});
		
		mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simbAction(4);
				logger(" *");
			}
		});
		
		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simbAction(5);
				logger(" /");
			}
		});
		
		point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnt_pressed = true;
				logger(".");
			}
		});
		
		per.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simbAction(6);
				logger(" %");
				eq_pressed = false;
				pnt_pressed = false;
			}
		});
		
		ans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disp.setText(Double.toString(answer));
				initVal = answer;
				logger(" \"ANS\" ");
			}
		});
		
		clr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = 0;
				initVal = 0;
				initVal2 = 0;
				disp.setText(Double.toString(initVal));
				logger("  !!!CLEARED!!!  ");
				str = "";
				resetVal();
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int xdc = (int) initVal/10;
				initVal = (double) xdc;
				disp.setText(Double.toString(initVal));
				logger(" !BackSpace! ");
			}
		});
		
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(eq_pressed)
				{
					initVal = 0;
					eq_pressed = false;
				}
				initVal = (initVal*10);
				pnt_pressed = false;
				disp.setText(Double.toString(initVal));
				logger(" 0");
			}
		});
		
		bt[0][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numAction(1.0);
				logger(" 1");
			}
		});
		
		bt[0][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numAction(2.0);
				logger(" 2");
			}
		});
		
		bt[0][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numAction(3.0);
				logger(" 3");
			}
		});
		
		bt[1][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numAction(4.0);
				logger(" 4");
			}
		});
		
		bt[1][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numAction(5.0);
				logger(" 5");
			}
		});
		
		bt[1][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numAction(6.0);
				logger(" 6");
			}
		});
		
		bt[2][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numAction(7.0);
				logger(" 7");
			}
		});
		
		bt[2][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numAction(8.0);
				logger(" 8");
			}
		});
		
		bt[2][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numAction(9.0);
				logger(" 9");
			}
		});
	}

	public void Rslt() {
		
		if(simb==2)
			result = initVal+initVal2;
		else if(simb==3)
			result = initVal2-initVal;
		else if(simb==4)
			result = initVal*initVal2;
		else if(simb==5)
			result = initVal2/initVal;
		else if(simb==6)
			result = initVal*(initVal2/100);
		else if(simb==7)
			result = initVal2%initVal;
		
		initVal = result;
		answer = result;
		initVal2 = 0;
		disp.setText(Double.toString(result));
		xc = 10;
	}
	
	public void numAction(Double x) {
		
		if(eq_pressed)
		{
			initVal = 0;
			eq_pressed = false;
		}
		if(pnt_pressed)
		{
			initVal = (initVal)+(x/(xc));
			xc = xc*xc2;
		}
		else
		{
			initVal = (initVal*intor)+x;
		}
		c.setFocusable(true);
		disp.setText(Double.toString(initVal));
	}
	
	public void simbAction(int s)
	{
		if(initVal !=0 && simb!=-1)
		{
			Rslt();
			initVal2 = result;
			initVal = 0;
		}
		else {		
			if(eq_pressed)
			{
				initVal = result;
				eq_pressed = false;
				logger(Double.toString(result));
			}	
			initVal2 = initVal;
			initVal = 0;
		}
		pnt_pressed = false;
		eq_pressed = false;
		xc = 10;
		xc2 = 10;
		simb = s;
	}
	
	public void logger(String ss)
	{
		str = str+ss;
		log.setText(str);
	}
	
	public void resetVal()
	{
		initVal = 0;
		result = 0;
		answer = 0;
		initVal2 = -1;
		xc = 10;
		intor = 10;
		xc2 = 10;
		eq_pressed = false;
		pnt_pressed = false;
	}
	
	public void keyPressed(KeyEvent ke) {
		
		int keyCode = ke.getKeyCode();
		
		switch(keyCode) {
		
		case KeyEvent.VK_1 :
			numAction(1.0);
			logger("1");
			System.out.println("2");
			break;
			
		case KeyEvent.VK_2 :
			numAction(2.0);
			logger("2");
			System.out.println("2");
			break;
			
		case KeyEvent.VK_3 :
			numAction(3.0);
			logger("3");
			System.out.println("3");
			break;
			
		case KeyEvent.VK_4 :
			numAction(4.0);
			logger("4");
			System.out.println("4");
			break;
			
		case KeyEvent.VK_5 :
			numAction(5.0);
			logger("5");
			System.out.println("5");
			break;
			
		case KeyEvent.VK_6 :
			numAction(6.0);
			logger("6");
			System.out.println("6");
			break;
			
		case KeyEvent.VK_7 :
			numAction(7.0);
			logger("7");
			System.out.println("7");
			break;
			
		case KeyEvent.VK_8 :
			numAction(8.0);
			logger("8");
			System.out.println("8");
			break;
			
		case KeyEvent.VK_9 :
			numAction(9.0);
			logger("9");
			System.out.println("9");
			break;
			
		case KeyEvent.VK_0 :
			numAction(0.0);
			logger("0");
			System.out.println("0");
			break;
		}
	
	}
	
	public void keyTyped(KeyEvent ke) {
		
	}
	
	public void keyReleased(KeyEvent ke) {

		
	}

	public void playSound()
	{
		String snd = "H:\\Java Programs\\eclipse\\test\\src\\arnab\\click.wav";
		
		try 
		{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(snd).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}
	}    
	
	public int bintodec(double dc) {
		
		int n = (int) dc;
		int dec = 0, i = 0, rem;
		while (n != 0) {
		    rem = n % 10;
		    n /= 10;
		    dec += rem * Math.pow(2, i);
		    ++i;
		}
		return dec;
	}
	
	public static void main(String[] args) {
		System.out.println("Calc 3.0 Test");
		
		new Main();
		
	}
}
