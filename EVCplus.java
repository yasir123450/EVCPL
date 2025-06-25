import java.util.Scanner;

public class EVCplus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.0;
        String pin = "1234";
        boolean isLoggedIn = false;

        // Bilowga App-ka
        System.out.println("********** Ku Soo Dhawoow EVCPlus **********");
        System.out.print("Fadlan geli *770# si aad u bilowdo: ");
        String code = scanner.nextLine();

        if (!code.equals("*770#")) {
            System.out.println("Code khaldan. Barnaamijka wuu xirmayaa...");
            return;
        }

        // PIN Confirmation
        for (int i = 0; i < 3; i++) {
            System.out.print("Geli PIN-kaaga: ");
            String inputPin = scanner.nextLine();
            if (inputPin.equals(pin)) {
                isLoggedIn = true;
                break;
            } else {
                System.out.println("PIN khaldan. Isku day mar kale.");
            }
        }

        if (!isLoggedIn) {
            System.out.println("3 jeer ayaa la khalday. Akoonka wuu xirmay.");
            return;
        }

        // Menu Loop
        while (true) {
            System.out.println("\n========== EVCPlus Menu ==========");
            System.out.println("1. Itus Haraaga");
            System.out.println("2. Kaarka Hadalka");
            System.out.println("3. Bixi Biil");
            System.out.println("4. U Wareeji EVCPlus");
            System.out.println("5. Warbixin Kooban");
            System.out.println("6. Salaam Bank");
            System.out.println("7. Maareynta Akoonka");
            System.out.println("8. Bill Payment");
            System.out.println("0. Bax");

            System.out.print("Dooro adeeg (0-8): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Mahadsanid. Nabad gelyo!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Haraagaaga waa: $" + balance);
                    break;

                case 2:
                    System.out.print("Geli lacagta aad rabto in kaarka hadalka la galiyo: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        System.out.println("Waad ku shubtay $" + amount + " si guul leh.");
                    } else {
                        System.out.println("Haraag kugu filan ma jiro ama lacag khaldan.");
                    }
                    break;

                case 3:
                    System.out.print("Magaca shirkadda: ");
                    String company = scanner.nextLine();
                    System.out.print("Lambarka biilka: ");
                    String billNumber = scanner.nextLine();
                    System.out.print("Lacagta biilka: ");
                    double billAmount = scanner.nextDouble();
                    scanner.nextLine();
                    if (billAmount <= balance) {
                        balance -= billAmount;
                        System.out.println("Biilka " + company + " " + billNumber + " ayaa lagu bixiyay $" + billAmount);
                    } else {
                        System.out.println("Haraag kugu filan ma jiro.");
                    }
                    break;

                case 4:
                    System.out.print("Lambarka qofka aad u wareejineyso: ");
                    String phone = scanner.nextLine();
                    System.out.print("Lacagta: ");
                    double transfer = scanner.nextDouble();
                    scanner.nextLine();
                    if (transfer <= balance && transfer > 0) {
                        balance -= transfer;
                        System.out.println("Waxaad u wareejisay $" + transfer + " qofka " + phone);
                    } else {
                        System.out.println("Lacag khaldan ama haraag ma filna.");
                    }
                    break;

                case 5:
                    System.out.println("------ Warbixin Kooban ------");
                    String[] history = {"Kaarka - $5", "Biil - $10", "Wareejin - $20"};
                    for (String record : history) {
                        System.out.println(record);
                    }
                    break;

                case 6:
                    System.out.println("------ Salaam Bank ------");
                    System.out.println("1. Salaam Balance");
                    System.out.println("2. Transfer to Bank");
                    System.out.println("3. Withdraw from Bank");
                    System.out.print("Dooro: ");
                    int bankChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (bankChoice == 1) {
                        System.out.println("Salaam Bank Balance: $500.00");
                    } else if (bankChoice == 2) {
                        System.out.print("Geli lacagta la wareejinayo: ");
                        double bankAmount = scanner.nextDouble();
                        scanner.nextLine();
                        if (bankAmount <= balance) {
                            balance -= bankAmount;
                            System.out.println("Waad wareejisay $" + bankAmount + " Bankiga.");
                        } else {
                            System.out.println("Haraag kuma filna.");
                        }
                    } else if (bankChoice == 3) {
                        System.out.println("Bankiga waxa laga soo saaray $100");
                        balance += 100;
                    } else {
                        System.out.println("Doorasho aan sax ahayn.");
                    }
                    break;

                case 7:
                    System.out.println("------ Maareynta Akoonka ------");
                    System.out.println("1. Bedel PIN");
                    System.out.println("2. Xir Akoonka");
                    System.out.println("3. Reset Profile");
                    System.out.print("Dooro: ");
                    int manage = scanner.nextInt();
                    scanner.nextLine();

                    if (manage == 1) {
                        System.out.print("Geli PIN cusub: ");
                        pin = scanner.nextLine();
                        System.out.println("PIN waa la badalay.");
                    } else if (manage == 2) {
                        System.out.println("Akoonka waa la xiray.");
                        return;
                    } else if (manage == 3) {
                        System.out.println("Profile waa la reset gareeyay.");
                    } else {
                        System.out.println("Doorasho khaldan.");
                    }
                    break;

                case 8:
                    System.out.println("------ Bill Payment ------");
                    String[] bills = {"Internet", "Koronto", "Biyaha"};
                    for (int i = 0; i < bills.length; i++) {
                        System.out.println((i + 1) + ". " + bills[i]);
                    }
                    System.out.print("Dooro nooca biilka: ");
                    int billType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Geli lacagta: ");
                    double payment = scanner.nextDouble();
                    scanner.nextLine();

                    if (payment <= balance && billType >= 1 && billType <= bills.length) {
                        balance -= payment;
                        System.out.println("Waxaad bixisay $" + payment + " biilka: " + bills[billType - 1]);
                    } else {
                        System.out.println("Xog khaldan ama haraag kuma filna.");
                    }
                    break;

                default:
                    System.out.println("Doorasho aan sax ahayn.");
            }
        }

        scanner.close();
    }
}