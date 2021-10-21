package seedu.duke.ui;

import seedu.duke.commands.ChangeHeightCommand;
import seedu.duke.commands.ChangeNameCommand;
import seedu.duke.commands.ChangeWeightCommand;
import seedu.duke.commands.HelpCommand;
import seedu.duke.commands.ProfileCreateCommand;
import seedu.duke.commands.SetGoalCommand;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class deals with interaction with user on CLI.
 * Also helps to change color of output if required.
 */
public class Ui {
    // to delete on v2.1
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GRAY = "\u001B[90m";
    public static final String FULL_BLOCK = "█";
    public static final String HALF_BLOCK = "▌";
    public static final int MAX_BAR = 16;
    public static final int BAR_WIDTH = 10;
    public static final String SPACE = " ";
    public static final String TAB = "\t";
    public static final String DIVIDER = "___________________________________________"
            + "_______________________________________________________________";
    public static final String LS = System.lineSeparator();
    public static final String INDENTED_LS = LS + TAB;
    public static final String EMOJI_1 = " ᕦ(ò_óˇ)";
    public static final String FITBOT_V0 = "  ______ _ _   _           _"
            + LS
            + " |  ____(_) | | |         | |"
            + LS
            + " | |__   _| |_| |__   ___ | |_"
            + LS
            + " |  __| | | __| '_ \\ / _ \\| __|"
            + LS
            + " | |    | | |_| |_) | (_) | |_"
            + LS
            + " |_|    |_|\\__|_.__/ \\___/ \\__|";
    public static final String QUOTATION = "\"";
    public static final String MESSAGE_WELCOME = "Welcome to Fitbot, a desktop app that helps university students"
            + " who are looking to keep track of their calories.";
    public static final String MESSAGE_DIRECT_HELP = "Please type a command to start or view the list of "
            + "available commands by typing " + HelpCommand.MESSAGE_COMMAND_FORMAT + ".";
    public static final String MESSAGE_FIX_PROFILE = "It seems that some of your profile attribute are missing.\n"
            + "Please follow the inputs needed so that your profile will be complete.";
    public static final String MESSAGE_NEW_PROFILE = "Hi user, before you proceed with the application, we would like"
            + " you to complete the profile.\n"
            + "Follow the instructions and key in the necessary information when prompted.\n"
            + "Note please complete your profile before exiting so that we can store your profile data.";


    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
        this.printStartApplicationPage();
    }

    public String getUserInput() {  //To be moved into UI
        return scanner.nextLine();
    }

    private static Logger logger = Logger.getLogger(Ui.class.getName());

    /**
     * Surround strings with lines for user to differentiate results.
     *
     * @param messages is the strings that need to be printed on CLI
     */
    public void formatMessageFramedWithDivider(String... messages) {
        System.out.println(DIVIDER);
        for (String message : messages) {
            System.out.println(message);
        }
        System.out.println(DIVIDER);
    }


    public void printStartApplicationPage() {
        logger.log(Level.FINE, "start of application");
        System.out.println(FITBOT_V0 + LS + MESSAGE_WELCOME);
    }

    public void printStartMessage(boolean isProfileComplete, boolean isProfilePresent) {
        if (isProfileComplete) {
            System.out.println(MESSAGE_DIRECT_HELP);
            return;
        }
        if (isProfilePresent) {
            System.out.println(MESSAGE_FIX_PROFILE);
        }

        System.out.println(MESSAGE_NEW_PROFILE);
    }

}
