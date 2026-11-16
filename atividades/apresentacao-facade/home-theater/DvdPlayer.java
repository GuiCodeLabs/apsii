public class DvdPlayer {
    public void on() {
        System.out.println("DVD ligado");
    }

    public void play(String movie) {
        System.out.println("Reproduzindo " + movie);
    }

    public void stop() {
        System.out.println("Reprodução parada");
    }

    public void off() {
        System.out.println("DVD desligado");
    }
}
