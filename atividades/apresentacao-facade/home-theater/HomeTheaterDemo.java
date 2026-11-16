public class HomeTheaterDemo {

    public static void main(String[] args) {
        DvdPlayer dvdAntes = new DvdPlayer();
        PopcornPopper popperAntes = new PopcornPopper();
        TheaterLights lightsAntes = new TheaterLights();
        Screen screenAntes = new Screen();
        Projector projectorAntes = new Projector();
        Amplifier ampAntes = new Amplifier();

        System.out.println("=== ANTES DA FACADE ===");
        System.out.println("O cliente precisa conhecer os aparelhos e a ordem:\n");

        popperAntes.on();
        popperAntes.pop();
        lightsAntes.dim(10);
        screenAntes.down();
        projectorAntes.on();
        projectorAntes.setInput(dvdAntes);
        ampAntes.on();
        ampAntes.setDvd(dvdAntes);
        ampAntes.setVolume(5);
        dvdAntes.on();
        dvdAntes.play("Matrix");

        System.out.println("\n=== DEPOIS DA FACADE ===");
        System.out.println("O cliente pede a tarefa com uma chamada de alto nível:\n");

        DvdPlayer dvdDepois = new DvdPlayer();
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                new PopcornPopper(),
                new TheaterLights(),
                new Screen(),
                new Projector(),
                new Amplifier(),
                dvdDepois);

        homeTheater.watchMovie("Matrix");
        homeTheater.endMovie();
    }
}

class HomeTheaterFacade {
    private final PopcornPopper popper;
    private final TheaterLights lights;
    private final Screen screen;
    private final Projector projector;
    private final Amplifier amplifier;
    private final DvdPlayer dvd;

    HomeTheaterFacade(PopcornPopper popper,
                      TheaterLights lights,
                      Screen screen,
                      Projector projector,
                      Amplifier amplifier,
                      DvdPlayer dvd) {
        this.popper = popper;
        this.lights = lights;
        this.screen = screen;
        this.projector = projector;
        this.amplifier = amplifier;
        this.dvd = dvd;
    }

    void watchMovie(String movie) {
        System.out.println("Preparando para assistir a " + movie + "...\n");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.setInput(dvd);
        amplifier.on();
        amplifier.setDvd(dvd);
        amplifier.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    void endMovie() {
        System.out.println("\nEncerrando a sessão...\n");
        dvd.stop();
        dvd.off();
        amplifier.off();
        projector.off();
        screen.up();
        lights.on();
        popper.off();
    }
}

class PopcornPopper {
    void on() {
        System.out.println("Pipoqueira ligada");
    }

    void pop() {
        System.out.println("Fazendo pipoca");
    }

    void off() {
        System.out.println("Pipoqueira desligada");
    }
}

class TheaterLights {
    void dim(int level) {
        System.out.println("Luzes em " + level + "%");
    }

    void on() {
        System.out.println("Luzes acesas");
    }
}

class Screen {
    void down() {
        System.out.println("Tela abaixada");
    }

    void up() {
        System.out.println("Tela recolhida");
    }
}

class Projector {
    void on() {
        System.out.println("Projetor ligado");
    }

    void setInput(DvdPlayer dvd) {
        System.out.println("Entrada DVD selecionada");
    }

    void off() {
        System.out.println("Projetor desligado");
    }
}

class Amplifier {
    void on() {
        System.out.println("Amplificador ligado");
    }

    void setDvd(DvdPlayer dvd) {
        System.out.println("DVD conectado ao amplificador");
    }

    void setVolume(int level) {
        System.out.println("Volume em " + level);
    }

    void off() {
        System.out.println("Amplificador desligado");
    }
}

class DvdPlayer {
    void on() {
        System.out.println("DVD ligado");
    }

    void play(String movie) {
        System.out.println("Reproduzindo " + movie);
    }

    void stop() {
        System.out.println("Reprodução parada");
    }

    void off() {
        System.out.println("DVD desligado");
    }
}
