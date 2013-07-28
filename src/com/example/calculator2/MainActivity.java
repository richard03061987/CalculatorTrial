package com.example.calculator2;

//import com.xperttech.helloworld.MainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;//number digit
	Button btnPlus,btnMinus,btnTimes,btnClear,btnEqual;//number digit
	 double numberOne=0;
	 double numberTwo=0;
	double numberResult=0;
	TextView textview;
	
	boolean userIsInMiddleOfTypingANumber = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		MyNumberListener myNumberListner = new MyNumberListener();
		MyOperationListener myOperationListner = new MyOperationListener();
		cleanListener clean = new cleanListener();
		
		setContentView(R.layout.activity_main);
		textview= (TextView)findViewById(R.id.txtResult);
		btn1=(Button)findViewById(R.id.button9);
		btn2=(Button)findViewById(R.id.button10);
		btn3=(Button)findViewById(R.id.button11);
		btn4=(Button)findViewById(R.id.button5);
		btn5=(Button)findViewById(R.id.button6);
		btn6=(Button)findViewById(R.id.button7);
		btn7=(Button)findViewById(R.id.button1);
		btn8=(Button)findViewById(R.id.button2);
		btn9=(Button)findViewById(R.id.button3);
		btn0=(Button)findViewById(R.id.button14);
		btnPlus=(Button)findViewById(R.id.button12);
		btnMinus=(Button)findViewById(R.id.button8);
		btnTimes=(Button)findViewById(R.id.button4);
		btnClear=(Button)findViewById(R.id.button13);
		btnEqual=(Button)findViewById(R.id.button15);
		
		
		btn1.setOnClickListener(myNumberListner);
		btn2.setOnClickListener(myNumberListner);
		btn3.setOnClickListener(myNumberListner);
		btn4.setOnClickListener(myNumberListner);
		btn5.setOnClickListener(myNumberListner);
		btn6.setOnClickListener(myNumberListner);
		btn7.setOnClickListener(myNumberListner);
		btn8.setOnClickListener(myNumberListner);
		btn9.setOnClickListener(myNumberListner);
		btn0.setOnClickListener(myNumberListner);
		btnPlus.setOnClickListener(myOperationListner);
		btnMinus.setOnClickListener(myOperationListner);
		btnTimes.setOnClickListener(myOperationListner);
		btnClear.setOnClickListener(clean);
		btnEqual.setOnClickListener(myOperationListner);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	class cleanListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			textview.setText("");
			
		}
	}
	 class MyNumberListener implements OnClickListener
	    {
			@Override
			public void onClick(View arg0) {	
				Button whichButton = (Button) arg0;
				int number = Integer.parseInt(whichButton.getText().toString());
				if(!userIsInMiddleOfTypingANumber)
				{
					numberOne = number;
				  userIsInMiddleOfTypingANumber = true;	
				  textview.setText(Double.toString(numberOne));
				}
				else
				{
					String oldNumber;
					String newNumber;
					
					oldNumber = textview.getText().toString() ;
					newNumber = oldNumber +Integer.toString(number);
					textview.setText(newNumber);
					
				}
			}
			
	    }
	    class MyOperationListener implements OnClickListener
	    {
			@Override
			public void onClick(View arg0) {	
				Button whichButton = (Button) arg0;
				whichButton.getText();
				Toast.makeText(MainActivity.this,
						"Am clicked " + whichButton.getText(), 
						Toast.LENGTH_LONG).show();
			}
	    	
	    }

}
