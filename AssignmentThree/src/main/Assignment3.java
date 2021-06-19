package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.bridgeSceneFigures.ABetterBridgeScene;
import mp.bridgeSceneFigures.AFactory;
import mp.bridgeSceneFigures.Avatar;
import mp.bridgeSceneFigures.BridgeScene;
import mp.bridgeSceneFigures.ConsoleView;
import mp.table.ATable;
import mp.table.Table;
import util.misc.ThreadSupport;

public class Assignment3 {

	static final int TIMER=2000; 

	
	public static void main(String[] args) {
		OEFrame anOEFrame = ObjectEditor.edit(AFactory.bridgeSceneFactoryMethod()); 
		AFactory.delegatingBridgeSceneViewFactoryMethod(); 
		AFactory.observableBridgeScenePainterFactoryMethod(); 
		Table<Avatar> aTable = new ATable<Avatar>(); 
		aTable.put("Arthur", AFactory.bridgeSceneFactoryMethod().getArthur());
		System.out.println("Arthur"); 
		System.out.println(aTable.get("Arthur"));
		Table<String> aTableTwo = new ATable<String>();
		aTableTwo.put("Arthur", "Failed"); 
		System.out.println("Arthur");
		System.out.println(aTableTwo.get("Arthur")); 
		
	
	}
}
