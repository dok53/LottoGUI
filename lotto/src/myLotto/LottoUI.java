package myLotto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.List;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.io.File;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.Box;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
//import java.awt.Component;

public class LottoUI extends JFrame {
	
	private JButton btnEuromillions;
	private JButton btnLotto;
	private JButton btnPick;
	private JButton btnGenerate;
	private JButton btnLuckyStars;
	private JButton btnClear;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private List list;
	private List list_1;
	private JTextField txtStarts_1;
	private JTextField txtEndsAt_2;
	private JTextField textField_draw;
	private boolean euro;
	private boolean lotto;
	private boolean stars;
	private boolean daily;
	
	Random Generator = new Random();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LottoUI frame = new LottoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LottoUI() {
		setForeground(SystemColor.controlShadow);
		setTitle("Derek's lucky lotto");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new List();
		list.setBounds(29, 31, 166, 19);
		list.setFont(new Font("Arial", Font.PLAIN, 11));
		list.setForeground(Color.BLACK);
		contentPane.add(list);
		
		JLabel lblMyLottoNumbers = new JLabel("My Lotto Numbers");
		lblMyLottoNumbers.setBounds(39, 11, 144, 14);
		lblMyLottoNumbers.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(lblMyLottoNumbers);
		
		btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(221, 205, 89, 23);
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Integer> templist = new ArrayList<Integer>();
					if (euro)
					{
						for(int i = 0; i < 5; i ++)
						{
							int j = Generator.nextInt(50);
							if (!templist.contains(j+1))
							{
								templist.add(j+1);
							}
							else
							{
								templist.add(j+2);
							}
						}
						list_1.add("Euro : " + templist.toString().replace("[", "").toString().replace("]", ""));
					}
					
					if (lotto)
					{
						for (int i = 0; i < 6; i ++)
						{
							int j = Generator.nextInt(45);
							if (!templist.contains(j+1))
							{
								templist.add(j+1);
							}
							else
							{
								templist.add(j+2);
							}
						}
						list_1.add("Lotto : " + templist.toString().replace("[", "").toString().replace("]", ""));
					}
					
					if (stars)
					{
						for (int i = 0; i < 2; i ++)
						{
							int j = Generator.nextInt(11);
							if (!templist.contains(j+1))
							{
								templist.add(j+1);
							}
							else
							{
								templist.add(j+2);
							}
						}
						list_1.add("Stars : " + templist.toString().replace("[", "").toString().replace("]", ""));
					}
					if (daily)
					{
						for(int i = 0; i < 6; i ++)
						{
							int j = Generator.nextInt(39);
							if (!templist.contains(j+1))
							{
								templist.add(j+1);
							}
							else
							{
								templist.add(j+2);
							}
						}
						list_1.add("Daily : " + templist.toString().replace("[", "").toString().replace("]", ""));
					}
					if (!stars && !lotto && !euro && !daily)
					{
						JOptionPane.showMessageDialog(contentPane, "Please select a draw");
					}
			}
		});
		contentPane.add(btnGenerate);
		
		btnPick = new JButton("Add");
		btnPick.setBounds(322, 205, 77, 23);
		btnPick.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				pickNumbers();
			}
			
		});
		btnPick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnPick);
		
		JLabel lblPickYourNumbers = new JLabel("Pick your Numbers");
		lblPickYourNumbers.setBounds(255, 11, 131, 14);
		lblPickYourNumbers.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(lblPickYourNumbers);
		
		textPane = new JTextPane();
		textPane.setBounds(221, 61, 176, 99);
		textPane.setFont(new Font("Monospaced", Font.PLAIN, 11));
		contentPane.add(textPane);
		
		btnLotto = new JButton("Lotto");
		btnLotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLotto.setBounds(322, 168, 77, 23);
		btnLotto.setSelected(false);
		btnLotto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textPane.setText(addLottoNumbers());
				lotto = true;
				euro = false;
				stars = false;
				daily = false;
			}
		});
		contentPane.add(btnLotto);
		
		btnEuromillions = new JButton("Euro");
		btnEuromillions.setBounds(221, 31, 77, 23);
		btnEuromillions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText(addEuroNumbers());
				euro = true;
				lotto = false;
				stars = false;
				daily = false;
			}
		});
		contentPane.add(btnEuromillions);
		
		btnLuckyStars = new JButton("Stars");
		btnLuckyStars.setBounds(322, 31, 77, 23);
		btnLuckyStars.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText(addLuckyStars());
				stars = true;
				lotto = false;
				euro = false;
				daily = false;
			}
		});
		contentPane.add(btnLuckyStars);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(29, 205, 77, 23);
		btnClear.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				list_1.clear();;
			}
		});
		contentPane.add(btnClear);
		
		list_1 = new List();
		list_1.setBounds(29, 81, 166, 118);
		list_1.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(list_1);
		
		JLabel lblGeneratedNumbers = new JLabel("Generated Numbers");
		lblGeneratedNumbers.setBounds(39, 52, 149, 23);
		lblGeneratedNumbers.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneratedNumbers.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(lblGeneratedNumbers);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(116, 205, 74, 23);
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int choice = list_1.getSelectedIndex();
				list_1.remove(choice);			}
		});
		contentPane.add(btnDelete);
		
		JButton btnDailyMill = new JButton("Daily mill");
		btnDailyMill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textPane.setText(addDailyMillNumbers());
				daily = true;
				stars = false;
				lotto = false;
				euro = false;
			}
		});
		btnDailyMill.setBounds(221, 167, 89, 25);
		contentPane.add(btnDailyMill);
		
		textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textPane_1.setEditable(false);
		textPane_1.setBounds(419, 61, 189, 99);
		contentPane.add(textPane_1);
		
		JLabel lblCreateADraw = new JLabel("Create a draw");
		lblCreateADraw.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCreateADraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateADraw.setBounds(450, 11, 144, 16);
		contentPane.add(lblCreateADraw);
		
		txtStarts_1 = new JTextField();
		txtStarts_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtStarts_1.setText("");
			}
		});
		txtStarts_1.setText("Starts at");
		txtStarts_1.setBounds(422, 31, 77, 22);
		contentPane.add(txtStarts_1);
		txtStarts_1.setColumns(10);
		
		txtEndsAt_2 = new JTextField();
		txtEndsAt_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEndsAt_2.setText("");
			}
		});
		txtEndsAt_2.setText("Ends at");
		txtEndsAt_2.setBounds(531, 31, 77, 22);
		contentPane.add(txtEndsAt_2);
		txtEndsAt_2.setColumns(10);
		
		textField_draw = new JTextField();
		textField_draw.setBounds(557, 168, 50, 22);
		contentPane.add(textField_draw);
		textField_draw.setColumns(10);
		
		JLabel lblHowManyTo = new JLabel("How many to draw?");
		lblHowManyTo.setBounds(429, 171, 133, 16);
		contentPane.add(lblHowManyTo);
		
		JButton btnGenerate_1 = new JButton("Populate");
		btnGenerate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerate_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane_1.setText(addCreatedDraw());
			}
		});
		btnGenerate_1.setBounds(419, 204, 89, 25);
		contentPane.add(btnGenerate_1);
		
		btnGenerate_2 = new JButton("Generate");
		btnGenerate_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Integer> templist = new ArrayList<Integer>();
				{
					int i = Integer.parseInt(txtEndsAt_2.getText());
					int j = Integer.parseInt(textField_draw.getText());
				    	for (int k = 1; k <= j; k++)
				    	{
							int x = Generator.nextInt(i);
						if (!templist.contains(x+1) && x < i)
						{
							templist.add(x+1);
						}
						else
						{
							templist.add(x+2);
						}
					}
				    list_1.add("Created : " + templist.toString().replace("[", "").toString().replace("]", ""));
				}
			}
		});
		btnGenerate_2.setBounds(520, 204, 88, 25);
		contentPane.add(btnGenerate_2);
	}
		
		/*JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(126, 240, 89, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(getComponent(0)) == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser.getSelectedFile();
				  // save to file
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(btnNewButton);*/
		
		/*btnLoad = new JButton("Load");
		btnLoad.setBounds(220, 239, 89, 23);
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(getComponent(0)) == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser.getSelectedFile();
				  // load from file
				}

			}
		});
		contentPane.add(btnLoad);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, list, lblMyLottoNumbers, btnGenerate, btnPick, lblPickYourNumbers, textPane, btnLotto, btnEuromillions, btnLuckyStars, btnClear, list_1, lblGeneratedNumbers, btnDelete, btnNewButton, btnLoad}));
	}*/
	
	public String addLottoNumbers()
	{
		ArrayList<Integer> lottoList = new ArrayList<Integer>();
		for (int i = 1; i <= 45; i++)
		{
			lottoList.add(i);
			Collections.sort(lottoList);
		}
		return "" + lottoList.toString().replace("[", "").toString().replace("]", "").toString().replace(",", "");
	}
	
	public String addEuroNumbers()
	{
		ArrayList<Integer> euroList = new ArrayList<Integer>();
		for (int i = 1; i <= 50; i++)
		{
			euroList.add(i);
			Collections.sort(euroList);
		}
		return "" + euroList.toString().replace("[", "").toString().replace("]", "").toString().replace(",", "");
	}
	
	public String addLuckyStars()
	{
		ArrayList<Integer> starsList = new ArrayList<Integer>();
		for (int i = 1; i <= 11; i++)
		{
			starsList.add(i);
			Collections.sort(starsList);
		}
		return "" + starsList.toString().replace("[", "").toString().replace("]", "").toString().replace(",", "");
	}
	
	public String addDailyMillNumbers()
	{
		ArrayList<Integer> dailyList = new ArrayList<Integer>();
		for (int i = 1; i <= 39; i++)
		{
			dailyList.add(i);
			Collections.sort(dailyList);
		}
		return "" + dailyList.toString().replace("[", "").toString().replace("]", "").toString().replace(",", "");
	}
	
	public String addCreatedDraw()
	{
		ArrayList<Integer> createdList = new ArrayList<Integer>();
		int i = Integer.parseInt(txtStarts_1.getText());
		int j = Integer.parseInt(txtEndsAt_2.getText());
		for ( int k = i; k <= j; k++)
		{
			createdList.add(k);
			Collections.sort(createdList);
		}
		return "" + createdList.toString().replace("[", "").toString().replace("]", "").toString().replace(",", "");
	}
	
	ArrayList<Integer> myList = new ArrayList<Integer>();
	private JButton btnDelete;
	private JButton btnGenerate_2;
	//private JButton btnLoad;
	@SuppressWarnings("deprecation")
	public void pickNumbers()
	{
		if (lotto)
		{
			if (myList.size() < 6)
			{
				int choice = Integer.parseInt(textPane.getSelectedText());
					if (myList.contains(choice))
					{
						JOptionPane.showMessageDialog(contentPane, "Number already added");
						myList.remove(choice);
					}
					myList.add(choice);
			}
			if (myList.size() <= 6)
			{
				list.clear();
				list.add("My lotto : " + myList.toString().replace("[", "").toString().replace("]", "").toString().replace(",",""));
			}
			if (myList.size() == 6)
			{
				list_1.add("My Lotto : " + myList.toString().replace("[", "").toString().replace("]", "").toString().replace(",",""));
				myList.clear();
			}
		}
		
		
	}
}	
