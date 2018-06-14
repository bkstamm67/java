/**
 * program:  o.java
 * used with:  matterState.java
 * author:  Brian Stamm
 * date:  9.14.15
 * description:  This is a basic object, that will determine if number
 * sent to it, if it is above or below a range.  Used to see if oxygen
 * is at freezing point.
 * */

public class o
{
   private int freeze = -362;
   private int boil = -306;
   private String b = "Gas";
   private String f = "Solid";
   private String l = "Liquid";
   

   public String stateO(int temp){
      if (temp < freeze)
	 return f;
      else if (temp < boil)
	 return l;
      else
	 return b;
   }
}
