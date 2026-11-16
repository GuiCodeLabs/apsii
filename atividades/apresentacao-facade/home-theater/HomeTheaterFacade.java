public class HomeTheaterFacade {
    private final PopcornPopper popper;
    private final TheaterLights lights;
    private final Screen screen;
    private final Projector projector;
    private final Amplifier amplifier;
    private final DvdPlayer dvd;

    public HomeTheaterFacade(PopcornPopper popper,
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

    public void watchMovie(String movie) {
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

    public void endMovie() {
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
