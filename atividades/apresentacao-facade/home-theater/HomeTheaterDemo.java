public class HomeTheaterDemo {
    public static void main(String[] args) {
        DvdPlayer dvdAntes = new DvdPlayer();
        PopcornPopper popperAntes = new PopcornPopper();
        TheaterLights lightsAntes = new TheaterLights();
        Screen screenAntes = new Screen();
        Projector projectorAntes = new Projector();
        Amplifier amplifierAntes = new Amplifier();

        System.out.println("=== ANTES DA FACADE ===");
        System.out.println("O cliente coordena cada aparelho diretamente:\n");

        popperAntes.on();
        popperAntes.pop();
        lightsAntes.dim(10);
        screenAntes.down();
        projectorAntes.on();
        projectorAntes.setInput(dvdAntes);
        amplifierAntes.on();
        amplifierAntes.setDvd(dvdAntes);
        amplifierAntes.setVolume(5);
        dvdAntes.on();
        dvdAntes.play("Matrix");

        System.out.println("\n=== DEPOIS DA FACADE ===");
        System.out.println("O cliente chama uma operação de alto nível:\n");

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
