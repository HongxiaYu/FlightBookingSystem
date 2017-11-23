package test;



public class Test {
	
	public Test() {		
		// JPanel panel_1 = new JPanel();
		// add(panel_1, BorderLayout.SOUTH);
		//
		// JButton btnNewButton = new JButton("RESET");
		// btnNewButton.addActionListener(new ResetMealAction());
		// panel_1.add(btnNewButton);
		//
		// JButton btnNewButton_1 = new JButton(" OK ");
		// btnNewButton_1.addActionListener(new ConfirmMealAction());
		// panel_1.add(btnNewButton_1);	
		
		// not needed anymore?? 
		
		//		FirstClassSeat fcs = new FirstClassSeat(1);
		//		FirstClassSeat fcs2 = new FirstClassSeat(1);
		//		FirstClassSeat fcs3 = new FirstClassSeat(1);
		//		FirstClassSeat fcs4 = new FirstClassSeat(1);
		//		FirstClassSeat fcs5 = new FirstClassSeat(1);
		//
		//		EconomyClassSeat ecs6 = new EconomyClassSeat(6);
		//		EconomyClassSeat ecs7 = new EconomyClassSeat(7);
		//		EconomyClassSeat ecs8 = new EconomyClassSeat(8);
		//		EconomyClassSeat ecs9 = new EconomyClassSeat(9);
		//		EconomyClassSeat ecs10 = new EconomyClassSeat(10);
		//
		//		firstClassSeats.add(fcs);
		//		firstClassSeats.add(fcs2);
		//		firstClassSeats.add(fcs3);
		//		firstClassSeats.add(fcs4);
		//		firstClassSeats.add(fcs5);
		//
		//		economySeats.add(ecs6);
		//		economySeats.add(ecs7);
		//		economySeats.add(ecs8);
		//		economySeats.add(ecs9);
		//		economySeats.add(ecs10);
				
		
		
	}


	// public void initEconomySeatPanel(JPanel economyClassSeatPanel, ButtonGroup
	// buttonGroup) {
	// economyClassSeatPanel.setLayout(new BoxLayout(economyClassSeatPanel,
	// BoxLayout.Y_AXIS));
	// economyClassSeatPanel.setBorder(new TitledBorder("Choose Seat"));
	//
	// JRadioButton rdbtnSeat = new JRadioButton("SEAT 6 5 000SEK");
	// rdbtnSeat.setAlignmentX(Component.CENTER_ALIGNMENT);
	// economyClassSeatPanel.add(rdbtnSeat);
	// buttonGroup.add(rdbtnSeat);
	//
	// JRadioButton rdbtnSeat_1 = new JRadioButton("SEAT 7 5 000SEK");
	// rdbtnSeat_1.setAlignmentX(Component.CENTER_ALIGNMENT);
	// economyClassSeatPanel.add(rdbtnSeat_1);
	// buttonGroup.add(rdbtnSeat_1);
	//
	// JRadioButton rdbtnSeat_2 = new JRadioButton("SEAT 8 5 000SEK");
	// rdbtnSeat_2.setAlignmentX(Component.CENTER_ALIGNMENT);
	// economyClassSeatPanel.add(rdbtnSeat_2);
	// buttonGroup.add(rdbtnSeat_2);
	//
	// JRadioButton rdbtnSeat_3 = new JRadioButton("SEAT 9 5 000SEK");
	// rdbtnSeat_3.setAlignmentX(Component.CENTER_ALIGNMENT);
	// economyClassSeatPanel.add(rdbtnSeat_3);
	// buttonGroup.add(rdbtnSeat_3);
	//
	// JRadioButton rdbtnSeat_4 = new JRadioButton("SEAT 10 5 000SEK");
	// rdbtnSeat_4.setAlignmentX(Component.CENTER_ALIGNMENT);
	// economyClassSeatPanel.add(rdbtnSeat_4);
	// buttonGroup.add(rdbtnSeat_4);
	// }	
	
	
	
//	class ResetMealAction implements ActionListener {
//	public void actionPerformed(ActionEvent e) {
//		Component[] components = mealPanel.getComponents();
//		for (Component c : components) {
//			if (c instanceof MealCheckBox) {
//				MealCheckBox cb = (MealCheckBox) c;
//				cb.setSelected(false);
//			}
//		}
//
//	}
//}

//class ConfirmMealAction implements ActionListener {
//	public void actionPerformed(ActionEvent e) {
//		selectedMealList.clear();
//		Component[] components = mealPanel.getComponents();
//		for (Component c : components) {
//			if (c instanceof MealCheckBox) {
//				MealCheckBox cb = (MealCheckBox) c;
//				if (cb.isSelected()) {
//					addSelectFood(cb.getFood());
//				}
//			}
//		}
//		System.out.println("Total Price: " + selectedMealList.getMealTotalPrice());
//	}
//}
	
}
