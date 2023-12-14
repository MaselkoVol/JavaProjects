package Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Patient.*;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main (String[] args) {
        ArrayList<Patient> patients = new ArrayList<Patient>(0);
        inputKeyboard(patients);
        printPatients(patients);
        String diagnosis = "насмарк";
        System.out.println("\nPatients that have the diagnosis: " + diagnosis);
        ArrayList<Patient> patientsWithDiagnosis = patientsWithDiagnosis(patients, diagnosis);
        printPatients(patientsWithDiagnosis);

        int from = 1000, to = 10000;
        System.out.println("\nPatients whose medcard number is in range from " + from + " to " + to);
        ArrayList<Patient> patientsHaveMedcardInRange = patientsHaveMedcardInRange(patients, from, to);
        printPatients(patientsHaveMedcardInRange);

        char digit = '3';
        System.out.println("\nPatients whose phone number ends with digit " + digit);
        ArrayList<Patient> patientsPhoneNumberStartsWithDigit = patientsPhoneNumberStartsWithDigit(patients, digit);
        printPatients(patientsPhoneNumberStartsWithDigit);
    }

    private static void inputKeyboard (ArrayList<Patient> patients) {
        System.out.println("\nInput data about patient, to stop input type 0");
        System.out.println("example: medcardNum - surname - name - patronymic - address - phoneNum - diagnosis");
        System.out.println("or: medcardNum-surname-name-patronymic-address-phoneNum-diagnosis\n");

        String[] patientInfo;
        int medcardNum;

        do {
            System.out.print(patients.size() + 1 + ") ");
            patientInfo = scan.nextLine().split("-");

            if (patientInfo.length == 1 && patientInfo[0].compareTo("0") == 0) {
                break;
            }
            if (patientInfo.length != 7) {
                System.out.println("There is lack of info or you inputed to much!");
                continue;
            }

            for (int i = 0; i < patientInfo.length;i++) {
                patientInfo[i] = delSpaces(patientInfo[i]);
            }
            // transform string to int for medcardNum
            try {
                medcardNum = Integer.parseInt(patientInfo[0]);
            } catch (Exception e) {
                System.out.println("Medical curd number need to be a number!");
                continue;
            }

            // I cant know what name or surname you have, so please look carefully what you are typing
            patients.add(new Patient(patients.size(), medcardNum, patientInfo[1], patientInfo[2], patientInfo[3], patientInfo[4], patientInfo[5], patientInfo[6]));
        } while (true);
    }

    public static String delSpaces (String str) {
        int i, k;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') continue;
            break;
        }
        if (i == str.length()) {
            return "";
        }
        for (k = str.length() - 1; k >= 0; k--) {
            if (str.charAt(k) == ' ') continue;
            break;
        }
        return str.substring(i,k + 1);
    }
    public static void printPatients (ArrayList<Patient> patients) {
        String[] columnNames = {"Id", "Medcart", "Surname", "Name", "Patronymic", "Address", "Phone number", "diagnosis"};
        int [] max = new int[8];
        max[0] = columnNames[0].length();
        max[1] = columnNames[1].length();
        max[2] = columnNames[1].length();
        max[3] = columnNames[3].length();
        max[4] = columnNames[4].length();
        max[5] = columnNames[5].length();
        max[6] = columnNames[6].length();
        max[7] = columnNames[7].length();
        for (int i = 0; i < patients.size(); i++) {
            if (max[0] < Integer.toString(patients.get(i).getId()).length()) {
                max[0] = Integer.toString(patients.get(i).getId()).length();
            }
            if (max[1] < Integer.toString(patients.get(i).getMedcardNum()).length()) {
                max[1] = Integer.toString(patients.get(i).getMedcardNum()).length();
            }
            if (max[2] < patients.get(i).getSurname().length()) {
                max[2] = patients.get(i).getSurname().length();
            }
            if (max[3] < patients.get(i).getName().length()) {
                max[3] = patients.get(i).getName().length();
            }
            if (max[4] < patients.get(i).getPatronymic().length()) {
                max[4] = patients.get(i).getPatronymic().length();
            }
            if (max[5] < patients.get(i).getAddress().length()) {
                max[5] = patients.get(i).getAddress().length();
            }
            if (max[6] < patients.get(i).getPhoneNum().length()) {
                max[6] = patients.get(i).getPhoneNum().length();
            }
            if (max[7] < patients.get(i).getDiagnosis().length()) {
                max[7] = patients.get(i).getDiagnosis().length();
            }
        }

        int lineWidth = sum(max) + 25;
        printCharNTimes('-', lineWidth);
        System.out.printf("\n| %" + max[0] +"s | %" + max[1] + "s | %"  + max[2] + "s | %"  + max[3] + "s | %" + max[4] + "s | %" + max[5] + "s | %" + max[6] + "s | %" + max[7] + "s |\n", columnNames[0], columnNames[1], columnNames[2], columnNames[3], columnNames[4], columnNames[5], columnNames[6], columnNames[7]);
        printCharNTimes('-', lineWidth);
        for (int i = 0; i < patients.size(); i++) {
            System.out.printf("\n| %" + max[0] +"s | %" + max[1] + "s | %"  + max[2] + "s | %"  + max[3] + "s | %" + max[4] + "s | %" + max[5] + "s | %" + max[6] + "s | %" + max[7] + "s |\n", patients.get(i).getId(), patients.get(i).getMedcardNum(), patients.get(i).getSurname(), patients.get(i).getName(), patients.get(i).getPatronymic(), patients.get(i).getAddress(), patients.get(i).getPhoneNum(), patients.get(i).getDiagnosis());
            printCharNTimes('-', lineWidth);
        }
        System.out.println();
    }
    public static ArrayList<Patient> patientsWithDiagnosis(ArrayList<Patient> allPatients, String diagnosis) {
        ArrayList<Patient> subPatients = new ArrayList<Patient>(0);
        for (int i = 0; i < allPatients.size(); i++) {
            if (allPatients.get(i).hasDiagnosis(diagnosis)) {
                subPatients.add(new Patient(allPatients.get(i).getId(), allPatients.get(i).getMedcardNum(), allPatients.get(i).getSurname(), allPatients.get(i).getName(), allPatients.get(i).getPatronymic(), allPatients.get(i).getAddress(), allPatients.get(i).getPhoneNum(), allPatients.get(i).getDiagnosis()));
            }
        }
        return subPatients;
    }
    public static ArrayList<Patient> patientsHaveMedcardInRange(ArrayList<Patient> allPatients, int from, int to) {
        ArrayList<Patient> subPatients = new ArrayList<Patient>(0);
        for (int i = 0; i < allPatients.size(); i++) {
            if (allPatients.get(i).isMedcardNumInRange(from, to)) {
                subPatients.add(new Patient(allPatients.get(i).getId(), allPatients.get(i).getMedcardNum(), allPatients.get(i).getSurname(), allPatients.get(i).getName(), allPatients.get(i).getPatronymic(), allPatients.get(i).getAddress(), allPatients.get(i).getPhoneNum(), allPatients.get(i).getDiagnosis()));
            }
        }
        return subPatients;
    }
    public static ArrayList<Patient> patientsPhoneNumberStartsWithDigit(ArrayList<Patient> allPatients, char digit) {
        ArrayList<Patient> subPatients = new ArrayList<Patient>(0);
        for (int i = 0; i < allPatients.size(); i++) {
            if (allPatients.get(i).doesPhoneNumStartsWithDigit(digit)) {
                subPatients.add(new Patient(allPatients.get(i).getId(), allPatients.get(i).getMedcardNum(), allPatients.get(i).getSurname(), allPatients.get(i).getName(), allPatients.get(i).getPatronymic(), allPatients.get(i).getAddress(), allPatients.get(i).getPhoneNum(), allPatients.get(i).getDiagnosis()));
            }
        }
        return subPatients;
    }
    public static int sum(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        return res;
    }

    public static void printCharNTimes (char c, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
    }
}