/**
 * program:  m.java
 * used with:  matterState.java
 * author:  Brian Stamm
 * date:  9.14.15
 * description:  This is a basic object, that will determine if number
 * sent to it, if it is above or below a range.  Used to see if mercury
 * is at freezing/boiling points.
 * */

public class m
{
   private int freeze = -38;
   private int boil = 676;
   private String b = "Gas";
   private String f = "Solid";
   private String l = "Liquid";
   

   public String stateM(int temp){
      if (temp < freeze)
	 return f;
      else if (temp < boil)
	 return l;
      else
	 return b;
   }
}
