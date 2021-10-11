package agency;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Person p = new Person("Alexandru","Toma","5001345678912","Mures");
        ContBancar b = new ContBancar(p,1200);
        b.createCard();

        Account acc = new Account("alexandreu07","passwordtest","alexandreu07@yahoo.com",
                "Alexandru","Toma","5001345678912","Mures","0743678918");
        acc.addCI(p);
        acc.identityVerification();

        acc.addCard(b.getCard());
        acc.depositViaCard(200);


        AdminAgency admin =  AdminAgency.getInstance("user_1","password_1");

        Games c = new Games("FCB","FCR",1.2,1.4);
        Games d = new Games("FCS","CRF",1.7,1.8);
        Games e = new Games("ADF","FTR",2.2,2.4);
        Games f = new Games("FTRB","GHHR",1.4,1.6);


        boolean stop = true;

        do{
            System.out.println("\n\n1. Depunere bani.\n" +
                    "2. Retragere bani.\n" +
                    "3. Pariere\n"+
                    "4. Iesire");
            System.out.print("Optiune: ");

            Scanner scanner = new Scanner(System.in);
            int option;
            option = scanner.nextInt();


            switch (option) {
                case 2: {
                    System.out.print("\nIntroduceti suma: ");
                    double sum = scanner.nextDouble();
                    acc.retragereViaCard(sum);
                    break;
                }
                case 1: {
                    System.out.print("\nIntroduceti suma: ");
                    double sum = scanner.nextDouble();
                    acc.depositViaCard(sum);
                    break;
                }
                case 3: {
                    System.out.println("1. " + c.toString() + "\n" +
                            "2. " + d.toString() + "\n" + "3. " + e.toString() + "\n" + "4. " + f.toString());
                    System.out.print("Alegeti o optiune: ");

                    int opt = scanner.nextInt();

                    switch (opt) {
                        case 1: {
                            System.out.print("\nIntroduceti suma pe care doriti sa o pariati: ");
                            double sum = scanner.nextDouble();
                            System.out.print("Introduceti echipa: ");
                            int echipa = scanner.nextInt();

                            if (sum <= acc.get_sold()) {
                                acc.actualizareSoldMinus(sum);
                                double castig = c.pariare(sum, echipa);
                                acc.actualizareSoldPlus(castig);
                                if (castig > 0)
                                    System.out.println(castig);
                                else System.out.println("Necastigator");
                            }
                            break;
                        }

                        case 2: {
                            System.out.print("\nIntroduceti suma pe care doriti sa o pariati: ");
                            double sum = scanner.nextDouble();
                            System.out.print("Introduceti echipa: ");
                            int echipa = scanner.nextInt();

                            if (sum <= acc.get_sold()) {
                                acc.actualizareSoldMinus(sum);
                                double castig = d.pariare(sum, echipa);
                                acc.actualizareSoldPlus(castig);
                                if (castig > 0)
                                    System.out.println(castig);
                                else System.out.println("Necastigator");
                            }
                            break;
                        }

                        case 3: {
                            System.out.print("\nIntroduceti suma pe care doriti sa o pariati: ");
                            double sum = scanner.nextDouble();
                            System.out.print("Introduceti echipa: ");
                            int echipa = scanner.nextInt();

                            if (sum <= acc.get_sold()) {
                                acc.actualizareSoldMinus(sum);
                                double castig = e.pariare(sum, echipa);
                                acc.actualizareSoldPlus(castig);
                                if (castig > 0)
                                    System.out.println(castig);
                                else System.out.println("Necastigator");
                            }
                            break;
                        }
                        case 4: {
                            System.out.print("\nIntroduceti suma pe care doriti sa o pariati: ");
                            double sum = scanner.nextDouble();
                            System.out.print("Introduceti echipa: ");
                            int echipa = scanner.nextInt();

                            if (sum <= acc.get_sold()) {
                                acc.actualizareSoldMinus(sum);
                                double castig = f.pariare(sum, echipa);
                                acc.actualizareSoldPlus(castig);
                                if (castig > 0)
                                    System.out.println(castig);
                                else System.out.println("Necastigator");
                                break;
                            }

                            break;
                        }
                    }

                    break;
                }
                case 4: {
                    stop = false;
                    break;
                }

                default: {
                    System.out.println("Nu ati ales optiuna corecta");
                    break;
                }
            }
        }while(stop);

        System.out.println("test");
    }
}