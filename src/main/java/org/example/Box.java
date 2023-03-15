package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Box {
    private int height;
    private int width;
    private int depth;
    private boolean busy;
    private String number_id;
    private int number_tel;



    private boolean door;

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.busy=false;
        this.door=false;

    }
    public void setNumber_id(String number_id) {
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
    public void setNumber_tel(int number_tel) {

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
    }

    public boolean check(int a, int b, int c)
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
    }

    public boolean isBusy() {
        return busy;
    }

    public String getNumber_id() {
        return number_id;
    }

    public int getNumber_tel() {
        return number_tel;
    }

    public boolean isDoor() {
        return door;
    }

}
