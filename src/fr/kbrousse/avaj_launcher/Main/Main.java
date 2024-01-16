package fr.kbrousse.avaj_launcher.Main;

import fr.kbrousse.avaj_launcher.Aircraft.Baloon;
import fr.kbrousse.avaj_launcher.Aircraft.Coordinates;
import fr.kbrousse.avaj_launcher.Tower.Tower;
import fr.kbrousse.avaj_launcher.WeatherTower.WeatherTower;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Tower tower = new Tower();
        WeatherTower weatherTower = new WeatherTower();
        //Baloon baloon = new Baloon(1, "jojo", Coordinates(1, 2, 3));
    }
}