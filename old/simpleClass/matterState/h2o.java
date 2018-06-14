/**
 * program:  h2o.java
 * used with:  matterState.java
 * author:  Brian Stamm
 * date:  9.14.15
 * description:  This is a basic object, that will determine if number
 * sent to it, if it is above or below a range.  Used to see if water
 * is at freezing/boiling point.
 * */

public class h2o
{
   private int freeze = 32;
   private int boil = 212;
   private String b = "Gas";
   private String f = "Solid";
   private String l = "Liquid";
   

   public String stateH2o(int temp){
      if (temp < freeze)
	 return f;
      else if (temp < boil)
	 return l;
      else
	 return b;
   }
}
