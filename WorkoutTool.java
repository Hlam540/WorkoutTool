import java.util.*;

public class WorkoutTool {
    private Scanner scanner;
    private Map<BodyPart, List<String>> exercises;

    public WorkoutTool() {
        this.scanner = new Scanner(System.in);
        this.exercises = new HashMap<>();
        initializeExercises();
    }

    private void initializeExercises() {
        exercises.put(BodyPart.CHEST, Arrays.asList(
                "Push-ups", "Bench Press", "Chest Flyes", "Dumbbell Pullover", "Incline Bench Press",
                "Decline Bench Press", "Cable Crossovers", "Pec Deck Machine", "Dips", "Chest Press Machine",
                "Dumbbell Flyes", "Incline Dumbbell Press", "Decline Dumbbell Press", "Close-Grip Bench Press",
                "Svend Press", "Resistance Band Chest Press", "Resistance Band Chest Flyes", "Isometric Chest Squeeze",
                "Explosive Push-ups", "Medicine Ball Chest Pass"));

        exercises.put(BodyPart.BACK, Arrays.asList(
                "Pull-ups", "Bent-Over Rows", "Deadlifts", "Lat Pulldowns", "T-Bar Rows",
                "Single-Arm Dumbbell Rows", "Seated Cable Rows", "Chin-Ups", "Inverted Rows", "Back Extensions",
                "Face Pulls", "Wide-Grip Pull-Ups", "Close-Grip Pull-Ups", "Trap Bar Deadlifts", "Reverse Flyes",
                "Renegade Rows", "Resistance Band Rows", "Superman Exercise", "Good Mornings", "Landmine Row"));

        exercises.put(BodyPart.SHOULDERS, Arrays.asList(
                "Shoulder Press", "Lateral Raises", "Front Raises", "Arnold Press", "Upright Rows",
                "Dumbbell Shoulder Press", "Overhead Press", "Cable Lateral Raises", "Reverse Pec Deck Flyes", "Push Press",
                "Face Pulls", "Seated Dumbbell Press", "Front Plate Raises", "Dumbbell Shrugs", "Barbell Shrugs",
                "Single-Arm Cable Lateral Raise", "Single-Arm Dumbbell Press", "Landmine Press", "Resistance Band Lateral Raise",
                "Scaption"));

        exercises.put(BodyPart.ARMS, Arrays.asList(
                "Bicep Curls", "Tricep Dips", "Hammer Curls", "Tricep Extensions", "Concentration Curls",
                "Preacher Curls", "Overhead Tricep Extension", "Skull Crushers", "Incline Dumbbell Curls", "Tricep Kickbacks",
                "Close-Grip Bench Press", "Cable Tricep Pushdowns", "Cable Bicep Curls", "Reverse Curls", "Zottman Curls",
                "Single-Arm Tricep Extension", "Single-Arm Bicep Curls", "Resistance Band Curls", "Resistance Band Tricep Extensions",
                "21s Bicep Curl"));

        exercises.put(BodyPart.ABS, Arrays.asList(
                "Crunches", "Planks", "Leg Raises", "Russian Twists", "Bicycle Crunches",
                "Mountain Climbers", "V-Ups", "Hanging Leg Raises", "Flutter Kicks", "Ab Rollouts",
                "Toe Touches", "Windshield Wipers", "Seated In and Outs", "Ab Wheel Rollouts", "Side Plank Hip Lifts",
                "Dead Bug", "Dragon Flags", "Standing Oblique Crunches", "Cable Crunches", "Med Ball Slams"));

        exercises.put(BodyPart.OBLIQUES, Arrays.asList(
                "Side Planks", "Oblique Crunches", "Woodchoppers", "Side Bends", "Mountain Climbers",
                "Russian Twists", "Hanging Oblique Knee Raises", "Cable Woodchoppers", "Seated Oblique Twists", "Oblique V-Ups",
                "Standing Side Crunches", "Windshield Wipers", "Side Jackknives", "Side Leg Raises", "Kneeling Cable Crunch",
                "Bicycle Kicks", "Side Plank Dips", "Side-to-Side Medicine Ball Slams", "Renegade Rows", "Saxon Side Bends"));

        exercises.put(BodyPart.QUADRICEPS, Arrays.asList(
                "Squats", "Lunges", "Leg Press", "Bulgarian Split Squats", "Box Jumps",
                "Front Squats", "Step-Ups", "Goblet Squats", "Wall Sits", "Hack Squats",
                "Leg Extensions", "Pistol Squats", "Sissy Squats", "Dumbbell Step-Ups", "Reverse Lunges",
                "Resistance Band Squats", "Resistance Band Leg Extensions", "Jump Squats", "Walking Lunges", "Split Squats"));

        exercises.put(BodyPart.HAMSTRINGS, Arrays.asList(
                "Deadlifts", "Leg Curls", "Good Mornings", "Glute-Ham Raises", "Stiff-Legged Deadlifts",
                "Romanian Deadlifts", "Kettlebell Swings", "Single-Leg Deadlifts", "Nordic Hamstring Curls", "Cable Pull-Throughs",
                "Seated Leg Curls", "Standing Leg Curls", "Resistance Band Leg Curls", "Bridges", "Swiss Ball Leg Curls",
                "Hamstring Walkouts", "Hip Hinge", "Sumo Deadlifts", "Reverse Plank", "Sprinter Leg Curls"));

        exercises.put(BodyPart.GLUTES, Arrays.asList(
                "Hip Thrusts", "Glute Bridges", "Bulgarian Split Squats", "Donkey Kicks", "Fire Hydrants",
                "Step-Ups", "Sumo Squats", "Cable Kickbacks", "Side-Lying Clamshells", "Lateral Band Walks",
                "Single-Leg Glute Bridges", "Frog Pumps", "Kettlebell Swings", "Curtsy Lunges", "Romanian Deadlifts",
                "Squat Jumps", "Glute Ham Raise", "Glute Bridge March", "Hip Abductions", "Resistance Band Hip Thrusts"));

        exercises.put(BodyPart.CALVES, Arrays.asList(
                "Calf Raises", "Donkey Calf Raises", "Toe Raises", "Jump Rope", "Box Jumps",
                "Seated Calf Raises", "Standing Calf Raises", "Single-Leg Calf Raises", "Plyo Lunges", "Farmers Walk on Toes",
                "Smith Machine Calf Raises", "Leg Press Calf Raises", "Sprint Drills", "Ankle Circles", "Jump Squats",
                "Skipping", "Stair Climbing", "Explosive Calf Raises", "Resistance Band Calf Raises", "Isometric Calf Hold"));
    }

    enum BodyPart {//enumerating on the body parts
        CHEST, BACK, SHOULDERS, ARMS, ABS, OBLIQUES, QUADRICEPS, HAMSTRINGS, GLUTES, CALVES
    }

    public void start() {//method to ask screening questions
        System.out.println("Welcome to the Workout Tool!");
        System.out.println("Would you like a Workout Schedule (1) or Quick Workout (2)?");

        int option = getValidIntInput();


        switch (option) {
            case 1:
                workoutSchedule();
                break;
            case 2:
                BodyPart selectedPart = userChoice();
                commonExercises(selectedPart);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                start();
                break;
        }
    }
    private int getValidIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear the invalid input
            }
        }
    }
    public void allParts() {
        System.out.println("1. Chest");
        System.out.println("2. Back");
        System.out.println("3. Shoulders");
        System.out.println("4. Arms");
        System.out.println("5. Abs");
        System.out.println("6. Obliques");
        System.out.println("7. Quadriceps");
        System.out.println("8. Hamstrings");
        System.out.println("9. Glutes");
        System.out.println("10. Calves");
    }

    public BodyPart userChoice() {//method for quick workout
        System.out.println("Enter the number correlated to the desired body part: ");
        allParts();
        int choice = getValidIntInput();
        while(choice<1 || choice>10){
            System.out.println("Invalid Choice, Choose Between 1-10.");
            choice = getValidIntInput();
        }

        switch (choice) {
            case 1:
                return BodyPart.CHEST;
            case 2:
                return BodyPart.BACK;
            case 3:
                return BodyPart.SHOULDERS;
            case 4:
                return BodyPart.ARMS;
            case 5:
                return BodyPart.ABS;
            case 6:
                return BodyPart.OBLIQUES;
            case 7:
                return BodyPart.QUADRICEPS;
            case 8:
                return BodyPart.HAMSTRINGS;
            case 9:
                return BodyPart.GLUTES;
            case 10:
                return BodyPart.CALVES;
            default:
                throw new IllegalArgumentException("Invalid choice: " + choice);
        }
    }

    public void commonExercises(BodyPart selectedBodyPart) {//method for quick workout
        List<String> selectedExercises = exercises.get(selectedBodyPart);
        System.out.println("Exercises for " + selectedBodyPart + ":");
        Collections.shuffle(selectedExercises);
        for (int i =0; i<4; i++) {
            System.out.println(selectedExercises.get(i) + " (10-15 reps)");
        }
    }

    private void workoutSchedule() {//WorkoutSchedule Tool
        String[] body = {"Chest", "Back", "Shoulders", "Arms", "Abs", "Obliques", "Quadriceps", "Hamstrings", "Glutes", "Calves"};
        System.out.println("You chose the Workout Scheduling Tool.");
        System.out.println("How many days do you want to workout a week? (Min: 1, Max: 7)");
//        int day1 = 0, day2 = 0, day3 = 0, day4 = 0, day5 = 0, day6 = 0, day7 = 0;
        int days = getValidIntInput();

        while (days < 1 || days > 7) {
            System.out.println("Invalid input. Please enter a number between 1 and 7.");
            days = getValidIntInput();
        }
        int[] selectedBodyParts = new int[days];

        for (int i = 0; i < days; i++) {
            System.out.println("Choose Body Part for Day " + (i + 1) + ":");
            allParts();
            int choice = getValidIntInput();
            while (choice < 1 || choice > 10) {
                System.out.println("Invalid, please choose a valid body part(1-10).");
                allParts();
                choice = getValidIntInput();
            }
            selectedBodyParts[i] = choice - 1;
        }
        String[] temp = new String[days];
        for (int i = 0; i < days; i++) {
            temp[i] = body[selectedBodyParts[i]];
//            System.out.println("Day " + (i + 1) + ": " + temp[i]);
        }

        System.out.println("Your Workout Schedule for Each Week: ");
        for (int i = 0; i < days; i++) {
            System.out.println("Day " + (i + 1) + ": " + temp[i]);
            List<String> exercisesForPart = new ArrayList<>(exercises.get(BodyPart.values()[selectedBodyParts[i]]));
            Collections.shuffle(exercisesForPart);
            System.out.println("Exercises:");
            for (int j = 0; j < 4; j++) {
                System.out.println("  - " + exercisesForPart.get(j) + " (10-15 reps)");
            }
        }
    }
    public static void main(String[] args) {
        new WorkoutTool().start();
    }
}