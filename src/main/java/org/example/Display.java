package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Display {
    public ArrayList < Box > P_locker = new ArrayList < > (); //array list of boxes

    public Display() { //constructor to set size of boxes
        //set size of boxes (60)
        for (int i = 0; i < 60; i++) {
            if (i >= 0 && i < 20) {
                P_locker.add(new Box(8, 38, 64));
            } else if (i >= 20 && i < 40) {
                P_locker.add(new Box(19, 38, 64));
            } else {
                P_locker.add(new Box(41, 38, 64));
            }
        }
    }

    public void insert_package(int number, String id_number) //insert package to concrete box
    {

        if (id_number.strip().charAt(0) == 'A') {
            Boolean
                    var = true;
            for (int i = 0; i < 20; i++) {
                if (!P_locker.get(i).isBusy()) {

                    P_locker.get(i).setNumber_tel(number);
                    P_locker.get(i).setNumber_id(id_number);
                    P_locker.get(i).setBusy(true);
                    P_locker.get(i).setDoor(true);
                    var = false;
                    break;
                }

            }
            //when all A boxes are busy
            if (var) {
                for (int i = 20; i < 60; i++) {
                    if (!P_locker.get(i).isBusy()) {

                        P_locker.get(i).setNumber_tel(number);
                        P_locker.get(i).setNumber_id(id_number);
                        P_locker.get(i).setBusy(true);
                        P_locker.get(i).setDoor(true);
                        break;
                    }

                }
            }

        } else if (id_number.strip().charAt(0) == 'B') {
            Boolean
                    var = true;
            for (int i = 20; i < 40; i++) {
                if (!P_locker.get(i).isBusy()) {

                    P_locker.get(i).setNumber_tel(number);
                    P_locker.get(i).setNumber_id(id_number);
                    P_locker.get(i).setBusy(true);
                    P_locker.get(i).setDoor(true);
                    var = false;
                    break;
                }

            }
            //when all B boxes are busy
            if (var) {
                for (int i = 40; i < 60; i++) {
                    if (!P_locker.get(i).isBusy()) {

                        P_locker.get(i).setNumber_tel(number);
                        P_locker.get(i).setNumber_id(id_number);
                        P_locker.get(i).setBusy(true);
                        P_locker.get(i).setDoor(true);
                        break;
                    }

                }
            }

        } else if (id_number.strip().charAt(0) == 'C') {
            for (int i = 40; i < 60; i++) {
                if (!P_locker.get(i).isBusy()) {

                    P_locker.get(i).setNumber_tel(number);
                    P_locker.get(i).setNumber_id(id_number);
                    P_locker.get(i).setBusy(true);
                    P_locker.get(i).setDoor(true);
                    break;
                }

            }

        }
    }
    public void receive_package(int num_tel, String num_id) //receive package from parcel locker
    {
        if (num_id.strip().charAt(0) == 'A') {
            for (int i = 0; i < 20; i++) {
                if (P_locker.get(i).getNumber_id().equals(num_id) && P_locker.get(i).getNumber_tel() == num_tel) {
                    P_locker.get(i).setBusy(false);
                    P_locker.get(i).setDoor(true);
                    P_locker.get(i).setNumber_tel(-1);
                    P_locker.get(i).setNumber_id("-1");

                    break;
                }

            }

        } else if (num_id.strip().charAt(0) == 'B') {
            for (int i = 20; i < 40; i++) {
                if (P_locker.get(i).getNumber_id().equals(num_id) && P_locker.get(i).getNumber_tel() == num_tel) {

                    P_locker.get(i).setBusy(false);
                    P_locker.get(i).setDoor(true);
                    break;
                }

            }

        } else if (num_id.strip().charAt(0) == 'C') {
            for (int i = 40; i < 60; i++) {
                if (P_locker.get(i).getNumber_id().equals(num_id) && P_locker.get(i).getNumber_tel() == num_tel) {

                    P_locker.get(i).setBusy(false);
                    P_locker.get(i).setDoor(true);
                    break;
                }

            }

        } else {
            for (int i = 20; i < 60; i++) {
                if (P_locker.get(i).getNumber_id().equals(num_id) && P_locker.get(i).getNumber_tel() == num_tel) {

                    P_locker.get(i).setBusy(false);
                    P_locker.get(i).setDoor(true);
                    break;
                }
            }
            System.out.println("Nie znaleziono paczki o podanym numerze telefonu i numerze odobioru");
        }

    }
    public void closed_door() //close open box
    {
        for (int i = 0; i < 60; i++) {
            if (P_locker.get(i).isDoor()) {
                P_locker.get(i).setDoor(false);
                System.out.println("Skrytka została zamknięta.");

            }

        }

    }
    public void first() //default display
    {
        System.out.println("Wybierz co chcesz zrobić?");
        System.out.println("1-Nadaj Paczkę");
        System.out.println("2-Odbierz Paczkę");
        Scanner s = new Scanner(System.in);
        String x = s.next();
        //
        Instant start = Instant.now();
        switch (x) {
            case "1": {
                System.out.println("Podaj numer telefonu odbiorcy");

                try {
                    int num_tel = s.nextInt(); //if input is not int throw exception
                    String num = Integer.toString(num_tel);

                    for (int i = 0; i < 9; i++) { //check incorrect symbols in number of telephone
                        if (num.charAt(i) < '0' || num.charAt(i) > '9') {
                            throw new WrongNumber();
                        }
                    }

                    System.out.println(num_tel);
                    System.out.println("Podaj kod nadania");
                    String num_id = s.next();

                    if (num.length() != 9 || num_id.length() != 6) //check length of numbers
                        throw new WrongNumber();

                    for (int i = 1; i < 6; i++) //check correct template of id number AXXXXX,BXXXXX,CXXXXX where X is digit
                    {
                        if (num_id.charAt(i) < '0' || num_id.charAt(i) > '9') {
                            throw new WrongNumber();
                        }
                    }
                    if (!(num_id.charAt(0) == 'A' || num_id.charAt(0) == 'B' || num_id.charAt(0) == 'C'))
                        throw new WrongNumber();

                    System.out.println(num_id);
                    this.insert_package(num_tel, num_id);
                    System.out.println("Skrytka została otworzona.");
                    System.out.println("Kliknij ENTER, aby zamknąć skrytkę.");
                    s.nextLine();
                    s.nextLine();
                    this.closed_door();
                    Instant end = Instant.now();
                    System.out.println("Operacja zajeła tylko " + Duration.between(start, end).getSeconds() + " sekund.");
                    this.diag_display();

                } catch (WrongNumber e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Wprowadzony numer telofonu jest niepoprawny");
                } catch (Exception e) {
                    System.out.println("Wystąpił problem podczas podawania danych, proszę spróbowac jeszcze raz");
                } finally {
                    this.first();
                }

            }
            case "2": {
                try {
                    System.out.println("Podaj numer telefonu");
                    int num_tel = s.nextInt();
                    String num = Integer.toString(num_tel);

                    for (int i = 0; i < num.length(); i++) { //the same exceptions as above
                        if (num.charAt(i) < '0' || num.charAt(i) > '9') {
                            throw new WrongNumber();
                        }
                    }
                    System.out.println(num_tel);
                    System.out.println("Podaj kod odbioru");
                    String num_id = s.next();

                    if (num.length() != 9 || num_id.length() != 6)
                        throw new WrongNumber();

                    for (int i = 1; i < 6; i++) {
                        if (num_id.charAt(i) < '0' || num_id.charAt(i) > '9') {
                            throw new WrongNumber();
                        }
                    }
                    if (!(num_id.charAt(0) == 'A' || num_id.charAt(0) == 'B' || num_id.charAt(0) == 'C'))
                        throw new WrongNumber();
                    System.out.println(num_id);
                    this.receive_package(num_tel, num_id);
                    System.out.println("Skrytka została otworzona.");
                    System.out.println("Kliknij ENTER, aby zamknąć skrytkę.");
                    s.nextLine();
                    s.nextLine();
                    this.closed_door();
                    //System.out.println("Skrytka została zamknięta.");
                    Instant end = Instant.now();
                    System.out.println("Operacja zajeła tylko " + Duration.between(start, end).getSeconds() + " sekund.");
                    this.diag_display();
                } catch (WrongNumber e) {
                    System.out.println(e.getMessage());

                } catch (InputMismatchException e) {
                    System.out.println("Wprowadzony numer telofonu jest niepoprawny");
                } catch (Exception e) {
                    System.out.println("Wystąpił problem podczas podawania danych, proszę spróbowac jeszcze raz");
                } finally {
                    this.first();
                }

            }
            default: {
                this.first();
            }
        }

    }
    public class WrongNumber extends Exception { //exception when word have incorrect symbol
        @Override
        public String getMessage() {
            return "Numer telefonu lub numer id zawiera niedozwolone znaki";
        }
    }
    public void diag_display() //show diagnostic report, which boxes are occupied
    {
        for (int i = 0; i < 60; i++) {
            System.out.println("Skrzynka " + i + ": " + P_locker.get(i).isBusy());
        }
    }
    public void check_unique_value(String
                                           var) //check that id_number not exist in parcel locker

    {
        for (int i = 0; i < 60; i++) {
            if (P_locker.get(i).getNumber_id().equals(var)) {
                System.out.println("Niepoprawna wartość numberu id paczki, ponieważ paczka o takim numerze już istnieje");
                this.first();
            }
        }

    }

}