package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Box {  //define a Box of Parcel Locker

    private int height;
    private int width;
    private int depth;
    private boolean busy;
    private String number_id;
    private int number_tel;



    private boolean door;

    public Box(int height, int width, int depth) {  //Box constructor
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.busy=false;
        this.door=false;

    }
    public void setNumber_id(String number_id) {    //set number id of box
        if(!this.busy)
        {
            if(number_id.equals(-1))
            {
                this.number_id =null;
            }
            this.number_id = number_id;
        }
        else {
            System.out.println("Nie mozna dodać numeru paczki do tej skrzynki");
        }

    }
    public void setNumber_tel(int number_tel) { //set telephone number of box

        if(!this.busy)
        {

            this.number_tel = number_tel;
        }
        else {
            System.out.println("Nie mozna dodać numeru telefonu do tej skrzynki");
        }
    }

    public void setDoor(boolean door) {
        this.door = door;
    }//set door open-true, close-false

    public boolean check(int a, int b, int c) //check if the packing is according to the box
    {
        ArrayList<Integer> package_dimensions=new ArrayList<Integer>();
        package_dimensions.add(a);
        package_dimensions.add(b);
        package_dimensions.add(c);
        Collections.sort(package_dimensions);
        if(this.height>=package_dimensions.get(0) && this.width>=package_dimensions.get(1)&&this.depth>=package_dimensions.get(2) && this.busy==false)
        {
            return true;
        } else if (this.height>=package_dimensions.get(1) && this.width>=package_dimensions.get(2)&&this.depth>=package_dimensions.get(2)&& this.busy==false) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }//set Busy

    public boolean isBusy() {
        return busy;
    }//check if the boxing is busy

    public String getNumber_id() {
        return number_id;
    }//return number_id

    public int getNumber_tel() {
        return number_tel;
    }//return number telephone

    public boolean isDoor() {
        return door;
    }//check if the door is open

}
