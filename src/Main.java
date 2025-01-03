import DataStorage.FileHandler;
import UserTypes.*;

import javax.swing.*;
import java.io.IOException;


public class Main extends JFrame {
    public static void main(String[] args) throws IOException {
        FileHandler.loadUsers();
    }
}
