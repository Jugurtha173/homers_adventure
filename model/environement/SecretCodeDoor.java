package model.environement;

import java.util.Optional;
import java.util.Scanner;
import javafx.scene.control.TextInputDialog;
import model.GameModel;

public class SecretCodeDoor extends AutoLockDoor{
    
    private final int SECRET_CODE;
    
    public SecretCodeDoor(){
        super(); 
        this.SECRET_CODE = 1703;
    }
    
    public SecretCodeDoor(Room room1, Room room2, int x, int y) {
    	super(room1, room2, x, y);
    	this.SECRET_CODE = 1703;
    }
    
    public SecretCodeDoor(Room room1, Room room2, int code) {
    	super(room1, room2);
    	this.SECRET_CODE = code;
    }
    
    public SecretCodeDoor(Room room1, Room room2, int code, int x, int y) {
    	super(room1, room2, x, y);
    	this.SECRET_CODE = code;
    }
   
    @Override
    public void open() {
    	this.unLock();    	
    }
    
    public void unLock(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Secret code door");
        dialog.setHeaderText("Tape the code !");
        dialog.setContentText("Please enter the code:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.get().equals(""+ this.SECRET_CODE)){
            System.out.println(result.get() + " equals " + this.SECRET_CODE);
            super.unLock();
            super.open();
        } else{
            System.out.println(result.get() + " not equals " + this.SECRET_CODE);
            GameModel.showMessage("CODE INCORRECT !!!");
        }
	    

    	/*GameModel.show("Tape the code to unlock : ");
        Scanner code = new Scanner(System.in);
        
        if(code.hasNextInt()){
	        if(code.nextInt() == this.SECRET_CODE) {
	        	super.unLock();
	        	super.open();
	        } else {
	        	System.err.println("CODE INCORRECT !!!");        	
	        }
        }
        else {
        	System.err.println("Waiting for a digit code");
        }*/
    }

}
