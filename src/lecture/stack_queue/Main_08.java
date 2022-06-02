package lecture.stack_queue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;

public class Main_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution4(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int answer = 1;
        Deque<Patient> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(new Patient(i, arr[i]));
        }
        while (!deque.isEmpty()) {
            Patient patient = deque.element();
            int max = calculateMax(deque);
            if (patient.priority == max) {
                if (patient.id == m) {
                    return answer;
                } else {
                    answer++;
                    deque.remove();
                }
            } else {
                deque.add(deque.remove());
            }
        }
        return answer;
    }

    private static int calculateMax(Deque<Patient> patients) {
        return patients.stream()
            .mapToInt(o -> o.priority)
            .max()
            .orElse(0);
    }

    private static int solution2(int n, int m, int[] arr) {
        int answer = 1;
        Deque<Patient> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(new Patient(i, arr[i]));
        }
        while (!deque.isEmpty()) {
            Patient patient = deque.element();
            int max = Collections.max(deque, Comparator.comparingInt(o -> o.priority)).priority;
            if (patient.priority == max) {
                if (patient.id == m) {
                    return answer;
                } else {
                    answer++;
                    deque.remove();
                }
            } else {
                deque.add(deque.remove());
            }
        }
        return answer;
    }

    private static int solution3(int n, int m, int[] arr) {
        int answer = 1;
        Deque<Patient> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(new Patient(i, arr[i]));
        }
        while (!deque.isEmpty()) {
            Patient patient = deque.remove();
            if (isGoBack(deque, patient)) {
                deque.add(patient);
            } else {
                if (patient.id == m) {
                    return answer;
                }
                answer++;
            }
        }
        return answer;
    }

    private static int solution4(int n, int m, int[] arr) {
        int answer = 0;
        Deque<Patient> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.offer(new Patient(i, arr[i]));
        }

        while (!deque.isEmpty()) {
            Patient patient = deque.remove();
            for (Patient p : deque) {
                if (p.priority > patient.priority) {
                    deque.offer(patient);
                    patient = null;
                    break;
                }
            }
            if (patient != null) {
                answer++;
                if (patient.id == m) {
                    return answer;
                }
            }
        }
        return answer;
    }

    private static boolean isGoBack(Deque<Patient> deque, Patient patient) {
        for (Patient p : deque) {
            if (p.priority > patient.priority) {
                return true;
            }
        }
        return false;
    }

    static class Patient {
        int id;
        int priority;

        public Patient(int number, int position) {
            this.id = number;
            this.priority = position;
        }
    }
}
