package launcher;
import gui.SimplePresentationScreen;
import entities.Student;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimplePresentationScreen frame = new SimplePresentationScreen(new Student(137424, "Ocaranza", "Juan Bautista", "juanbautistaocaranza@gmail.com", "https://github.com/JuanOcaranza", "/images/student.png"));
            	frame.setVisible(true);
            }
        });
    }
}