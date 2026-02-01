import java.util.Scanner;

public class MusicPlayerApp {
    
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("Welcome to Music Player");
        
        player.displayPlaylist();
        
        while (running) {
            System.out.println("\n Commands ");
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Stop");
            System.out.println("4. Play Next");
            System.out.println("5. Play Previous");
            System.out.println("6. Show Playlist");
            System.out.println("7. Show Status");
            System.out.println("8. Exit");
            System.out.print("\nEnter your choice (1-8): ");
            
            try {
                String choice = scanner.nextLine().trim();
                
                switch (choice) {
                    case "1":
                        player.play();
                        break;
                    case "2":
                        player.pause();
                        break;
                    case "3":
                        player.stop();
                        break;
                    case "4":
                        player.playNext();
                        break;
                    case "5":
                        player.playPrevious();
                        break;
                    case "6":
                        player.displayPlaylist();
                        break;
                    case "7":
                        player.displayStatus();
                        break;
                    case "8":
                        System.out.println("\nThank you for using Music Player. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 8.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input!");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
}
