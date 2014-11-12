package combo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

public class ComboBox {

		
	HashMap<Integer, String> Month = new HashMap();
	public static  String[] Days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	public static  int[] Years = {2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019};
	
	
	
	
	private JFrame ComboFrame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBox window = new ComboBox();
					window.ComboFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ComboBox() {
		initialize();
	}
	
	private void initialize() {
		Scanner int_ints= new Scanner(System.in);
		
		ComboFrame = new JFrame();
		ComboFrame.setBounds(100, 100, 450, 300);
		ComboFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ComboFrame.getContentPane().setLayout(null);
		
		Month.put(1, "January");
		Month.put(2, "February");
		Month.put(3, "March");
		Month.put(4, "April");
		Month.put(5, "May");
		Month.put(6, "June");
		Month.put(7, "July");
		Month.put(8, "August");
		Month.put(9, "September");
		Month.put(10, "October");
		Month.put(11, "November");
		Month.put(12, "December");

		Calendar now = Calendar.getInstance();
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DATE);
		final int year= now.get(Calendar.YEAR);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		
		for(int i = 1; i < Month.size() + 1; i++){
			System.out.println(Month.get(i));
		}
		
		final JComboBox comboBox = new JComboBox();
		
	
		
		comboBox.setBounds(167, 54, 120, 20);
		ComboFrame.getContentPane().add(comboBox);
		
		for(int i=1; i < Month.size() + 1; i++){
			comboBox.addItem(Month.get(i));
		
		}

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(167, 81, 60, 20);
		ComboFrame.getContentPane().add(comboBox_1);
		
		for (int i = 0; i < Days.length; i++){
			comboBox_1.addItem(Days[i]);
		}
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(167, 108, 90, 20);
		ComboFrame.getContentPane().add(comboBox_2);
		
		for (int i = 0; i < Years.length; i++){
			comboBox_2.addItem(Years[i]);
		}
		
	for (int i = 1; i < Month.size() + 1;i++){
		if (month== i){
			comboBox.setSelectedItem(Month.get(i));
		}
	}
	
	for (int i = 0; i < Days.length; i++){
		if (day == i){
			comboBox_1.setSelectedItem(Days[i-1]);
		}
	}

	
	for (int i = 0; i < Years.length; i++){
		if (year == Years[i]  ){
			comboBox_2.setSelectedItem(Years[i]);
		}
	}
	
	
	
	
		
		comboBox.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e){
            	Object choosen = comboBox.getSelectedItem();
            
            if (choosen.toString()=="November" || choosen.toString()=="September" || choosen.toString()=="June"
                    || choosen.toString()=="April"){
                    comboBox_1.removeAllItems();
                    
                    for (int x=0; x<Days.length -1;x++){
                    	comboBox_1.addItem(Days[x]);
                    }
              }
                  
                            
                    else if (choosen.toString()=="January" || choosen.toString()=="March" || choosen.toString()=="May"
                    || choosen.toString()=="July"  || choosen.toString()=="August"  || choosen.toString()=="October"
                    || choosen.toString()=="December"){
                                   comboBox_1.removeAllItems();
                                   
                                    for (int x=0; x<Days.length;x++){
                                    	comboBox_1.addItem(Days[x]);
                                    }
                                 }  
         // Leap Year Check
             else if((year % 4 == 0) && year % 100 != 0){
        		if(choosen.toString()=="February" ){
                    comboBox_1.removeAllItems();
                    
                    for (int x=0; x<Days.length -2;x++){
                    	comboBox_1.addItem(Days[x]);
                    }
                }
        }
            else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0))
            {
            	if(choosen.toString()=="February" ){
                    comboBox_1.removeAllItems();
                    
                    for (int x=0; x<Days.length -2;x++){
                    	comboBox_1.addItem(Days[x]);	
                    }
                }
           }
            else {
            	comboBox_1.removeAllItems();
            	
                      for (int x=0; x<Days.length -3;x++){
                      	comboBox_1.addItem(Days[x]);
                      }
                }
            
            } 
        });      		
		
		
		// Labels
		JLabel Labelmonth = new JLabel("Month");
		Labelmonth.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Labelmonth.setBounds(111, 57, 46, 14);
		ComboFrame.getContentPane().add(Labelmonth);
		
		JLabel LabelYear = new JLabel("Year");
		LabelYear.setFont(new Font("Times New Roman", Font.BOLD, 14));
		LabelYear.setBounds(111, 111, 46, 14);
		ComboFrame.getContentPane().add(LabelYear);
		
		JLabel Labelday = new JLabel("Day");
		Labelday.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Labelday.setBounds(111, 84, 46, 14);
		ComboFrame.getContentPane().add(Labelday);
	}
             }