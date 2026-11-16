public class Amplifier {
    public void on() {
        System.out.println("Amplificador ligado");
    }

    public void setDvd(DvdPlayer dvd) {
        System.out.println("DVD conectado ao amplificador");
    }

    public void setVolume(int level) {
        System.out.println("Volume em " + level);
    }

    public void off() {
        System.out.println("Amplificador desligado");
    }
}
