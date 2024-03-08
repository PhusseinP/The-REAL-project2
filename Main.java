import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Task> listOfTasks = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);





    public static int promptUser() {
        System.out.println("Please select one.\n");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(5) Update priority of task");
        System.out.println("(0) Exit.");
        System.out.println("Which task would you like to do?");
        int task = input.nextInt();
        input.nextLine();

        return task;
    }

    public static Task addTask() {

        while(true) {
            try {
                System.out.println("What is the name of the task?");
                String name = input.nextLine();

                System.out.println("Give the task a description:");
                String description = input.nextLine();

                System.out.println("What is the priority of the task (0-5)?");
                int priority = input.nextInt();
                input.nextLine();

                Task addedTask = new Task(name, description, priority);
                listOfTasks.add(addedTask);


                return addedTask;
            } catch (NumberFormatException e) {
                System.out.println("Error!");
            }
        }
    }


    public static void updatePriority() {
        System.out.println(listOfTasks);
        System.out.println("Which task priority would you like to update? (0-" + listOfTasks.size()+ ")");
        int selectedTask = input.nextInt();
        input.nextLine();
        Task updatePriority = listOfTasks.get(selectedTask);



        System.out.println("What would you like to change the priority to? (0-5)");
        int newPriority = input.nextInt();
        input.nextLine();
        updatePriority.setPriority(newPriority);




    }

    public static void updateTask() {

        System.out.println(listOfTasks);
        System.out.println("What task would use like to update? 1-" + listOfTasks.size());
        int updatedList = input.nextInt()-1;

        Task task2 = listOfTasks.get(updatedList);

        System.out.println("Add a description:");
        String descriptionTask = input.nextLine();

        task2.setDescription(descriptionTask);
        listOfTasks.set(updatedList, task2);


    }
    public static void removeTask() {

        System.out.println("What task would use like to remove? -" + listOfTasks.size());
        int task = input.nextInt()-1;
        input.nextLine();


        listOfTasks.remove(task);
        System.out.println(listOfTasks);


    }

    public static ArrayList<Task> returnList() {
        try {
            System.out.println("1: Print entire list");
            System.out.println("2: Print list by priority");
            System.out.println("Which would you like?");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    for (int i = 0; i < listOfTasks.size(); i++) {
                        System.out.println("Index value: " + i + " | " + "Task Name: " + listOfTasks.get(i).getName() +
                                " Description: " + listOfTasks.get(i).getDescription() +
                                " Priority: " + listOfTasks.get(i).getPriority() + "\n");
                    }
                    break;

                case 2:
                    System.out.println("Which priority would you like to view? (0-5)");
                    int wantedPriority = input.nextInt();
                    input.nextLine();
                    boolean isPriorInList = false;
                    for(Task task: listOfTasks) {
                        if (task.getPriority() == wantedPriority) {
                            int i = listOfTasks.indexOf(task);
                            System.out.println("Index value: " + i + " | " + "Task Name: " + listOfTasks.get(i).getName() +
                                    " Description: " + listOfTasks.get(i).getDescription() +
                                    " Priority: " + listOfTasks.get(i).getPriority() + "\n");
                            isPriorInList = true;
                        }



                    }
                    break;


            }
        } catch (Exception e) {
            System.out.println("Error!");
        }

        return listOfTasks;
    }




    public static void main(String[] args) {

        int task = promptUser();
        while (true) {
            switch (task) {
                case 1:
                    addTask();
                    task = promptUser();
                    break;
                case 2:
                    removeTask();
                    task = promptUser();
                    break;
                case 3:
                    updateTask();
                    task = promptUser();
                    break;
                case 4:
                    returnList();
                    task = promptUser();
                    break;
                case 5:
                    updatePriority();
                    task = promptUser();
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Select a valid number");
                    promptUser();
                    break;


            }

        }
    }
}