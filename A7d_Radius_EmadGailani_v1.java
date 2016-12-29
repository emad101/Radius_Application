//Emad Al-Gailani
// The caculation of the circule assighment
//2/12/2014
//The reflection is on the other file
import java.net.*; // for image
import javax.swing.*; // for image
import javax.swing.JOptionPane;// for the joption
import java.text.DecimalFormat; // to allow only two decimal
import java.awt.*; // for the color
public  class A7d_Radius_EmadGailani_v1// class name
{// main class begins 
  public static void main(String[] args) throws Exception// public static, throws Exception is for the imagees 
  { //main program begin 
    DecimalFormat df = new DecimalFormat("#.##"); // to allow only two decimal
//All the variables     
    int anotherTime =0; 
    int userInput =0;
    int opration =0;
    String radius ="0";
    double y=0;
    double he=0;
    double answer =0;
    int unit1=0;
    double ok=0;
    String unit5="0";
    String     unit2="0";
    String[] unit ={"inches", "feet", "cm", "meters"};
    String[] again = { "diffrent Rdius" ,"Same Rdius", "Main Menu" , "Convert unit","Exit"};
    String[] begin = { "Begin" , "About" , "Exit"};
    int unit3=0;
    String h="0";
// this arrayes used to convert the unit which was used in a swith later 
    int[][] convert ={
      {0, 1, 2, 3},
      {4, 0, 5, 6},
      {7, 8,0, 9},
      {10,11,12,0},
    };
//The main program begins with the main menu    
    do
    { //beginning of do for the main menue
//the main screen with the pic      
      String[] options = {"Area of a circle", "Circumference of a Circle" , "Volume of a sphare ", "Surface area of a sphare","volume of cylinder" };
      final ImageIcon icon1 = new ImageIcon(new URL("https://c1.staticflickr.com/7/6121/5987210771_f2a8465f19_z.jpg")); // photo 
      userInput = JOptionPane.showOptionDialog(null, "" , "Every Thing Realted to circules " ,0,JOptionPane.QUESTION_MESSAGE, icon1, begin, 0); 
      do
      { // begininng of do for the diffrent readuis
       // about the game
        if (userInput == 1)
        {
          JOptionPane.showMessageDialog(null, "This is a program that will make your life easy\nYou just have to give the raduis and then the program will caculate the following:\n   1.Area of a circle\n   2.Circumference of a Circle\n   3.Volume of a sphare\n   4.Surface area of a sphare\n   5.volume of cylinder after giving the hight of it\nIt will aslo allow you to put the unit of the raduis and then you will be able to convert the unit\nThats it enjoy the program and remember every thing looks better in a circle ");
          userInput = JOptionPane.showOptionDialog(null, "" , "Every Thing Realted to circules " ,0,JOptionPane.QUESTION_MESSAGE, icon1, begin, 0); 
        }
        //exinting the game
        else if(userInput <= 2 && userInput != 1 && userInput != 0)
        {
          UIManager.put("OptionPane.messageForeground", Color.orange);
          JOptionPane.showMessageDialog(null, "Thank you bye"); 
          return;
        }
// the main program begin when the user enter begin        
        else
        {
          do
          { //begining of do for the same readuis 
// asking the user to enter the raduis with the try and catch            
            try {
              radius = JOptionPane.showInputDialog(null, "What is the radius" );
              y = Double.parseDouble(radius);
              
            }
            // telling the user that he didnt input a number            
            catch ( Exception err ) {
              UIManager.put("OptionPane.messageForeground", Color.red);
              JOptionPane.showMessageDialog(null, "Invalied Input ","Try Again", JOptionPane.ERROR_MESSAGE,null); 
              UIManager.put("OptionPane.messageForeground", Color.black);
            }
          }while(y==0);
          //asking the user what is the unit
          unit1 = JOptionPane.showOptionDialog(null, "What is the unit of the raduis" , "play" ,0,JOptionPane.QUESTION_MESSAGE, null, unit, 0);
          do
          {
            //asking the user what caculation do he want to calculate
            opration = JOptionPane.showOptionDialog(null, "what caculation do you want to know" , "play" ,0,JOptionPane.QUESTION_MESSAGE, null, options, 0);
            //swith for the unit for the first time
            switch (unit1) 
            { // begin of swith    
              case 0:
                unit5= "inches";
                break; 
              case 1:
                unit5="feet";
                break; 
              case 2:
                unit5="cm";
                break; 
              case 3:
                unit5= "meters"; 
                break; 
               default:
                JOptionPane.showMessageDialog(null,"bye");
                return; 
            }
            //swith to caculate the caculations 
            switch (opration) 
            { // begin of swith    
              case 0:
                answer =Area(y);
                JOptionPane.showMessageDialog(null,"The Area of a circle for a radius of " +y+ " is "+ df.format(answer)+" "+ unit5);  
                break; 
              case 1:
                answer=Circumference(y);
                JOptionPane.showMessageDialog(null,"The Circumference of a Circle for a radius of " +y+ " is " +df.format(answer)+" "+ unit5);  
                break; 
              case 2:
                answer=Volume(y);
                JOptionPane.showMessageDialog(null,"The Volume of a sphare a radius of " +y+ " is " +df.format(answer)+" "+ unit5); 
                break; 
              case 3:
                answer=Surface(y);
                JOptionPane.showMessageDialog(null,"Surface area of a sphare of a radius of " +y+ " is "+df.format(answer)+" "+ unit5); 
                break;
              case 4:
                // if the user want to know the vlume of the cylinder and asking him what is the hight 
                do
              {
                try {
                  h= JOptionPane.showInputDialog(null, "What is the hight of the cylinder" );
                  he = Double.parseDouble(h);
                }
                //message telling the user that he didnt entered a number
                catch ( Exception err ) {
                  UIManager.put("OptionPane.messageForeground", Color.red);
                  JOptionPane.showMessageDialog(null, "Invalied Input","Try Again", JOptionPane.ERROR_MESSAGE,null);
                  UIManager.put("OptionPane.messageForeground", Color.black);
                }
              }while(he==0);
              answer=Cylinde(y,he);
              JOptionPane.showMessageDialog(null,"Surface area of a sphare of a radius of " +y+ " ,and a hight of " +he+ " is "+df.format(answer)+" "+ unit5); 
              break;
              default:
                JOptionPane.showMessageDialog(null,"bye");
                return; 
            }
            // asking the user what he want to pick from the options after he caculate what he want
            String know = "What would you want to know";
            JLabel resLabel1 = new JLabel(know);
            resLabel1.setFont(new Font("Monospaced", Font.BOLD, 22));
            anotherTime= JOptionPane.showOptionDialog(null,resLabel1 ," again" ,0,JOptionPane.QUESTION_MESSAGE, null, again, 0); // message
            //if the user choose to convert the unit
            if (anotherTime==3)
            {
              unit3 = JOptionPane.showOptionDialog(null, "What do you want to convert to" , "play" ,0,JOptionPane.QUESTION_MESSAGE, null, unit, 0);
              //switch for the convert unit
              switch (unit3) 
              { // begin of swith    
                case 0:
                  unit2= "inches";
                  break; 
                case 1:
                  unit2="feet";
                  break; 
                case 2:
                  unit2="cm";
                  break; 
                case 3:
                  unit2= "meters"; 
                  break; 
                case 4:
                  userInput=0;
                default:
                  JOptionPane.showMessageDialog(null,"bye");
                  return; 
              }
              //caculating the covert unit from the arryes 
              int convertTest = convert [unit3][unit1];
              switch (convertTest) 
              { // begin of swith    
                case 0:
                  ok=answer;
                  break; 
                case 1:
                  ok =answer*12;
                  break; 
                case 2:
                  ok=answer*0.393701;
                  break; 
                case 3:
                  ok=answer*39.3701;
                  break; 
                case 4:
                  ok=answer*0.0833333;
                  break; 
                case 5:
                  ok=answer*0.0328084;
                  break; 
                case 6:
                  ok=answer*3.28084;
                  break; 
                case 7:
                  ok=answer*2.54;
                  break; 
                case 8:
                  ok=answer*30.48;
                  break; 
                case 9:
                  ok=answer*100;
                  break; 
                case 10:
                  ok=answer*0.0254;
                  break; 
                case 11:ok=answer*0.3048;
                break; 
                case 12:
                  ok=answer*0.01;
                default:
                  JOptionPane.showMessageDialog(null,"bye");
              }
              //telling the user what is the converting answer
              JOptionPane.showMessageDialog(null, " the convertion  from " +unit5+ " to " +unit2+ " for " +df.format(answer)+ " is "  +df.format(ok)+" "+ unit2);  
              anotherTime= JOptionPane.showOptionDialog(null, "What would you want to know   " ," again" ,0,JOptionPane.QUESTION_MESSAGE, null, again, 0); // message
            } //end of the covert option
          }while (anotherTime==1);// if the user want to caculater with the same raduis
        }// end of begin option
      }while(anotherTime==0);// if the user want to caculate with a diffrent raduis 
    }while (anotherTime==2);// if the user want to go the main screen
    UIManager.put("OptionPane.messageForeground", Color.orange);
    JOptionPane.showMessageDialog(null, "Thank you bye");   
  }// end of main method
// method to caculate the area  
  public static double Area (double y) 
  {
    return(Math.PI *(y*y));
  }
//method to caculate the circumference  
  public static double Circumference (double y) 
  {
    return(2* Math.PI *(y));
  }
//method to caculate the volume
  public static double Volume(double y) 
  {
    return((1.333333333333)* (Math.PI) *(y*y*y));
  }
//method to caculate the surfase area 
  public static double Surface(double y) 
  {
    return((4)*(Math.PI) *(y*y));
  }
//method to caculate the cylinda  
  public static double Cylinde (double y ,double he) 
  {
    return(((Math.PI) *(y*y)*(he)));
  }
}//end program



